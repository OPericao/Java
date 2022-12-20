package e1;

public class Especialistas extends EquipoArtistico{
    private final boolean peligro;
    public Especialistas(String nombre,String apellido,String nacionalidad,String DNI,String telefono,int horasTrabajadas,boolean peligro){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
        this.peligro=peligro;
        sueldoHora=40;
    }
    public int getSalary(){
        if(!peligro) return horasTrabajadas*sueldoHora;
        else return (horasTrabajadas*sueldoHora)+1000;
    }
    public String getDatos(){
        if(peligro){
            return (nombre+" "+apellido+" (Stunt performer with extra for danger): "+getSalary()+ " euro");
        }else return (nombre+" "+apellido+" (Stunt performer): "+getSalary()+ " euro");
    }

}
