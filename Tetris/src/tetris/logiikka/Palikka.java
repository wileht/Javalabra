
package tetris.logiikka;

import java.util.ArrayList;

public class Palikka {
    
    private ArrayList<Pala> palat;

    public Palikka() {
        this.palat = new ArrayList<>();
    }
    
    public void liiku(int dx, int dy) {
        for (Pala pala : palat) {
            pala.liiku(dx, dy);
        }
    }
    
    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }
}
