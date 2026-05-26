public class ControladorGeneral {

    public static void main(String[] args) {

        Title title= new Title();
        title.Titleprint();

        ComprobarCasillas comprobarCasillas= new ComprobarCasillas();
        IngresoDatos ingresoDatos= new IngresoDatos();
        boolean victoria=false;
        int cont=0;
        char fila=' ', columna=' ';
        char[][] matMostrar= new char[4][4]; 
        LlenarMatriz llenarMatriz = new LlenarMatriz();
        llenarMatriz.inicializarMatriz(matMostrar);
        
        

        do {

            cont++;
            //cont para elegir X o O, cont=0 imprime una X cont=1 una O, osea siempre se inicia con X y cont mod 2, si es 0 una x y si es 1 una O
            fila=ingresoDatos.ingresarFila(cont);
            columna=ingresoDatos.ingresarColumna(cont);

            victoria=comprobarCasillas.validarVictoria(fila , columna, matMostrar);






            //El juego termina cuando alguien gane o pasen los 9 turnos y el tablero se llene
        } while (!victoria && cont < 9);





    }

    

}
