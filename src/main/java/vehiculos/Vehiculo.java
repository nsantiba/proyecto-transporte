package vehiculos;

import entidades.Localizacion;

/**
 * @author Devin Gaibor
 * Superclase de la cual heredan todos los vehiculos pertenecientes al sistema de transportes. 
 */
public abstract class Vehiculo
{
    private double bateria;
    private String codigo;
    private boolean disponible;
    private Localizacion ubicacion;
    
 
    
   public Vehiculo ( double bateria, String codigo, boolean disponible, Localizacion ubicacion )
    {
        this.bateria = bateria; 
        this.codigo = codigo; 
        this.disponible = disponible; 
        this.ubicacion = ubicacion; 
    }


    public double getBateria ( )
    {
       return bateria; 
    }
  
    public String getCodigo()
    {
       return codigo;
    }
    
    public boolean getDisponible()
    {
        return disponible; 
    }
    
    // getter de ubicacion
    
    public void setBateria ( double bateria )
    {
        this.bateria = bateria; 
    }
    
    public void setCodigo ( String codigo )
    {
        this.codigo = codigo; 
    }
    
    public void setDisponible ( boolean disponible )
    {
        this.disponible = disponible; 
    }
    
    public void setUbicacion ( Localizacion ubicacion )
    {
        this.ubicacion = ubicacion; 
    }
       
    public Localizacion getUbicacion()
    {
        return ubicacion; 
    }

    /**
     * author
     * @return 
     */
    @Override
    public String toString()
    {    
        return codigo+" " + ubicacion.getDireccion() ;// no se si vehiculo.class esta bien 
    }
    
    /**
     * author
     * @param obj
     * Este método compara 2 objetos si si son de la clase vehiculo devuelve si son iguales o no 
     * @return boolean
     */
    @Override
    public boolean equals ( Object obj )
    {
        if ( ( obj != null ) && ( obj instanceof Vehiculo ) )
        {
            Vehiculo v = ( Vehiculo ) obj;  
            return ( v.getCodigo().equals ( codigo ) );
        }
        return false;
    }
    
    public void Cargar ( )
    {
        disponible = false; 
    }
    public void finalizarCarga (Localizacion nuevalocaclizacion, Double nuevaBateria )
    {
        disponible = true; 
        ubicacion= nuevalocaclizacion;
        bateria= nuevaBateria; 
    }
    
    
    public void prestar(){
        disponible = false; 
    }
    public abstract double calcularBateriaUtilizada(double distancia);
    
}

