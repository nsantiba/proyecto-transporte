package actores;

import entidades.Localizacion;
import entidades.Recarga;
import entidades.Sistema;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import metodos_pago.CuentaBancaria;
import vehiculos.Vehiculo;

/**
 * @author Devin Gaibor
 * Clase que representa al usuario que realiza las recargas de la batería de los transporte.
 */
public class Charger extends Usuario
{
     private String licencia;
     private CuentaBancaria cuentaBancaria; 
     private ArrayList<Recarga> recargas; 
     
    
    
    public Charger ( String licencia, String identificacion, String nombre, String direccion, String correo, String usuario, String contrasenia, CuentaBancaria cuentaBancaria ){
    
        super ( identificacion, nombre, direccion, correo, usuario, contrasenia );
        this.licencia = licencia;
        this.cuentaBancaria= cuentaBancaria; 
        recargas= new ArrayList<>(); 
    }

    public Charger ( ) { }
        
    /**
     * @author Eddy Santibañez J
     * @param localizacion la ubicacion del usuario
     * @param rango el rango e distancia en el que se busca
     * @param sistema el objeto sistema que contiene la informacion de todos los vehiculos
     * este método imprime por pantalla los transportes que se  encuentren cerca de la localización pasada como parámetro
     * en el rango indicado
     */
    @Override
    public void encontrarTransportesCercanos ( Localizacion localizacion, double rango,  Sistema sistema )
    {
        ArrayList < Vehiculo > Vehiculos_seleccionados = new ArrayList < > ( );
        ArrayList < Double> km_distancia = new ArrayList < > ( );
        for ( Vehiculo vehiculo: sistema.getVehiculos ( ) ){
            //aqui el rango si pone 1 seria 1000??*****
            double distancia = sistema.calcularDistancia ( localizacion, vehiculo.getUbicacion() );
            if ( distancia <= rango && vehiculo.getBateria() <= 20 && vehiculo.getDisponible()==true ){
                Vehiculos_seleccionados.add(vehiculo);
                km_distancia.add(distancia); }
        }
        
        ArrayList<Double> listaCopiada = (ArrayList<Double>) km_distancia.clone();
        Collections.sort(listaCopiada);
        for (int i=0; i< Vehiculos_seleccionados.size(); i++){
           double distancia=  listaCopiada.get(i); 
           int indice= km_distancia.indexOf(distancia);
           System.out.println(Vehiculos_seleccionados.get(indice));
            //asuminedo que las distancias no son iguales ***
        }
       
    }

    public String getLicencia ( )
    {
        return licencia;
    }

    public void setLicencia ( String licencia )
    {
        this.licencia = licencia;
    }
    
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria){
        this.cuentaBancaria= cuentaBancaria; 
    }
    
    public CuentaBancaria getCuentaBancaria(){
        return cuentaBancaria; 
    }
    public ArrayList<Recarga> getRecargas(){
        return recargas; 
    }
    
    public void verReporte(LocalDate inicio, LocalDate fin){
        double total=0;
        for (Recarga r: recargas){
           
            if( r.getFecha().isAfter(inicio) && r.getFecha().isBefore(fin) ){
                System.out.println(r);
                total= total+r.getValor(); 
            }
         
        }
        System.out.println("El valor total de las recargas es de "+total);
    }
    
    
}
