package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.*;

public class PalikkaTest {

    private Palikka palikka;
    private Tetris tetris;
    private double tarkkuus = 0.001;

    public PalikkaTest() {
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
        liikuttaja.setAlusta(new Piirtoalusta(tetris));
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(), liikuttaja,
                new RivinTyhjentaja(tetris, liikuttaja));
        this.palikka = vaihtaja.luoNelioPalikka(null);
        tetris.setPalikka(palikka);
        liikuttaja.setTormays(new Tormays(tetris, vaihtaja));
    }

    @After
    public void tearDown() {
    }

    // Poikkeustapausten testaus LiikkujaTestissä
    @Test
    public void liikkuuOikeanVerran() {
        int Xalussa = palikka.getPalat().get(0).getX();
        int Yalussa = palikka.getPalat().get(0).getY();
        palikka.liiku(25, -20);
        assertEquals(palikka.getPalat().get(0).getX(), Xalussa + 25, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), Yalussa - 20, tarkkuus);
    }

    @Test
    public void pudotusLattialle() {
        palikka.putoa();
        assertEquals(palikka.getPalat().get(0).getY(), 638, tarkkuus);
    }

    @Test
    public void pudotusUlkopuolisellePalalle() {
        tetris.lisaaPala(new Pala(175, 188, null));
        palikka.putoa();
        assertEquals(palikka.getPalat().get(0).getY(), 163, tarkkuus);
    }
}
