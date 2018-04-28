package com.devops.freakattack.rageattack.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
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
import com.devops.freakattack.rageattack.controlador.Dano;
import com.devops.freakattack.rageattack.modelo.Inimigo;
import com.devops.freakattack.rageattack.modelo.Jogador;
import com.devops.freakattack.rageattack.modelo.Objeto;

import java.util.ArrayList;

public class Cenario extends AppCompatActivity implements View.OnClickListener {

    //referencias visuais
    private Button ataque_fraco = null;
    private Button ataque_medio = null;
    private Button ataque_forte = null;
    private Button ataque_especial = null;
    private Button sair= null;
    private TextView vida = null;
    private TextView energia = null;
    private TextView estamina = null;
    private ImageView adversario = null;
    private ImageView cenario = null;
    private ImageView persoJogador = null;
    private ImageView[] statusJogador = null;
    private ImageView[] coracao = null;

    private AlertDialog alerta;

    //objetos necessarios
    private Jogador jog = null;
    private Inimigo adv = null;
    private Inimigo carro = null;
    private Inimigo heli = null;
    private ArrayList<Inimigo> inimigos = null;
    private Dano controladorJogo = null;

    //
    private String pNome;
    private int pVida;
    private int pAtaque;
    private int pDefesa;
    private int pStamina;
    private int pEnergia;
    private int pEspecial;
    private int pId;

    //
    private int rodizio = 1;

    int pos = 0;

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenario);

        //pega os dadosda itentn
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        pNome = bundle.getString("nome");
        pVida = bundle.getInt("hp");
        pAtaque = bundle.getInt("atk");
        pDefesa = bundle.getInt("def");
        pStamina = bundle.getInt("sta");
        pEnergia = bundle.getInt("ene");
        pEspecial = bundle.getInt("esp");
        pId = bundle.getInt("id");

        //referencias visuais
        this.ataque_fraco = (Button) findViewById(R.id.cenario_atkfraco);
        this.ataque_medio = (Button) findViewById(R.id.cenario_atkmedio);
        this.ataque_forte = (Button) findViewById(R.id.cenario_atkforte);
        this.ataque_especial = (Button) findViewById(R.id.cenario_atkespecial);
        this.sair = (Button) findViewById(R.id.cenario_btnsair);
        this.vida = (TextView) findViewById(R.id.cenario_txtvida);
        this.energia = (TextView) findViewById(R.id.cenario_txtenergia);
        this.estamina = (TextView) findViewById(R.id.cenario_txtstamina);
        this.adversario =(ImageView) findViewById(R.id.cenario_inimigo);
        this.cenario =(ImageView) findViewById(R.id.cenario_cenario);
        this.persoJogador =(ImageView) findViewById(R.id.cenario_imgperso);
        //inicializa o controldor que retonar os dados do jogo
        controladorJogo = new Dano(10,18,25,10,0,28);

        caraNormal();
        //coloca os corações
        this.coracao = new  ImageView[3];
        coracao[0] = (ImageView) findViewById(R.id.coracao1);
        coracao[1] = (ImageView) findViewById(R.id.coracao2);
        coracao[2] = (ImageView) findViewById(R.id.coracao3);

        //clicklistener
        ataque_fraco.setOnClickListener(this);
        ataque_medio.setOnClickListener(this);
        ataque_forte.setOnClickListener(this);
        ataque_especial.setOnClickListener(this);
        sair.setOnClickListener(this);


        //inicializa as coisas
        inicializarInimigos();
        inicilizaDadosjogador();
        iniciaJogo();

    }

    //inicia o jogo
    private void iniciaJogo(){
        //escolhe o cenario
        int cen = controladorJogo.getCenario();
        if(cen == 1) cenario.setBackground(getResources().getDrawable(R.drawable.cenarioaa));
        if(cen == 2) cenario.setBackground(getResources().getDrawable(R.drawable.cenariob));
        if(cen == 3) cenario.setBackground(getResources().getDrawable(R.drawable.cenarioc));
        if(cen == 4) cenario.setBackground(getResources().getDrawable(R.drawable.cenariod));
        if(cen == 5) cenario.setBackground(getResources().getDrawable(R.drawable.cenarioe));

        //

        if(rodizio % 2 == 0){
            pos = 1;
            adversario.setBackground(getResources().getDrawable(R.drawable.helicoptera));
        }else{
            pos = 0;
            adversario.setBackground(getResources().getDrawable(R.drawable.carroa));
        }
        pos++;

    }

    private void inicializarInimigos(){
        this.inimigos = new ArrayList<>();
        //cria o inimigo e adiciona no arryalist
        adv = new Inimigo(1,"Carro",50,20,10);
        carro = new Inimigo(1,"Carro",50,20,10);
        this.inimigos.add(adv);
        adv = new Inimigo(2,"Helicoptero",70,10,30);
        heli = new Inimigo(2,"Helicoptero",70,10, 30);
        this.inimigos.add(adv);
    }

    private void inicilizaDadosjogador(){
        jog = new Jogador();
        jog.setNome(pNome);
        jog.setPtsAtaque(pAtaque);
        jog.setPtsDefesa(pDefesa);
        jog.setPtsEnergia(pEnergia);
        jog.setPtsEspecial(pEspecial);
        jog.setPtsEstamina(pStamina);
        jog.setPtsVida(pVida);
        jog.setId(pId);
        //
        vida.setText("Vida: "+pVida+"/"+jog.getPtsVida());
        energia.setText("Energia: "+pEnergia+"/"+jog.getPtsEnergia());
        estamina.setText("Estamina: "+pStamina+"/"+jog.getPtsEstamina());


    }

    //clique dos botoes
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cenario_atkfraco:
                //ação
//                modificarVida(1);
//                vida.setText(Integer.toString(cenario.getVida()));
                vibrar("fraco");
                int dano = controladorJogo.getDanoataque("fraco", jog);
                modificarVida(1, dano);
                break;
            case R.id.cenario_atkmedio:
                //ação
//                modificarVida(2);
//                vida.setText(Integer.toString(cenario.getVida()));
                vibrar("medio");
                break;
            case R.id.cenario_atkforte:
                //ação
//                modificarVida(2);
//                vida.setText(Integer.toString(cenario.getVida()));
                vibrar("forte");
                break;
            case R.id.cenario_atkespecial:
                //ação
//                modificarVida(2);
//                vida.setText(Integer.toString(cenario.getVida()));
                vibrar("especial");
                break;
            case R.id.cenario_btnsair:
                //ação
                break;
            default:
                break;
        }
    }

    public void vibrar(String forca){
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        int m = 0;
        switch (forca){
            case "fraco":
                m = 200;
                vibrator.vibrate(m);
                mudaReact(m);
                break;
            case "medio":
                m = 300;
                vibrator.vibrate(m);
                mudaReact(m);
                break;
            case "forte":
                m = 400;
                vibrator.vibrate(m);
                mudaReact(m);
                break;
            case "especial":
                m = 600;
                vibrator.vibrate(m);
                mudaReact(m);
                break;
        }

    }

    private void mudaReact(int forca){
        //continuação do metodo anterior
        final int milis = forca;
        CountDownTimer d =  new CountDownTimer(milis, 1) {
            int m = milis;
            public void onTick(long millisUntilFinished) {
                //formata a string conforme o tempo avança
                mudaBotoes(false);
                if(m == 200) caraAtaque();
                if(m == 300) caraAtaque();
                if(m == 400) caraAtaque();
                if(m == 600) caraSuper();

            }
            public void onFinish() {
                mudaBotoes(true);
                caraNormal();
                this.cancel();
            }
        };
        d.start();

    }

    //metodos de mudanla
    private void mudaBotoes(boolean ativar){
        ataque_fraco.setEnabled(ativar);
        ataque_medio.setEnabled(ativar);
        ataque_forte.setEnabled(ativar);
        ataque_especial.setEnabled(ativar);
    }

    private void caraNormal(){
        if(pId == 1) persoJogador.setBackground(getResources().getDrawable(R.drawable.waldenormal));
        if(pId == 2) persoJogador.setBackground(getResources().getDrawable(R.drawable.lokanormal));
        if(pId == 3) persoJogador.setBackground(getResources().getDrawable(R.drawable.marquinnormal));
    }

    private void caraAtaque(){
        if(pId == 1) persoJogador.setBackground(getResources().getDrawable(R.drawable.walderataque));
        if(pId == 2) persoJogador.setBackground(getResources().getDrawable(R.drawable.lokaataque));
        if(pId == 3) persoJogador.setBackground(getResources().getDrawable(R.drawable.marquinataque));
    }

    private void caraSuper(){
        if(pId == 1) persoJogador.setBackground(getResources().getDrawable(R.drawable.waldersuper));
        if(pId == 2) persoJogador.setBackground(getResources().getDrawable(R.drawable.lokasuper));
        if(pId == 3) persoJogador.setBackground(getResources().getDrawable(R.drawable.marquinsuper));
    }

    private void caraDano(){
        if(pId == 1) persoJogador.setBackground(getResources().getDrawable(R.drawable.walderdano));
        if(pId == 2) persoJogador.setBackground(getResources().getDrawable(R.drawable.lokadano));
        if(pId == 3) persoJogador.setBackground(getResources().getDrawable(R.drawable.marquindano));
    }

    private void caraPosdano(){
        if(pId == 1) persoJogador.setBackground(getResources().getDrawable(R.drawable.walderposdano));
        if(pId == 2) persoJogador.setBackground(getResources().getDrawable(R.drawable.lokaposdano));
        if(pId == 3) persoJogador.setBackground(getResources().getDrawable(R.drawable.marquinposdano));

    }


    private void modificarVida(int opcao, int dano) {
        int vida = 0;
        if(dano > 0){

            Inimigo aux = inimigos.get(pos);
            vida = aux.getPtsVida() - dano;
            inimigos.get(pos).setPtsVida(vida);

            verificarVida(inimigos.get(pos));
        }

    }

    public void verificarVida(Inimigo ene){

        if(ene.getPtsVida() <= 0) {
            coracao[1].setVisibility(View.INVISIBLE);
            fimFase();
        }
        else if(ene.getPtsVida() <= 15) {
            if(ene.getId() == 1) adversario.setBackground(getResources().getDrawable(R.drawable.carroc));
            if(ene.getId() == 2) adversario.setBackground(getResources().getDrawable(R.drawable.helicopterc));
            coracao[2].setVisibility(View.INVISIBLE);
        }
        else if(ene.getPtsVida() <= 32) {
            if(ene.getId() == 1) adversario.setBackground(getResources().getDrawable(R.drawable.carrob));
            if(ene.getId() == 2) adversario.setBackground(getResources().getDrawable(R.drawable.helicopterb));
            coracao[0].setVisibility(View.INVISIBLE);

        }
    }


    private void fimFase() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Destruído!");
        //define a mensagem
        builder.setMessage("Veiculo totalmente destruído. Próxima a caminho !");
        //define um botão como positivo
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
        iniciaJogo();
    }

}


