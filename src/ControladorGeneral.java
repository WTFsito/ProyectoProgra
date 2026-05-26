import java.util.Scanner;

public class ControladorGeneral {

    public void iniciarJuego() {

        Scanner scanner = new Scanner(System.in);

        Title title = new Title();
        title.Titleprint();

        ComprobarCasillas comprobarCasillas = new ComprobarCasillas();
        IngresoDatos ingresoDatos = new IngresoDatos();
        LlenarMatriz llenarMatriz = new LlenarMatriz();

        int opcion;

        do {

            System.out.println("\n1. Iniciar partida");
            System.out.println("2. Terminar juego");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();

            switch(opcion) {

                case 1:

                    boolean victoria = false;
                    int cont = -1;

                    char[][] matMostrar = new char[4][4];

                    llenarMatriz.inicializarMatriz(matMostrar);
                    llenarMatriz.fijarCasillas(matMostrar);

                    llenarMatriz.imprimirMatriz(matMostrar);

                    do {

                        cont++;

                        if(cont % 2 == 0) {

                            System.out.println("Turno N°: " + (cont + 1) + ", juega \"X\"");

                        } else {

                            System.out.println("Turno N°: " + (cont + 1) + ", juega \"O\"");

                        }

                        int[] datos = ingresoDatos.ingresarDatos(matMostrar);

                        int filaPosicion = datos[0];
                        int columnaPosicion = datos[1];

                        if(cont % 2 == 0) {

                            matMostrar[filaPosicion][columnaPosicion] = 'X';

                        } else {

                            matMostrar[filaPosicion][columnaPosicion] = 'O';

                        }

                        llenarMatriz.imprimirMatriz(matMostrar);

                        victoria = comprobarCasillas.validarVictoria(
                                filaPosicion,
                                columnaPosicion,
                                matMostrar
                        );

                        if(victoria) {

                            if(cont % 2 == 0) {

                                System.out.println("¡El jugador X ha ganado!");

                            } else {

                                System.out.println("¡El jugador O ha ganado!");

                            }

                        }

                        if(cont == 8 && !victoria) {

                            System.out.println("¡Empate!");

                        }

                    } while(!victoria && cont < 8);

                    break;

                case 2:

                    System.out.println("Juego finalizado.");
                    System.out.println("Gracias por jugar ^-^");
                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while(opcion != 2);

    }
}