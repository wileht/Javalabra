package tetris.logiikka;

public class Pala {

    private int x;
    private int y;

    public Pala() {
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
        this.x += dx;
        this.y += dy;
    }
}
