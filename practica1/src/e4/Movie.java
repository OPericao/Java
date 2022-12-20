package e4;

import java.util.ArrayList;
public class Movie {

    String title;
    ArrayList<MovieRating> ratings = new ArrayList<>(); //Creacion de una ArrayList para almacenar las valoraciones

    public Movie(String title) {
        this.title = title;
    } //Metodo construcor

    public String getTitle() { //Getter

        return title;
    }

    public void insertRating(MovieRating movieRating) { //Metodo que inserta una nueva valoracion a la lista

        ratings.add(movieRating);
    }

    private boolean isRated() { //Metodo que comprueba si una pelicula tiene alguna valoracion
        boolean valorado = false;

        for (MovieRating rating : ratings){
            if (rating != MovieRating.NOT_RATED){ //En el momento en el que una de las valoraciones de la lista es
                //distinta de NOT_RATED, significa que tiene alguna valoracion. Por lo tanto, se sale del bucle
                valorado = true;
                break;
            }
        }
        return valorado;
    }

    public MovieRating maximumRating() //Metodo que devuelve la mejor valoracion de una pelicula
    {
        MovieRating maxRat = MovieRating.NOT_RATED; //Valoracion maxima
        if(isRated()){
            for (MovieRating rating : ratings){
                if (rating.isBetterThan(maxRat)){ //Si la valoracion es mejor que la actual maxima, esta se convierte
                    //ahora en la nueva maxima
                    maxRat=rating;
                }
            }
            return maxRat;
        }
        else{ //En caso de no tener ninguna valoracion, devuelve NOT_RATED
            return MovieRating.NOT_RATED;
        }
    }

    public double averageRating() { //Metodo que devuelve la media de las valoraciones de una pelicula
        double avg,sum = 0;
        int aux = 0;
        if(isRated()){
            for (MovieRating rating : ratings){
                if(rating.getNumericRating()>=0){ //Condicion para excluir valoraciones NOT_RATED
                    aux = aux + 1;
                    sum = sum + rating.getNumericRating(); //Suma acumulada de las valoraciones
                }
            }
            avg = sum/aux; //Media de las valoraciones
            return avg;
        }
        else { //Caso en que el no hay valoraciones validas

            throw new java.util.NoSuchElementException();
        }
    }

}
