package tetris.logiikka;

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
        Palikka uusi = new Palikka(this.liikuttaja);
        uusi.lisaaPala(new Pala());
        tetris.setPalikka(uusi);
        kuuntelija.setPalikka(uusi);
        tyhjentaja.tarkistaRivit();
    }
}
