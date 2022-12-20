package e2;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TanqueTest {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");

    static private final Tanque t1 = new Tanque("Focas","Exterior");
    static private final Sensor s1 = new Sensor("oxigeno",65,t1);
    @Test
    void pruebaAlertasPersonal(){
        LocalDateTime now = LocalDateTime.now();    //Este tiempo no es exactamente el mismo que el que guarda la alerta,
                                                    //por lo que puede fallar en algunas ocasiones
        Alerta alerta1 = new Alerta("Control Principal Focas",10,50,120,200);
        Alerta alerta2 = new Alerta("Control Secundario Focas",20,50,100,130);
        Personal personal1 = new Personal("Jose Luis");
        s1.anadirObservador(alerta1);
        s1.anadirObservador(alerta2);
        alerta1.anadirObservador(personal1);
        alerta2.anadirObservador(personal1);
        s1.setValor(110);
        s1.setValor(140);
        s1.setValor(220);
        assertEquals(personal1.alertasPendientes(), String.format("---Alertas Jose Luis---\n" +
                        "\n" +
                        "Alertas rojas:\n" +
                        "Alerta ROJA:\n" +
                        "Focas, Exterior\n" +
                        "Control Secundario Focas: parametro oxigeno, nivel 140\n" +
                        dtf.format(now) + "\n" +
                        "Alerta ROJA:\n" +
                        "Focas, Exterior\n" +
                        "Control Principal Focas: parametro oxigeno, nivel 220\n" +
                        dtf.format(now) + "\n" +
                        "\n" +
                        "Alertas naranjas:\n" +
                        "Alerta NARANJA:\n" +
                        "Focas, Exterior\n" +
                        "Control Secundario Focas: parametro oxigeno, nivel 110\n" +
                        dtf.format(now) + "\n" +
                        "Alerta NARANJA:\n" +
                        "Focas, Exterior\n" +
                        "Control Principal Focas: parametro oxigeno, nivel 140\n" +
                        dtf.format(now) + "\n"));
        System.out.println(personal1.alertasPendientes());
    }
    @Test
    void pruebaAlertasActuador(){
        Alerta alerta1 = new Alerta("Control Principal Focas",10,50,120,200);
        Alerta alerta2 = new Alerta("Control Secundario Focas",20,50,100,130);
        Actuador actuador1 = new Actuador("Instantaneo");
        s1.anadirObservador(alerta1);
        s1.anadirObservador(alerta2);
        alerta1.anadirObservador(actuador1);
        alerta2.anadirObservador(actuador1);
        s1.setValor(110);
        assertEquals(actuador1.storeString(alerta2), """
                Actuador Instantaneo notificado por\s
                Control Secundario Focas (Alerta NARANJA)
                """);
        s1.setValor(140);
        assertEquals(actuador1.storeString(alerta1), """
                Actuador Instantaneo notificado por\s
                Control Principal Focas (Alerta NARANJA)
                """);
        s1.setValor(220);
        assertEquals(actuador1.storeString(alerta2), """
                Actuador Instantaneo notificado por\s
                Control Secundario Focas (Alerta ROJA)
                """);
        assertEquals(actuador1.storeString(alerta1), """
                Actuador Instantaneo notificado por\s
                Control Principal Focas (Alerta ROJA)
                """);

    }
}
