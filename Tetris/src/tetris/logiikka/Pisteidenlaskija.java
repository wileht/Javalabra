package tetris.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import tetris.Tetris;

/**
 * Laskee pisteitä ja käskee Tetristä nopeutumaan tasaisin väliajoin
 *
 * @author Wille Lehtomäki
 */
public class Pisteidenlaskija extends Timer implements ActionListener {

    private Tetris tetris;
    private int pisteet;

    public Pisteidenlaskija(Tetris tetris) {
        super(15000, null);
        addActionListener(this);

        this.tetris = tetris;
        this.pisteet = 0;
    }

    /**
     * Käskee Tetristä nopeutumaan
     *
     * @see tetris.Tetris#nopeuta()
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tetris.nopeuta();
    }

    /**
     * Lisää rivin tuhoamisesta saadut pisteet
     */
    public void lisaaRivinPisteet() {
        this.pisteet += 140;
    }

    /**
     * Nollaa pistetilanteen
     */
    public void tyhjenna() {
        this.pisteet = 0;
    }

    public int getPisteet() {
        return pisteet;
    }
}
