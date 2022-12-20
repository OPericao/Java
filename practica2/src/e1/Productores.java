package e1;

public class Productores extends EquipoTecnico{
    public Productores(String nombre,String apellido,String nacionalidad,String DNI,String telefono,int horasTrabajadas){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
        sueldoHora=90;
    }
    public int getSalary(){
        return horasTrabajadas*sueldoHora;
    }
    public int getRoyalties(int recaudacion){
        return ((recaudacion/100)*2);
    }
    public String getDatos(){
        return (nombre+" "+apellido+" (Producer): "+getSalary()+ " euro");
    }

    public String getDatos2(int recaudacion){
        return (nombre+" "+apellido+" (Producer): "+getRoyalties(recaudacion)+ " euro");
    }
}
