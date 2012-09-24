package tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.logiikka.*;

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

        RivinTyhjentaja tyhjentaja = new RivinTyhjentaja(tetris, liikuttaja);
        liikuttaja.setTyhjentaja(tyhjentaja);

        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, liittyma.getKuuntelija(), liikuttaja, tyhjentaja);
        vaihtaja.vaihdaPalikka();

        Tormays tormays = new Tormays(tetris, vaihtaja);
        liikuttaja.setTormays(tormays);

        Kaantaja kaantaja = new Kaantaja(liittyma.getAlusta(), tormays);
        liittyma.getKuuntelija().setKaantaja(kaantaja);

        tetris.start();
    }
}
