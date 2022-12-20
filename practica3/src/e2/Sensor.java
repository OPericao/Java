package e2;

public class Sensor extends Sujeto{
    private final String parametro;
    private int valor;
    private final Tanque tanque;

    public Sensor(String parametro,int valor,Tanque tanque){
        this.parametro=parametro;
        this.valor=valor;
        this.tanque=tanque;
        tanque.addSensor(this);
    }
    public String getParametro(){
        return parametro;
    }
    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor=valor;
        notificarObservadores();
    }
    public Tanque getTanque(){
        return tanque;
    }
}