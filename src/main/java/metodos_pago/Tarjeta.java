package metodos_pago;

import extras.Solicitar;

/**
 * @author Devin Gaibor
 * Clase que representa el método de pago utilzado por el rider al momento de cancelar el préstamo del transporte.
 */
public class Tarjeta
{
    private String numero;
    private String banco;
    private String nombre_titular;
    
    /**
     * Método que solicita los datos necesarios para rellenar la información de la tarjeta.
     */
    public Tarjeta(String numero, String banco, String nombre_titular){
        this.numero= numero;
        this.banco= banco; 
        this.nombre_titular= nombre_titular; 
        
    }
     public Tarjeta(){
     } 
                
    public void solicitarDatos ( )
    {
        System.out.println("Datos de Tarjeta");
        numero = Solicitar.datos ( "Número" );
        banco = Solicitar.datos ( "Banco" );
        nombre_titular = Solicitar.datos ( "Nombre del Titular" );
    }

    public String getNumero ( )
    {
        return numero;
    }

    public void setNumero ( String numero )
    {
        this.numero = numero;
    }

    public String getBanco ( )
    {
        return banco;
    }

    public void setBanco ( String banco )
    {
        this.banco = banco;
    }

    public String getNombre_titular ( )
    {
        return nombre_titular;
    }

    public void setNombre_titular ( String nombre_titular )
    {
        this.nombre_titular = nombre_titular;
    }

    @Override
    public String toString() {
        return  "Numero=" + numero + ", Banco=" + banco + ", Nombre Titular=" + nombre_titular ;
    }
    
}
