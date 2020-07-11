package vehiculos;

import entidades.Localizacion;

/**
 * @author Devin Gaibor
 * Clase que representa un tipo de vehiculo del sistema de transporte, el cual puede desplazarse gracias a la fuerza de su motor eléctrico
 * o mediante un impulso obtenido gracias al pedaleo del usuario.
 */
public class Bicicleta extends Vehiculo
{
   
    
    public Bicicleta ( double bateria, String codigo, boolean disponible,Localizacion ubicacion )
    {
       super(bateria, codigo, disponible, ubicacion);
    }
   
   

    
    @Override
     public String toString()
    {    
        return "Bicicleta " +getCodigo()+" " + getUbicacion().getDireccion() ;// no se si vehiculo.class esta bien 
    }
    @Override
     public double calcularBateriaUtilizada(double distancia){
        double valor= (distancia*10)/1000;
        //se divide para 1000 para que sea en 1km??
        return valor ; 
     }
}
