package e1;

public class Cancelled implements Estado{
    private static final Cancelled instancia = new Cancelled();
    private Cancelled() { }

    public static Cancelled getInstancia() { return instancia; }

    public String screenInfo(Order order){
        return ("Order number: " + order.getIdentificador() + "\nCancelled order");
    }
    public void addCarrito(Order order, Product producto, int numero){}
    public void eliminarCarrito(Order order, Product producto, int numero){}
    public void pagar(Order order){}
    @Override
    public void cancelar(Order order){
    }
    public void nextPhase(Order order){
    }
    public void previousPhase(Order order){
    }
}
