package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.logiikka.Pala;

public class PalaTest {

    private Pala pala;
    private double tarkkuus = 0.001;

    public PalaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this.pala = new Pala();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palaLiikkuuOikeanVerran() {
        pala.liiku(5, 5);
        assertEquals(pala.getX(), 180, tarkkuus);
        assertEquals(pala.getY(), -7, tarkkuus);
    }
}
