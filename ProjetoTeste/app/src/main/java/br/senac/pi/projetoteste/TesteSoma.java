package br.senac.pi.projetoteste;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TesteSoma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_soma);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.btnsomar).setOnClickListener(somar());
        findViewById(R.id.btnmultiplicar).setOnClickListener(multiplicar());
        findViewById(R.id.btnsubtrair).setOnClickListener(subtrair());
        findViewById(R.id.btndividir).setOnClickListener(dividir());

    }
    private View.OnClickListener somar(){
        return new View.OnClickListener(){
            public void onClick(View v){
                EditText edtN1 = (EditText) findViewById(R.id.edtN1);
                EditText edtN2 = (EditText) findViewById(R.id.edtN2);
                double n1 = Double.parseDouble(edtN1.getText().toString());
                double n2 = Double.parseDouble(edtN1.getText().toString());
                double total = (n1+n2);
                TextView TextoResultado = (TextView)findViewById(R.id.txtResult);
                TextoResultado.setText(getString(R.string.result)+" "+total);
            }
        };
    }
    private View.OnClickListener multiplicar(){
        return new View.OnClickListener(){
            public void onClick(View v){
                EditText edtN1 = (EditText) findViewById(R.id.edtN1);
                EditText edtN2 = (EditText) findViewById(R.id.edtN2);
                double n1 = Double.parseDouble(edtN1.getText().toString());
                double n2 = Double.parseDouble(edtN1.getText().toString());
                double total = (n1*n2);
                TextView TextoResultado = (TextView)findViewById(R.id.txtResult);
                TextoResultado.setText(getString(R.string.result)+" "+total);
            }
        };
    }
    private View.OnClickListener subtrair(){
        return new View.OnClickListener(){
            public void onClick(View v){
                EditText edtN1 = (EditText) findViewById(R.id.edtN1);
                EditText edtN2 = (EditText) findViewById(R.id.edtN2);
                double n1 = Double.parseDouble(edtN1.getText().toString());
                double n2 = Double.parseDouble(edtN1.getText().toString());
                double total =(n1-n2);
                TextView TextoResultado = (TextView)findViewById(R.id.txtResult);
                TextoResultado.setText(getString(R.string.result)+" "+total);
            }
        };
    }
    private View.OnClickListener dividir(){
        return new View.OnClickListener(){
            public void onClick(View v){
                EditText edtN1 = (EditText) findViewById(R.id.edtN1);
                EditText edtN2 = (EditText) findViewById(R.id.edtN2);
                double n1 = Double.parseDouble(edtN1.getText().toString());
                double n2 = Double.parseDouble(edtN1.getText().toString());
                double total = (n1/n2);
                TextView TextoResultado = (TextView)findViewById(R.id.txtResult);
                TextoResultado.setText(getString(R.string.result)+" "+total);
            }
        };
    }

}
