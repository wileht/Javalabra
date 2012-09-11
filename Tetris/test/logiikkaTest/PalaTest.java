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
    public void palaLiikkuu() {
        pala.liiku(5, 5);
        assertEquals(pala.getX(), 180, tarkkuus);
        assertEquals(pala.getY(), -7, tarkkuus);
    }

    @Test
    public void palaTormaaSeinaan() {
        pala.liiku(-175, 0);
        pala.liiku(-5, 0);
        assertEquals(pala.getX(), 0, tarkkuus);
        pala.liiku(325, 0);
        pala.liiku(5, 0);
        assertEquals(pala.getX(), 325, tarkkuus);
    }

    @Test
    public void palaTormaaLattiaan() {
        pala.liiku(0, 662);
        pala.liiku(0, 5);
        assertEquals(pala.getY(), 650, tarkkuus);
    }
}
