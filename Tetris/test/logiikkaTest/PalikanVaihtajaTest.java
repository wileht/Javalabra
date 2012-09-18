package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.Liikuttaja;
import tetris.logiikka.PalikanVaihtaja;
import tetris.logiikka.RivinTyhjentaja;

public class PalikanVaihtajaTest {

    private PalikanVaihtaja vaihtaja;
    private Tetris tetris;
    private Nappaimistonkuuntelija kuuntelija;
    private Liikuttaja liikuttaja;

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
        this.vaihtaja = new PalikanVaihtaja(tetris, kuuntelija, liikuttaja, new RivinTyhjentaja(tetris));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void vaihdaPalikkaToimii() {
        vaihtaja.vaihdaPalikka();
        assertEquals(tetris.getPalikka(), kuuntelija.getPalikka());
    }
}
