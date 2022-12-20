package e2;

import java.util.Iterator;

public class Principal {
    public String selectCandidates(TVRealityList lista, int salto){
        Iterator<String> itr = lista.iterator();
        int contador = 1;
        while(itr.hasNext()&&salto>1){
            itr.next();
            contador++;
            if(contador==salto){
                itr.remove();
                contador=1;
            }
        }
        if(salto==1){
            return lista.candidatos.get(lista.candidatos.size()-1);
        }else return lista.candidatos.get(0);
    }
}
