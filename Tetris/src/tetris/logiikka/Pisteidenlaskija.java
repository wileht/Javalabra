package tetris.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import tetris.Tetris;

/**
 * Laskee pisteitä ja käskee Tetristä nopeutumaan
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
     * Lisää pisteet rivin tuhoutumisen jälkeen
     */
    public void lisaaRivinPisteet() {
        this.pisteet += 140;
    }

    /**
     * Käskee Tetristä nopeutumaan
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        tetris.nopeuta();
    }
    
    public int getPisteet() {
        return pisteet;
    }
}
