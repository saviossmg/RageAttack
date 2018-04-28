package com.devops.freakattack.rageattack.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.devops.freakattack.rageattack.R;
import com.devops.freakattack.rageattack.model.Objeto;

public class Cenario extends AppCompatActivity implements View.OnClickListener {



    private Button ataque_1 = null;
    private Button ataque_2 = null;
    private TextView vida = null;
    private ImageView objeto = null;
    private Objeto cenario = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenario);
        //referencias visuais
        ataque_1 = (Button) findViewById(R.id.ataque_1);
        ataque_2 = (Button) findViewById(R.id.ataque_2);
        vida = (TextView) findViewById(R.id.textView_vida_qtd);
        objeto = (ImageView) findViewById(R.id.cenario_inimigo);
        cenario = new Objeto();


        //clicklistener
        ataque_1.setOnClickListener(this);
        ataque_2.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ataque_1:
                vida.setText("1");
                break;
            case R.id.ataque_2:
                vida.setText("2");
                break;
            default:
                break;

        }
    }
}
