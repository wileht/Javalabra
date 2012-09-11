package tetris.logiikka;

import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;

public class PalikanVaihtaja {

    private Tetris tetris;
    private Nappaimistonkuuntelija kuuntelija;
    private Liikuttaja liikuttaja;

    public PalikanVaihtaja(Tetris tetris, Nappaimistonkuuntelija kuuntelija, Liikuttaja liikuttaja) {
        this.tetris = tetris;
        this.kuuntelija = kuuntelija;
        this.liikuttaja = liikuttaja;
    }

    public void vaihdaPalikka() {
        Palikka uusi = new Palikka(this.liikuttaja);
        uusi.lisaaPala(new Pala());
        tetris.setPalikka(uusi);
        kuuntelija.setPalikka(uusi);
    }
}
