package e1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static Product p1 = new Product("Chocolate",5);
    static Product p2 = new Product("Galletas",10);
    static Product p3 = new Product("Arroz",7);

    @Test
    void prueba1(){
        Order o1 = new Order("1212");
        assertEquals(o1.screenInfo(),"Order number: 1212\nShopping -- Welcome to online shop");
        System.out.println(o1.screenInfo());
        o1.addCarrito(p1,2);
        o1.addCarrito(p2,6);
        o1.addCarrito(p3,1);
        assertEquals(o1.screenInfo(),"Order number: 1212\nShopping -- 3 products");
        System.out.println(o1.screenInfo());
        o1.eliminarCarrito(p1,1);
        o1.nextPhase();
        assertEquals(o1.screenInfo(),"Order number: 1212\nCheckOut: 3 products");
        System.out.println(o1.screenInfo());
        o1.eliminarCarrito(p2,2);
        o1.addCarrito(p3,3);
        o1.nextPhase();
        LocalDateTime now = LocalDateTime.now();    //Este tiempo no es exactamente el mismo que el que guarda el order,
                                                    //por lo que puede fallar en algunas ocasiones
        assertEquals(o1.screenInfo(),"Order number: 1212\n" +
                "Paid Order: 3 products -- " + dtf.format(now));
        System.out.println(o1.screenInfo());
        o1.pagar();
        o1.nextPhase();
        assertEquals(o1.screenInfo(),"Order number: 1212\nCancelled order");
        System.out.println(o1.screenInfo());
    }

    @Test
    void prueba2(){
        Order o2 = new Order("3344");
        o2.addCarrito(p1,1);
        o2.nextPhase();
        o2.addCarrito(p1,2);
        o2.previousPhase();
        o2.addCarrito(p2,5);
        o2.eliminarCarrito(p1,1);
        o2.nextPhase();
        assertEquals(o2.printLog(), """
                - Add: Item: Chocolate - Quantity: 1 -> Shopping cart -- Products : 1
                Order 3344: Check out phase
                - Modify: Item: Chocolate - Quantity: 3 -> Shopping cart -- Products : 1
                Order 3344: Shopping phase
                - Add: Item: Galletas - Quantity: 5 -> Shopping cart -- Products : 2
                - Modify: Item: Chocolate - Quantity: 2 -> Shopping cart -- Products : 2
                Order 3344: Check out phase
                """);
        System.out.println(o2.printLog());
    }
}
