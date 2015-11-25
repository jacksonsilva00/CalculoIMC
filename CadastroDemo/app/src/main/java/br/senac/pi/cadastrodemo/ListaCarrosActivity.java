package br.senac.pi.cadastrodemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import br.senac.pi.cadastrodemo.domains.Carro;
import br.senac.pi.cadastrodemo.domains.CarrosDB;

public class ListaCarrosActivity extends AppCompatActivity {
    private CursorAdapter dataSource;
    private SQLiteDatabase database;
    private static final  String campos[] = {"nome","marca","_id"};
    ListView listView;
    CarrosDB carrosDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carros);
        listView = (ListView) findViewById(R.id.listView);
        carrosDB = new CarrosDB(this);
        database = carrosDB.getWritableDatabase();
        findViewById(R.id.btnListarCarros).setOnClickListener(listarCarros());
        // delete
        listView.setOnItemClickListener(deletarItem());
    }
    private View.OnClickListener listarCarros(){
        return new View.OnClickListener(){
            public void onClick(View v) {
                Cursor carros = database.query("carro",campos,null,null,null,null,null,null);
                if (carros.getCount() > 0){
                    dataSource = new SimpleCursorAdapter(ListaCarrosActivity.this,R.layout.row,carros,campos,new int[] {R.id.txtNomeCarro,R.id.txtMarcaCarro});
                    listView.setAdapter(dataSource);
                }else{
                    Toast.makeText(ListaCarrosActivity.this,getString(R.string.erro_registro),Toast.LENGTH_LONG).show();
                }

            }
        };
    }
    private AdapterView.OnItemClickListener deletarItem(){
        return new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //SQLiteDatabase db = carrosDB.getWritableDatabase();
                //String whereArgs[] = new String[]{String.valueOf(position)};
                //db.delete("carro","_id = ?",whereArgs);
                // parte alterada de long para final long
                final int posicao = position;
                final long itemSelecionado = id;
                //Log.i("carro", "ID do item selecionado" + itemSelecionado);
                //Carro carro = new Carro();
                //carro.setId(itemSelecionado);
                //carrosDB.delete(carro);
                AlertDialog.Builder builder = new AlertDialog.Builder(ListaCarrosActivity.this);
                builder.setTitle("Pegunta");
                builder.setMessage("O que deseja fazer?");
                builder.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Toast.makeText(ListaCarrosActivity.this, "Clicou no Editar", Toast.LENGTH_LONG).show();
                        String codigo;
                        //Carro c = new Carro();
                        Cursor carro = database.query("carro",campos,null,null,null,null,null,null);
                        carro.moveToPosition(posicao);
                        codigo = carro.getString(carro.getColumnIndexOrThrow("_id"));
                        Intent intent = new Intent(ListaCarrosActivity.this,AlterarCarrosAcitivity.class);
                        intent.putExtra("id",codigo);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("Deletar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // mesmo invocação de excluir anterior , mas dentro do metodo
                        //Log.i("carro", "ID do item selecionado" + itemSelecionado);
                        Carro carro = new Carro();
                        carro.setId(itemSelecionado);
                        carrosDB.delete(carro);

                    }
                });
                    AlertDialog dialog = builder.create();
                    dialog.show();
            }
        };

    }

}
