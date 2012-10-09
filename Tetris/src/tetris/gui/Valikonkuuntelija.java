package tetris.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
 * Huolehtii valikon painikkeiden toiminnasta toteuttamalla rajapinnan
 * ActionListener
 *
 * @author Wille Lehtomäki
 */
public class Valikonkuuntelija implements ActionListener {

    private Kayttoliittyma liittyma;

    public Valikonkuuntelija(Kayttoliittyma liittyma) {
        this.liittyma = liittyma;
    }

    /**
     * Tarkistaa, mitä valikon painiketta on painettu, ja kutsuu Kayttoliittyman
     * metodeita sen mukaan
     * 
     * @see tetris.gui.Kayttoliittyma#uusiPeli()
     * @see tetris.gui.Kayttoliittyma#keskeytaTaiJatka()
     * @see tetris.gui.Kayttoliittyma#lopeta()
     * @see tetris.gui.Kayttoliittyma#naytaOhjeikkuna()
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String valinta = ((JMenuItem) e.getSource()).getText();
        if (valinta.equals("Uusi peli")) {
            liittyma.uusiPeli();
        }
        if (valinta.equals("Keskeytä/Jatka")) {
            liittyma.keskeytaTaiJatka();
        }
        if (valinta.equals("Lopeta peli")) {
            liittyma.lopeta();
        }
        if (valinta.equals("Apua")) {
            liittyma.naytaOhjeikkuna();
        }
    }
}
