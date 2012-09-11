
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tetris.Tetris;

public class TetrisTest {
    
    private Tetris tetris;
    
    public TetrisTest() {
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
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ensimmainenPalikkaLuodaan() {
        assertNotNull(tetris.getPalikka());
    }
    
    @Test
    public void ensimmainenPalikkaLuodaanOikeaanPaikkaan() {
        assertEquals(tetris.getPalikka().getPalat().get(0).getX(), 175, 0.01);
        assertEquals(tetris.getPalikka().getPalat().get(0).getY(), -12, 0.01);
    }
    
    @Test
    public void palikkaTippuuOikeanVerran() {
        tetris.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TetrisTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(tetris.getPalikka().getPalat().get(0).getX(), 175, 0.01);
        assertEquals(tetris.getPalikka().getPalat().get(0).getY(), 13, 0.01);
    }
}
