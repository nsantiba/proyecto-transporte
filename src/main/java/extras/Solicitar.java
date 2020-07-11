package extras;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import entidades.Localizacion;
import java.util.Scanner;

/**
 * @author Devin Gaibor
 * Clase que contien varios métodos útiles para agilizar el proceso de solicitud de información al usuario.
 */
public abstract class Solicitar
{
    /**
     * @author Devin Gaibor
     * @param referencia String donde se especifica lo que se solicita
     * @return String
     * Método que recibe como parámetro la referencia o nombre de lo que se desea solicitar y retorna una cadena con la respuesta del usuario.
     */
    public static String datos ( String referencia )
    {
        Scanner sc = new Scanner ( System.in );
        System.out.print ( referencia + ": " );
        String respuesta = sc.nextLine( );
        return respuesta;
    }
    
    /**
     * @author Devin Gaibor
     * @param numero_opciones
     * @param referencia
     * @return int
     * Método que recibe como parámetros el número de opciones del menú y la referencia de lo solicitado; este método se utiliza para solicitar
     * al usuario que escoja una opción válida en todo sentido; retorna la opción ingresada.
     */
    public static int opcion ( int numero_opciones, String referencia )
    {
        int opcion;
        
        while ( true )
        {
            try
            {
                opcion =  Integer.parseInt ( datos ( referencia ) );
                if ( Validar.rango ( numero_opciones, opcion ) )
                    break;
                else
                    System.out.println ( "Error, el número ingresado está fuera de rango, por favor ingrese un número dentro del rango (1 - " + numero_opciones + " )." );
            }catch ( Exception e )
            {
                System.out.println ( "***************Error Ingreso Inválido***************" );
                System.out.println ( "Ingrese un número válido para continuar, no use caractéres especiales ni letras." );
            }
        }
        
        return opcion; 
    }
    
    public static Localizacion  ubicacion (  )
    {
        String key= "2c979437cb57461abacd9394637e78cc";
        String direccion=  datos("Ingrese ubicacion");
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder ( key );
        JOpenCageForwardRequest request = new JOpenCageForwardRequest ( direccion );
        request.setLanguage ( "es" ); 
        JOpenCageResponse response = jOpenCageGeocoder.forward ( request );
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();
        
        while(firstResultLatLng==null){
            System.out.println("La direccion ingresada no es válida");
            direccion=  datos("Ingrese ubicacion");
            jOpenCageGeocoder = new JOpenCageGeocoder ( key);
            request = new JOpenCageForwardRequest ( direccion );
            request.setLanguage ( "es" ); 
            request.setMinConfidence(3);
            response = jOpenCageGeocoder.forward ( request );
            firstResultLatLng = response.getFirstPosition();
        }
        double latitud = firstResultLatLng.getLat(); // convierto latitud en dobule 
        double longitud = firstResultLatLng.getLng(); // convierto longitud en double 
        return ( new Localizacion( latitud, longitud, direccion ) ); //Retorna una localizacion
    }    
    
    
    public static Localizacion  ubicacion ( String direccion )
    {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder ( "2c979437cb57461abacd9394637e78cc" );
        JOpenCageForwardRequest request = new JOpenCageForwardRequest ( direccion+", Guayaquil, Ecuador" );
        request.setLanguage ( "es" ); 
        request.setRestrictToCountryCode("ec");
        JOpenCageResponse response = jOpenCageGeocoder.forward ( request );
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();
        double latitud = firstResultLatLng.getLat(); // convierto latitud en dobule 
        double longitud = firstResultLatLng.getLng(); // convierto longitud en double 
        return ( new Localizacion( latitud, longitud, direccion ) ); //Retorna una localizacion
    }    
    
    
    
}
