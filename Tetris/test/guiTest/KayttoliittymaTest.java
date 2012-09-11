package guiTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import tetris.Tetris;
import tetris.gui.Kayttoliittyma;

public class KayttoliittymaTest {

    private Kayttoliittyma liittyma;
    private Tetris tetris;

    public KayttoliittymaTest() {
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
        this.liittyma = new Kayttoliittyma(tetris);
    }

    @After
    public void tearDown() {
    }
//    @Test
//    public void luoPalikanVaihtajaToimii() {
//        liittyma.luoPalikanVaihtaja();
//        assertNotNull(tetris.getPalikka().getPalikanVaihtaja());
//    }
}
