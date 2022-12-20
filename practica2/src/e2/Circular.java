package e2;

import java.util.ArrayList;
import java.util.Iterator;

public class Circular implements Iterator<String> {
    int indice=0;
    ArrayList<String> lista;

    Circular(ArrayList<String> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return (lista.size())!=1;
    }

    @Override
    public String next() {
        if(lista.size()>2){
            if(indice>=((lista.size())-1)) {
                indice=0;
                return lista.get(indice);
            }else return lista.get(indice++); //deberia ser else return, comprobar
        }else if(indice==lista.size()) {
            indice--;
        }if(indice==0){
                return lista.get(++indice);
        }else return lista.get(--indice);
    }

    @Override
    public void remove(){
        if(indice>=lista.size()-1){
            indice=0;
            lista.remove(lista.size()-1);
        }else lista.remove(indice);
    }
}
