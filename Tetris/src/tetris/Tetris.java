package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import tetris.logiikka.Pala;
import tetris.logiikka.Palikka;

/**
 * Pitää kirjaa kaikista Paloista ja pudottaa automaattisesti kulloinkin
 * käsiteltävää Palikkaa määrätyn aikavälein välein
 *
 * @author Wille Lehtomäki
 */
public class Tetris extends Timer implements ActionListener {

    private int palanKoko;
    private ArrayList<Pala> palat;
    private Palikka palikka;

    public Tetris() {
        super(650, null);

        addActionListener(this);
        setInitialDelay(1000);

        this.palanKoko = 25;
        this.palat = new ArrayList<>();
    }

    /**
     * Pudottaa kulloistakin Palikkaa asetetun aikavälin välein
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        palikka.liiku(0, 25);
    }

    /**
     * Lisää annetun Palan Tetrikseen
     *
     * @param pala lisättävä Pala
     */
    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    /**
     * Poistaa annetut Palat Tetriksestä
     *
     * @param poistettavat poistettavat Palat
     */
    public void poistaPalat(ArrayList<Pala> poistettavat) {
        for (Pala pala : poistettavat) {
            this.palat.remove(pala);
        }
    }

    /**
     * Lisää annetut Palat Tetrikseen
     *
     * @param lisattavat lisättävät palat
     */
    public void lisaaPalat(ArrayList<Pala> lisattavat) {
        for (Pala pala : lisattavat) {
            this.palat.add(pala);
        }
    }

    public int getPalanKoko() {
        return palanKoko;
    }

    public void setPalikka(Palikka palikka) {
        for (Pala pala : palikka.getPalat()) {
            this.palat.add(pala);
        }
        this.palikka = palikka;
    }

    public Palikka getPalikka() {
        return palikka;
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }
}
