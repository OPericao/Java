package e1;

public abstract class EquipoTecnico extends EquipoHumano{
    public EquipoTecnico(String nombre, String apellido, String nacionalidad, String DNI, String telefono, int horasTrabajadas){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
    }
    public abstract int getSalary();
    public abstract String getDatos();
    public abstract int getRoyalties(int recaudacion);
    public abstract String getDatos2(int recaudacion);
}
