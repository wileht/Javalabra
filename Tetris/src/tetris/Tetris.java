package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.Pala;
import tetris.logiikka.PalikanVaihtaja;
import tetris.logiikka.Palikka;

public class Tetris extends Timer implements ActionListener {

    private Piirtoalusta alusta;
    private int palanKoko;
    private ArrayList<Pala> palat;
    private Palikka palikka;

    public Tetris(int palanKoko) {
        super(1000, null);

        addActionListener(this);
        setInitialDelay(1000);

        this.palanKoko = palanKoko;

        this.palat = new ArrayList<>();
        
        this.palikka = new Palikka();
        Pala ekaPala = new Pala();
        this.palat.add(ekaPala);
        this.palikka.lisaaPala(ekaPala);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        palikka.liiku(0, 25);
        alusta.paivita();
    }

    public void setAlusta(Piirtoalusta alusta) {
        this.alusta = alusta;
    }

    public int getPalanKoko() {
        return palanKoko;
    }

    public void setPalikka(Palikka palikka) {
        for (Pala pala : palikka.getPalat()) {
            this.palat.add(pala);
        }
        this.palikka = palikka;
    }

    public Palikka getPalikka() {
        return palikka;
    }

    public void lisaaPala(Pala pala) {
        this.palat.add(pala);
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }
}
