package tetris.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import tetris.Tetris;
import tetris.logiikka.Pisteidenlaskija;

/**
 * Graafisen käyttöliittymän runko
 *
 * @author Wille Lehtomäki
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Tetris tetris;
    private Piirtoalusta alusta;
    private Nappaimistonkuuntelija kuuntelija;
    private Pisteidenlaskija laskija;
    private boolean peliPaattynyt = false;

    public Kayttoliittyma(Tetris tetris) {
        this.tetris = tetris;
        this.laskija = new Pisteidenlaskija(tetris);
    }

    /**
     * Luo käyttöliittymän
     *
     * @see luoKomponentit(Container container)
     */
    @Override
    public void run() {
        frame = new JFrame("Tetris");
        int leveys = 366;
        int korkeus = 725;
        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        luoValikko();

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo käyttöliittymän komponentit
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        this.alusta = new Piirtoalusta(tetris);
        container.add(alusta);
        this.kuuntelija = new Nappaimistonkuuntelija();
        frame.addKeyListener(kuuntelija);
    }

    /**
     * Luo peli-ikkunan yläosassa näkyvän valikon
     */
    private void luoValikko() {
        JMenuBar valikko = new JMenuBar();

        JMenu peli = new JMenu("Peli");
        valikko.add(peli);
        JMenu ohje = new JMenu("Ohje");
        valikko.add(ohje);

        peli.add(luoUusiPeli());
        peli.add(luoKeskeytaTaiJatka());
        peli.add(luoLopetaPeli());
        ohje.add(luoApua());

        frame.setJMenuBar(valikko);
    }

    /**
     * Luo valikkoon painikkeen "Uusi peli"
     *
     * @return luotu painike
     */
    private JMenuItem luoUusiPeli() {
        JMenuItem uusi = new JMenuItem("Uusi peli");
        uusi.addActionListener(new Valikonkuuntelija(this));
        return uusi;
    }

    /**
     * Luo valikkoon painikkeen "Keskeytä/Jatka"
     *
     * @return luotu painike
     */
    private JMenuItem luoKeskeytaTaiJatka() {
        JMenuItem keskeytaTaiJatka = new JMenuItem("Keskeytä/Jatka");
        keskeytaTaiJatka.addActionListener(new Valikonkuuntelija(this));
        return keskeytaTaiJatka;
    }

    /**
     * Luo valikkoon painikkeen "Lopeta peli"
     *
     * @return luotu painike
     */
    private JMenuItem luoLopetaPeli() {
        JMenuItem lopeta = new JMenuItem("Lopeta peli");
        lopeta.addActionListener(new Valikonkuuntelija(this));
        return lopeta;
    }

    /**
     * Luo valikkoon painikkeen "Apua"
     *
     * @return luotu painike
     */
    private JMenuItem luoApua() {
        JMenuItem apua = new JMenuItem("Apua");
        apua.addActionListener(new Valikonkuuntelija(this));
        return apua;
    }

    /**
     * Nollaa käynnissä olleen pelin tilanteen ja aloittaa uuden pelin
     *
     * @see tetris.Tetris#tyhjenna()
     * @see tetris.logiikka.Pisteidenlaskija#tyhjenna()
     * @see tetris.logiikka.PalikanVaihtaja#vaihdaPalikka()
     * @see tetris.gui.Nappaimistonkuuntelija#jatka()
     * @see tetris.gui.Piirtoalusta#paivita()
     */
    public void uusiPeli() {
        peliPaattynyt = false;
        tetris.tyhjenna();
        tetris.setDelay(650);
        laskija.tyhjenna();
        tetris.getVaihtaja().vaihdaPalikka();
        kuuntelija.jatka();
        tetris.restart();
        laskija.restart();
        alusta.paivita();
    }

    /**
     * Lopettaa pelin ja näyttää pelaajan pisteet
     */
    public void lopeta() {
        peliPaattynyt = true;
        alusta.paivita();
        keskeyta();
        JOptionPane.showMessageDialog(frame, "Peli päättyi!\n\nPisteesi: " + laskija.getPisteet());
    }

    /**
     * Keskeyttää pelin tai jatkaa sen kulkua siitä, mihin se jäi ennen
     * edellistä keskeytystä. Mikäli peli on jo päättynyt, ei tehdä kumpaakaan.
     *
     * @see keskeyta()
     * @see jatka()
     */
    public void keskeytaTaiJatka() {
        if (peliPaattynyt) {
            return;
        }
        if (tetris.isRunning()) {
            keskeyta();
        } else {
            jatka();
        }
    }

    /**
     * Keskeyttää pelin
     *
     * @see tetris.gui.Nappaimistonkuuntelija#keskeyta()
     */
    public void keskeyta() {
        tetris.stop();
        kuuntelija.keskeyta();
        laskija.stop();
    }

    /**
     * Käynnistää pelin uudelleen siitä kohtaa, mihin se jäi ennen
     * keskeyttämistä
     *
     * @see tetris.gui.Nappaimistonkuuntelija#jatka()
     */
    public void jatka() {
        tetris.start();
        kuuntelija.jatka();
        laskija.start();
    }

    /**
     * Näyttää pelaajalle pelin toimintaa selventävän ohjeikkunan
     */
    public void naytaOhjeikkuna() {
        keskeyta();
        JOptionPane.showMessageDialog(frame, "Peli keskeytetty.\n\nOhjaa palikkaa nuolinäppäimillä.\n"
                + "Nuoli ylöspäin kääntää palikan,\nenter ja space pudottavat palikan suoraan.");
    }

    public Piirtoalusta getAlusta() {
        return alusta;
    }

    public Nappaimistonkuuntelija getKuuntelija() {
        return kuuntelija;
    }

    public Pisteidenlaskija getLaskija() {
        return laskija;
    }
}
