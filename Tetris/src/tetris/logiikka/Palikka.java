package tetris.logiikka;

import java.util.ArrayList;

/**
 * Palikka koostuu neljästä Palasta, joista yksi on samalla myös kääntämisessä
 * tarvittava kiintopiste, jonka ympäri muut Palat pyörivät. Palikkaa
 * liikuttaessa tai kääntäessä sen jokainen Pala liikkuu. Vain yksi Palikka on
 * kerrallaan käsiteltävänä.
 *
 * @author Wille Lehtomäki
 */
public class Palikka {

    private ArrayList<Pala> palat;
    private Liikuttaja liikuttaja;
    private Pala kiintopiste;

    public Palikka(Liikuttaja liikuttaja, ArrayList<Pala> palat, Pala kiintopiste) {
        this.liikuttaja = liikuttaja;
        this.palat = palat;
        this.kiintopiste = kiintopiste;
    }

    /**
     * Vaihtoehtoinen, luokan Kaantaja käyttämä konstruktori
     *
     * @see tetris.logiikka.Kaantaja#luoTestipalikka(Palikka, int, int)
     * @param palat
     */
    public Palikka(ArrayList<Pala> palat) {
        this.palat = palat;
    }

    /**
     * Liikuttaa Palikkaa haluttuun suuntaan luokan Liikuttaja avulla
     *
     * @param dx haluttu muutos Palikan Palojen x-koordinaatteihin
     * @param dy haluttu muutos Palikan Palojen y-koordinaatteihin
     * @see tetris.logiikka.Liikuttaja#liiku(Palikka, int, int)
     */
    public void liiku(int dx, int dy) {
        liikuttaja.liikuta(this, dx, dy);
    }

    /**
     * Pudottaa Palikan niin alas kuin mahdollista luokan Liikuttaja avulla
     *
     * @see tetris.logiikka.Liikuttaja#pudota(Palikka)
     */
    public void putoa() {
        liikuttaja.pudota(this);
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }

    public void setLiikuttaja(Liikuttaja liikuttaja) {
        this.liikuttaja = liikuttaja;
    }

    public Pala getKiintopiste() {
        return kiintopiste;
    }
}
