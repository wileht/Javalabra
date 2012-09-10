
package tetris.logiikka;

import java.util.ArrayList;

public class Palikka {
    
    private ArrayList<Pala> palat;
    private PalikanVaihtaja vaihtaja;

    public Palikka(PalikanVaihtaja vaihtaja) {
        this.vaihtaja = vaihtaja;
        this.palat = new ArrayList<>();
    }

    public Palikka() {
        this.palat = new ArrayList<>();
    }
    
    public void liiku(int dx, int dy) {
        for (Pala pala : palat) {
            pala.liiku(dx, dy);
        }
        vaihdetaankoPalikka();
    }
    
    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }
    
    private void vaihdetaankoPalikka() {
        if (osuukoLattiaan()) {
            vaihdaPalikka();
        }
    }
    
    public boolean osuukoLattiaan() {
        for (Pala pala : palat) {
            if (pala.getY() >= 625) {
                return true;
            }
        }
        return false;
    }

    private void vaihdaPalikka() {
        vaihtaja.vaihdaPalikka();
    }

    public void setVaihtaja(PalikanVaihtaja vaihtaja) {
        this.vaihtaja = vaihtaja;
    }
}
