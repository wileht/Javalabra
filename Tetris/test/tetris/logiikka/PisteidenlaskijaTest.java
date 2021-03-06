package tetris.logiikka;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;

public class PisteidenlaskijaTest {

    private Pisteidenlaskija laskija;
    private Tetris tetris;
    private double tarkkuus = 0.001;

    public PisteidenlaskijaTest() {
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
        this.laskija = new Pisteidenlaskija(tetris);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alussaEiYhtaanPistetta() {
        assertEquals(laskija.getPisteet(), 0, tarkkuus);
    }

    @Test
    public void rivinPisteidenLisays() {
        for (int i = 0; i < 10; i++) {
            laskija.lisaaRivinPisteet();
        }
        assertEquals(laskija.getPisteet(), 1400, tarkkuus);
    }

    @Test
    public void pelinNopeutus() {
        tetris.start();
        laskija.actionPerformed(null);

        assertEquals(tetris.getDelay(), 615);
    }

    @Test
    public void pisteidenNollaus() {
        laskija.lisaaRivinPisteet();
        laskija.tyhjenna();

        assertEquals(laskija.getPisteet(), 0, tarkkuus);
    }
}
