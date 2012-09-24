package tetris.logiikka;

import java.util.ArrayList;

public class Palikka {

    private ArrayList<Pala> palat;
    private Liikuttaja liikuttaja;
    private Pala kiintopiste;

    public Palikka(Liikuttaja liikuttaja, ArrayList<Pala> palat, Pala kiintopiste) {
        this.liikuttaja = liikuttaja;
        this.palat = palat;
        this.kiintopiste = kiintopiste;
    }

    public Palikka() {
        this.palat = new ArrayList<>();
    }

    public Palikka(ArrayList<Pala> palat) {
        this.palat = palat;
    }

    public void liiku(int dx, int dy) {
        liikuttaja.liikuta(this, dx, dy);
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }

    public void setLiikuttaja(Liikuttaja liikuttaja) {
        this.liikuttaja = liikuttaja;
    }

    public Pala getKiintopiste() {
        return kiintopiste;
    }
}
