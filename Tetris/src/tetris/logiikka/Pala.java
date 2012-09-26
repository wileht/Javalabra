package tetris.logiikka;

import java.awt.Color;

/**
 * Pala on liikuteltava koordinaattipari, jolle on määritelty väri
 *
 * @author Wille Lehtomäki
 */
public class Pala {

    private int x;
    private int y;
    private Color vari;

    public Pala(int x, int y, Color vari) {
        this.x = x;
        this.y = y;
        this.vari = vari;
    }

    /**
     * Liikuttaa Palaa annettujen parametrien mukaisesti. Tässä ei välitetä
     * mahdollisista Törmäyksistä.
     *
     * @param dx Palan x-koordinaattiin haluttava muutos
     * @param dy Palan y-koordinaattiin haluttava muutos
     */
    public void liiku(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getVari() {
        return vari;
    }
}
