package tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.logiikka.Kaantaja;
import tetris.logiikka.Palikka;

/**
 * Huolehtii Palikan näppäinohjauksesta toteuttamalla rajapinnan KeyListener
 *
 * @see java.awt.event.KeyListener
 * @author Wille Lehtomäki
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Palikka palikka;
    private Kaantaja kaantaja;
    private boolean jatketaanko;

    public Nappaimistonkuuntelija() {
        this.jatketaanko = true;
    }

    /**
     * Liikuttaa palikkaa haluttuun suuntaan, kääntää tai pudottaa sen
     *
     * @see tetris.logiikka.Palikka#liiku(int, int)
     * @see tetris.logiikka.Kaantaja#kaanna(Palikka)
     * @see tetris.logiikka.Palikka#putoa()
     * @param e kuuntelijan tunnistama näppäimenpainallus
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (!jatketaanko || palikka == null) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            palikka.liiku(-25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            palikka.liiku(25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            palikka.liiku(0, 25);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            kaantaja.kaanna(palikka);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER
                || e.getKeyCode() == KeyEvent.VK_SPACE) {
            palikka.putoa();
        }
    }

    /**
     * Keskeyttää Palikoiden näppäinohjauksen
     */
    public void keskeyta() {
        this.jatketaanko = false;
    }

    /**
     * Ottaa Palikoiden näppäinohjauksen uudelleen käyttöön
     */
    public void jatka() {
        this.jatketaanko = true;
    }

    public void setPalikka(Palikka palikka) {
        this.palikka = palikka;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public Palikka getPalikka() {
        return palikka;
    }

    public void setKaantaja(Kaantaja kaantaja) {
        this.kaantaja = kaantaja;
    }
}
