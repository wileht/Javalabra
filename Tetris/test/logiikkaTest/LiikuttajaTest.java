package logiikkaTest;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.*;

public class LiikuttajaTest {

    private Liikuttaja liikuttaja;
    private Tetris tetris;
    private Palikka palikka;
    private double tarkkuus = 0.001;

    public LiikuttajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this.tetris = new Tetris();
        this.liikuttaja = new Liikuttaja(tetris);
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(),
                liikuttaja, new RivinTyhjentaja(tetris, liikuttaja));
        liikuttaja.setAlusta(new Piirtoalusta(tetris));
        liikuttaja.setTormays(new Tormays(tetris, vaihtaja));
        this.palikka = vaihtaja.luoNelioPalikka(null);
        tetris.setPalikka(palikka);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palikkaLiikkuuOikeanVerran() {
        liikuttaja.liikuta(palikka, 25, 25);
        assertEquals(palikka.getPalat().get(0).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), 13, tarkkuus);
    }

    @Test
    public void palikkaEiVoiLiikkuaSeinanLapi() {
        liikuttaja.liikuta(palikka, -150, 0);
        liikuttaja.liikuta(palikka, -5, 0);
        assertEquals(palikka.getPalat().get(0).getX(), 0, tarkkuus);

        liikuttaja.liikuta(palikka, 300, 0);
        liikuttaja.liikuta(palikka, 5, 0);
        assertEquals(palikka.getPalat().get(0).getX(), 300, tarkkuus);
    }

    @Test
    public void palikkaEiVoiLiikkuaLattianLapi() {
        liikuttaja.liikuta(palikka, 0, 662);
        liikuttaja.liikuta(palikka, 0, 5);
        assertEquals(palikka.getPalat().get(0).getY(), 650, tarkkuus);
    }

    @Test
    public void palikkaEiVoiTormataToiseenPalikkaan() {
        ArrayList<Pala> tormattavat = new ArrayList<>();
        tormattavat.add(new Pala(150, -12, null));
        Palikka tormattava = new Palikka(liikuttaja, tormattavat, new Pala(0, 0, null));
        tetris.lisaaPalat(tormattavat);
        tormattava.liiku(30, 30);

        palikka.liiku(30, 30);
        assertEquals(palikka.getPalat().get(0).getX(), tormattava.getPalat().get(0).getX() - 30, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), tormattava.getPalat().get(0).getY() - 30, tarkkuus);
    }

    @Test
    public void palikkaVaihtuuKunOsutaanLattiaan() {
        palikka.liiku(0, 662);
        assertEquals(tetris.getPalat().size(), 8, tarkkuus);
    }

    @Test
    public void palikkaVaihtuuKunLaskeudutaanPalalle() {
        ArrayList<Pala> tormattavat = new ArrayList<>();
        tormattavat.add(new Pala(175, 0, null));
        Palikka tormattava = new Palikka(liikuttaja, tormattavat, new Pala(0, 0, null));
        tetris.lisaaPalat(tormattavat);
        tormattava.liiku(0, 600);

        palikka.liiku(0, 587);
        assertEquals(tetris.getPalat().size(), 9, tarkkuus);
    }
}
