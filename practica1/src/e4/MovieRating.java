package e4;

public enum MovieRating {
    NOT_RATED(-1),
    AWFUL(0),
    BAD(2),
    MEDIOCRE(4),
    GOOD(6),
    EXCELLENT(8),
    MASTERPIECE(10);

    private final int valor;

    MovieRating(int valor){
        this.valor = valor;
    } //Metodo constructor

    public int getNumericRating(){ //Getter
        return valor;
    }

    public boolean isBetterThan(MovieRating movieRating){ //Metodo que comprueba si una valoracion pasada por parametro
        //es mejor que la valoracion actual
        return (valor > movieRating.getNumericRating());
    }
}

