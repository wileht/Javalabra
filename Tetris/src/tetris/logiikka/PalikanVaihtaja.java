package tetris.logiikka;

import java.util.ArrayList;
import java.util.Random;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;

public class PalikanVaihtaja {

    private Tetris tetris;
    private Nappaimistonkuuntelija kuuntelija;
    private Liikuttaja liikuttaja;
    private RivinTyhjentaja tyhjentaja;

    public PalikanVaihtaja(Tetris tetris, Nappaimistonkuuntelija kuuntelija, Liikuttaja liikuttaja,
            RivinTyhjentaja tyhjentaja) {
        this.tetris = tetris;
        this.kuuntelija = kuuntelija;
        this.liikuttaja = liikuttaja;
        this.tyhjentaja = tyhjentaja;
    }

    public void vaihdaPalikka() {
        Palikka uusi = luoUusiPalikka();
        tetris.setPalikka(uusi);
        kuuntelija.setPalikka(uusi);
        tyhjentaja.tarkistaRivit();
    }

    public Palikka luoUusiPalikka() {
        Palikka palautettava = null;
        Random random = new Random();
        int arpa = random.nextInt(7);
        if (arpa == 0) {
            palautettava = luoNelioPalikka();
        } else if (arpa == 1) {
            palautettava = luoPitkulaPalikka();
        } else if (arpa == 2) {
            palautettava = luoLPalikka();
        } else if (arpa == 3) {
            palautettava = luoJPalikka();
        } else if (arpa == 4) {
            palautettava = luoTPalikka();
        } else if (arpa == 5) {
            palautettava = luoSPalikka();
        } else if (arpa == 6) {
            palautettava = luoZPalikka();
        }
        return palautettava;
    }

    public Palikka luoNelioPalikka() {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -12));
        palat.add(new Pala(150, -37));
        palat.add(new Pala(175, -37));

        Pala kiintopiste = new Pala(175, -12);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    public Palikka luoPitkulaPalikka() {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(175, -12));
        palat.add(new Pala(175, -62));
        palat.add(new Pala(175, -87));

        Pala kiintopiste = new Pala(175, -37);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    public Palikka luoLPalikka() {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(200, -12));
        palat.add(new Pala(175, -12));
        palat.add(new Pala(175, -62));

        Pala kiintopiste = new Pala(175, -37);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    public Palikka luoJPalikka() {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -12));
        palat.add(new Pala(175, -12));
        palat.add(new Pala(175, -62));

        Pala kiintopiste = new Pala(175, -37);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    public Palikka luoTPalikka() {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -37));
        palat.add(new Pala(200, -37));
        palat.add(new Pala(175, -12));

        Pala kiintopiste = new Pala(175, -37);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    public Palikka luoSPalikka() {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -12));
        palat.add(new Pala(175, -37));
        palat.add(new Pala(200, -37));

        Pala kiintopiste = new Pala(175, -12);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }

    public Palikka luoZPalikka() {
        ArrayList<Pala> palat = new ArrayList<>();
        palat.add(new Pala(150, -37));
        palat.add(new Pala(175, -37));
        palat.add(new Pala(200, -12));

        Pala kiintopiste = new Pala(175, -12);
        palat.add(kiintopiste);

        return new Palikka(liikuttaja, palat, kiintopiste);
    }
}
