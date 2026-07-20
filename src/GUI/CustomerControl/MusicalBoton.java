package GUI.CustomerControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;


public class MusicalBoton extends JButton {

    public MusicalBoton(String texto) {
        super(texto);
        setFont(new Font("Segoe UI", Font.BOLD, 18));
        setForeground(Color.WHITE);
        setBackground(new Color(30, 30, 30, 200));
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
