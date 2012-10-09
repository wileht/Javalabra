package tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {
        Tetris tetris = new Tetris();

        Kayttoliittyma liittyma = new Kayttoliittyma(tetris);
        SwingUtilities.invokeLater(liittyma);

        while (liittyma.getAlusta() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        tetris.luoPeli(liittyma);
    }
}
