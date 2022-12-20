package e2;

import java.util.ArrayList;
import java.util.List;

public class Tanque{
    List<Sensor> listaSensores = new ArrayList<>();
    public void addSensor(Sensor sensor){
        listaSensores.add(sensor);
    }
    private final String nombre;
    private final String ubicacion;
    public Tanque(String nombre,String ubicacion){
        this.nombre=nombre;
        this.ubicacion=ubicacion;
    }
    public String getNombre(){
        return nombre;
    }
    public String getUbicacion(){
        return ubicacion;
    }
}
