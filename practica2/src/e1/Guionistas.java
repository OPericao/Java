package e1;

public class Guionistas extends EquipoTecnico{
    boolean original;
    public Guionistas(String nombre,String apellido,String nacionalidad,String DNI,String telefono,int horasTrabajadas,boolean original){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
        this.original=original;
        sueldoHora=70;
    }
    public int getSalary(){
        if(!original) return horasTrabajadas*sueldoHora;
        else return (horasTrabajadas*sueldoHora)+4000;
    }
    public int getRoyalties(int recaudacion){
        return ((recaudacion/100)*5);
    }
    public String getDatos() {
        if (original) {
            return (nombre + " " + apellido + " (Screenwriter, original screenplay): " + getSalary()+ " euro");
        } else return (nombre + " " + apellido + " (Screenwriter): " + getSalary()+ " euro");
    }
    public String getDatos2(int recaudacion){
        return (nombre+" "+apellido+" (Screenwriter): "+getRoyalties(recaudacion)+ " euro");
    }
}
