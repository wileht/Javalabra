package tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.logiikka.Liikuttaja;
import tetris.logiikka.PalikanVaihtaja;
import tetris.logiikka.RivinTyhjentaja;

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
        liikuttaja.setAlusta(liittyma.getAlusta());
        tetris.getPalikka().setLiikuttaja(liikuttaja);
        
        RivinTyhjentaja tyhjentaja = new RivinTyhjentaja(tetris);
        tetris.setTyhjentaja(tyhjentaja);

        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, liittyma.getKuuntelija(), liikuttaja, tyhjentaja);
        liikuttaja.setVaihtaja(vaihtaja);

        tetris.start();
    }
}
