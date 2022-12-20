package e2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PrincipalTest {
    private static final TVRealityList listaa = new TVRealityList();
    private static final TVRealityList listab = new TVRealityList();
    private static final Principal ejem = new Principal();

    @BeforeAll
    static void insertar(){
        listaa.setRecorrido(Recorridos.circular);
        listaa.insertarCandidato("Pepe");
        listaa.insertarCandidato("Juan");
        listaa.insertarCandidato("Maria");
        listaa.insertarCandidato("Ramon");
        listaa.insertarCandidato("Lucia");
        listab.setRecorrido(Recorridos.rebote);
        listab.insertarCandidato("Juan");
        listab.insertarCandidato("Pepe");
        listab.insertarCandidato("Maria");
        listab.insertarCandidato("Lucia");
        listab.insertarCandidato("Ramon");
        listab.insertarCandidato("Roberto");
        listab.insertarCandidato("Cayetana");
        listab.insertarCandidato("Carmen");


    }

    @Test
    void selectWinner(){
        assertEquals(ejem.selectCandidates(listaa,2),"Maria");
        assertEquals(ejem.selectCandidates(listab,3),"Carmen");
    }
}
