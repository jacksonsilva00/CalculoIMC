package br.senac.pi.demoview;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;
import java.io.IOException;

public class ProgressDemo extends AppCompatActivity {
    private static final String URL = "http://www.livroandroid.com.br/imgs/livro_android.png";
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_demo);
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
        dialog=ProgressDialog.show(this,"Exemplo","Buscando Imagem por favor aguarde",false,true);
        downloadImage(URL);
    }
    public void downloadImage(final String urlImagem){
        new Thread(){
            public void run(){
                try {
                    // Faz o download da Imagem
                    URL url = new URL(urlImagem);
                    InputStream in = url.openStream();
                    //Converte o InputStrem do Java para Bitmap
                    final Bitmap imagem = BitmapFactory.decodeStream(in);
                    in.close();
                    //Atualiza a
                    atualizaImagem(imagem);
                }catch (IOException e){
                    Log.e("Erro download", e.getMessage(), e);

                }
            }
        }.start();

    }
    public void atualizaImagem(final Bitmap imagem){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                ImageView imageView = (ImageView) findViewById(R.id.img);
                imageView.setImageBitmap(imagem);

            }
        });

    }

}
