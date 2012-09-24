package tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.logiikka.Kaantaja;
import tetris.logiikka.Palikka;

public class Nappaimistonkuuntelija implements KeyListener {

    private Palikka palikka;
    private Kaantaja kaantaja;

    public Nappaimistonkuuntelija() {
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
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            kaantaja.kaanna(palikka);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Palikka getPalikka() {
        return palikka;
    }

    public void setKaantaja(Kaantaja kaantaja) {
        this.kaantaja = kaantaja;
    }
}
