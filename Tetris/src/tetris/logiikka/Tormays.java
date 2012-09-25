package tetris.logiikka;

import java.util.ArrayList;
import tetris.Tetris;

public class Tormays {

    private Tetris tetris;
    private PalikanVaihtaja vaihtaja;

    public Tormays(Tetris tetris, PalikanVaihtaja vaihtaja) {
        this.tetris = tetris;
        this.vaihtaja = vaihtaja;
    }

    public boolean tormaakoRajoihin(int x, int y) {
        if (tormaakoPalaSeinaan(x)
                || tormaakoPalaLattiaan(y)) {
            return true;
        }
        return false;
    }

    public boolean tormaakoPalaSeinaan(int x) {
        if (x >= 0 && x <= 325) {
            return false;
        }
        return true;
    }

    public boolean tormaakoPalaLattiaan(int y) {
        if (y <= 650) {
            return false;
        }
        return true;
    }

    public boolean tormaakoPalikkaPalaan(Palikka palikka, int dx, int dy) {
        ArrayList<Pala> muutPalat = palikanUlkopuolisetPalat(palikka);
        ArrayList<Pala> palikanPalat = palikka.getPalat();
        for (Pala palikanPala : palikanPalat) {
            for (Pala muuPala : muutPalat) {
                if (palikanPala.getX() + dx == muuPala.getX()
                        && palikanPala.getY() + dy == muuPala.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tormaakoKaantynytPalikkaPalaan(Palikka kaantynyt, ArrayList<Pala> muutPalat) {
        for (Pala palikanPala : kaantynyt.getPalat()) {
            for (Pala tetriksenPala : muutPalat) {
                if (palikanPala.getX() == tetriksenPala.getX()
                        && palikanPala.getY() == tetriksenPala.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean osuukoPalikkaLattiaan(Palikka palikka) {
        for (Pala pala : palikka.getPalat()) {
            if (pala.getY() >= 625) {
                return true;
            }
        }
        return false;
    }

    public boolean onkoPalikanAllaPala(Palikka palikka) {
        for (Pala toinenPala : palikanUlkopuolisetPalat(palikka)) {
            for (Pala pala : palikka.getPalat()) {
                if (toinenPala.getX() == pala.getX() && toinenPala.getY() == pala.getY() + 25) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Pala> palikanUlkopuolisetPalat(Palikka palikka) {
        ArrayList<Pala> palat = new ArrayList<>();

        for (Pala tetriksenPala : tetris.getPalat()) {
            if (!palikka.getPalat().contains(tetriksenPala)) {
                palat.add(tetriksenPala);
            }
        }

        return palat;
    }

    public void vaihdetaankoPalikka(Palikka palikka) {
        if (osuukoPalikkaLattiaan(palikka) || onkoPalikanAllaPala(palikka)) {
            vaihtaja.vaihdaPalikka();
        }
    }
//
//    public PalikanVaihtaja getVaihtaja() {
//        return vaihtaja;
//    }
}
