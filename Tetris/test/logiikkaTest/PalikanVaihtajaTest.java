package logiikkaTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.PalikanVaihtaja;
import static org.junit.Assert.*;

public class PalikanVaihtajaTest {
    
    private PalikanVaihtaja vaihtaja;
    private Tetris tetris;
    private Nappaimistonkuuntelija kuuntelija;
    
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
        this.kuuntelija = new Nappaimistonkuuntelija(new Piirtoalusta(tetris));
        this.vaihtaja = new PalikanVaihtaja(tetris, kuuntelija);
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
