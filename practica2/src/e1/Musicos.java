package e1;

public class Musicos extends EquipoTecnico{
    public Musicos(String nombre,String apellido,String nacionalidad,String DNI,String telefono,int horasTrabajadas){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
        sueldoHora=60;
    }
    public int getSalary(){
        return horasTrabajadas*sueldoHora;
    }
    public int getRoyalties(int recaudacion){
        return ((recaudacion/100)*4);
    }
    public String getDatos(){
        return (nombre+" "+apellido+" (Musician): "+getSalary()+ " euro");
    }

    public String getDatos2(int recaudacion){
        return (nombre+" "+apellido+" (Musician): "+getRoyalties(recaudacion)+ " euro");
    }

}
