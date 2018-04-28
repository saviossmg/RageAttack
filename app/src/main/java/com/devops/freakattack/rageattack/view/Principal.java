package com.devops.freakattack.rageattack.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.devops.freakattack.rageattack.R;

public class Principal extends AppCompatActivity implements View.OnClickListener  {

    //variaveis das referencias visuais
    private TextView txtAtaque = null;
    private TextView txtDefesa = null;
    private TextView txtEstamina = null;
    private TextView txtEspecial = null;
    private TextView txtEnergia = null;
    private TextView txtVida = null;

    private Button btnPersonagem1 = null;
    private Button btnPersonagem2 = null;
    private Button btnPersonagem3 = null;
    private Button btnPlay = null;
    private Button btnSobre = null;

    private Intent cenario = null;
    private Bundle dicionario = null;

    //variaveis de controle
    private int perso = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //set das referencias visuais com as variaveis
        this.txtAtaque = (TextView) findViewById(R.id.principal_txt_atkperso);
        this.txtDefesa = (TextView) findViewById(R.id.principal_txt_defperso);
        this.txtEspecial = (TextView) findViewById(R.id.principal_txt_espperso);
        this.txtEstamina = (TextView) findViewById(R.id.principal_txt_estperso);
        this.txtEnergia = (TextView) findViewById(R.id.principal_txt_eneperso);
        this.txtVida = (TextView) findViewById(R.id.principal_txt_vidperso);

        this.btnPersonagem1 = (Button) findViewById(R.id.principal_btn_p1);
        this.btnPersonagem2 = (Button) findViewById(R.id.principal_btn_p2);
        this.btnPersonagem3 = (Button) findViewById(R.id.principal_btn_p3);
        this.btnPlay = (Button) findViewById(R.id.principal_btn_play);
        this.btnSobre = (Button) findViewById(R.id.principal_btn_about);

        this.txtAtaque.setText("-");
        this.txtDefesa.setText("-");
        this.txtEspecial.setText("-");
        this.txtEstamina.setText("-");
        this.txtEnergia.setText("-");
        this.txtVida.setText("-");

        //set o listenr dos botoes
        this.btnPersonagem1.setOnClickListener(this);
        this.btnPersonagem2.setOnClickListener(this);
        this.btnPersonagem3.setOnClickListener(this);
        this.btnPlay.setOnClickListener(this);
        this.btnSobre.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.principal_btn_p1:
                this.selecionaPersonagem(1);
                break;
            case R.id.principal_btn_p2:
                this.selecionaPersonagem(2);
                break;
            case R.id.principal_btn_p3:
                this.selecionaPersonagem(3);
                break;
            case R.id.principal_btn_play:
                this.iniciaJogo();
                break;
            case R.id.principal_btn_about:
                this.mostraAbout();
                break;
        }
    }

    //metodo que irá selecionar o personagem e mudar o texto na tela
    private void selecionaPersonagem(int p){
        //ação
    }

    //metodo que irá iniciar o jogo
    private void iniciaJogo(){
        //cria a intent para a tela de novo jogador
        cenario = new Intent(this, Cenario.class);
        startActivityForResult(cenario, 1);
    }

    //metodo que irá mostrar o about
    private void mostraAbout(){
        //ação
    }

}
