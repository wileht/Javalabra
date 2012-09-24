package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.*;

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
        liikuttaja.setAlusta(new Piirtoalusta(tetris));
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(), liikuttaja,
                new RivinTyhjentaja(tetris, liikuttaja));
        vaihtaja.vaihdaPalikka();
        this.palikka = tetris.getPalikka();
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
}
