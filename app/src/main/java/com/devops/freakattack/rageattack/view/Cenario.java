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
//    private ImageView[] coracao = null;

    private AlertDialog alerta;

    //objetos necessarios
    private Jogador jog = null;
    private Inimigo adv = null;
    private ArrayList<Inimigo> inimigos = null;

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
    private int rodizio = 0;

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

        //coloca os corações
//        this.coracao = new  ImageView[3];
//        coracao[0] = (ImageView) findViewById(R.id.coracao1);
//        coracao[1] = (ImageView) findViewById(R.id.coracao2);
//        coracao[2] = (ImageView) findViewById(R.id.coracao3);

        //clicklistener
        ataque_fraco.setOnClickListener(this);
        ataque_medio.setOnClickListener(this);
        ataque_forte.setOnClickListener(this);
        ataque_especial.setOnClickListener(this);
        sair.setOnClickListener(this);


        //inicializa as coisas
        inicializarInimigos();
        inicilizaDadosjogador();


    }

    //inicia o jogo
    private void iniciaJogo(){

    }

    private void inicializarInimigos(){
        this.inimigos = new ArrayList<>();
        //cria o inimigo e adiciona no arryalist
        adv = new Inimigo(1,"Carro",50,20,10);
        this.inimigos.add(adv);
        adv = new Inimigo(2,"Helicoptero",80,10,30);
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
        vida.setText("Estamina: "+pStamina+"/"+jog.getPtsEstamina());
        if(jog.getId() == 1) persoJogador.setBackground(getResources().getDrawable(R.drawable.waldenormal));
        if(jog.getId() == 2) persoJogador.setBackground(getResources().getDrawable(R.drawable.lokanormal));
        if(jog.getId() == 3) persoJogador.setBackground(getResources().getDrawable(R.drawable.marquinnormal));

    }

    //clique dos botoes
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cenario_atkfraco:
                //ação
//                modificarVida(1);
//                vida.setText(Integer.toString(cenario.getVida()));
                vibrar("fraco");
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
        switch (forca){
            case "fraco":
                vibrator.vibrate(100);
                break;
            case "medio":
                vibrator.vibrate(150);
                break;
            case "forte":
                vibrator.vibrate(200);
                break;
            case "especial":
                vibrator.vibrate(300);
                break;



        }

    }

/*
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
*/

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
    }

}


