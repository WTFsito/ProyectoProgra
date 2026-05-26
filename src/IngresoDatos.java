import java.util.Scanner;

public class IngresoDatos {

    Scanner scanner = new Scanner(System.in);

    public int[] ingresarDatos(char[][] matMostrar) {

        int fila;
        int columna;

        do {

            System.out.print("Ingresa fila (1-3): ");
            fila = scanner.nextInt();

            System.out.print("Ingresa columna (1-3): ");
            columna = scanner.nextInt();

            if (fila < 1 || fila > 3 || columna < 1 || columna > 3) {

                System.out.println("Error: Debes ingresar números entre 1 y 3.");

            } else if (matMostrar[fila][columna] == 'X' || matMostrar[fila][columna] == 'O') {

                System.out.println("Esa casilla ya está ocupada.");

            } else {

                break;

            }

        } while (true);

        return new int[]{fila, columna};
    }
}