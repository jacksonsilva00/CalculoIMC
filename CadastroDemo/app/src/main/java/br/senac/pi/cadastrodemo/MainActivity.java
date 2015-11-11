package br.senac.pi.cadastrodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.senac.pi.cadastrodemo.domains.Carro;
import br.senac.pi.cadastrodemo.domains.CarrosDB;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findViewById(R.id.btnButton).setOnClickListener(carro());
        findViewById(R.id.btnListarCarros).setOnClickListener(listcarros());
        Button btnCadastrarCarro = (Button) findViewById(R.id.btnButton);
        btnCadastrarCarro.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v ){
                EditText edtcarro = (EditText) findViewById(R.id.edtCarro);
                EditText edtFab = (EditText) findViewById(R.id.edtFab);
                TextView txtresult = (TextView) findViewById(R.id.txtresult);
                Carro carro = new Carro();
                CarrosDB db = new CarrosDB(MainActivity.this);
                String edtcarro1 = edtcarro.getText().toString();
                String edtFab1 = edtFab.getText().toString();
                carro.setNome(edtcarro1);
                carro.setMarca(edtFab1);
                if(db.save(carro) != -1){
                    Toast.makeText(MainActivity.this,getString(R.string.sucesso_db),Toast.LENGTH_LONG).show();
                    edtcarro.setText(" ");
                    edtFab.setText(" ");
                    edtcarro.requestFocus();

                }else{
                    Toast.makeText(MainActivity.this,getString(R.string.erro_db),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public View.OnClickListener listcarros(){
        return new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListaCarrosActivity.class);
                startActivity(intent);
            }
        };
    }

    /*public View.OnClickListener carro(){
        return new View.OnClickListener() {
            public void onClick(View v) {
                EditText edtcarro = (EditText) findViewById(R.id.edtCarro);
                EditText edtFab = (EditText) findViewById(R.id.edtFab);
                TextView txtresult = (TextView) findViewById(R.id.txtresult);
                Carro carro = new Carro();
                CarrosDB db = new CarrosDB(MainActivity.this);
                String edtcarro1 = edtcarro.getText().toString();
                String edtFab1 = edtFab.getText().toString();
                carro.setNome(edtcarro1);
                carro.setMarca(edtFab1);
                if(db.save(carro) != -1){
                    Toast.makeText(MainActivity.this,getString(R.string.visualizarcarro),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,getString(R.string.visualizarcarro),Toast.LENGTH_LONG).show();
                }
                //db.save(carro);
                //txtresult.setText(getString(R.string.visualizarcarro)+carro.getNome()+"  "+carro.getMarca());
            }
        };
    }*/
}
