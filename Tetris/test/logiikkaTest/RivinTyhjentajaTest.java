package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.logiikka.Pala;
import tetris.logiikka.RivinTyhjentaja;

public class RivinTyhjentajaTest {

    private RivinTyhjentaja tyhjentaja;
    private Tetris tetris;
    private double tarkkuus = 0.001;

    public RivinTyhjentajaTest() {
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
        this.tyhjentaja = new RivinTyhjentaja(tetris);
        tetris.setTyhjentaja(tyhjentaja);
        for (int i = 0; i < 14; i++) {
            Pala uusi = new Pala();
            uusi.liiku(-175, 25);
            uusi.liiku(i * 25, 0);
            tetris.lisaaPala(uusi);
        }
    }

    @After
    public void tearDown() {
    }

    //luokka Tetris luo konstruktorissaan yhden Palan
    @Test
    public void riviTyhjenee() {
        tyhjentaja.tyhjennaRivi(1);
        assertEquals(tetris.getPalat().size(), 1, tarkkuus);
    }

    @Test
    public void rivienTarkistusToimii() {
        tyhjentaja.tarkistaRivit();
        assertEquals(tetris.getPalat().size(), 1, tarkkuus);
    }

    @Test
    public void rivinPoistuessaYlemmatPalatTippuvat() {
        Pala tiputettava = new Pala();
        tetris.lisaaPala(tiputettava);
        tyhjentaja.tarkistaRivit();
        assertEquals(tiputettava.getX(), 175, tarkkuus);
        assertEquals(tiputettava.getY(), 13, tarkkuus);
    }
}
