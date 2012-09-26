package tetris.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import tetris.Tetris;

/**
 * Graafisen käyttöliittymän runko
 *
 * @author Wille Lehtomäki
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Tetris tetris;
    private Piirtoalusta alusta;
    private Nappaimistonkuuntelija kuuntelija;

    public Kayttoliittyma(Tetris tetris) {
        this.tetris = tetris;
    }

    /**
     * Luo käyttöliittymän
     *
     * @see luoKomponentit(Container container)
     */
    @Override
    public void run() {
        frame = new JFrame("Tetris");
        int leveys = 366;
        int korkeus = 700;
        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo käyttöliittymän komponentit
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        this.alusta = new Piirtoalusta(tetris);
        container.add(alusta);
        this.kuuntelija = new Nappaimistonkuuntelija();
        frame.addKeyListener(kuuntelija);
    }

    public Piirtoalusta getAlusta() {
        return alusta;
    }

    public Nappaimistonkuuntelija getKuuntelija() {
        return kuuntelija;
    }
}
