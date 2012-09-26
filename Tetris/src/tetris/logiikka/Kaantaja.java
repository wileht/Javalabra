package tetris.logiikka;

import java.util.ArrayList;
import tetris.gui.Piirtoalusta;

/**
 * Kääntää Palikoita 90 astetta myötäpäivään metodilla kaanna(Palikka)
 *
 * @see kaanna(Palikka)
 * @author Wille Lehtomäki
 */
public class Kaantaja {

    private Piirtoalusta alusta;
    private Tormays tormays;

    public Kaantaja(Piirtoalusta alusta, Tormays tormays) {
        this.alusta = alusta;
        this.tormays = tormays;
    }

    /**
     * Tarkistaa, voiko annetun Palikan kääntää ja mikäli voi, kääntää sen.
     * Käännöksen jälkeen tarkistetaan, pitääkö palikka vaihtaa ja pyydetään
     * Piirtoalustaa piirtämään pelitilanne. Kääntäessä käännös suoritetaan
     * koordinaatiston origon suhteen, joten Palojen koordinaatteihin on
     * suoritettava käännöksen jälkeen korjaus, jonka suuruus lasketaan metodin
     * alussa.
     *
     * @see luoTestipalikka(Palikka, int, int)
     * @see tormaakoTestiPalikkaJohonkin(Palikka, Palikka)
     * @see kaannaPalikka(Palikka, int, int)
     * @see tetris.logiikka.Tormays#vaihdetaankoPalikka(Palikka)
     * @see tetris.gui.Piirtoalusta#paivita()
     * @param palikka Käännettävä palikka
     */
    public void kaanna(Palikka palikka) {
        int kiintoX = palikka.getKiintopiste().getX();
        int kiintoY = palikka.getKiintopiste().getY();
        int dx = kiintoX + kiintoY;
        int dy = kiintoY - kiintoX;

        Palikka kaantynyt = luoTestipalikka(palikka, dx, dy);

        if (tormaakoTestiPalikkaJohonkin(palikka, kaantynyt)) {
            return;
        }

        kaannaPalikka(palikka, dx, dy);

        tormays.vaihdetaankoPalikka(palikka);
        alusta.paivita();
    }

    /**
     * Kopioi annetun Palikan ja palauttaa kopion käännettynä
     *
     * @param palikka Kopioitava Palikka
     * @param dx Kiintopisteestä saatu korjaus Palikan Palojen
     * x-koordinaatteihin
     * @param dy Kiintopisteestä saatu korjaus Palikan Palojen
     * y-koordinaatteihin
     * @return
     */
    private Palikka luoTestipalikka(Palikka palikka, int dx, int dy) {
        ArrayList<Pala> kaantynytPalikka = new ArrayList<>();

        for (Pala pala : palikka.getPalat()) {
            Pala uusi = new Pala(pala.getX(), pala.getY(), null);
            kaantynytPalikka.add(uusi);
        }

        Palikka testipalikka = new Palikka(kaantynytPalikka);
        kaannaPalikka(testipalikka, dx, dy);

        return testipalikka;
    }

    private boolean tormaakoTestiPalikkaJohonkin(Palikka palikka, Palikka kaantynyt) {
        for (Pala pala : kaantynyt.getPalat()) {
            if (tormays.tormaakoRajoihin(pala.getX(), pala.getY())) {
                return true;
            }
        }
        if (tormays.tormaakoKaantynytPalikkaPalaan(kaantynyt, tormays.palikanUlkopuolisetPalat(palikka))) {
            return true;
        }

        return false;
    }

    /**
     * Kääntää annetun palikan ja korjaa sen paikan
     *
     * @param palikka Käännettävä Palikka
     * @param dx Kiintopisteestä saatu korjaus Palikan Palojen
     * x-koordinaatteihin
     * @param dy Kiintopisteestä saatu korjaus Palikan Palojen
     * y-koordinaatteihin
     */
    public void kaannaPalikka(Palikka palikka, int dx, int dy) {
        for (Pala pala : palikka.getPalat()) {
            int alkuX = pala.getX();
            int alkuY = pala.getY();
            pala.setX(-1 * alkuY);
            pala.setY(alkuX);
            pala.liiku(dx, dy);
        }
    }
}
