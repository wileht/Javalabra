package tetris.logiikka;

import java.util.ArrayList;
import tetris.Tetris;

public class RivinTyhjentaja {

    private Tetris tetris;

    public RivinTyhjentaja(Tetris tetris) {
        this.tetris = tetris;
    }

    public void tarkistaRivit() {
        for (int i = 1; i <= 27; i++) {
            int montakoPalaaRivissa = 0;
            for (int j = 0; j < 14; j++) {
                for (Pala pala : tetris.getPalat()) {
                    if (pala.getX() == j * 25 && pala.getY() == i * 25 - 12) {
                        montakoPalaaRivissa++;
                    }
                }
            }
            if (montakoPalaaRivissa == 14) {
                tyhjennaRivi(i);
                tiputaYlempiaRiveja(i);
            }
        }
    }

    public void tyhjennaRivi(int i) {
        ArrayList<Pala> poistettavat = new ArrayList<>();
        for (Pala pala : tetris.getPalat()) {
            if (pala.getY() == i * 25 - 12) {
                poistettavat.add(pala);
            }
        }
        tetris.poistaPalat(poistettavat);
    }

    public void tiputaYlempiaRiveja(int i) {
        tetris.tiputaYlempiaRiveja(i);
    }
}
