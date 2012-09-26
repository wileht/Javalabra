package logiikkaTest;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import tetris.Tetris;
import tetris.gui.Nappaimistonkuuntelija;
import tetris.gui.Piirtoalusta;
import tetris.logiikka.*;

public class KaantajaTest {

    private Kaantaja kaantaja;
    private Palikka palikka;
    private Tetris tetris;
    private double tarkkuus = 0.001;

    public KaantajaTest() {
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
        PalikanVaihtaja vaihtaja = new PalikanVaihtaja(tetris, new Nappaimistonkuuntelija(), liikuttaja,
                new RivinTyhjentaja(tetris, liikuttaja));
        Tormays tormays = new Tormays(tetris, vaihtaja);
        liikuttaja.setTormays(tormays);
        Piirtoalusta alusta = new Piirtoalusta(tetris);
        liikuttaja.setAlusta(alusta);
        this.kaantaja = new Kaantaja(alusta, tormays);
        this.palikka = vaihtaja.luoPitkulaPalikka(null);
        tetris.setPalikka(palikka);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palikkaKaantyyOikeanVerran() {
        kaantaja.kaanna(palikka);

        assertEquals(palikka.getPalat().get(0).getX(), 150, tarkkuus);
        assertEquals(palikka.getPalat().get(0).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(1).getX(), 200, tarkkuus);
        assertEquals(palikka.getPalat().get(1).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(2).getX(), 225, tarkkuus);
        assertEquals(palikka.getPalat().get(2).getY(), -37, tarkkuus);

        assertEquals(palikka.getPalat().get(3).getX(), 175, tarkkuus);
        assertEquals(palikka.getPalat().get(3).getY(), -37, tarkkuus);
    }

    @Test
    public void palikkaEiVoiKaantyaSeinanLapi() {
        palikka.liiku(125, 0);
        kaantaja.kaanna(palikka);

        assertEquals(palikka.getPalat().get(0).getX(), 300, tarkkuus);
    }

    @Test
    public void palikkaEiVoiKaantyaLattianLapi() {
        kaantaja.kaanna(palikka);
        palikka.liiku(0, 662);
        kaantaja.kaanna(palikka);

        assertEquals(palikka.getPalat().get(0).getY(), 625, tarkkuus);
    }

    @Test
    public void palikkaEiVoiKaantyaUlkopuolisenPalanPaalle() {
        tetris.lisaaPala(new Pala(225, -37, null));
        kaantaja.kaanna(palikka);

        assertEquals(palikka.getPalat().get(0).getX(), 175, tarkkuus);
    }
}
