package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeliculaTest {
    private static final Pelicula p1 = new Pelicula("Avatar", 300000);
    private static final Pelicula p2 = new Pelicula("Star Wars", 2500);
    private static final Pelicula p3 = new Pelicula("Indiana Jones", 666000);
    private static final EquipoHumano h1 = new Directores ("Juan","Dominguez","Espana","26546789S","600987861",100,5);
    private static final EquipoHumano h2 = new Guionistas ("Pedro","Pazos","Espana","78612354C","845908767",200,true);
    private static final EquipoHumano h3 = new Interpretes ("Marcos","Garcia","Espana","53791817J","640343877",300,Rol.protagonist);
    private static final EquipoHumano h4 = new Interpretes ("Hernan","Parras","Colombia","47284221J","712123131",150,Rol.secondary);

    private static final EquipoHumano h5 = new Interpretes ("Luca","Panzini","Italia","90871266B","640604444",300,Rol.extra);
    private static final EquipoHumano h6 = new Interpretes ("Oscar","Mato","Espana","14243451D","641121877",300,Rol.extra);
    private static final EquipoHumano h7 = new Productores ("Laura","Suarez","Espana","57666766J","640612222",300);
    private static final EquipoHumano h8 = new Interpretes ("Sandra","Gil","Espana","57J","655513477",300,Rol.protagonist);
    private static final EquipoHumano h9 = new Dobladores ("Julian","Martinez","Venezuela","31315443G","622456532",150);
    private static final EquipoHumano h10 = new Musicos ("Friedrich","Muller","Alemania","12435687P","649988977",100);
    private static final EquipoHumano h11 = new Especialistas ("Roman","Wall","Reino Unido","90345456T","621123212",80,true);
    @BeforeAll
    static void insertarTrabajador(){
        p1.insertarTrabajador(h1);
        p1.insertarTrabajador(h2);
        p1.insertarTrabajador(h3);
        p2.insertarTrabajador(h4);
        p2.insertarTrabajador(h5);
        p3.insertarTrabajador(h6);
        p3.insertarTrabajador(h7);
        p3.insertarTrabajador(h8);
        p3.insertarTrabajador(h9);
        p3.insertarTrabajador(h10);
        p3.insertarTrabajador(h11);
    }

    @Test
    void printSalaries(){
        assertEquals("""
                Juan Dominguez (Director, 5 years of experience): 15000 euro
                Pedro Pazos (Screenwriter, original screenplay): 18000 euro
                Marcos Garcia (Actor protagonist): 180000 euro
                The total payroll for Avatar is 213000 euro""",p1.printSalaries());
        assertEquals("""
                Hernan Parras (Actor secondary): 30000 euro
                Luca Panzini (Actor extra): 60000 euro
                The total payroll for Star Wars is 90000 euro""",p2.printSalaries());
    }

    @Test
    void getSalary(){
        assertEquals(15000,h1.getSalary());
        assertEquals(18000,h2.getSalary());
        assertEquals(180000,h3.getSalary());
        assertEquals(3000,h9.getSalary());
        assertEquals(6000,h10.getSalary());
        assertEquals(4200,h11.getSalary());
    }

    @Test
    void getDatos(){
        assertEquals("Juan Dominguez (Director, 5 years of experience): 15000 euro",h1.getDatos());
        assertEquals("Pedro Pazos (Screenwriter, original screenplay): 18000 euro",h2.getDatos());
        assertEquals("Marcos Garcia (Actor protagonist): 180000 euro",h3.getDatos());
        assertEquals("Julian Martinez (Dubber): 3000 euro",h9.getDatos());
        assertEquals("Friedrich Muller (Musician): 6000 euro",h10.getDatos());
        assertEquals("Roman Wall (Stunt performer with extra for danger): 4200 euro",h11.getDatos());
    }

    @Test
    void printRoyalties(){
        assertEquals("""
                        Juan Dominguez (Director): 15000 euro
                        Pedro Pazos (Screenwriter): 15000 euro
                        """,
                p1.printRoyalties());
        assertEquals("",p2.printRoyalties());
        assertEquals("""
                Laura Suarez (Producer): 13320 euro
                Friedrich Muller (Musician): 26640 euro
                """,p3.printRoyalties());
    }
}
