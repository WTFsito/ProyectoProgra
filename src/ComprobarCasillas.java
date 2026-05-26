public class ComprobarCasillas {

    public boolean validarVictoria( char fila, char columna, char[][] matMostrar) {
        if (matMostrar[fila][1]==matMostrar[fila][2] && matMostrar[fila][1]==matMostrar[fila][3]) {
            return true;
        }

        if (matMostrar[1][columna]==matMostrar[2][columna] && matMostrar[1][columna]==matMostrar[3][columna]) {
            return true;
        }        

        if (fila == columna) {
            if (matMostrar[1][1] == matMostrar[2][2] &&matMostrar[1][1] == matMostrar[3][3]) {
            return true;
            }
        }

        if (fila + columna == 4) {

            if (matMostrar[1][3] == matMostrar[2][2] && matMostrar[1][3] == matMostrar[3][1]) {

            return true;
            }   
        }

        return false;
    }

}

