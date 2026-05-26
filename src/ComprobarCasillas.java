public class ComprobarCasillas {

    public boolean validarVictoria( int fila, int columna, char[][] matMostrar) {
        // Aqui se valida que al menos haya una fila completamente llena de X o O.
        if (matMostrar[fila][1]==matMostrar[fila][2] && matMostrar[fila][1]==matMostrar[fila][3]) {
            return true;
        }
        // Se valida que haya al m,enos una columna con X o O.

        if (matMostrar[1][columna]==matMostrar[2][columna] && matMostrar[1][columna]==matMostrar[3][columna]) {
            return true;
        }        

        // Se valida que la diagonal principal de la matriz este llena de X o O

        if (fila == columna) {
            if (matMostrar[1][1] == matMostrar[2][2] &&matMostrar[1][1] == matMostrar[3][3]) {
            return true;
            }
        
        }

        // Se valida la diagonal secundaria de la matriz este llena de X o O

        if (fila + columna == 4) {

            if (matMostrar[1][3] == matMostrar[2][2] && matMostrar[1][3] == matMostrar[3][1]) {

            return true;
            }   
        }

        return false;
    }

}

/*
Todo lo anterior validado nos guiamos por los indices de posicion de cada elemento de la matriz

Indices de cada elemento de la matriz (Sin contar la primera fila y columna)

11      12       13


21      22       23                  El primer valor es el numero de fila y el segundo el numero de columna


31      32       33

Primer if: Se valida con un valor constante de las filas y se va comparando con cada valor de las columnas
Segundo if: Se valida con un valor constante de columna y se va variando el valor de las filas para ir comparandolo
Tercer if: SDe valida la diagonal principal, es decir, cuando el valor de la fila y columna es igual.
Cuarto if: Se nota que los valores de la diagonal principal sumados dan 4 en todas las posiciones.

*/

