package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.Liikuttaja;
import tetris.logiikka.Pala;
import tetris.logiikka.PalikanVaihtaja;
import tetris.logiikka.Palikka;

public class PalikkaTest {

    private Palikka palikka;
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
        Tetris tetris = new Tetris();
        Liikuttaja liikuttaja = new Liikuttaja(tetris);
        liikuttaja.setVaihtaja(new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(
                new Piirtoalusta(tetris)), liikuttaja));
        this.palikka = new Palikka(liikuttaja);
        Pala pala = new Pala();
        palikka.lisaaPala(pala);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void liikkuuOikeanVerran() {
        palikka.liiku(25, 25);
        assertEquals(palikka.getPalat().get(0).getX(), 200, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), 13, tarkkuus);
    }

    @Test
    public void lisaaPalaToimii() {
        palikka.lisaaPala(new Pala());
        assertEquals(palikka.getPalat().size(), 2, tarkkuus);
    }
}
