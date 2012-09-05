package tetris.logiikka;

import java.util.Random;
import tetris.Tetris;

public class Pala {

    private int x;
    private int y;
    private Tetris tetris;

    public Pala() {
        Random random = new Random();
        this.x = 175;
        this.y = -12;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void liiku(int dx, int dy) {
        if (this.x + dx >= 0 && this.x + dx <= 325) {
            this.x += dx;
        }
        if (this.y + dy <= 650) {
            this.y += dy;
        }
    }
}
