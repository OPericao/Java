package e1;

import java.time.Duration;
import java.time.Instant;

public class Payment implements Estado{
    boolean pagado = false;
    boolean cancelado = false;
    private static final Payment instancia = new Payment();
    private Payment() { }

    public static Payment getInstancia() { return instancia; }

    public String screenInfo(Order order){
        return ("Order number: " + order.getIdentificador() + "\nPaid Order: "+order.nProductos+" products -- " + order.dtf.format(order.creacion));
    }
    public void addCarrito(Order order, Product producto, int numero){}
    public void eliminarCarrito(Order order, Product producto, int numero){}
    public void pagar(Order order){
        pagado = true;
    }
    public void cancelar(Order order){
        cancelado = true;
    }
    public void nextPhase(Order order){
        if(pagado) {
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(order.start, finish).toMillis();
            if((timeElapsed > 1000*60*60*24) && !cancelado) {
                order.setEstado(Completed.getInstancia());
            }else order.setEstado(Cancelled.getInstancia());
        }
    }
    public void previousPhase(Order order){
    }
}
