package br.senac.pi.demoview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogDemo extends AppCompatActivity {
    private Button btnAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_demo);
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
        btnAlertDialog=(Button) findViewById(R.id.btnAlertDialog);
        btnAlertDialog.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v){
              AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this);
              builder.setIcon(R.drawable.freebsd);
              builder.setTitle("Titulo da Janela");
              builder.setMessage("Mensagem alerta");
              builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(AlertDialogDemo.this, "Clicou no Sim", Toast.LENGTH_LONG).show();
                  }
              });
              builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(AlertDialogDemo.this, "Clicou no Não", Toast.LENGTH_LONG).show();
                  }
              });
              AlertDialog dialog = builder.create();
              dialog.show();
            }
        });
    }

}
