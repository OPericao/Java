package e2;

import java.util.ArrayList;
import java.util.Iterator;

enum Recorridos {rebote,circular}
public class TVRealityList implements Iterable<String> {

    Recorridos recorrido;
    ArrayList<String> candidatos = new ArrayList<>();

    public void setRecorrido(Recorridos recorrido){
        this.recorrido=recorrido;
    }
    @Override
    public Iterator<String> iterator(){
        if(recorrido.compareTo(Recorridos.circular)==0){
            return new Circular(candidatos);
        }else return new Rebote(candidatos);
    }
    public void insertarCandidato(String nombre){
        candidatos.add(nombre);
    }
}
