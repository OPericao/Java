package e2;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

enum EstadoAlerta {DESACTIVADA,NARANJA,ROJA}

public class Alerta extends Sujeto implements Observador {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    private final String nombre;
    private EstadoAlerta estado;
    private final int minNaranja;
    private final int min;
    private final int max;
    private final int maxNaranja;
    private String parametroSensor;
    private int valorSensor;
    private Tanque tanque_aux;

    public Alerta(String nombre, int minNaranja, int min, int max, int maxNaranja) {
        this.nombre = nombre;
        this.minNaranja = minNaranja;
        this.min = min;
        this.max = max;
        this.maxNaranja = maxNaranja;
        estado = EstadoAlerta.DESACTIVADA;
    }

    public EstadoAlerta getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void update(Sujeto s) {
        Sensor sensor = (Sensor) s;
        parametroSensor = sensor.getParametro();
        valorSensor = sensor.getValor();
        tanque_aux = sensor.getTanque();
        now = LocalDateTime.now();
        if (sensor.getValor() < minNaranja || sensor.getValor() > maxNaranja) {
            if (estado != EstadoAlerta.ROJA) {
                estado = EstadoAlerta.ROJA;
                notificarObservadores();
            }
        } else if (sensor.getValor() < min || sensor.getValor() > max) {
            if (estado != EstadoAlerta.NARANJA) {
                estado = EstadoAlerta.NARANJA;
                notificarObservadores();
            }
        }
    }

    public String generarInforme() {
        return ("Alerta " + estado + ":\n" + tanque_aux.getNombre() + ", " + tanque_aux.getUbicacion() + "\n" + nombre + ": parametro " +
                parametroSensor + ", nivel " + valorSensor + "\n" + dtf.format(now) + "\n");
    }

}
