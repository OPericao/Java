package e1;

public class ShoppingCart implements Estado{
    private static final ShoppingCart instancia = new ShoppingCart();
    private ShoppingCart() { }
    public static ShoppingCart getInstancia() { return instancia; }

    public String screenInfo(Order order){
        return ("Order number: " + order.getIdentificador() + "\nShopping -- "+order.nProductos+" products");
    }
    @Override
    public void addCarrito(Order order, Product producto,int numero){
        boolean encontrado=false;
        if(numero<producto.getCantidad()){
            for(Product objetoAComprar : order.productosCarrito){
                if(objetoAComprar.getNombre().equals(producto.getNombre())){
                    encontrado=true;
                    objetoAComprar.anadir(numero);
                    order.historial.append("- Modify: Item: ").append(producto.getNombre()).append(" - Quantity: ").append(objetoAComprar.getCantidad())
                            .append(" -> ").append("Shopping cart -- Products : ").append(order.nProductos).append("\n");
                    break;
                }
            }
            if(!encontrado){
                order.productosCarrito.add(new Product(producto.getNombre(),numero));
                order.agnadirProducto();
                order.historial.append("- Add: Item: ").append(producto.getNombre()).append(" - Quantity: ").append(numero).append(" -> ")
                        .append("Shopping cart -- Products : ").append(order.nProductos).append("\n");
            }
            producto.quitar(numero);
        }
        else throw new IllegalArgumentException("No hay suficiente stock");
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
            producto.anadir(numero);
            order.historial.append("- Remove: Item: ").append(producto.getNombre()).append(" -> ")
                    .append("Shopping cart -- Products : ").append(order.nProductos).append("\n");
        }
        else throw new IllegalArgumentException("Producto no encontrado");
    }
    public void pagar(Order order){}
    public void cancelar(Order order){}
    public void nextPhase(Order order){
        order.setEstado(CheckOut.getInstancia());
        order.historial.append("Order ").append(order.getIdentificador()).append(": Check out phase").append("\n");
    }
    public void previousPhase(Order order){
    }
}
