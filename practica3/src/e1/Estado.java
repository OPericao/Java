package e1;

public interface Estado {
    String screenInfo(Order order);
    void addCarrito(Order order, Product producto, int numero);
    void eliminarCarrito(Order order, Product producto, int numero);
    void pagar(Order order);
    void cancelar(Order order);
    void nextPhase(Order order);
    void previousPhase(Order order);

}
