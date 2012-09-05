package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.Pala;

public class Tetris extends Timer implements ActionListener {

    private Piirtoalusta alusta;
    private int palanKoko;
    private ArrayList<Pala> palat;

    public Tetris(int palanKoko) {
        super(1000, null);

        addActionListener(this);
        setInitialDelay(1000);

        this.palanKoko = palanKoko;

        this.palat = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Pala pala : palat) {
            pala.liiku(0, 25);
        }
        alusta.paivita();
    }

    public void setAlusta(Piirtoalusta alusta) {
        this.alusta = alusta;
    }

    public int getPalanKoko() {
        return palanKoko;
    }

    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }
}
