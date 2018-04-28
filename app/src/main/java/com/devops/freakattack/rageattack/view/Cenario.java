package com.devops.freakattack.rageattack.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devops.freakattack.rageattack.R;
import com.devops.freakattack.rageattack.modelo.Objeto;

public class Cenario extends AppCompatActivity implements View.OnClickListener {



    private Button ataque_1 = null;
    private Button ataque_2 = null;

    private TextView vida = null;

    private ImageView carro = null;

    private Objeto cenario = null;

    private AlertDialog alerta;

    private ImageView[] coracao = null;

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenario);
        //referencias visuais
        ataque_1 = (Button) findViewById(R.id.ataque_1);
        ataque_2 = (Button) findViewById(R.id.ataque_2);
        carro = (ImageView) findViewById(R.id.cenario_inimigo);
        cenario = new Objeto();
        coracao = new  ImageView[3];
        coracao[0] = (ImageView) findViewById(R.id.coracao1);
        coracao[1] = (ImageView) findViewById(R.id.coracao2);
        coracao[2] = (ImageView) findViewById(R.id.coracao3);


        //clicklistener
        ataque_1.setOnClickListener(this);
        ataque_2.setOnClickListener(this);

    }


    public void onClick(View v) {

        switch (v.getId()){

            case R.id.ataque_1:
                modificarVida(1);
//                vida.setText(Integer.toString(cenario.getVida()));
                vibrar();
                break;
            case R.id.ataque_2:
                modificarVida(2);
//                vida.setText(Integer.toString(cenario.getVida()));
                vibrar();
                break;
            default:
                break;

        }
    }

    public void vibrar(){
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(250);
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

        if(cenario.getVida() < 0) {
            coracao[1].setVisibility(View.INVISIBLE);
            fimFase();
        }
        else if(cenario.getVida() < 30) {
            carro.setBackground(getResources().getDrawable(R.drawable.carroc));
            coracao[2].setVisibility(View.INVISIBLE);
        }
        else if(cenario.getVida() < 70) {
            coracao[0].setVisibility(View.INVISIBLE);
            carro.setBackground(getResources().getDrawable(R.drawable.carrob));
        }

    }

    private void fimFase() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Destruído!");
        //define a mensagem
        builder.setMessage("Veiculo totalmente destruído. Próxima Fase !");
        //define um botão como positivo
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    }


}


