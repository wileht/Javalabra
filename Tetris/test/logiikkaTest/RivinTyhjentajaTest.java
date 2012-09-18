package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.Liikuttaja;
import tetris.logiikka.Pala;
import tetris.logiikka.RivinTyhjentaja;
import tetris.logiikka.Tormays;

public class RivinTyhjentajaTest {

    private RivinTyhjentaja tyhjentaja;
    private Tetris tetris;
    private Liikuttaja liikuttaja;
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
        this.liikuttaja = new Liikuttaja(tetris);
        this.tyhjentaja = new RivinTyhjentaja(tetris, liikuttaja);
        liikuttaja.setAlusta(new Piirtoalusta(tetris));
        liikuttaja.setTormays(new Tormays(tetris));
        liikuttaja.setTyhjentaja(tyhjentaja);
        
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

    @Test
    public void riviTyhjenee() {
        tyhjentaja.tyhjennaRivi(1);
        assertEquals(tetris.getPalat().size(), 0, tarkkuus);
    }

    @Test
    public void rivienTarkistusToimii() {
        tyhjentaja.tarkistaRivit();
        assertEquals(tetris.getPalat().size(), 0, tarkkuus);
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
