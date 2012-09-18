package guiTest;

import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;

public class NappaimistonkuuntelijaTest {

    private Nappaimistonkuuntelija kuuntelija;
    private Tetris tetris;
    private double tarkkuus = 0.001;

    public NappaimistonkuuntelijaTest() {
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
        this.kuuntelija = new Nappaimistonkuuntelija();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void PalikkaLiikkuuVasemmalle() {
        // KeyEventtien simulointia
    } 
}
