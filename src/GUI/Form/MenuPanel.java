package GUI.Form;

import GUI.CustomerControl.MusicalBoton;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MenuPanel extends JPanel {

    private Image imagenFondo;
    private MainForm mainform;

    public MenuPanel(MainForm mainform) {
        this.mainform = mainform;

        setLayout(null); 

        URL rutaFondo = getClass().getResource("/GUI/Resource/Img/logo3enraya.jpeg");
        if (rutaFondo != null) {
            imagenFondo = new ImageIcon(rutaFondo).getImage();
        }

        MusicalBoton btnJugar = new MusicalBoton("Jugar");
        btnJugar.setBounds(280, 260, 160, 45);
        btnJugar.addActionListener(e -> {
            mainform.cambiarDePanel(new TableroPanel());
        });

        MusicalBoton btnSalir = new MusicalBoton("Salir");
        btnSalir.setBounds(280, 320, 160, 45);
        btnSalir.addActionListener(e -> System.exit(0));

        add(btnJugar);
        add(btnSalir);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
