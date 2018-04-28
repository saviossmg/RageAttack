package com.devops.freakattack.rageattack.controlador;

import com.devops.freakattack.rageattack.modelo.Inimigo;
import com.devops.freakattack.rageattack.modelo.Jogador;

import java.util.Random;

public class Dano {

    private int multiFraco;
    private int multiMedio;
    private int multiForte;
    private int multiEspecial;
    private int multiDefesaini;
    private int multiDefesafim;
    private Random gerador;

    public Dano(){

    }

    public Dano(int multiFraco, int multiMedio, int multiForte, int multiEspecial, int multiDefesaini, int multiDefesafim) {
        this.multiFraco = multiFraco;
        this.multiMedio = multiMedio;
        this.multiForte = multiForte;
        this.multiEspecial = multiEspecial;
        this.multiDefesaini = multiDefesaini;
        this.multiDefesafim = multiDefesafim;
        this.gerador = null;
    }

    //calcula o dano de um ataque normal
    public int getDanoataque(String tipo, Jogador player){
        int danoCalculado = 0;
        //calcula o dano randomicamente
        gerador = new Random();
        int danoBruto = gerador.nextInt(player.getPtsAtaque()) + 1;
        switch (tipo){
            case "fraco":
                danoCalculado = danoBruto*(multiFraco/100);
                break;
            case "medio":
                danoCalculado = danoBruto*(multiMedio/100);
                break;
            case "forte":
                danoCalculado = danoBruto*(multiForte/100);
                break;
            default:
                danoCalculado = 0;
                break;
        }
        return danoCalculado;
    }

    //calcula o dano de um ataque especial
    public int getDanoespecial(Jogador player){
        int danoCalculado = 0;
        //calcula o dano randomicamente
        gerador = new Random();
        int danoBruto = gerador.nextInt(player.getPtsEspecial()) + 1;
        danoCalculado = danoBruto*10; //10x mais dano
        return danoCalculado;
    }

    //calcula o percentual de defesa - PLAYERS
    public int getPtsdefesaJ(Jogador player){
        int defesaCalculada = 0;
        //calcula o dano randomicamente
        gerador = new Random();
        int defesaBruta = gerador.nextInt(player.getPtsDefesa()) + 1;
        defesaCalculada = defesaBruta*(multiForte/100); //defesa sempre é o maximo atauqe mais forte
        return defesaCalculada;
    }

    //calcula o percentual de defesa - INIMIGOS
    public int getPtsdefesaI(Inimigo enemy){
        int defesaCalculada = 0;
        //calcula o dano randomicamente
        gerador = new Random();
        int defesaBruta = gerador.nextInt(enemy.getPtsDefesa()) + 1;
        defesaCalculada = defesaBruta*(multiForte/100); //defesa sempre é o maximo atauqe mais forte
        return defesaCalculada;
    }

    //escolhe o cenario
    public int getCenario(){
        gerador = new Random();
        return gerador.nextInt(5)+1;
    }

}
