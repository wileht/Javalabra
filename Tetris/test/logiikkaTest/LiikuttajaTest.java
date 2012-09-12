package logiikkaTest;

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
        this.palikka = new Palikka(liikuttaja);
        palikka.lisaaPala(new Pala());
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(
                new Piirtoalusta(tetris)), liikuttaja);
        liikuttaja.setVaihtaja(vaihtaja);
        liikuttaja.setTyhjentaja(new RivinTyhjentaja(tetris));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palikkaEiVoiLiikkuaSeinanLapi() {
        liikuttaja.liikuta(palikka, -175, 0);
        liikuttaja.liikuta(palikka, -5, 0);
        assertEquals(palikka.getPalat().get(0).getX(), 0, tarkkuus);

        liikuttaja.liikuta(palikka, 325, 0);
        liikuttaja.liikuta(palikka, 5, 0);
        assertEquals(palikka.getPalat().get(0).getX(), 325, tarkkuus);
    }

    @Test
    public void palikkaEiVoiLiikkuaLattianLapi() {
        liikuttaja.liikuta(palikka, 0, 662);
        liikuttaja.liikuta(palikka, 0, 5);
        assertEquals(palikka.getPalat().get(0).getY(), 650, tarkkuus);
    }

    @Test
    public void palikkaEiVoiTormataToiseenPalikkaan() {
        Palikka tormattava = new Palikka(liikuttaja);
        Pala pala = new Pala();
        tormattava.lisaaPala(pala);
        tetris.lisaaPala(pala);
        tormattava.liiku(30, 30);
        palikka.liiku(30, 30);
        assertEquals(palikka.getPalat().get(0).getX(), tormattava.getPalat().get(0).getX() - 30, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), tormattava.getPalat().get(0).getY() - 30, tarkkuus);
    }

    @Test
    public void palikkaVaihtuuKunOsutaanLattiaan() {
        palikka.liiku(0, 662);
        assertEquals(tetris.getPalat().size(), 2, tarkkuus);
    }

    @Test
    public void palikkaVaihtuuKunLaskeudutaanToisellePalikalle() {
        Palikka tormattava = new Palikka(liikuttaja);
        Pala pala = new Pala();
        tormattava.lisaaPala(pala);
        tetris.lisaaPala(pala);
        tormattava.liiku(0, 600);
        palikka.liiku(0, 575);
        assertEquals(tetris.getPalat().size(), 3, tarkkuus);
    }
}
