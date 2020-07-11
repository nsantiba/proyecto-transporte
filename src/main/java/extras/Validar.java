package extras;

/**
 * @author Devin Gaibor
 * Clase abstracta con métodos útiles para la implementación del código, que abarca desde validadores hasta precarga de datos.
 */
public abstract class Validar
{
    /**
     * @author Devin Gaibor
     * @param numero_opciones numero de opciones que se validaran 
     * @param opcion la opcion escogida por el ususario
     * @return boolean retorna verdadero si la opcion es valida
     * 
     * Método que recibe como parámetros el número de opciones totales de un menú y la opción ingresada por el usuario,
     * para validar que dicha opción se encuentre dentro del rango establecido; retorna un booleano que representa la validez del análisis.
     */
    public static boolean rango ( int numero_opciones, int opcion )
    {
        return ( opcion >= 1 && opcion <= numero_opciones );
    }
}