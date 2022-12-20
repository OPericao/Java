package e1;

public class Completed implements Estado{
    private static final Completed instancia = new Completed();
    private Completed() { }

    public static Completed getInstancia() { return instancia; }

    public String screenInfo(Order order){
        return ("Order number: " + order.getIdentificador() + "\nCompleted order: "+order.nProductos+" products");
    }
    public void addCarrito(Order order, Product producto, int numero){}
    public void eliminarCarrito(Order order, Product producto, int numero){}
    public void pagar(Order order){}
    public void cancelar(Order order){}
    public void nextPhase(Order order){}
    public void previousPhase(Order order){}
}
