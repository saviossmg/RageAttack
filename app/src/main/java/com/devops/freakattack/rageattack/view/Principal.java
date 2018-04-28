package com.devops.freakattack.rageattack.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.devops.freakattack.rageattack.R;
import com.devops.freakattack.rageattack.modelo.Jogador;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements View.OnClickListener  {

    //variaveis das referencias visuais
    private TextView txtAtaque = null;
    private TextView txtDefesa = null;
    private TextView txtEstamina = null;
    private TextView txtEspecial = null;
    private TextView txtEnergia = null;
    private TextView txtVida = null;
    private TextView txtNome = null;

    private Button btnPersonagem1 = null;
    private Button btnPersonagem2 = null;
    private Button btnPersonagem3 = null;
    private Button btnPlay = null;
    private Button btnSobre = null;

    private Intent cenario = null;
    private Bundle dicionario = null;

    //variaveis de controle
    private int perso = -1;

    private ArrayList<Jogador> jogadores = null;
    private Intent solicitacao = null;

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
        this.txtNome = (TextView) findViewById(R.id.principal_txt_nomeperso);

        this.btnPersonagem1 = (Button) findViewById(R.id.principal_btn_p1);
        this.btnPersonagem2 = (Button) findViewById(R.id.principal_btn_p2);
        this.btnPersonagem3 = (Button) findViewById(R.id.principal_btn_p3);
        this.btnPlay = (Button) findViewById(R.id.principal_btn_play);
        this.btnSobre = (Button) findViewById(R.id.principal_btn_about);

        this.txtNome.setText("-");
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

        //carrega o array list
        this.carregaJogadores();
        this.btnPlay.setEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //zera as variaveis
        this.txtNome.setText("-");
        this.txtAtaque.setText("-");
        this.txtDefesa.setText("-");
        this.txtEspecial.setText("-");
        this.txtEstamina.setText("-");
        this.txtEnergia.setText("-");
        this.txtVida.setText("-");
        this.perso = 0;
        this.btnPersonagem1.setBackground(getResources().getDrawable(R.drawable.waldenormal));
        this.btnPersonagem2.setBackground(getResources().getDrawable(R.drawable.lokanormal));
        this.btnPersonagem3.setBackground(getResources().getDrawable(R.drawable.marquinnormal));
        this.btnPlay.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.principal_btn_p1:
                this.selecionaPersonagem(0);
                this.btnPersonagem1.setBackground(getResources().getDrawable(R.drawable.walderataque));
                this.btnPersonagem2.setBackground(getResources().getDrawable(R.drawable.lokanormal));
                this.btnPersonagem3.setBackground(getResources().getDrawable(R.drawable.marquinnormal));
                break;
            case R.id.principal_btn_p2:
                this.selecionaPersonagem(1);
                this.btnPersonagem1.setBackground(getResources().getDrawable(R.drawable.waldenormal));
                this.btnPersonagem2.setBackground(getResources().getDrawable(R.drawable.lokaataque));
                this.btnPersonagem3.setBackground(getResources().getDrawable(R.drawable.marquinnormal));
                break;
            case R.id.principal_btn_p3:
                this.selecionaPersonagem(2);
                this.btnPersonagem1.setBackground(getResources().getDrawable(R.drawable.waldenormal));
                this.btnPersonagem2.setBackground(getResources().getDrawable(R.drawable.lokanormal));
                this.btnPersonagem3.setBackground(getResources().getDrawable(R.drawable.marquinataque));
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
        this.perso = p;
        if(this.perso != -1){
            //se for diferente de 0, ele irá habilitar o botão
            this.btnPlay.setEnabled(true);
            Jogador aux = this.jogadores.get(this.perso);
            this.txtVida.setText("Vida: "+aux.getPtsVida());
            this.txtEnergia.setText("Energia: "+aux.getPtsEnergia());
            this.txtEstamina.setText("Estamina: "+aux.getPtsEstamina());
            this.txtEspecial.setText("Especial: "+aux.getPtsEspecial());
            this.txtDefesa.setText("Defesa: "+aux.getPtsDefesa());
            this.txtAtaque.setText("Ataque: "+aux.getPtsAtaque());
            this.txtNome.setText(aux.getNome());
        }
    }

    //metodo que irá iniciar o jogo
    private void iniciaJogo(){
        //ação
        dicionario = new Bundle();
        dicionario.putString("nome", jogadores.get(perso).getNome());
        dicionario.putInt("atk", jogadores.get(perso).getPtsAtaque());
        dicionario.putInt("def", jogadores.get(perso).getPtsDefesa());
        dicionario.putInt("sta", jogadores.get(perso).getPtsEstamina());
        dicionario.putInt("ene", jogadores.get(perso).getPtsEnergia());
        dicionario.putInt("hp", jogadores.get(perso).getPtsVida());
        dicionario.putInt("esp", jogadores.get(perso).getPtsEspecial());
        dicionario.putInt("id", jogadores.get(perso).getId());
        //cria uma intenção e solicita a troca de telas
        solicitacao = new Intent(this, Cenario.class);
        //Dicionario de dados
        solicitacao.putExtras(dicionario);
        startActivity(solicitacao);
    }

    //metodo que irá mostrar o about
    private void mostraAbout(){
        //ação
    }

    private void carregaJogadores(){
        this.jogadores = new ArrayList<>();
        Jogador aux = new Jogador(1,"Lobei",86,46,98,68,97,5);
        this.jogadores.add(aux);
        aux = new Jogador(2,"Loka",44,99,29,80,38,10);
        this.jogadores.add(aux);
        aux = new Jogador(3,"Marquin",74,43,43,91,58,2);
        this.jogadores.add(aux);
    }

}
