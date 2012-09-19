package tetris.logiikka;

import tetris.Tetris;

public class Tormays {

    private Tetris tetris;

    public Tormays(Tetris tetris) {
        this.tetris = tetris;
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

    public boolean tormaakoPalaToiseenPalaan(Pala pala, int x, int y) {
        for (Pala toinenPala : tetris.getPalat()) {
            if (toinenPala != pala) {
                if (toinenPala.getX() == x
                        && toinenPala.getY() == y) {
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
        for (Pala toinenPala : tetris.getPalat()) {
            for (Pala pala : palikka.getPalat()) {
                if (toinenPala.getX() == pala.getX() && toinenPala.getY() == pala.getY() + 25) {
                    return true;
                }
            }
        }
        return false;
    }
}
