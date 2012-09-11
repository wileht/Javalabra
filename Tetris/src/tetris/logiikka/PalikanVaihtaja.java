package tetris.logiikka;

import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;

public class PalikanVaihtaja {

    private Tetris tetris;
    private Nappaimistonkuuntelija kuuntelija;

    public PalikanVaihtaja(Tetris tetris, Nappaimistonkuuntelija kuuntelija) {
        this.tetris = tetris;
        this.kuuntelija = kuuntelija;
    }

    public void vaihdaPalikka() {
        Palikka uusi = new Palikka(this);
        uusi.lisaaPala(new Pala());
        tetris.setPalikka(uusi);
        kuuntelija.setPalikka(uusi);
    }
}
