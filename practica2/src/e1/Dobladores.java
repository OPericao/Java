package e1;

public class Dobladores extends EquipoArtistico{
    public Dobladores(String nombre,String apellido,String nacionalidad,String DNI,String telefono,int horasTrabajadas){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
        sueldoHora=20;
    }
    public int getSalary(){
        return horasTrabajadas*sueldoHora;
    }
    public String getDatos(){
        return (nombre+" "+apellido+" (Dubber): "+getSalary()+ " euro");
    }
}
