public class LlenarMatriz {

    public char[][] inicializarMatriz (char[][] matMostrar){
        char[][] matrizLlena = new char[4][4];

        for (int i = 0; i < matrizLlena.length; i++) {
            for (int j = 0; j < matrizLlena[i].length; j++) {
                matrizLlena[i][j] = ' '; 
            }
        }

        return matrizLlena;
    }
// Fija las casillas de la primera columna y la primera fila con las posiciones en las que se pueden colocar las X o O
    public char[][] fijarCasillas (char[][] matMostrar){
        char[][] matrizFija = new char[4][4];
        matrizFija[0][0]='/';
        matrizFija[0][1]='1';
        matrizFija[0][2]='2';
        matrizFija[0][3]='3';
        matrizFija[1][0]='1';
        matrizFija[2][0]='2';
        matrizFija[3][0]='3';
        return matrizFija;
    }
}
