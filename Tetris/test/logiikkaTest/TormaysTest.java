package logiikkaTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import tetris.Tetris;
import tetris.logiikka.Pala;
import tetris.logiikka.Palikka;
import tetris.logiikka.Tormays;

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
        this.tormays = new Tormays(tetris);
        this.palikka = new Palikka();
        this.pala = new Pala();
        palikka.lisaaPala(pala);
    }

    @After
    public void tearDown() {
    }

    
    //Nämä tulevat testatuiksi epäsuorasti myös LiikkujaTestissä
    @Test
    public void palaTormaaSeinaan() {
        assertFalse(tormays.tormaakoPalaSeinaan(0));
        assertTrue(tormays.tormaakoPalaSeinaan(-1));
        assertTrue(tormays.tormaakoPalaSeinaan(400));
    }

    @Test
    public void palaTormaaLattiaan() {
        assertFalse(tormays.tormaakoPalaLattiaan(650));
        assertTrue(tormays.tormaakoPalaLattiaan(651));
    }

    @Test
    public void palaTormaaToiseenPalaan() {
        Pala uusi = new Pala();
        uusi.liiku(25, 12);
        tetris.lisaaPala(uusi);

        assertFalse(tormays.tormaakoPalaToiseenPalaan(pala, pala.getX(), pala.getY()));
        pala.liiku(24, 12);
        assertFalse(tormays.tormaakoPalaToiseenPalaan(pala, pala.getX(), pala.getY()));
        pala.liiku(1, 0);
        assertTrue(tormays.tormaakoPalaToiseenPalaan(pala, pala.getX(), pala.getY()));
    }

    // Tällä hetkellä testataan vain yhden Palan Palikoita
    @Test
    public void palikkaOsuuLattiaan() {
        assertFalse(tormays.osuukoPalikkaLattiaan(palikka));
        pala.liiku(0, 636);
        assertFalse(tormays.osuukoPalikkaLattiaan(palikka));
        pala.liiku(0, 1);
        assertTrue(tormays.osuukoPalikkaLattiaan(palikka));
    }

    @Test
    public void palikkaOsuuAllaOlevaanPalaan() {
        Pala uusi = new Pala();
        uusi.liiku(0, 625);
        tetris.lisaaPala(uusi);

        assertFalse(tormays.onkoPalikanAllaPala(palikka));
        pala.liiku(0, 599);
        assertFalse(tormays.onkoPalikanAllaPala(palikka));
        pala.liiku(0, 1);
        assertTrue(tormays.onkoPalikanAllaPala(palikka));
    }
}
