package GUI.Form;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ventana principal de la aplicación. Contiene el panel de menú.
 */
public class MainForm extends JFrame {

    public MainForm() {
        setTitle("Mi Aplicación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 480);
        setLocationRelativeTo(null); // centrar en pantalla
        setResizable(false);

        cambiarDePanel(new MenuPanel(this));
    }

    public void cambiarDePanel(JPanel NuevoPanel) {
        getContentPane().removeAll();
        getContentPane().add(NuevoPanel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}
