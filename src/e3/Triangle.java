package e3;

public record Triangle(int angle0, int angle1, int angle2) { //Registro con 3 parametros (los 3 angulos del triangulo)

    public Triangle(int angle0,int angle1,int angle2) { //Metodo constructor (a partir de los 3 angulos)
        this.angle0 = angle0;
        this.angle1 = angle1;
        this.angle2 = angle2;

        if((angle0+angle1+angle2)!=180) throw new IllegalArgumentException("Triangulo no definido correctamente");
        //Comprobacion de que los 3 angulos sumen 180 grados
    }

    public Triangle(Triangle t){ //Metodo constructor (a partir de otro triangulo)
        this(t.angle0,t.angle1,t.angle2);
    }

    public boolean isRight (){
        return ((angle0 == 90)||(angle1 == 90)||(angle2 == 90));
    }
    //Metodo para ver si un triangulo es rectangulo

    public boolean isAcute (){
        return ((angle0 < 90)&&(angle1 < 90)&&(angle2 < 90));
    }
    //Metodo para ver si un triangulo es acutangulo

    public boolean isObtuse (){
        return ((angle0 > 90)||(angle1 > 90)||(angle2 > 90));
    }
    //Metodo para ver si un triangulo es obtusangulo

    public boolean isEquilateral (){
        return ((angle0 == 60)&&(angle1 == 60)&&(angle2 == 60));
    }
    //Metodo para ver si un triangulo es equilatero

    public boolean isIsosceles (){
        return(((angle0==angle1)||(angle0==angle2)||(angle1==angle2))&&!((angle0==angle1)&&(angle0==angle2)));
    } //Metodo para ver si un triangulo es isosceles

    public boolean isScalene (){
        return(angle0!=angle1)&&(angle1!=angle2)&&(angle0!=angle2);
    }
    ////Metodo para ver si un triangulo es escaleno

    @Override //Sobreescritura del metodo equals
    public boolean equals (Object o){
        if(o instanceof Triangle)
        {
            return(((angle0==((Triangle)o).angle0)||(angle0==((Triangle)o).angle1)||(angle0==((Triangle)o).angle2))&&
                    ((angle1==((Triangle)o).angle0)||(angle1==((Triangle)o).angle1)||(angle1==((Triangle)o).angle2))&&
                    ((angle2==((Triangle)o).angle0)||(angle2==((Triangle)o).angle1)||(angle2==((Triangle)o).angle2)));
            //Comprobacion de si los 3 angulos de los triangulos a compara son los mismos, independientemente del orden
        }else return false;
    }

    @Override //Sobreescritura del metodo hashcode
    public int hashCode (){ //El hashcode debe devolver un valor distinto para cada triangulo distinto.
        int result;
        result = angle0*angle1*angle2; //Multiplicando los 3 angulos, nos aseguramos de que el resultado sera distinto
        //para cada terna de angulos. Ademas, como el orden de los factores no altera el producto, se cumple
        //la condicion que queriamos (y por lo tanto es compatible con el equals)
        return result;
    }
}
