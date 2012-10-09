package tetris.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.Tetris;
import tetris.logiikka.Pala;

/**
 * Piirtää pelin ja päivittää pelitilanteen metodilla paivita()
 *
 * @see paivita()
 * @author Wille Lehtomäki
 */
public class Piirtoalusta extends JPanel {

    private Tetris tetris;

    public Piirtoalusta(Tetris tetris) {
        this.tetris = tetris;
    }

    /**
     * Piirtää ruudukon ja luokan Tetris sisältämät Palat pelialueelle
     *
     * @see tetris.Tetris#getPalat()
     * @see piirraRuudukko(Graphics)
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        piirraRuudukko(graphics);

        for (Pala pala : tetris.getPalat()) {
            graphics.setColor(pala.getVari());
            graphics.fill3DRect(pala.getX() + 1, pala.getY() + 1,
                    tetris.getPalanKoko() - 2, tetris.getPalanKoko() - 2, true);
        }
    }

    /**
     * Piirtää pelitilanteen uudelleen
     */
    public void paivita() {
        repaint();
    }

    /**
     * Piirtää koko pelialueen kattavan ruudukon
     *
     * @param graphics
     */
    private void piirraRuudukko(Graphics graphics) {
        graphics.setColor(new Color(225, 225, 225));

        for (int i = 0; i <= 14; i++) {
            graphics.drawLine(i * 25, 0, i * 25, 675);
        }
        for (int i = 0; i <= 27; i++) {
            graphics.drawLine(0, i * 25 - 12, 350, i * 25 - 12);
        }
    }
}
