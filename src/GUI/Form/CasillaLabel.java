package GUI.Form;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CasillaLabel extends JLabel {
    
    // Definimos los tres estados posibles
    public static final int VACIO = 0;
    public static final int X = 1;
    public static final int O = 2;
    
    private int estadoActual = VACIO;
    
    private ImageIcon imgVacia;
    private ImageIcon imgX;
    private ImageIcon imgO;

    public CasillaLabel() {
        // Cargar las imágenes desde la carpeta Resource
        imgVacia = cargarIcono("/GUI/Resource/Img/vacia.png");
        imgX = cargarIcono("/GUI/Resource/Img/X.png");
        imgO = cargarIcono("/GUI/Resource/Img/O.png");
        
        // Estado inicial
        setEstado(VACIO);
    }
    
    // Método para cambiar el estado y actualizar la imagen automáticamente
    public void setEstado(int nuevoEstado) {
        this.estadoActual = nuevoEstado;
        switch (nuevoEstado) {
            case VACIO -> setIcon(imgVacia);
            case X     -> setIcon(imgX);
            case O     -> setIcon(imgO);
        }
    }

    public int getEstadoActual() {
        return estadoActual;
    }

    // Método auxiliar para evitar errores si la imagen no se encuentra
    private ImageIcon cargarIcono(String ruta) {
        URL url = getClass().getResource(ruta);
        if (url != null) {
            return new ImageIcon(url);
        }
        System.out.println("No se pudo encontrar el recurso: " + ruta);
        return null;
    }
}