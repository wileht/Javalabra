package tetris;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.*;

public class TetrisTest {

    private Tetris tetris;
    private double tarkkuus = 0.001;

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
        Liikuttaja liikuttaja = new Liikuttaja(tetris);
        liikuttaja.setAlusta(new Piirtoalusta(tetris));
        RivinTyhjentaja tyhjentaja = new RivinTyhjentaja(tetris, liikuttaja);
        liikuttaja.setTyhjentaja(tyhjentaja);
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(),
                liikuttaja, tyhjentaja);
        liikuttaja.setTormays(new Tormays(tetris, vaihtaja));
        vaihtaja.vaihdaPalikka();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ensimmainenPalikkaLuodaan() {
        assertNotNull(tetris.getPalikka());
    }

    @Test
    public void palikkaTippuuOikeanVerran() {
        int Xalussa = tetris.getPalikka().getPalat().get(0).getX();
        int Yalussa = tetris.getPalikka().getPalat().get(0).getY();
        tetris.start();
        try {
            Thread.sleep(1300); // Timerin delay 650 (ms)
        } catch (InterruptedException ex) {
            Logger.getLogger(TetrisTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(tetris.getPalikka().getPalat().get(0).getX(), Xalussa, tarkkuus);
        assertEquals(tetris.getPalikka().getPalat().get(0).getY(), Yalussa + 25, tarkkuus);
    }

    // Huom! setUpissa kutsutaan metodia vaihdaPalikka(), joka luo Tetrikseen
    // yhden neljän Palan Palikan
    @Test
    public void palanLisays() {
        tetris.lisaaPala(new Pala(100, 100, null));
        assertEquals(tetris.getPalat().size(), 5, tarkkuus);
    }

    @Test
    public void useammanPalanLisays() {
        ArrayList<Pala> lisattavat = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            lisattavat.add(new Pala(10, 10, null));
        }
        tetris.lisaaPalat(lisattavat);
        assertEquals(tetris.getPalat().size(), 7, tarkkuus);
    }

    @Test
    public void palojenPoisto() {
        ArrayList<Pala> poistettavat = new ArrayList<>();
        for (Pala pala : tetris.getPalat()) {
            poistettavat.add(pala);
        }
        poistettavat.remove(0);
        tetris.poistaPalat(poistettavat);
        assertEquals(tetris.getPalat().size(), 1, tarkkuus);
    }

    @Test
    public void palalistanTyhjennys() {
        tetris.tyhjenna();
        assertEquals(tetris.getPalat().size(), 0, tarkkuus);
    }

    @Test
    public void nopeutus() {
        tetris.nopeuta();
        assertEquals(tetris.getDelay(), 615, tarkkuus);
    }
}
