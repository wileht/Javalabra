package tetris.logiikka;

import java.util.ArrayList;

public class Palikka {

    private ArrayList<Pala> palat;
    private Liikuttaja liikuttaja;

    public Palikka(Liikuttaja liikuttaja) {
        this.liikuttaja = liikuttaja;
        this.palat = new ArrayList<>();
    }

    public Palikka() {
        this.palat = new ArrayList<>();
    }

    public void liiku(int dx, int dy) {
        liikuttaja.liikuta(this, dx, dy);
    }

    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }

    public void setLiikuttaja(Liikuttaja liikuttaja) {
        this.liikuttaja = liikuttaja;
    }
}
