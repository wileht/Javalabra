package tetris.logiikka;

import tetris.Tetris;
import tetris.gui.Piirtoalusta;

public class Liikuttaja {

    private Tetris tetris;
    private PalikanVaihtaja vaihtaja;
    private Piirtoalusta alusta;

    public Liikuttaja(Tetris tetris) {
        this.tetris = tetris;
    }

    public void liikuta(Palikka palikka, int dx, int dy) {
        for (Pala pala : palikka.getPalat()) {
            if (tormaakoSeinaan(pala, dx, dy) || tormaakoLattiaan(pala, dx, dy) || tormaakoToiseenPalaan(pala, dx, dy)) {
                return;
            }
        }

        for (Pala pala : palikka.getPalat()) {
            pala.liiku(dx, dy);
        }

        vaihdetaankoPalikka(palikka);
        alusta.paivita();
    }

    public boolean tormaakoSeinaan(Pala pala, int dx, int dy) {
        if ((pala.getX() + dx) >= 0 && pala.getX() + dx <= 325) {
            return false;
        }
        return true;
    }

    public boolean tormaakoLattiaan(Pala pala, int dx, int dy) {
        if (pala.getY() + dy <= 650) {
            return false;
        }
        return true;
    }

    public boolean tormaakoToiseenPalaan(Pala pala, int dx, int dy) {
        for (Pala toinenPala : tetris.getPalat()) {
            if (toinenPala != pala) {
                if (toinenPala.getX() == pala.getX() + dx
                        && toinenPala.getY() == pala.getY() + dy) {
                    return true;
                }
            }
        }
        return false;
    }

    public void vaihdetaankoPalikka(Palikka palikka) {
        if (osuukoLattiaan(palikka) || onkoAllaToinenPala(palikka)) {
            vaihtaja.vaihdaPalikka();
        }
    }

    public void setVaihtaja(PalikanVaihtaja vaihtaja) {
        this.vaihtaja = vaihtaja;
    }

    public boolean osuukoLattiaan(Palikka palikka) {
        for (Pala pala : palikka.getPalat()) {
            if (pala.getY() >= 625) {
                return true;
            }
        }
        return false;
    }

    public boolean onkoAllaToinenPala(Palikka palikka) {
        for (Pala toinenPala : tetris.getPalat()) {
            for (Pala pala : palikka.getPalat()) {
                if (toinenPala.getX() == pala.getX() && toinenPala.getY() == pala.getY() + 25) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setAlusta(Piirtoalusta alusta) {
        this.alusta = alusta;
    }
}
