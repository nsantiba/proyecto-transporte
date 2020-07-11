package entidades;

/**
 *
 * @author Eddy Santibañez J
 */
public class Localizacion
{
    private double latitud; 
    private double longitud; 
    private String direccion; 

    public Localizacion ( double latitud, double longitud, String direccion )
    {
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
    }

    public Localizacion ( )
    {
    }
    
    public double getLatitud ( )
    {
        return latitud;
    }

    public void setLatitud ( double latitud )
    {
        this.latitud = latitud;
    }

    public double getLongitud ( )
    {
        return longitud;
    }

    public void setLongitud ( double longitud )
    {
        this.longitud = longitud;
    }

    public String getDireccion ( )
    {
        return direccion;
    }

    public void setDireccion ( String direccion )
    {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return direccion;
    }
    
}
