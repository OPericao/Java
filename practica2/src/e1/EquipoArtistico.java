package e1;

public abstract class EquipoArtistico extends EquipoHumano{
    public EquipoArtistico(String nombre, String apellido, String nacionalidad, String DNI, String telefono, int horasTrabajadas){
        super(nombre,apellido,nacionalidad,DNI,telefono,horasTrabajadas);
    }
    public abstract int getSalary();
    public abstract String getDatos();
    public int getRoyalties(int recaudacion){
        return 0;
    }
    public String getDatos2(int recaudacion){
        return "";
    }
}
