package e1;

public class CheckOut implements Estado{
    private static final CheckOut instancia = new CheckOut();
    private CheckOut() { }

    public static CheckOut getInstancia() { return instancia; }

    public String screenInfo(Order order){
        return ("Order number: " + order.getIdentificador() + "\nCheckOut: "+order.nProductos+" products");
    }
    @Override
    public void addCarrito(Order order, Product producto,int numero){
        if(numero<producto.getCantidad()){
            for(Product objetoAComprar : order.productosCarrito){
                if(objetoAComprar.getNombre().equals(producto.getNombre())){
                    objetoAComprar.anadir(numero);
                    order.historial.append("- Modify: Item: ").append(producto.getNombre()).append(" - Quantity: ").append(objetoAComprar.getCantidad())
                            .append(" -> ").append("Shopping cart -- Products : ").append(order.nProductos).append("\n");
                    break;
                }
            }
        }
        else throw new IllegalArgumentException("Producto no encontrado");
    }
    @Override
    public void eliminarCarrito(Order order, Product producto, int numero){
        boolean encontrado=false;
        if(numero<producto.getCantidad()){
            for(Product objetoAEliminar : order.productosCarrito){
                if(objetoAEliminar.getNombre().equals(producto.getNombre())){
                    encontrado=true;
                    objetoAEliminar.quitar(numero);
                    producto.anadir(numero);
                    order.historial.append("- Modify: Item: ").append(producto.getNombre()).append(" - Quantity: ").append(objetoAEliminar.getCantidad())
                            .append(" -> ").append("Shopping cart -- Products : ").append(order.nProductos).append("\n");
                    break;
                }
            }
            if(!encontrado){
                throw new IllegalArgumentException("Producto no encontrado");
            }
        }
        else if(numero==producto.getCantidad()){
            order.productosCarrito.remove(producto);
            order.eliminarProducto();
            order.historial.append("- Remove: Item: ").append(producto.getNombre()).append(" -> ").append("Shopping cart -- Products : ")
                    .append(order.nProductos).append("\n");
        }
        else throw new IllegalArgumentException("Producto no encontrado");
    }
    public void pagar(Order order){}
    public void cancelar(Order order){}
    public void nextPhase(Order order){
            order.setEstado(Payment.getInstancia());
            order.historial.append("Order ").append(order.getIdentificador()).append(": Payment phase").append("\n");
    }
    public void previousPhase(Order order){
        order.setEstado(ShoppingCart.getInstancia());
        order.historial.append("Order ").append(order.getIdentificador()).append(": Shopping phase").append("\n");
    }
}
