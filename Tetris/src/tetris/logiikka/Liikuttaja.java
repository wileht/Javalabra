package tetris.logiikka;

import tetris.Tetris;
import tetris.gui.Piirtoalusta;

/**
 * Huolehtii Palikoiden ja Palojen liikuttamisesta
 *
 * @author Wille Lehtomäki
 */
public class Liikuttaja {

    private Tetris tetris;
    private Piirtoalusta alusta;
    private RivinTyhjentaja tyhjentaja;
    private Tormays tormays;

    public Liikuttaja(Tetris tetris) {
        this.tetris = tetris;
    }

    /**
     * Tarkistaa, voiko annettu Palikka liikkua annetun verran, ja myönteisessä
     * tapauksessa liikuttaa sitä. Lopuksi tarkistetaan, täytyykö Palikka
     * vaihtaa ja päivitetään Piirtoalusta.
     *
     * @see tormaakoLiikkunutPalikkaJohonkin(Palikka, int, int)
     * @see tetris.logiikka.Pala#liiku(int, int)
     * @see tetris.logiikka.Tormays#vaihdetaankoPalikka(Palikka)
     * @see tetris.gui.Piirtoalusta#paivita()
     * @param palikka Liikutettava Palikka
     * @param dx Haluttu muutos Palikan sijaintiin x-akselilla
     * @param dy Haluttu muutos Palikan sijaintiin y-akselilla
     */
    public void liikuta(Palikka palikka, int dx, int dy) {
        if (tormaakoLiikkunutPalikkaJohonkin(palikka, dx, dy)) {
            return;
        }

        for (Pala pala : palikka.getPalat()) {
            pala.liiku(dx, dy);
        }

        tormays.vaihdetaankoPalikka(palikka);
        alusta.paivita();
    }

    public boolean tormaakoLiikkunutPalikkaJohonkin(Palikka palikka, int dx, int dy) {
        for (Pala pala : palikka.getPalat()) {
            if (tormays.tormaakoRajoihin(pala.getX() + dx, pala.getY() + dy)) {
                return true;
            }
        }
        if (tormays.tormaakoPalikkaPalaan(palikka, dx, dy)) {
            return true;
        }

        return false;
    }

    /**
     * Tiputtaa täyteen tulleen rivin tyhjentämisen jälkeen kaikkien ylempien
     * rivien Paloja
     *
     * @param i rivi, jonka yläpuolisten rivien Paloja halutaan pudottaa
     */
    public void tiputaYlempiaRiveja(int i) {
        for (Pala pala : tetris.getPalat()) {
            if (pala.getY() <= i * 25 - 12) {
                pala.liiku(0, 25);
            }
        }
    }

    /**
     * Pudottaa annetun Palikan niin alas kuin mahdollista
     *
     * @param palikka
     */
    public void pudota(Palikka palikka) {
        while (true) {
            Pala pala = palikka.getPalat().get(0);
            int Yalussa = pala.getY();
            liikuta(palikka, 0, 25);
            int Ylopussa = pala.getY();

            if (Yalussa == Ylopussa) {
                break;
            }
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
