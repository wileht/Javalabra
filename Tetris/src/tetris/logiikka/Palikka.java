package tetris.logiikka;

import java.util.ArrayList;

public class Palikka {

    private ArrayList<Pala> palat;
//    private PalikanVaihtaja vaihtaja;
    private Liikuttaja liikuttaja;

    public Palikka(Liikuttaja liikuttaja) {
        this.liikuttaja = liikuttaja;
//        this.vaihtaja = vaihtaja;
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

    public boolean osuukoLattiaan() {
        for (Pala pala : palat) {
            if (pala.getY() >= 625) {
                return true;
            }
        }
        return false;
    }
//
//    public void vaihdaPalikka() {
//        vaihtaja.vaihdaPalikka();
//    }
//
//    public void setVaihtaja(PalikanVaihtaja vaihtaja) {
//        this.vaihtaja = vaihtaja;
//    }

    public void setLiikuttaja(Liikuttaja liikuttaja) {
        this.liikuttaja = liikuttaja;
    }

//    public PalikanVaihtaja getPalikanVaihtaja() {
//        return vaihtaja;
//    }
}
