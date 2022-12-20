package e1;
enum Rol {protagonist,secondary,extra}
public class Interpretes extends EquipoArtistico{
    Rol rol;
    public Interpretes(String nombre,String apellido,String nacionalidad,String DNI,String telefono,int horasTrabajadas,Rol rol){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
        this.rol=rol;
        sueldoHora=200;
    }
    public int getSalary(){
        if (rol.compareTo(Rol.protagonist)==0) return (horasTrabajadas*sueldoHora*3);
        else return (horasTrabajadas*sueldoHora);
    }
    public String getDatos(){return (nombre+" "+apellido+" (Actor "+rol.toString()+"): "+getSalary()+ " euro");
    }
}
