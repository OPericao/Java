package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class LoginScreenTest {

    private static final Users u1 = new Users("pepe@gmail.com","46747474A","653123454","holahola23",Mfa.SMS);
    private static final Users u2 = new Users("lucia23@yahoo.es","90747474B","654125456","$pq7Uy",Mfa.Correo);
    private static final Users u3 = new Users("ramongarcia@hotmail.com","98554567U","754678899","abraCadabrA", Mfa.App);
    private static final Users u4 = new Users("alo@yahoo.es","49887766F","981346243","puluLu$", Mfa.Correo);
    private static final LoginScreen screen = new LoginScreen("","",Estrategia.email);
    @BeforeAll
    static void anadir(){
        screen.anadirUsuario(u1);
        screen.anadirUsuario(u2);
        screen.anadirUsuario(u3);
        screen.anadirUsuario(u4);
    }
    @Test
    void setMfaTest(){
        u1.setMfaFav(Mfa.App);
    }
    @Test
    void idTest(){
        screen.setLoginStrategy(Estrategia.email);
        screen.setUserIdentifier("pepe@g.com");
        assertTrue(screen.checkID());
        screen.setUserIdentifier("tata89");
        assertFalse(screen.checkID());
        screen.setLoginStrategy(Estrategia.DNI);
        screen.setUserIdentifier("46747474B");
        assertTrue(screen.checkID());
        screen.setUserIdentifier("467474742");
        assertFalse(screen.checkID());
        screen.setLoginStrategy(Estrategia.tlfno);
        screen.setUserIdentifier("653123455");
        assertTrue(screen.checkID());
        screen.setUserIdentifier("6531234552");
        assertFalse(screen.checkID());
    }
    @Test
    void passwordTest(){
        screen.setLoginStrategy(Estrategia.email);
        screen.setUserIdentifier("pepe@gmail.com");
        screen.setPassword("holahola23");
        assertTrue(screen.checkPass());
        screen.setPassword("holahola2324");
        assertFalse(screen.checkPass());
        screen.setLoginStrategy(Estrategia.DNI);
        screen.setUserIdentifier("90747474B");
        screen.setPassword("$pq7Uy");
        assertTrue(screen.checkPass());
        screen.setUserIdentifier("90747474B");
        screen.setPassword("$Pq7Uy");
        assertFalse(screen.checkPass());
        screen.setLoginStrategy(Estrategia.tlfno);
        screen.setUserIdentifier("981346243");
        screen.setPassword("puluLu$");
        assertTrue(screen.checkPass());
    }
    @Test
    void genTest1(){
        screen.setLoginStrategy(Estrategia.email);
        screen.setUserIdentifier("pepe@gmail.com");
        screen.setPassword("holahola23");
        assertTrue(Integer.parseInt(screen.generate())>=100000 && Integer.parseInt(screen.generate())<=1000000);
    }

    @Test
    void genTest2(){
        screen.setLoginStrategy(Estrategia.DNI);
        screen.setUserIdentifier("90747474B");
        screen.setPassword("$pq7Uy");
        assertTrue(screen.generate().length()==4 && screen.generate().matches("[A-Z]+"));
    }

    @Test
    void genTest3(){
        screen.setLoginStrategy(Estrategia.tlfno);
        screen.setUserIdentifier("754678899");
        screen.setPassword("abraCadabrA");
        assertTrue(screen.generate().length()==5 && screen.generate().matches("[A-Z0-9]+"));
    }
}
