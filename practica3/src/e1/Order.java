package e1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    String identificador;
    Estado estado = ShoppingCart.getInstancia();
    int nProductos=0;
    List<Product> productosCarrito = new ArrayList<>();
    StringBuilder historial = new StringBuilder();
    Instant start = Instant.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime creacion = LocalDateTime.now();

    public Order (String identificador){
        this.identificador=identificador;
    }
    public String getIdentificador(){
        return identificador;
    }

    public String screenInfo(){
        if(productosCarrito.isEmpty())
            return ("Order number: " + identificador + "\nShopping -- Welcome to online shop");
        else return estado.screenInfo(this);
    }
    public String printLog(){
        return historial.toString();
    }

    public void addCarrito(Product prod,int cant){
        estado.addCarrito(this,prod,cant);
    }
    public void eliminarCarrito(Product prod, int cant) {
        estado.eliminarCarrito(this,prod,cant);
    }
    public void pagar(){
        estado.pagar(this);
    }
    public void cancelar(){
        estado.cancelar(this);
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void agnadirProducto(){
        this.nProductos++;
    }
    public void eliminarProducto(){
        this.nProductos--;
    }

    public void nextPhase(){
        estado.nextPhase(this);
    }
    public void previousPhase(){
        estado.previousPhase(this);
    }

}
