package tetris.logiikka;

import tetris.Tetris;
import tetris.gui.Piirtoalusta;

public class Liikuttaja {

    private Tetris tetris;
    private PalikanVaihtaja vaihtaja;
    private Piirtoalusta alusta;
    private RivinTyhjentaja tyhjentaja;
    private Tormays tormays;

    public Liikuttaja(Tetris tetris) {
        this.tetris = tetris;
    }

    public void liikuta(Palikka palikka, int dx, int dy) {
        for (Pala pala : palikka.getPalat()) {
            if (tormays.tormaakoPalaSeinaan(pala, pala.getX() + dx, pala.getX() + dx)
                    || tormays.tormaakoPalaLattiaan(pala, pala.getY() + dy)
                    || tormays.tormaakoPalaToiseenPalaan(pala, pala.getX() + dx, pala.getY() + dy)) {
                return;
            }
        }

        for (Pala pala : palikka.getPalat()) {
            pala.liiku(dx, dy);
        }

        vaihdetaankoPalikka(palikka);
        alusta.paivita();
    }

    public void vaihdetaankoPalikka(Palikka palikka) {
        if (tormays.osuukoPalikkaLattiaan(palikka) || tormays.onkoPalikanAllaToinenPala(palikka)) {
            vaihtaja.vaihdaPalikka();
        }
    }

    public void setVaihtaja(PalikanVaihtaja vaihtaja) {
        this.vaihtaja = vaihtaja;
    }

    public void tiputaYlempiaRiveja(int i) {
        for (Pala pala : tetris.getPalat()) {
            if (pala.getY() <= i * 25 - 12) {
                pala.liiku(0, 25);
            }
            tyhjentaja.tarkistaRivit();
        }
    }
    
    public void setAlusta(Piirtoalusta alusta) {
        this.alusta = alusta;
    }

    public void setTyhjentaja(RivinTyhjentaja tyhjentaja) {
        this.tyhjentaja = tyhjentaja;
    }

    public void setTormays(Tormays tormays) {
        this.tormays = tormays;
    }
}
