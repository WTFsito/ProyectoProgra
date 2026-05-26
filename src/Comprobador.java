import java.util.Scanner;

public class Comprobador {
    // matriz de 4x4 para permitir índices 1..3 directamente
    private char[][] matMostrar = new char[4][4];

    // inicializar en espacios
    public Comprobador() {
        for (int i = 0; i < matMostrar.length; i++)
            for (int j = 0; j < matMostrar[i].length; j++)
                matMostrar[i][j] = ' ';
    }
    public void comprobe() {

        int fila, columna;
        boolean casillaValida = false;

        Scanner scanner = new Scanner(System.in);
            do {
                // 1. Pedir datos al usuario
                System.out.print("Ingresa fila (1-3): ");
                fila = scanner.nextInt();
               System.out.print("Ingresa columna (1-3): ");
               columna = scanner.nextInt();

              // 2. Validar rango (1-3) y disponibilidad
               if (fila < 1 || fila > 3 || columna < 1 || columna > 3) {
                  System.out.println("Error: Debes ingresar números entre 1 y 3.");
              } else if (matMostrar[fila][columna] != ' ') { // Asumiendo que ' ' es vacío
                  System.out.println("¡Esa casilla ya está ocupada! Intenta otra.");
              } else {
                  // Si todo está bien, marcamos como válida para salir del bucle
                 casillaValida = true;
              }
            } while (!casillaValida);

            // 3. Colocar el símbolo y mostrar el tablero
            matMostrar[fila][columna] = 'X'; // O el símbolo del jugador actual
            imprimirTablero(); // Método que recorre e imprime la matriz
    }

    // Imprime el tablero usando índices 1..3
    private void imprimirTablero() {
        System.out.println("Tablero:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print("[" + matMostrar[i][j] + "]");
            }
            System.out.println();
        }
    }
}