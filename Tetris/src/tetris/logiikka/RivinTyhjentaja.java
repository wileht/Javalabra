package tetris.logiikka;

import java.util.ArrayList;
import tetris.Tetris;

/**
 * Tarkistaa pelialueen rivit ja tyhjentää täydet rivit
 *
 * @author Wille Lehtomäki
 */
public class RivinTyhjentaja {

    private Tetris tetris;
    private Liikuttaja liikuttaja;
    private Pisteidenlaskija laskija;

    public RivinTyhjentaja(Tetris tetris, Liikuttaja liikuttaja) {
        this.tetris = tetris;
        this.liikuttaja = liikuttaja;
    }

    /**
     * Käy läpi kaikki pelialueen rivit ja tyhjentää täydet rivit. Rivin
     * tyhjentyessä pudotetaan ylempänä olevia Paloja ja annetaan pisteitä.
     *
     * @see tyhjennaRivi(int)
     * @see tetris.logiikka.Pisteidenlaskija#lisaaRivinPisteet()
     * @see tiputaYlempiaRiveja(int)
     */
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
                laskija.lisaaRivinPisteet();
                tiputaYlempiaRiveja(i);
            }
        }
    }

    /**
     * Kerää tyhjennettävällä rivillä olevat Palat listaan ja antaa ne luokalle
     * Tetris poistettaviksi
     *
     * @param i tyhjennettävän rivin numero
     * @see tetris.Tetris#poistaPalat(ArrayList<Pala>)
     */
    public void tyhjennaRivi(int i) {
        ArrayList<Pala> poistettavat = new ArrayList<>();
        for (Pala pala : tetris.getPalat()) {
            if (pala.getY() == i * 25 - 12) {
                poistettavat.add(pala);
            }
        }
        tetris.poistaPalat(poistettavat);
    }

    /**
     * Tiputtaa kaikkien ylempien rivien Paloja luokan Liikuttaja avullta
     *
     * @param i rivi, jota ylempänä sijaitsevia Paloja pudotetaan
     * @see tetris.logiikka.Liikuttaja(tiputaYlempiaRiveja(int)
     */
    public void tiputaYlempiaRiveja(int i) {
        liikuttaja.tiputaYlempiaRiveja(i);
    }

    public void setLaskija(Pisteidenlaskija laskija) {
        this.laskija = laskija;
    }
}
