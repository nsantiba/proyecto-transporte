package vehiculos;

import entidades.Localizacion;

/**
 *
 * @author Eddy Santibañez J
 */
public class Scooter extends Vehiculo{    
    public Scooter ( double bateria, String codigo, boolean disponible, Localizacion ubicacion )
    {
        super(bateria, codigo, disponible, ubicacion);
    }
    
    @Override
    public String toString()
    {    
        return "Scooter " +getCodigo()+" " + getUbicacion().getDireccion() ;// no se si vehiculo.class esta bien 
    }
    
    @Override
    public  double calcularBateriaUtilizada(double distancia){
        return (distancia*7)/1000;
        //se divide par mil?? para que sea en 1 km ?
        
    }
    
}
