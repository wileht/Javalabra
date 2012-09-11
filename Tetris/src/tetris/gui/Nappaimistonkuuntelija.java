package tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.logiikka.Palikka;

public class Nappaimistonkuuntelija implements KeyListener {

    private Palikka palikka;
    private Piirtoalusta alusta;

    public Nappaimistonkuuntelija(Piirtoalusta alusta) {
        this.alusta = alusta;
    }

    public void setPalikka(Palikka palikka) {
        this.palikka = palikka;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            palikka.liiku(-25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            palikka.liiku(25, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            palikka.liiku(0, 25);
        }
        alusta.paivita();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Palikka getPalikka() {
        return palikka;
    }
}
