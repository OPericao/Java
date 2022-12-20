package e2;
import java.util.*;

public class Rebote implements Iterator<String> {
   int indice=0;
   boolean borde=false;
   ArrayList<String> lista;

   Rebote(ArrayList<String> lista) {
      this.lista = lista;
   }

   @Override
   public boolean hasNext() {
      return (lista.size())!=1;
   }

   @Override
   public String next() {
      if(lista.size()>2){
         if(indice>=((lista.size())-1)){
            borde=true;
         }else if (indice==0){
            borde=false;
         }
         if(borde){
            return lista.get(indice--);
         }else return lista.get(indice++);
      }else if(indice==lista.size()) {
         indice--;
      }if(indice==0){
         return lista.get(++indice);
      }else return lista.get(--indice);
   }

   @Override
   public void remove(){
      lista.remove(indice);
      if(indice>lista.size()-1){
         indice=lista.size()-1;
      }
      if(borde && indice>0){
            indice--;
      }
   }
}
