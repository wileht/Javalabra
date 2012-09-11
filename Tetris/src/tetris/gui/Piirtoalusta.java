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
        graphics.setColor(Color.RED);

        for (Pala pala : tetris.getPalat()) {
            graphics.fill3DRect(pala.getX(), pala.getY(), tetris.getPalanKoko(), tetris.getPalanKoko(), true);
        }
    }

    public void paivita() {
        repaint();
    }
}
