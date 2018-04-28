package com.devops.freakattack.rageattack.modelo;

public class Inimigo {

    private int id;
    private String nome;
    private int ptsVida;
    private int ptsDefesa;
    private int ptsAtaque;

    public Inimigo(){

    }

    public Inimigo(int id, String nome, int ptsVida, int ptsDefesa, int ptsAtaque) {
        this.id = id;
        this.nome = nome;
        this.ptsVida = ptsVida;
        this.ptsDefesa = ptsDefesa;
        this.ptsAtaque = ptsAtaque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPtsVida() {
        return ptsVida;
    }

    public void setPtsVida(int ptsVida) {
        this.ptsVida = ptsVida;
    }

    public int getPtsDefesa() {
        return ptsDefesa;
    }

    public void setPtsDefesa(int ptsDefesa) {
        this.ptsDefesa = ptsDefesa;
    }

    public int getPtsAtaque() {
        return ptsAtaque;
    }

    public void setPtsAtaque(int ptsAtaque) {
        this.ptsAtaque = ptsAtaque;
    }
}
