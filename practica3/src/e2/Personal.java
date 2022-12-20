package e2;

import java.util.*;

public class Personal implements Observador {
    private final String nombre;
    List<String> informesRoja = new ArrayList<>();
    List<String> informesNaranja = new ArrayList<>();

    public Personal(String nombre) {
        this.nombre = nombre;
    }
    public void update(Sujeto s){
        Alerta alertaAux = (Alerta) s;
        if(alertaAux.getEstado()==EstadoAlerta.NARANJA){
            informesNaranja.add(alertaAux.generarInforme());
        }else if(alertaAux.getEstado()==EstadoAlerta.ROJA){
            informesRoja.add(alertaAux.generarInforme());
        }
    }
    public String alertasPendientes() {
        StringBuilder pendientes = new StringBuilder();
        pendientes.append("---Alertas ").append(nombre).append("---\n");
        if(!informesRoja.isEmpty()) {
            pendientes.append("\nAlertas rojas:\n");
            for (String informe : informesRoja) {
                pendientes.append(informe);
            }
        }
        if(!informesNaranja.isEmpty()) {
            pendientes.append("\nAlertas naranjas:\n");
            for (String informe : informesNaranja) {
                pendientes.append(informe);
            }
        }
        return pendientes.toString();
    }
}
