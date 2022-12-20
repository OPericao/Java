package e1;

public class Product {
    private final String nombre;
    private int cantidad;

    public Product (String nombre, int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
    }

    public int getCantidad(){
        return cantidad;
    }

    public String getNombre(){
        return nombre;
    }
    public void quitar (int cant){
        cantidad = cantidad - cant;
    }

    public void anadir (int cant){ cantidad = cantidad + cant; }
}
