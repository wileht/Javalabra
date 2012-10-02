package tetris.logiikka;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;

/**
 * Huolehtii uusien Palikoiden luomisesta ja muutoksen ilmoittamisesta Palikkaa
 * käyttäville luokille
 *
 * @author Wille Lehtomäki
 */
public class PalikanVaihtaja {

    private Tetris tetris;
    private Nappaimistonkuuntelija kuuntelija;
    private Liikuttaja liikuttaja;
    private RivinTyhjentaja tyhjentaja;
    private Random random = new Random();

    public PalikanVaihtaja(Tetris tetris, Nappaimistonkuuntelija kuuntelija, Liikuttaja liikuttaja,
            RivinTyhjentaja tyhjentaja) {
        this.tetris = tetris;
        this.kuuntelija = kuuntelija;
        this.liikuttaja = liikuttaja;
        this.tyhjentaja = tyhjentaja;
    }

    /**
     * Luo uuden Palikan ja antaa sen Tetrikselle ja Nappaimistonkuuntelijalle,
     * sekä tarkistaa Pelialueen täysien rivien varalta
     *
     * @see tetris.Tetris#setPalikka(Palikka)
     * @see tetris.gui.Nappaimistonkuuntelija#setPalikka(Palikka)
     * @see tetris.logiikka.RivinTyhjentaja#tarkistaRivit()
     */
    public void vaihdaPalikka() {
        Palikka uusi = luoUusiPalikka();
        if (liikuttaja.tormaakoLiikkunutPalikkaJohonkin(uusi, 0, 0)) {
            lopeta();
        }
        tetris.setPalikka(uusi);
        kuuntelija.setPalikka(uusi);
        tyhjentaja.tarkistaRivit();
    }

    /**
     * Arpoo luotavan Palikan tyypin ja luo sen
     *
     * @return palautettava Palikka
     */
    public Palikka luoUusiPalikka() {
        Palikka palautettava = null;
        Color vari = annaVari();
        int arpa = random.nextInt(7);
        if (arpa == 0) {
            palautettava = luoNelioPalikka(vari);
        } else if (arpa == 1) {
            palautettava = luoPitkulaPalikka(vari);
        } else if (arpa == 2) {
            palautettava = luoLPalikka(vari);
        } else if (arpa == 3) {
            palautettava = luoJPalikka(vari);
        } else if (arpa == 4) {
            palautettava = luoTPalikka(vari);
        } else if (arpa == 5) {
            palautettava = luoSPalikka(vari);
        } else if (arpa == 6) {
            palautettava = luoZPalikka(vari);
        }
        return palautettava;
    }

    /**
     * Luo neliön muotoisen Palikan ja palauttaa sen
     *
     * @return luotu neliöpalikka
     */
    public Palikka luoNelioPalikka(Color vari) {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -12, vari));
        palat.add(new Pala(150, -37, vari));
        palat.add(new Pala(175, -37, vari));

        Pala kiintopiste = new Pala(175, -12, vari);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    /**
     * Luo suoran Palikan ja palauttaa sen
     *
     * @return luotu suora palikka
     */
    public Palikka luoPitkulaPalikka(Color vari) {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(175, -12, vari));
        palat.add(new Pala(175, -62, vari));
        palat.add(new Pala(175, -87, vari));

        Pala kiintopiste = new Pala(175, -37, vari);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    /**
     * Luo L-kirjaimen muotoisen Palikan ja palauttaa sen
     *
     * @return luotu palikka
     */
    public Palikka luoLPalikka(Color vari) {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(200, -12, vari));
        palat.add(new Pala(175, -12, vari));
        palat.add(new Pala(175, -62, vari));

        Pala kiintopiste = new Pala(175, -37, vari);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    /**
     * Luo J-kirjaimen muotoisen Palikan ja palauttaa sen
     *
     * @return luotu palikka
     */
    public Palikka luoJPalikka(Color vari) {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -12, vari));
        palat.add(new Pala(175, -12, vari));
        palat.add(new Pala(175, -62, vari));

        Pala kiintopiste = new Pala(175, -37, vari);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    /**
     * Luo T-kirjaimen muotoisen Palikan ja palauttaa sen
     *
     * @return luotu palikka
     */
    public Palikka luoTPalikka(Color vari) {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -37, vari));
        palat.add(new Pala(200, -37, vari));
        palat.add(new Pala(175, -12, vari));

        Pala kiintopiste = new Pala(175, -37, vari);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    /**
     * Luo S-kirjaimen muotoisen Palikan ja palauttaa sen
     *
     * @return luotu palikka
     */
    public Palikka luoSPalikka(Color vari) {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -12, vari));
        palat.add(new Pala(175, -37, vari));
        palat.add(new Pala(200, -37, vari));

        Pala kiintopiste = new Pala(175, -12, vari);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    /**
     * Luo Z-kirjaimen muotoisen Palikan ja palauttaa sen
     *
     * @return luotu palikka
     */
    public Palikka luoZPalikka(Color vari) {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -37, vari));
        palat.add(new Pala(175, -37, vari));
        palat.add(new Pala(200, -12, vari));

        Pala kiintopiste = new Pala(175, -12, vari);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    /**
     * Arpoo ja palauttaa uuden värin pitäen huolta, ettei saatu väri
     * ole pelin taustan värinen
     *
     * @return arvottu väri
     */
    private Color annaVari() {
        Color vari = null;
        while (true) {
            vari = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            if (Math.abs(vari.getRed() - 238) + Math.abs(vari.getGreen() - 238)
                    + Math.abs(vari.getBlue() - 238) >= 60) {
                break;
            }
        }
        return vari;
    }

    /**
     * Lopettaa pelin pysäyttämällä Palikoiden automaattisen tiputuksen
     * ja näppäinohjauksen
     * 
     * @see tetris.Tetris#lopeta()
     * @see tetris.logiikka.Nappaimistonkuuntelija#lopeta()
     */
    private void lopeta() {
        tetris.lopeta();
        kuuntelija.lopeta();
    }
}
