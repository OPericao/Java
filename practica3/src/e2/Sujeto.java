package e2;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {
    private List<Observador> sensores = new ArrayList<>();
    public void anadirObservador(Observador sensor){
        sensores.add(sensor);
    }
    public void quitarObservador(Observador sensor){
        sensores.remove(sensor);
    }
    public void notificarObservadores(){
        for(Observador o : sensores){
            o.update(this);
        }
    }
}
