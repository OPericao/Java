package e1;

public abstract class EquipoHumano {
        String nombre;
        String apellido;
        String nacionalidad;
        String DNI;
        String telefono;
        int horasTrabajadas;
        int sueldoHora;
        public EquipoHumano(String nombre, String apellido, String nacionalidad, String DNI, String telefono, int horasTrabajadas){
                this.nombre = nombre;
                this.apellido = apellido;
                this.nacionalidad = nacionalidad;
                this.DNI = DNI;
                this.telefono = telefono;
                this.horasTrabajadas = horasTrabajadas;
        }
        public abstract int getSalary();
        public abstract String getDatos();

        public abstract int getRoyalties(int recaudacion);
        public abstract String getDatos2(int recaudacion);

}
