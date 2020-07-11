package entidades;

import actores.Rider;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import metodos_pago.Tarjeta;
import vehiculos.Vehiculo;

/**
 * @author Devin Gaibor
 * Clase que representa el prestamo realizado por el rider.
 */
public class Prestamo
{
    private Vehiculo  vehiculo;
    private Tarjeta tarjeta;
    private Rider rider;
    
    private LocalDate fecha;
    private LocalTime inicio; 
    private double duracion; 
    private LocalTime fin; 
    private double km_recorridos;
    private double pago;
    private boolean activo;
    
    public Prestamo(Vehiculo  vehiculo, Rider rider, LocalTime inicio,LocalDate fecha ){
        activo= true; 
        this.vehiculo= vehiculo;
        this.rider= rider; 
        this.inicio= inicio; 
        this.fecha= fecha; 
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    public boolean getActivo()
    {
        return activo;
    }
    
    public void setActivo ( boolean activo )
    {
        this.activo = activo;
    }
    
    public double calcularDuracion(){
        int tiempo= (int)inicio.until(fin, MINUTES);
        return tiempo;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
    
    public double getKm_recorridos()
    {
        return km_recorridos;
    }
    
    public void setKm_recorridos ( double km_recorridos )
    {
        this.km_recorridos = km_recorridos;
    }
    
    public double getPago ( )
    {
        return pago;
    }
    
    public void setPago ( double pago )
    {
        this.pago = pago;
    }
    
   

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }
    public void finalizar(){
        activo= false; 
  
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return  "fecha= " + fecha + ", duracion= " + duracion + ", km Recorridos= " + km_recorridos + ", Valor=" + pago ;
    }
   
}
