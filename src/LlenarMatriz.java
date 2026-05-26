public class LlenarMatriz {

    public char[][] inicializarMatriz (char[][] matMostrar){

        for (int i = 0; i < matMostrar.length; i++) {
            for (int j = 0; j < matMostrar[i].length; j++) {
                matMostrar[i][j] = ' '; 
            }
        }
        return matMostrar;
    }
// Fija las casillas de la primera columna y la primera fila con las posiciones en las que se pueden colocar las X o O
    public char[][] fijarCasillas (char[][] matMostrar){

        matMostrar[0][0]='/';
        matMostrar[0][1]='1';
        matMostrar[0][2]='2';
        matMostrar[0][3]='3';
        matMostrar[1][0]='1';
        matMostrar[2][0]='2';
        matMostrar[3][0]='3';
        return matMostrar;
    }

    public void imprimirMatriz(char[][] matriz) {

    for(int i = 0; i < 4; i++) {

        for(int j = 0; j < 4; j++) {

            if(matriz[i][j] == ' ') {

                System.out.print("["+ " "+"]");

            } else {

                System.out.print("[" + matriz[i][j] + "]");

            }

        }

        System.out.println();
    }
}
}
