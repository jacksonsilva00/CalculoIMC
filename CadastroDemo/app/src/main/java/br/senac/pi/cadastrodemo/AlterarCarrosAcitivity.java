package br.senac.pi.cadastrodemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.senac.pi.cadastrodemo.domains.CarrosDB;

public class AlterarCarrosAcitivity extends AppCompatActivity {
    private CarrosDB carrosDB;
    private SQLiteDatabase db;
    private EditText edtAlterarNomeCarro,edtAlterarMarcaCarro;
    private TextView txtIdCarro;
    private String id ;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_carros_acitivity);
        id = getIntent().getStringExtra("id");
        carrosDB = new CarrosDB(this);
        txtIdCarro = (TextView) findViewById(R.id.txtIdCarro);
        edtAlterarNomeCarro = (EditText) findViewById(R.id.edtAlterarNomeCarro);
        edtAlterarMarcaCarro = (EditText) findViewById(R.id.edtAlterarMarcaCarro);
        cursor = carregarCarro(Integer.parseInt(id));
        txtIdCarro.setText(cursor.getString(cursor.getColumnIndexOrThrow("_id")));
        edtAlterarNomeCarro.setText(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        edtAlterarMarcaCarro.setText(cursor.getString(cursor.getColumnIndexOrThrow("marca")));
        findViewById(R.id.btnAlterarCarro).setOnClickListener(alterarcarro());
    }
    private Cursor carregarCarro(int id){
        db = carrosDB.getWritableDatabase();
        String[] campos = {"_id","nome","marca"};
        String whereArgs = String.valueOf(id);
        cursor = db.query("carro", campos, whereArgs, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    private View.OnClickListener alterarcarro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = carrosDB.getWritableDatabase();
                ContentValues values = new ContentValues();
                String whereArgs = id;
                Log.i("curso", "ID capturado: " + id);
                values.put("nome", edtAlterarNomeCarro.getText().toString());
                values.put("marca", edtAlterarMarcaCarro.getText().toString());
                db.update("carro", values, "_id = " + whereArgs, null);
                db.close();
                //Intent intent = new Intent(AlterarCarrosAcitivity.this, ListaCarrosActivity.class);
                //startActivity(intent);

            }
        };
    }

}
