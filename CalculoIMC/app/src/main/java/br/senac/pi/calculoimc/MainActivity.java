package br.senac.pi.calculoimc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        findViewById(R.id.btnCalcular).setOnClickListener(calcular());
    }
        //  Peso / altura²
        //  18,5 abaixo do peso
        //  18.6 a 24.9 peso ideal
        //  25.0 a 29.9 levemente acima do peso
        //  30.0 a 34.9 obesidade grau I
        //  35.0 a 39.9 Obesidade grau II (severa)
        //  acima de 40 Obesidade III (imorbida)




    private View.OnClickListener calcular(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText n1 = (EditText) findViewById(R.id.edtPeso);
                EditText n2 = (EditText) findViewById(R.id.edtAltura);
                double n01 = Double.parseDouble(n1.getText().toString());
                double n02 = Double.parseDouble(n2.getText().toString());
                double result = (n01/((n02*n02)));
                TextView TextResult = (TextView) findViewById(R.id.txtResult);
                TextResult.setText(getString(R.string.resultado).toString()+" "+result);
                TextView TextoPeso = (TextView) findViewById(R.id.txtPeso);
                if (result <= 18.5){
                    TextoPeso.setText(getString(R.string .peso1).toString());
                }else if((result >= 18.6) && (result <= 24.9)){
                    TextoPeso.setText(getString(R.string.peso2).toString());
                }else if((result >= 25.0) && (result <= 29.9)){
                    TextoPeso.setText(getString(R.string.peso3).toString());
                }else if((result >= 30.0) && (result <= 34.9)){
                    TextoPeso.setText(getString(R.string.peso4).toString());
                }else if((result >= 35.0) && (result <= 39.9)){
                    TextoPeso.setText(getString(R.string.peso5).toString());
                }else if((result >= 40)){
                    TextoPeso.setText(getString(R.string.peso6).toString());
                }


            }
        };
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
