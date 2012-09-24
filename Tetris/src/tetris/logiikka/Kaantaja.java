package tetris.logiikka;

import java.util.ArrayList;
import tetris.gui.Piirtoalusta;

public class Kaantaja {

    private Piirtoalusta alusta;
    private Tormays tormays;

    public Kaantaja(Piirtoalusta alusta, Tormays tormays) {
        this.alusta = alusta;
        this.tormays = tormays;
    }

    public void kaanna(Palikka palikka) {
        int kiintoX = palikka.getKiintopiste().getX();
        int kiintoY = palikka.getKiintopiste().getY();
        int dx = kiintoX + kiintoY;
        int dy = -1 * (kiintoX - kiintoY);

        Palikka kaantynyt = luoTestipalikka(palikka, dx, dy);

        if (tormaakoTestiPalikkaJohonkin(palikka, kaantynyt)) {
            return;
        }

        kaannaPalikka(palikka, dx, dy);

        tormays.vaihdetaankoPalikka(palikka);
        alusta.paivita();
    }

    public Palikka luoTestipalikka(Palikka palikka, int dx, int dy) {
        ArrayList<Pala> kaantynytPalikka = new ArrayList<>();

        for (Pala pala : palikka.getPalat()) {
            Pala uusi = new Pala(pala.getX(), pala.getY());
            kaantynytPalikka.add(uusi);
        }

        Palikka testipalikka = new Palikka(kaantynytPalikka);
        kaannaPalikka(testipalikka, dx, dy);

        return testipalikka;
    }

    public boolean tormaakoTestiPalikkaJohonkin(Palikka palikka, Palikka kaantynyt) {
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
