package e2;

import java.util.Arrays;

public class SocialDistance
{
    public static char [][] seatingPeople ( char [][] layout )
    {
        if(layout == null)   throw new IllegalArgumentException("Error"); //Comprobacion para evitar parametros nulos
        boolean fallo = false;
        char[][] auxiliar = new char[layout.length][layout[0].length]; //Matriz auxiliar (copia del parametro). En ella
        //se iran guardando los cambios que seran copiados finalmente a la matriz original
        int contador = 0;
        boolean cambio;


        for(int i = 0; i < layout.length-1;i++) //Comprobacion de la forma de la matriz. Solo se aceptan matrices
            //cuadradas o rectangulares
        {
            if(layout[i].length!=layout[i+1].length)
            {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < layout.length; i++) // Bucle para copiar la matriz original en la auxiliar
        {
            for (int j = 0; j < layout[0].length; j++) {
                if((layout[i][j]!='A')&&(layout[i][j]!='.')){ //Comprobacion de si los caracteres de la matriz parametro
                    //son validos
                    fallo = true;
                }else auxiliar[i][j] = layout[i][j];
            }
        }
        if(fallo) throw new IllegalArgumentException("Error");

        do //Bucle que realiza cuatro acciones: sentar, actualizar la matriz, levantar y volver a actualizar
        {
            cambio = false; //Cuando se detecte un cambio, significara que el bucle se tiene que voilver a ejecutar.
            //Asi, cuando no quede mas por hacer, no se realizara ningun cambio y por lo tanto se saldra del bucle

            for (int i = 0; i < layout.length; i++) //Bucle para sentar a los alumnos
            {
                for (int j = 0; j < layout[0].length; j++) {
                    if (layout[i][j] == 'A') //Comprobacion de que el caracter sea el correcto
                    {
                        if((layout.length>1)&&(layout[0].length>1)) //Caso general (matrices 2x2 o mas)
                        {
                            if ((i==0)&&(j==0)) { //Esquina superior izquierda
                                if((layout[i][j+1]!='#')&&(layout[i+1][j]!='#')&&(layout[i+1][j+1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else if ((i==0)&&(j==(layout[0].length-1))) { //Esquina superior derecha
                                if((layout[i][j-1]!='#')&&(layout[i+1][j]!='#')&&(layout[i+1][j-1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else if ((i==(layout.length-1))&&(j==0)) { //Esquina inferior izquierda
                                if((layout[i-1][j]!='#')&&(layout[i-1][j+1]!='#')&&(layout[i][j+1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else if ((i==(layout.length-1))&&(j==(layout[0].length-1))) { //Esquina inferior derecha
                                if((layout[i-1][j-1]!='#')&&(layout[i-1][j]!='#')&&(layout[i][j-1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else if (i==0) { //Borde superior
                                if((layout[i][j-1]!='#')&&(layout[i][j+1]!='#')&&(layout[i+1][j-1]!='#')&&(layout[i+1][j]!='#')&&(layout[i+1][j+1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else if (i==layout.length-1) { //Borde inferior
                                if((layout[i][j-1]!='#')&&(layout[i][j+1]!='#')&&(layout[i-1][j-1]!='#')&&(layout[i-1][j]!='#')&&(layout[i-1][j+1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else if (j==0) { //Borde izquierdo
                                if((layout[i-1][j]!='#')&&(layout[i+1][j]!='#')&&(layout[i-1][j+1]!='#')&&(layout[i][j+1]!='#')&&(layout[i+1][j+1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else if (j==layout[0].length-1) { //Borde derecho
                                if((layout[i-1][j]!='#')&&(layout[i+1][j]!='#')&&(layout[i-1][j-1]!='#')&&(layout[i][j-1]!='#')&&(layout[i+1][j-1]!='#')){
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                            else{ //Interior
                                if ((layout[i-1][j-1] != '#') && (layout[i-1][j] != '#') && (layout[i-1][j+ 1] != '#') && (layout[i][j-1] != '#') && (layout[i][j+1] != '#') && (layout[i+1][j-1] != '#') && (layout[i+1][j] != '#') && (layout[i+1][j+1] != '#')) {
                                    auxiliar[i][j] = '#';
                                    cambio = true;
                                }
                            }
                        }else if((layout.length==1)&&(layout[0].length)==1){ //Caso matriz 1x1
                            auxiliar[i][j] = '#';
                        }else if(layout[0].length==1){ //Caso matriz columna
                            for(i = 0; i<layout.length;i++){
                                auxiliar[i][j] = '#';
                            }
                        }else{ //Caso matriz fila
                            for(j = 0; j<layout[0].length;j++){
                                auxiliar[i][j] = '#';
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < layout.length; i++) //Actualizacion de la matriz original copiando los cambios
                //realizados en la auxiliar
            {
                layout[i] = Arrays.copyOf(auxiliar[i], auxiliar[i].length);
            }


            for (int i = 0; i < layout.length; i++) //Bucle para levantar a los alumnos
            {
                for (int j = 0; j < layout[0].length; j++) { //Comprobacion de que el caracter sea el correcto
                    if (layout[i][j] == '#') //
                    {
                        if((layout.length>1)&&(layout[0].length>1)) //Caso general (matrices 2x2 o mas)
                        {
                            //No hai un caso para las esquinas, puestas estas nunca van a cumplir la condicion de
                            //cambio (solo tienen 3 asientos adyacentes)
                            if((i==0)&&((j!=0)&&(j!=layout[0].length-1))){ //Borde superior
                                if (layout[i][j - 1] == '#') contador++;
                                if (layout[i][j + 1] == '#') contador++;
                                if (layout[i + 1][j - 1] == '#') contador++;
                                if (layout[i + 1][j] == '#') contador++;
                                if (layout[i + 1][j + 1] == '#') contador++;
                            }
                            else if((i==layout.length-1)&&((j!=0)&&(j!=layout[0].length-1))){ //Borde inferior
                                if (layout[i][j - 1] == '#') contador++;
                                if (layout[i][j + 1] == '#') contador++;
                                if (layout[i - 1][j - 1] == '#') contador++;
                                if (layout[i - 1][j] == '#') contador++;
                                if (layout[i - 1][j + 1] == '#') contador++;
                            }
                            else if((j==0)&&((i!=0)&&(i!=layout.length-1))){ //Borde izquierdo
                                if (layout[i - 1][j] == '#') contador++;
                                if (layout[i + 1][j] == '#') contador++;
                                if (layout[i - 1][j + 1] == '#') contador++;
                                if (layout[i][j + 1] == '#') contador++;
                                if (layout[i + 1][j + 1] == '#') contador++;
                            }
                            else if((j==layout[0].length-1)&&((i!=0)&&(i!=layout.length-1))){ //Borde derecho
                                if (layout[i - 1][j] == '#') contador++;
                                if (layout[i + 1][j] == '#') contador++;
                                if (layout[i - 1][j - 1] == '#') contador++;
                                if (layout[i][j - 1] == '#') contador++;
                                if (layout[i + 1][j - 1] == '#') contador++;
                            }
                            else if((i!=0)&&(j!=0)&&(i!=layout.length-1)&&(j!=layout[0].length-1)) { //Interior
                                if (layout[i - 1][j - 1] == '#') contador++;
                                if (layout[i - 1][j] == '#') contador++;
                                if (layout[i - 1][j + 1] == '#') contador++;
                                if (layout[i][j - 1] == '#') contador++;
                                if (layout[i][j + 1] == '#') contador++;
                                if (layout[i + 1][j - 1] == '#') contador++;
                                if (layout[i + 1][j] == '#') contador++;
                                if (layout[i + 1][j + 1] == '#') contador++;
                            }
                        }
                            if (contador >= 4) { //Si 4 o mas de los asientos que rodean al actual estan ocupados,
                                auxiliar[i][j] = 'A'; //el alumno se tiene que levantar
                                cambio = true;
                            }
                        }
                    contador = 0; //Reinicio del contador para cada posicion de la matriz
                    }

                }
            for (int i = 0; i < layout.length; i++) //Actualizacion de la matriz original copiando los cambios
            {
                layout[i] = Arrays.copyOf(auxiliar[i], auxiliar[i].length);
            }
        } while (cambio);
    return layout;
    }
}
