package e1;

public class Directores extends EquipoTecnico{
    int anos;
    public Directores(String nombre,String apellido,String nacionalidad,String DNI,String telefono,int horasTrabajadas,int anos){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
        this.anos=anos;
        sueldoHora=100;
    }
    public int getSalary(){
        return (horasTrabajadas*sueldoHora)+(anos*1000);
    }
    public int getRoyalties(int recaudacion){
        return ((recaudacion/100)*5);
    }
    public String getDatos(){
        return (nombre+" "+apellido+" (Director, "+anos+" years of experience): "+getSalary()+ " euro");
    }

    public String getDatos2(int recaudacion){
        return (nombre+" "+apellido+" (Director): "+getRoyalties(recaudacion)+ " euro");
    }
}
