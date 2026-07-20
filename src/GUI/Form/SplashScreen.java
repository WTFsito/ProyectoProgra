package GUI.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;


public class SplashScreen extends JWindow {

    private JProgressBar barraCarga;

    public SplashScreen() {
        setLayout(new BorderLayout());

       
       URL rutaImagen = getClass().getResource("/GUI/Resource/Img/carga1.png");
        JLabel lblImagen;
        if (rutaImagen != null) {
            lblImagen = new JLabel(new ImageIcon(rutaImagen));
        } else {
            lblImagen = new JLabel("Cargando...", JLabel.CENTER);
            lblImagen.setOpaque(true);
            lblImagen.setBackground(Color.DARK_GRAY);
            lblImagen.setForeground(Color.WHITE);
            lblImagen.setPreferredSize(new java.awt.Dimension(500, 300));
        }
        add(lblImagen, BorderLayout.CENTER);

        barraCarga = new JProgressBar(0, 100);
        barraCarga.setStringPainted(true);
        add(barraCarga, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); 
    }

   
    public void mostrar() {
        setVisible(true);

        new Thread(() -> {
            for (int progreso = 0; progreso <= 100; progreso++) {
                final int valor = progreso;
                SwingUtilities.invokeLater(() -> barraCarga.setValue(valor));
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            SwingUtilities.invokeLater(() -> {
                dispose(); 
                MainForm menu = new MainForm();
                menu.setVisible(true);
            });
        }).start();
    }
}
