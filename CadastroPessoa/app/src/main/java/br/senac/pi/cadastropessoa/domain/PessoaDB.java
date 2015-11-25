package br.senac.pi.cadastropessoa.domain;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 25/11/2015.
 */
public class PessoaDB extends SQLiteOpenHelper {
    private static final String nome_banco = "cadastropessoa.sqlite";
    private static final int versao_database = 1;

    public PessoaDB(Context context) {
        super(context, nome_banco,null, versao_database);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS pessoa(_id integer primary key autoincrement," + "nome text , telefone int , cpf text);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long save(Pessoa pessoa){
        long id = pessoa.getId();
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("nome",pessoa.getNome());
            values.put("cpf",pessoa.getCpf());
            values.put("telefone",pessoa.getTelefone());
            if (id != 0){
                String _id = String.valueOf(pessoa.getId());
                String[] whereArgs = new String[] {_id};
                //
                int count = db.update("pessoa",values,"_id=?",whereArgs);
                return count;
            }else{
                //
                id = db.insert("pessoa","",values);
                return id;
            }
        }finally {
            db.close();
        }
    }
    public int delete(Pessoa pessoa){
        SQLiteDatabase db = getWritableDatabase();
        try {
            int count = db.delete("pessoa","_id=?",new String[]{String.valueOf(pessoa.getId())});
            return count;
        }finally {
            db.close();
        }
    }
    public List<Pessoa> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            Cursor cursor = db.query("carro", null, null, null, null, null, null);
            return toList(cursor);
        }finally {
            db.close();
        }
    }
    public List<Pessoa> toList(Cursor cursor){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        if (cursor.moveToFirst()){
            do {
                Pessoa pessoa = new Pessoa();
                pessoas.add(pessoa);
                pessoa.setId(cursor.getLong(cursor.getColumnIndex("_id")));
                pessoa.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                pessoa.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
                pessoa.setTelefone(cursor.getInt(cursor.getColumnIndex("telefone")));
            }while (cursor.moveToNext());
        }
        return pessoas;
    }

}
