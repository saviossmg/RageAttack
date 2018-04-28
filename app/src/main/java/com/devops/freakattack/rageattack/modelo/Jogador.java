package com.devops.freakattack.rageattack.modelo;

public class Jogador {

    private int id;
    private String nome;
    private int ptsVida;
    private int ptsEnergia;
    private int ptsEstamina;
    private int ptsAtaque;
    private int ptsDefesa;
    private int ptsEspecial;

    public Jogador(){
    }

    public Jogador(int id, String nome, int ptsVida, int ptsEnergia, int ptsEstamina, int ptsAtaque, int ptsDefesa, int ptsEspecial) {
        this.id = id;
        this.nome = nome;
        this.ptsVida = ptsVida;
        this.ptsEnergia = ptsEnergia;
        this.ptsEstamina = ptsEstamina;
        this.ptsAtaque = ptsAtaque;
        this.ptsDefesa = ptsDefesa;
        this.ptsEspecial = ptsEspecial;
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

    public int getPtsEnergia() {
        return ptsEnergia;
    }

    public void setPtsEnergia(int ptsEnergia) {
        this.ptsEnergia = ptsEnergia;
    }

    public int getPtsEstamina() {
        return ptsEstamina;
    }

    public void setPtsEstamina(int ptsEstamina) {
        this.ptsEstamina = ptsEstamina;
    }

    public int getPtsAtaque() {
        return ptsAtaque;
    }

    public void setPtsAtaque(int ptsAtaque) {
        this.ptsAtaque = ptsAtaque;
    }

    public int getPtsDefesa() {
        return ptsDefesa;
    }

    public void setPtsDefesa(int ptsDefesa) {
        this.ptsDefesa = ptsDefesa;
    }

    public int getPtsEspecial() {
        return ptsEspecial;
    }

    public void setPtsEspecial(int ptsEspecial) {
        this.ptsEspecial = ptsEspecial;
    }
}
