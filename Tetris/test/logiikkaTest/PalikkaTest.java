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
        liikuttaja.setVaihtaja(new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(),
                liikuttaja, new RivinTyhjentaja(tetris, liikuttaja)));
        liikuttaja.setAlusta(new Piirtoalusta(tetris));
        this.palikka = new Palikka(liikuttaja);
        Pala pala = new Pala();
        palikka.lisaaPala(pala);
        liikuttaja.setTormays(new Tormays(tetris));
    }

    @After
    public void tearDown() {
    }

    // Poikkeustapausten testaus LiikkujaTestissä
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
