
package tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.logiikka.Pala;
import tetris.logiikka.Palikka;

public class Main {

    public static void main(String[] args) {
        Tetris tetris = new Tetris(25);
        
        Kayttoliittyma liittyma = new Kayttoliittyma(tetris);
        SwingUtilities.invokeLater(liittyma);
        
        while (liittyma.getAlusta() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        liittyma.asetaPalikanVaihtaja();
        
        tetris.setAlusta(liittyma.getAlusta());
        tetris.start();
    }
}
