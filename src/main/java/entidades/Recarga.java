package entidades;

import actores.Charger;
import java.time.LocalDate;
import vehiculos.Vehiculo;

/**
 *
 * @author Eddy Santibañez J
 * Esta clase permite definir la informacion que se guardara cada que se realice una recarga
 */
public class Recarga
{
    private LocalDate fecha;
    private double valor;
    private Vehiculo vehiculo; 
    private Charger charger; 
    
    public Recarga ( LocalDate fecha, double valor, Vehiculo vehiculo, Charger charger )
    {
        this.fecha = fecha; 
        this.valor = valor; 
        this.vehiculo = vehiculo; 
        this.charger = charger;
    }
    
    public LocalDate getFecha ( )
    {
        return fecha;
    }
    
    public double getValor ( )
    {
        return valor; 
    }
    
    public Vehiculo getVehiculo ( )
    {
        return vehiculo; 
    }
    
    public Charger getCharger ( )
    {
        return charger; 
    }
    
    public void setFecha ( LocalDate fecha )
    {
        this.fecha = fecha; 
    }
    
    public void setValor ( double valor )
    {
        this.valor = valor; 
    }
    
    public void setVehivulo ( Vehiculo vehiculo)
    {
        this.vehiculo = vehiculo; 
    }
    
    public void setCharger ( Charger charger )
    {
        this.charger = charger; 
    }
    
    @Override
    public String toString(){
        return "Fecha: "+fecha+" Codigo Vehiculo: " +vehiculo.getCodigo()+" Valor: "+valor;        
    }
}
