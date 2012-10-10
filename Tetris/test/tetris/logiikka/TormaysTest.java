package tetris.logiikka;

import static org.junit.Assert.*;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;

public class TormaysTest {

    private Tetris tetris;
    private Tormays tormays;
    private Palikka palikka;
    private Pala pala;

    public TormaysTest() {
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
        Liikuttaja liikuttaja = new Liikuttaja(tetris);
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris,
                new Nappaimistonkuuntelija(), liikuttaja, new RivinTyhjentaja(tetris, liikuttaja));
        this.tormays = new Tormays(tetris, vaihtaja);
        liikuttaja.setTormays(tormays);
        liikuttaja.setAlusta(new Piirtoalusta(tetris));
        this.palikka = vaihtaja.luoNelioPalikka(null);
        tetris.setPalikka(palikka);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void sisallaOlevaPalaEiTormaaRajoihin() {
        assertFalse(tormays.tormaakoRajoihin(0, 325));
        assertFalse(tormays.tormaakoRajoihin(300, 650));
    }

    @Test
    public void palaTormaaRajoihin() {
        assertTrue(tormays.tormaakoRajoihin(-1, 10));
        assertTrue(tormays.tormaakoRajoihin(326, 326));
        assertTrue(tormays.tormaakoRajoihin(300, 651));
    }

    @Test
    public void palaTormaaSeinaan() {
        assertTrue(tormays.tormaakoPalaSeinaan(-1));
        assertTrue(tormays.tormaakoPalaSeinaan(400));
    }

    @Test
    public void palaTormaaLattiaan() {
        assertFalse(tormays.tormaakoPalaLattiaan(650));
        assertTrue(tormays.tormaakoPalaLattiaan(651));
    }

    @Test
    public void palikkaTormaaUlkopuoliseenPalaan() {
        tetris.lisaaPala(new Pala(200, 200, null));

        assertFalse(tormays.tormaakoPalikkaPalaan(palikka, 0, 0));
        assertTrue(tormays.tormaakoPalikkaPalaan(palikka, 25, 212));
    }

    @Test
    public void kaantynytPalikkaTormaaUlkopuoliseenPalaan() {
        Pala uusi = new Pala(200, 200, null);
        tetris.lisaaPala(uusi);
        assertFalse(tormays.tormaakoKaantynytPalikkaPalaan(palikka,
                tormays.palikanUlkopuolisetPalat(palikka)));

        uusi.liiku(-25, -212);
        assertTrue(tormays.tormaakoKaantynytPalikkaPalaan(palikka,
                tormays.palikanUlkopuolisetPalat(palikka)));
    }

    @Test
    public void palikkaOsuuLattiaan() {
        assertFalse(tormays.osuukoPalikkaLattiaan(palikka));
        palikka.liiku(0, 636);
        assertFalse(tormays.osuukoPalikkaLattiaan(palikka));
        palikka.liiku(0, 1);
        assertTrue(tormays.osuukoPalikkaLattiaan(palikka));
    }

    @Test
    public void palikkaOsuuAllaOlevaanPalaan() {
        tetris.lisaaPala(new Pala(175, 625, null));

        assertFalse(tormays.onkoPalikanAllaPala(palikka));
        palikka.liiku(0, 611);
        assertFalse(tormays.onkoPalikanAllaPala(palikka));
        palikka.liiku(0, 1);
        assertTrue(tormays.onkoPalikanAllaPala(palikka));
    }

    @Test
    public void palikanUlkopuolisetPalatToimii() {
        tetris.lisaaPala(new Pala(175, 625, null));
        tetris.lisaaPala(new Pala(200, 600, null));

        assertEquals(tormays.palikanUlkopuolisetPalat(palikka).size(), 2, 0.001);
    }
}
