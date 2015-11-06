package br.senac.pi.demoview;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

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
        findViewById(R.id.btnTextViewDemo).setOnClickListener(abrirTextViewDemo());
        findViewById(R.id.btnEditTextDemo).setOnClickListener(abrirEditTextDemo());
        findViewById(R.id.btnImageViewDemo).setOnClickListener(abrirImageViewDemo());
        findViewById(R.id.btnDemoView).setOnClickListener(abrirDemoView());
        findViewById(R.id.btnImageButton).setOnClickListener(abrirImageButton());
        findViewById(R.id.btnCheckBox).setOnClickListener(abrirCheckBox());
        findViewById(R.id.btnProgressDemo).setOnClickListener(abrirProgressDemo());
        findViewById(R.id.btnAlertDialog).setOnClickListener(abrirAlertDialog());
        findViewById(R.id.btnScrollViewDemo).setOnClickListener(abrirScrollViewDemo());

    }
    private View.OnClickListener abrirScrollViewDemo(){
        return  new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,ScrellViewDemoActivicty.class);
                startActivity(intent);
            }
        };

    }
    private View.OnClickListener abrirAlertDialog(){
        return new View.OnClickListener(){
          public void onClick(View v){
              Intent intent = new Intent(MainActivity.this,AlertDialogDemo.class);
              startActivity(intent);
          }
        };
    }
    private View.OnClickListener abrirProgressDemo(){
        return new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProgressDemo.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirCheckBox(){
        return new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,CheckBox.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirDemoView(){
        return new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirTextViewDemo(){
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextViewDemo.class);
                startActivity(intent);

            }
        };
    }
    private View.OnClickListener abrirEditTextDemo(){
        return new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,EditTextDemo.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirImageViewDemo(){
        return new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,ImageView.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirImageButton(){
        return new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,ImageButton.class);
                startActivity(intent);
            }
        };
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /*public void abrirTexViewDemo(View view){
        Intent intent = new Intent(this, TextViewDemo.class);
        startActivity(intent);
    }*/

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
