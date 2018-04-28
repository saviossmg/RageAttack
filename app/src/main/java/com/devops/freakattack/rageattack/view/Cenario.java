package com.devops.freakattack.rageattack.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.devops.freakattack.rageattack.R;
import com.devops.freakattack.rageattack.modelo.Objeto;

public class Cenario extends AppCompatActivity implements View.OnClickListener {



    private Button ataque_1 = null;
    private Button ataque_2 = null;
    private TextView vida = null;
    private ImageView carro = null;
    private Objeto cenario = null;
    Bitmap bImage1 = null;
    Bitmap bImage2 = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenario);
        //referencias visuais
        ataque_1 = (Button) findViewById(R.id.ataque_1);
        ataque_2 = (Button) findViewById(R.id.ataque_2);
        vida = (TextView) findViewById(R.id.textView_vida_qtd);
        carro = (ImageView) findViewById(R.id.cenario_inimigo);

        bImage1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.carrob);
        bImage2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.carrob);

        cenario = new Objeto();


        //clicklistener
        ataque_1.setOnClickListener(this);
        ataque_2.setOnClickListener(this);
    }


    public void onClick(View v) {

        switch (v.getId()){

            case R.id.ataque_1:
                modificarVida(1);
                vida.setText(Integer.toString(cenario.getVida()));
                break;
            case R.id.ataque_2:
                modificarVida(2);
                vida.setText(Integer.toString(cenario.getVida()));
                break;
            default:
                break;

        }
    }

    private void modificarVida(int valor) {
        int vida = 0;
        switch (valor) {
            case 1:
                vida = cenario.getVida();
                cenario.setVida(--vida);
                verificarVida();
                break;
            case 2:
                vida = cenario.getVida();
                cenario.setVida(vida-2);
                verificarVida();
        }
    }

    public void verificarVida(){
        if(cenario.getVida() < 30){
            //atualizarTela();
            //Drawable drawable= getResources().getDrawable(R.drawable.carrob);
            //carro.setImageDrawable(drawable);
            //ImageView img= (ImageView) findViewById(R.id.image);
            //carro.setImageResource(R.drawable.carrob);
            //ImageView imageView = new ImageView(this);

            carro.setImageResource(R.drawable.carrob);
        } else if(cenario.getVida() < 70) {
            //atualizarTela();
            //Drawable drawable= getResources().getDrawable(R.drawable.carroc);
            //carro.setImageDrawable(drawable);
            //ImageView img= (ImageView) findViewById(R.id.image);
            //carro.setImageResource(R.drawable.carroc);
            //atualizarTela();

            carro.setImageResource(R.drawable.carroc);;
            //atualizarTela();

        }

    }


    public void atualizarTela(){
        Intent refresh = new Intent(this, Cenario.class);
        startActivity(refresh);
        this.finish(); //
    }
}
