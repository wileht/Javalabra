package tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.logiikka.Liikuttaja;
import tetris.logiikka.PalikanVaihtaja;

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

        Liikuttaja liikuttaja = new Liikuttaja(tetris);
        tetris.getPalikka().setLiikuttaja(liikuttaja);

        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, liittyma.getKuuntelija(), liikuttaja);
        liikuttaja.setVaihtaja(vaihtaja);

        tetris.setAlusta(liittyma.getAlusta());
        tetris.start();
    }
}
