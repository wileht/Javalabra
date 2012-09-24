package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.logiikka.Liikuttaja;
import tetris.logiikka.PalikanVaihtaja;
import tetris.logiikka.Palikka;
import tetris.logiikka.RivinTyhjentaja;

public class PalikanVaihtajaTest {

    private PalikanVaihtaja vaihtaja;
    private Tetris tetris;
    private Nappaimistonkuuntelija kuuntelija;
    private Liikuttaja liikuttaja;
    private double tarkkuus = 0.001;

    public PalikanVaihtajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.tetris = new Tetris();
        this.kuuntelija = new Nappaimistonkuuntelija();
        this.liikuttaja = new Liikuttaja(tetris);
        this.vaihtaja = new PalikanVaihtaja(tetris, kuuntelija, liikuttaja, new RivinTyhjentaja(tetris, liikuttaja));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ensimmainenPalikkaLuodaan() {
        vaihtaja.vaihdaPalikka();
        assertEquals(tetris.getPalat().size(), 4, tarkkuus);
    }

    @Test
    public void vaihdaPalikkaVaihtaaPalikan() {
        vaihtaja.vaihdaPalikka();
        assertEquals(tetris.getPalikka(), kuuntelija.getPalikka());
    }

    @Test
    public void nelioPalikanLuonti() {
        Palikka palikka = vaihtaja.luoNelioPalikka();

        assertEquals(palikka.getPalat().get(0).getX(), 150, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 150, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -12, tarkkuus);
    }

    @Test
    public void pitkulaPalikanLuonti() {
        Palikka palikka = vaihtaja.luoPitkulaPalikka();

        assertEquals(palikka.getPalat().get(0).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -62, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -87, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -37, tarkkuus);
    }

    @Test
    public void LPalikanLuonti() {
        Palikka palikka = vaihtaja.luoLPalikka();

        assertEquals(palikka.getPalat().get(0).getX(), 200, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -62, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -37, tarkkuus);
    }

    @Test
    public void JPalikanLuonti() {
        Palikka palikka = vaihtaja.luoJPalikka();

        assertEquals(palikka.getPalat().get(0).getX(), 150, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -62, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -37, tarkkuus);
    }

    @Test
    public void TPalikanLuonti() {
        Palikka palikka = vaihtaja.luoTPalikka();

        assertEquals(palikka.getPalat().get(0).getX(), 150, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 200, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -37, tarkkuus);
    }

    @Test
    public void SPalikanLuonti() {
        Palikka palikka = vaihtaja.luoSPalikka();

        assertEquals(palikka.getPalat().get(0).getX(), 150, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 200, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -12, tarkkuus);
    }

    @Test
    public void ZPalikanLuonti() {
        Palikka palikka = vaihtaja.luoZPalikka();

        assertEquals(palikka.getPalat().get(0).getX(), 150, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 200, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -12, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -12, tarkkuus);
    }
}
