package actores;

import entidades.Localizacion;
import entidades.Prestamo;
import entidades.Recarga;
import entidades.Sistema;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import vehiculos.Vehiculo;
import metodos_pago.Tarjeta;

/**
 * @author Devin Gaibor
 * Clase que representa al usuario que realiza el préstamo de los transportes.
 */
public class Rider extends Usuario
{
    private ArrayList<Tarjeta> tarjetas= new ArrayList<>(); 
    private boolean prestando; 
    private ArrayList<Prestamo> prestamos = new ArrayList<>(); 


    public Rider ( ) { }
    
    /**
     * @author Eddy Santibañez J
     * @param localizacion
     * @param rango
     * @param sistema 
     */
    @Override
    public void encontrarTransportesCercanos ( Localizacion localizacion,double rango, Sistema sistema )
    {
       ArrayList < Vehiculo > Vehiculos_seleccionados = new ArrayList < > ( );
        ArrayList < Double> km_distancia = new ArrayList < > ( );
        for ( Vehiculo vehiculo: sistema.getVehiculos ( ) ){
            //aqui el rango si pone 1 seria 1000??*****
            double distancia = sistema.calcularDistancia ( localizacion, vehiculo.getUbicacion() );
            if ( distancia <= rango && vehiculo.getBateria() >= 20 && vehiculo.getDisponible()){
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
    
    public Rider ( Tarjeta tarjeta, String identificacion, String nombre, String direccion, String correo, String usuario, String contrasenia )
    {
      
        super ( identificacion, nombre, direccion, correo, usuario, contrasenia );
        
        prestando= false; 
        tarjetas.add(tarjeta);
        
    }
    
    public ArrayList<Tarjeta> getTarjetas ( )
    {
        return tarjetas;
    }
    public ArrayList<Prestamo> getPrestamos ( )
    {
        return prestamos;
    }
       public boolean getPrestando ( )
    {
        return prestando;
    }
       public void setPrestando (boolean prestando )
    {
        this.prestando= prestando;
    }

    public void setTarjeta ( Tarjeta tarjeta )
    {
        tarjetas.add(tarjeta);
    }     
    public Prestamo encontrarPrestamo(){
        for(Prestamo p: prestamos){
            if(p.getActivo()==true){
                return p;
            }
        }
        return null;
        
    }
    @Override
   public void verReporte(LocalDate inicio, LocalDate fin){
        double total=0;
        for (Prestamo p: prestamos){
           
            if( p.getFecha().isAfter(inicio) && p.getFecha().isBefore(fin) ){
                System.out.println(p);
                
            }
         
        }
    }
    
}

