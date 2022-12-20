package e2;

public class Actuador implements Observador{
    private final String nombre;

    public Actuador(String nombre) {
        this.nombre = nombre;
    }
    public void update(Sujeto s){
        Alerta alertaAux = (Alerta) s;
        if(alertaAux.getEstado()!=EstadoAlerta.DESACTIVADA) {
            System.out.println(storeString((Alerta)s));
        }
    }
    public String storeString(Alerta alerta){
        return ("Actuador " + nombre + " notificado por \n" + alerta.getNombre() +
                " (Alerta " + alerta.getEstado() + ")\n");
    }
}
