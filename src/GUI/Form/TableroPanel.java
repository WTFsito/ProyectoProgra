package GUI.Form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TableroPanel extends JPanel {
    
    private Image imagenFondo;
    private CasillaLabel[][] casillas = new CasillaLabel[3][3];
    private JTextField cajaDeTexto1;
    private int contadorTurno = 1;
    private JLabel lblTurnoNumero;
    private JLabel lblJugadorActual;
    private void actualizarIndicadoresTurno() {
        
        lblTurnoNumero.setText("Turno: " + contadorTurno);
    
        
        if (contadorTurno % 2 != 0) {
            lblJugadorActual.setText("Turno de: Jugador 1 (X)");
            lblJugadorActual.setForeground(Color.CYAN);
        } else {
            lblJugadorActual.setText("Turno de: Jugador 2 (O)");
            lblJugadorActual.setForeground(Color.MAGENTA);
        }
    }

    public TableroPanel() {

        JPanel panelInfoTurno = new JPanel();
        panelInfoTurno.setLayout(null); 
        panelInfoTurno.setBackground(Color.WHITE); 
        panelInfoTurno.setBounds(220, 15, 275, 65);

        
        lblTurnoNumero = new JLabel("Turno: 1");
        lblTurnoNumero.setBounds(228, 20, 200, 30);
        lblTurnoNumero.setFont(new Font("Arial", Font.BOLD, 18));
        lblTurnoNumero.setForeground(Color.BLACK); 
        add(lblTurnoNumero);
        
        
        lblJugadorActual = new JLabel("Turno de: Jugador 1 (X)");
        lblJugadorActual.setBounds(228, 50, 300, 30);
        lblJugadorActual.setFont(new Font("Arial", Font.BOLD, 16));
        lblJugadorActual.setForeground(Color.CYAN); // Un color neón para hacer juego
        add(lblJugadorActual);

        add(panelInfoTurno);

    

    
    
        setLayout(null); 
        
        
        URL rutaFondo = getClass().getResource("/GUI/Resource/Img/fondo_tablero.png");
        if (rutaFondo != null) {
            imagenFondo = new ImageIcon(rutaFondo).getImage();
        }
        
        
        int tamañoCasilla = 60;

        // --- FILA 1 ---
        CasillaLabel c1 = new CasillaLabel();
        c1.setBounds(228, 90, tamañoCasilla, tamañoCasilla);
        add(c1);

        CasillaLabel c2 = new CasillaLabel();
        c2.setBounds(327, 90, tamañoCasilla, tamañoCasilla);
        add(c2);

        CasillaLabel c3 = new CasillaLabel();
        c3.setBounds(426, 90, tamañoCasilla, tamañoCasilla);
        add(c3);

        // --- FILA 2 ---
        CasillaLabel c4 = new CasillaLabel();
        c4.setBounds(228, 187, tamañoCasilla, tamañoCasilla);
        add(c4);
        
        CasillaLabel c5 = new CasillaLabel();
        c5.setBounds(327, 187, tamañoCasilla, tamañoCasilla);
        add(c5);

        CasillaLabel c6 = new CasillaLabel();
        c6.setBounds(426, 187, tamañoCasilla, tamañoCasilla);
        add(c6);

        // --- FILA 3 ---
        CasillaLabel c7 = new CasillaLabel();
        c7.setBounds(228, 286, tamañoCasilla, tamañoCasilla);
        add(c7);

        CasillaLabel c8 = new CasillaLabel();
        c8.setBounds(327, 286, tamañoCasilla, tamañoCasilla);
        add(c8);

        CasillaLabel c9 = new CasillaLabel();
        c9.setBounds(426, 286, tamañoCasilla, tamañoCasilla);
        add(c9);

        cajaDeTexto1 = new JTextField();
        cajaDeTexto1.setBounds(255, 375, 200, 20);
        add(cajaDeTexto1);

        casillas[0][0] = c1; casillas[0][1] = c2; casillas[0][2] = c3;
        casillas[1][0] = c4; casillas[1][1] = c5; casillas[1][2] = c6;
        casillas[2][0] = c7; casillas[2][1] = c8; casillas[2][2] = c9;


        cajaDeTexto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent num) {
                procesarEntradaCodigo();
            }
        });
    }

    public void procesarEntradaCodigo(){
        String codigo = cajaDeTexto1.getText().trim();
        cajaDeTexto1.setText("");

        if (codigo.isEmpty()){
            return;
        }

        int[] pos = obtenerCoordenadasPorCodigo(codigo);

        if (pos == null) {
            JOptionPane.showMessageDialog(this, 
                "Código de barras no reconocido. Intente nuevamente.", 
                "Código Inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int fila = pos[0];
        int col = pos[1];

        if (casillas[fila][col].getEstadoActual() != CasillaLabel.VACIO) {
            JOptionPane.showMessageDialog(this, 
                "La casilla ya está ocupada. Elija otra casilla.", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Determinar el símbolo según la regla de turnos (Impar = X, Par = O)
        int simboloJugador = (contadorTurno % 2 != 0) ? CasillaLabel.X : CasillaLabel.O;

        casillas[fila][col].setEstado(simboloJugador);

        // --- EVALUAR CONDICIONES DE FIN DE JUEGO ---
        if (verificarGanador(simboloJugador)) {
            String nombreJugador = (simboloJugador == CasillaLabel.X) ? "Jugador 1 (X)" : "Jugador 2 (O)";
            finalizarJuego("¡El " + nombreJugador + " ha ganado!");
            return;
        }

        if (verificarEmpate()) {
            finalizarJuego("¡Empate! Se han llenado todas las casillas.");
            return;
        }

        contadorTurno++;
        actualizarIndicadoresTurno();
    }

    private int[] obtenerCoordenadasPorCodigo(String codigo) {
        switch (codigo) {
            case "1120252026111": return new int[]{0, 0}; // C1 (Fila 0, Col 0)
            case "1220252026125": return new int[]{0, 1}; // C2 (Fila 0, Col 1)
            case "1320252026139": return new int[]{0, 2}; // C3 (Fila 0, Col 2)
            
            case "2120252026219": return new int[]{1, 0}; // C4 (Fila 1, Col 0)
            case "2220252026223": return new int[]{1, 1}; // C5 (Fila 1, Col 1)
            case "2320252026237": return new int[]{1, 2}; // C6 (Fila 1, Col 2)
            
            case "3120252026317": return new int[]{2, 0}; // C7 (Fila 2, Col 0)
            case "3220252026321": return new int[]{2, 1}; // C8 (Fila 2, Col 1)
            case "3320252026335": return new int[]{2, 2}; // C9 (Fila 2, Col 2)
            
            default: return null;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    public void marcarCasilla(int fila, int col, int jugador) {
        if (fila >= 0 && fila < 3 && col >= 0 && col < 3) {
            casillas[fila][col].setEstado(jugador);
        }
    }

    private boolean verificarGanador(int simbolo) {
        // 1. Revisar Filas
        for (int i = 0; i < 3; i++) {
            if (casillas[i][0].getEstadoActual() == simbolo &&
               casillas[i][1].getEstadoActual() == simbolo &&
               casillas[i][2].getEstadoActual() == simbolo) {
               return true;
            }
        }

        // 2. Revisar Columnas
        for (int j = 0; j < 3; j++) {
            if (casillas[0][j].getEstadoActual() == simbolo &&
                casillas[1][j].getEstadoActual() == simbolo &&
                casillas[2][j].getEstadoActual() == simbolo) {
                return true;
            }
        }

        // 3. Revisar Diagonal Principal (\)
        if (casillas[0][0].getEstadoActual() == simbolo &&
            casillas[1][1].getEstadoActual() == simbolo &&
            casillas[2][2].getEstadoActual() == simbolo) {
            return true;
        }

        // 4. Revisar Diagonal Inversa (/)
        if (casillas[0][2].getEstadoActual() == simbolo &&
            casillas[1][1].getEstadoActual() == simbolo &&
            casillas[2][0].getEstadoActual() == simbolo) {
            return true;
        }

        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casillas[i][i].getEstadoActual() == CasillaLabel.VACIO) {
                    return false;
                }
            }
        }
        return true; // No hay espacios vacíos
    }

    // Muestra el mensaje de fin de juego y pregunta si quieren reiniciar
    private void finalizarJuego(String mensaje) {
        int opcion = JOptionPane.showConfirmDialog(
            this, 
            mensaje + "\n¿Desean jugar otra partida?", 
            "Fin del Juego", 
            JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            reiniciarJuego();
        } else {
            System.exit(0); // Cierra la aplicación
        }
    }

    // Limpia el tablero y reinicia el contador de turnos
    private void reiniciarJuego() {
        contadorTurno = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j].setEstado(CasillaLabel.VACIO);
            }
        }
        actualizarIndicadoresTurno();
    }
}