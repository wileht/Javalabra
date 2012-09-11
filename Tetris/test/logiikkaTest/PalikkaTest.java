package logiikkaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.Pala;
import tetris.logiikka.PalikanVaihtaja;
import tetris.logiikka.Palikka;

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
        this.palikka = new Palikka();
        Pala pala = new Pala();
        palikka.lisaaPala(pala);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void liikuToimii() {
        palikka.liiku(25, 25);
        assertEquals(palikka.getPalat().get(0).getX(), 200, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), 13, tarkkuus);
    }
    
    @Test
    public void lisaaPalaToimii() {
        palikka.lisaaPala(new Pala());
        assertEquals(palikka.getPalat().size(), 2, tarkkuus);
    }
    
    @Test
    public void vaihdetaankoPalikkaToimii() {
        Tetris tetris = new Tetris();
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(new Piirtoalusta(tetris)));
        palikka.setVaihtaja(vaihtaja);
        palikka.liiku(0, 662);
        assertTrue(palikka.osuukoLattiaan());
    }
}
