package tetris.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.Tetris;
import tetris.logiikka.Pala;

public class Piirtoalusta extends JPanel {

    private Tetris tetris;

    public Piirtoalusta(Tetris tetris) {
        this.tetris = tetris;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
//        piirraRuudukko(graphics);
//        testiPiirros(graphics);
        graphics.setColor(Color.RED);

        for (Pala pala : tetris.getPalat()) {
            graphics.fill3DRect(pala.getX() + 1, pala.getY() + 1,
                    tetris.getPalanKoko() - 2, tetris.getPalanKoko() - 2, true);
        }
    }

    public void paivita() {
        repaint();
    }

    private void piirraRuudukko(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        
        for (int i = 0; i < 14; i++) {
            graphics.drawLine(i * 25, 0, i * 25, 675);
        }
        
        for (int i = 0; i < 27; i++) {
            graphics.drawLine(0, i * 25 - 12, 350, i * 25 - 12);
        }
    }

    private void testiPiirros(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.drawString("Testi", 10, 10);
        graphics.fillRect(-1, 663, 367, 3);
    }
}
