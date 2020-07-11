package entidades;

import actores.Charger;
import actores.Usuario;
import java.time.LocalTime;
import java.util.ArrayList;
import vehiculos.Bicicleta;
import vehiculos.Scooter;
import vehiculos.Vehiculo;

/**
 *
 * @author Eddy Santibañez J7
 * Esta clase define al sistema y almacena los vehiculos, ususarios y centros de reparación 
 */
public  class Sistema
{
    
    ArrayList < Usuario > usuarios = new ArrayList < > ( ); 
    ArrayList < Vehiculo > vehiculos =  new ArrayList < > ( ); 
     
    public ArrayList < Usuario > getUsuarios()
    {
        return usuarios; 
    }
    
    public ArrayList < Vehiculo > getVehiculos()
    {
        return vehiculos;  
    }

    
    public void anadirUsuario ( Usuario u )
    {
       usuarios.add ( u ); 
    }
    
    /**
     * @author Eddy Santibañez J
     * @param localizacion1 ubicacion inicial
     * @param localizacion2 ubicacion final
     * en este método se calcula la distancia entre las 2 localizaciones ingresadas
     * @return double 
     */
    public double calcularDistancia ( Localizacion localizacion1, Localizacion localizacion2 )
    {
        final int R = 6378; 
        double deltaLat; 
        double deltalng;
        
        double latra1= Math.toRadians(localizacion1.getLatitud());
        double latra2= Math.toRadians(localizacion2.getLatitud());
        double longra1= Math.toRadians(localizacion1.getLongitud());
        double longra2= Math.toRadians(localizacion2.getLongitud());
        
        
       
        deltaLat= latra1-latra2;
        
        deltalng= longra1-longra2; 
        double parte1 =  Math.sin ( deltaLat / 2 )*  Math.sin ( deltaLat / 2 );
        double parte2= Math.cos(latra1)*Math.cos(latra2);
        double parte3= Math.sin(deltalng)*Math.sin(deltalng);
        double a = parte1 + (parte2*parte3); 
        
        double c = 2 * Math.atan2 ( Math.sqrt ( a ), Math.sqrt ( 1 -a) );
      
        return (R*c) ; 
        
   }
   
    /**
     * @author Eddy Santibañez J
     * @param id identificacion del vehiculo  (codigo) 
     * En este método se devuelve el vehiculo que posee el id ingresado
     * @return Vehiculo
     */
   public Vehiculo encontrarVehiculo ( String id )
   {
        for ( Vehiculo v: vehiculos )
        {
            if ( id.equals ( v.getCodigo() ) )
                return v;   
        }
        return null;
   }
   /***
    * 
    * @param nuevoNivelBateria
    * @param v2
    * En este método se calcula el dinero que recibira el charger segun el nuevo nivel de bateria del vehiculo
    * @return double 
    */
   public double CalcularValorPagar(double nuevoNivelBateria, Vehiculo v2){
       double valor= nuevoNivelBateria-v2.getBateria();
       return valor*0.15;  
   }
   /***
    * 
    * @param p prestamo del que se calculará el valor 
    * @param duracion tiempo total del prestamo 
    * Este método devuelve el valor que debe pagar un rider por usar un transporte.
    * Este valor depende de la distancia recorrida y del tiempo durante el que se utilizó el vehiculo. 
    * @return double 
    */
   public double CalcularValorCobrar(Prestamo p, double duracion){
       double total;  
       
       if (p.getVehiculo() instanceof Bicicleta){
            total= 0.2*duracion+1;  
            return total;
       }
       if (p.getVehiculo() instanceof Scooter){
            total= 0.15*duracion+1; 
            return total;
       }
        return 0;  
   }
 
 
}
