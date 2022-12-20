package e1;


import java.util.ArrayList;



public class Pelicula {
    String titulo;
    int recaudacion;
    ArrayList<EquipoHumano> trabajadores = new ArrayList<>();

    public Pelicula(String titulo, int recaudacion) {
        this.titulo=titulo;
        this.recaudacion=recaudacion;
    }

    public void insertarTrabajador(EquipoHumano trabajador){
        trabajadores.add(trabajador);
    }

    public String printSalaries(){
        String texto = "";
        int suma=0;
        for(EquipoHumano trabajador:trabajadores) {
            texto = texto + trabajador.getDatos()+"\n";
            suma = suma + trabajador.getSalary();
        }
        texto = texto + "The total payroll for " + titulo + " is " + suma + " euro";
        return texto;
    }

    public String printRoyalties() {
        String texto = "";
        String textoAux;
        for (EquipoHumano trabajador:trabajadores) {
           textoAux = (trabajador.getDatos2(recaudacion));
           texto = texto + trabajador.getDatos2(recaudacion);

           if(!textoAux.equals("")) {
               texto = texto +"\n";
           }
        }
        return texto;
    }
}
