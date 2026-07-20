import javax.swing.SwingUtilities;
import GUI.Form.SplashScreen;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplashScreen splash = new SplashScreen();
            splash.mostrar();
        });
    }
}
