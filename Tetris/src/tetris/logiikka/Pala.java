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
//
//    public boolean tormaakoSeinaan(int dx, int dy) {
//        if (this.x + dx >= 0 && this.x + dx <= 325) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean tormaakoLattiaan(int dx, int dy) {
//        if (this.y + dy <= 650) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean tormaakoToiseenPalaan(int dx, int dy) {
//        
//        return false;
//    }
}
