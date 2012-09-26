package tetris.logiikka;

import java.util.ArrayList;
import tetris.Tetris;

/**
 * Huolehtii siitä, etteivät Palat ja Palikat pääse läpi pelialueen rajoista tai
 * liikkumaan toistensa päälle
 *
 * @author Wille Lehtomäki
 */
public class Tormays {

    private Tetris tetris;
    private PalikanVaihtaja vaihtaja;

    public Tormays(Tetris tetris, PalikanVaihtaja vaihtaja) {
        this.tetris = tetris;
        this.vaihtaja = vaihtaja;
    }

    /**
     * Tarkistaa, ovatko annetut koordinaatit pelialueen sisällä
     *
     * @param x annettu x-koordinaatti
     * @param y annettu y-koordinaatti
     * @return onko koordinaatti pelialueessa
     * @see tormaakoPalaSeinaan(int)
     * @see tormaakoPalaLattiaan(int)
     */
    public boolean tormaakoRajoihin(int x, int y) {
        if (tormaakoPalaSeinaan(x)
                || tormaakoPalaLattiaan(y)) {
            return true;
        }
        return false;
    }

    /**
     * Tarkistaa, onko annettu x-koordinaatti pelialueen sisällä
     *
     * @param x annettu x-koordinaatti
     * @return onko koordinaatti pelialueessa
     */
    public boolean tormaakoPalaSeinaan(int x) {
        if (x >= 0 && x <= 325) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistaa, onko annettu y-koordinaatti pelialueen lattian yläpuolella
     *
     * @param y annettu y-koordinaatti
     * @return onko koordinaatti lattian yläpuolella
     */
    public boolean tormaakoPalaLattiaan(int y) {
        if (y <= 650) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistaa, osuuko Palikan mikään Pala johonkin muuhun Tetriksen Palaan
     *
     * @param palikka tarkistettava Palikka
     * @param dx mahdollinen muutos Palikan Palojen x-koordinaatteihin
     * @param dy mahdollinen muutos Palikan Palojen y-koordinaatteihin
     * @return tormaako Palikka ulkopuoliseen Palaan
     * @see palikanUlkopuolisetPalat(Palikka)
     */
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

    /**
     * Tarkistaa, tormääkö käännetty Palikka johonkin Tetriksen Palaan
     *
     * @param kaantynyt käännetty palikka
     * @param muutPalat muut Tetriksen Palat kuin käännetyn Palikan Palat
     * @return tormaako käännetty Palikka ulkopuoliseen Palaan
     */
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

    /**
     * Tarkistaa, osuuko jokin Palikan Paloista pelialueen lattiaan
     *
     * @param palikka tarkistettava Palikka
     * @return osuuko Palikka lattiaan
     */
    public boolean osuukoPalikkaLattiaan(Palikka palikka) {
        for (Pala pala : palikka.getPalat()) {
            if (pala.getY() >= 625) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tarkistaa, onko Palikan alapuolella ulkopuolista Palaa
     *
     * @param palikka tarkistettava Palikka
     * @return onko Palikan alla Palaa
     */
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

    /**
     * Antaa Listana kaikki ne Tetriksen Palat, jotka eivät ole annetussa
     * Palikassa
     *
     * @param palikka tarkasteltava Palikka
     * @return kaikki Tetriksen Palat, jotka eivät ole palikassa
     */
    public ArrayList<Pala> palikanUlkopuolisetPalat(Palikka palikka) {
        ArrayList<Pala> palat = new ArrayList<>();

        for (Pala tetriksenPala : tetris.getPalat()) {
            if (!palikka.getPalat().contains(tetriksenPala)) {
                palat.add(tetriksenPala);
            }
        }

        return palat;
    }

    /**
     * Tarkistaa, pitääkö Palikka vaihtaa, eli osuuko se lattiaan tai onko sen
     * alla ulkopuolista Palaa
     *
     * @param palikka tarkasteltava Palikka
     * @see osuukoPalikkaLattiaan(Palikka)
     * @see onkoPalikanAllaPala(Palikka)
     * @see tetris.logiikka.Vaihtaja#vaihdaPalikka()
     */
    public void vaihdetaankoPalikka(Palikka palikka) {
        if (osuukoPalikkaLattiaan(palikka) || onkoPalikanAllaPala(palikka)) {
            vaihtaja.vaihdaPalikka();
        }
    }
}
