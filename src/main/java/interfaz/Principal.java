/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import actores.Charger;
import actores.Rider;
import actores.Usuario;
import entidades.*;
import extras.Solicitar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import metodos_pago.CuentaBancaria;
import metodos_pago.Tarjeta;
import vehiculos.Bicicleta;
import vehiculos.Scooter;
import vehiculos.Vehiculo;



/**
 *
 * @author Eddy Santibañez J
 */
public class Principal {
      
       
      static String noValido= "Codigo ingresado no válido"; 
      static Sistema system= new Sistema(); 
      static String opci= "Opcion";
      static String op1= "Has seleccionado la opcion 1";
      static String op2= "Has seleccionado la opcion 2";
      static String op3= "Has seleccionado la opcion 3";
      static String op4= "Has seleccionado la opcion 4";
      static String op5= "Has seleccionado la opcion5";
      //Creo ciertos vehiculos para empezar

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        
        inicializarSistema(); 
        boolean salir_inicial=false; 
        while(!salir_inicial){
            menu();
            int opcion0 = Solicitar.opcion ( 3, opci );
            
             switch (opcion0) {
                    case 1:
                   
                        interfazgneral();

                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        Usuario u2 = registro(system);
                        system.anadirUsuario(u2);
                        break;
                    default :
                        System.out.println("Has salido del programa");
                        salir_inicial= true; 
                        break;


            } //cierre del swicht principal
        }//cierre del wihle inicial 
    }//cierre del main
    
    
     /***
      * 
      * @param system objeto sistema que contiene la informacion de todos los vehiculos, usuarios y centros de reparacion
      * @return Usuario que inicia sesion
      */
      public static Usuario iniciarSesion ( Sistema system ){
         System.out.println ( "**********Bienvenido al Menú de Login**********" );
         System.out.println ( "Ingrese sus credenciales para continuar" );
         String user = Solicitar.datos ( "Nombre de Usuario" );
         String contrasenia = Solicitar.datos ( "Contraseña" );
         
         
         boolean existe = false; 
         while (existe== false){
             for (Usuario u: system.getUsuarios()){
                  if(u!= null){
                     
                     if(u.getUsuario().equals(user) && u.getContrasenia().equals(contrasenia)){
                         
                     existe= true; 
                     return u; 
                    }
                     else{
                     existe= false; 
                    }
                 }
                 

             }
             System.out.println("No válido");
             System.out.println ( "Ingrese sus credenciales para continuar" );
             System.out.println("Posibles usuarios");
             for (Usuario u: system.getUsuarios()){
                 System.out.println(u.getUsuario()); 
             }
             user = Solicitar.datos ( "Nombre de Usuario" );
             contrasenia = Solicitar.datos ( "Contraseña" );
        
         }
          
        return null;
    }
    
    /**
     * @author Devin Gaibor
     * @param system objeto sistema que contiene la informacion de todos los vehiculos, usuarios y centros de reparacion
     * @return Usuario
     * Método que presenta el menú de registro en las modalidades de rider o charger según la preferencia del usuario, brindándole la posibilidad de crear un usuario
     * para posteriormente agregarlo al sistema; tenga en cuenta que retorna el usuario creado, no lo agrega al sistema.
     */
    public static Usuario registro (Sistema system )
    {
        System.out.println ( "**********Bienvenido al Menú de Registro**********" );
        System.out.println ( "Antes de continuar con el registro especifique el tipo de usuario que desea registrar: " );
        System.out.println ( "1) Rider");
        System.out.println ( "2) Charger");
        int opcion = Solicitar.opcion ( 2, "Tipo de Usuario" );
        System.out.println ( "Listo, ahora continuemos con el registro.\n" );
        
        Usuario usuario;
        
        String identificacion = Solicitar.datos ( "Identificación" );
        String user= Solicitar.datos("Usuario ");
        String nombre = Solicitar.datos ( "Nombre" );
        String direccion = Solicitar.datos ( "Dirección" );
        String correo = Solicitar.datos ( "Correo" );
        String contrasenia= Solicitar.datos(" Contraseña ");
        
        if ( opcion == 1 )
        {
            Rider rider = new Rider ( );
            rider.setIdentificacion ( identificacion );
            rider.setUsuario(user);
            rider.setNombre ( nombre );
            rider.setDireccion ( direccion );
            rider.setCorreo ( correo );
            rider.setContrasenia(contrasenia);
            
            Tarjeta tarjeta = new Tarjeta ( );
            tarjeta.solicitarDatos ( );////////////
            rider.setTarjeta ( tarjeta );
            usuario = rider;
            
        }
        
        else
        {
            Charger charger = new Charger ( );
            charger.setIdentificacion ( identificacion );
            charger.setUsuario(user);
            charger.setNombre ( nombre );
            charger.setDireccion ( direccion );
            charger.setCorreo ( correo );
            charger.setContrasenia(contrasenia);
            
            
            String licencia = Solicitar.datos ( "Licencia: " );
            charger.setLicencia ( licencia );
            
            String banco= Solicitar.datos("Nombre de Banco de la cuenta bancaria" );
            CuentaBancaria cb= new CuentaBancaria(banco); 
            charger.setCuentaBancaria(cb); 
            usuario = charger;
        }
        
        return usuario;
        
        
    }
    /***
     * @author Eddy Santibañez J
     * Metodo que permite inicializar el sistema creando ciertos vehiculos y usuarios
     */
    public static void inicializarSistema(){
        
       Scooter v1= new Scooter(10, "001", true, Solicitar.ubicacion("FIMCP, ESPOL"));
       Scooter v2= new Scooter(71.5, "002",true,Solicitar.ubicacion("EDCOM, ESPOL"));
       Bicicleta b1= new Bicicleta(70,"003", true, Solicitar.ubicacion("FCV, ESPOL"));
       Bicicleta b2= new Bicicleta(50,"004", true, Solicitar.ubicacion("Policentro, Guayaquil"));
       Bicicleta b3= new Bicicleta(5,"005", true, Solicitar.ubicacion("FIEC, ESPOL"));
       Scooter v3= new Scooter(11, "006", true, Solicitar.ubicacion("San Marino, Guayaquil"));
  

       Tarjeta t1= new Tarjeta("111111","Banco Pichicnha","Juan Perez"); 
       Rider r1= new Rider(t1,"09877456130","Juan Perez","Alborada 9na etapa","jperez@hotmail.com","rideruser","rideruser"); 
       CuentaBancaria bc1= new CuentaBancaria("B Pichicncha");
       Charger c1= new Charger("0918721","2222222","Maria Lopez","Sauces 8 mz40 v2","malo@gmail.com","chargeruser","chargeruser",bc1); 
      system.getUsuarios().add(r1); 
      system.getUsuarios().add(c1); 
      system.getVehiculos().add(v1);
      system.getVehiculos().add(v2);
      system.getVehiculos().add(v3);
      system.getVehiculos().add(b1);
      system.getVehiculos().add(b2);
      system.getVehiculos().add(b3);
   
    }
    /***
     * @author Eddy Santibañez J
     * @param rid Rider que se ecuentra en el programa
     */
    public static void reporteRider(Rider rid){
        int ano1= (int) Double.parseDouble(Solicitar.datos("Ingrese año inicial"));
               int mes1=  (int) Double.parseDouble(Solicitar.datos("Ingrese mes inicial"));
               int dia1=  (int) Double.parseDouble(Solicitar.datos("Ingrese dia inicial"));
               int ano2=  (int) Double.parseDouble(Solicitar.datos("Ingrese año final"));
               int mes2=  (int) Double.parseDouble(Solicitar.datos("Ingrese mes final"));
               int dia2=  (int) Double.parseDouble(Solicitar.datos("Ingrese dia final"));

               LocalDate fecha3 = LocalDate.of(ano1,mes1,dia1);
               LocalDate fecha4 = LocalDate.of(ano2,mes2,dia2);
               rid.verReporte(fecha3, fecha4);
                                        
                                        
    }
    /***
     * @author Eddy Santibañez J
     * @param cod4 codigo del vehiculo que se va a devolver
     * @param rid Usuario Rider que devuelve el vehiculo
     */
    
    public static void terminarprestamoRider(String cod4, Rider rid){
        Vehiculo v2= system.encontrarVehiculo(cod4);
                                        
                                        while(v2==null){
                                            System.out.println(noValido);
                                            cod4= Solicitar.datos(" Ingrese código para finalizar de cargar un transporte"); 
                                            v2= system.encontrarVehiculo(cod4);
                                        }
                                        
                                        System.out.println("Finalizar prestamo de trasporte ");
                                        Localizacion loca3= Solicitar.ubicacion();
                                        Prestamo p= rid.encontrarPrestamo();
                                        p.setFin(LocalTime.now());
                                        double distancia= system.calcularDistancia(v2.getUbicacion(),loca3 );
                                        System.out.println("Distancia Recorrida: "+distancia+" Km");
                                        p.setKm_recorridos(distancia);
                                        
                                        double bateria_usada= v2.calcularBateriaUtilizada(distancia);
                                        System.out.println("Bateria Utilizada: "+bateria_usada+" KW");

                                        double duracion= p.calcularDuracion();
                                        System.out.println("Tiempo Préstamo: "+duracion+" min");
                                        double valor= system.CalcularValorCobrar(p, duracion);
                                        p.setDuracion(duracion);
                                        p.setPago(valor);
                                        

                                        
                                        System.out.println("Total a pagar por el préstamo: "+valor);
                                        
                                        System.out.println("Seleccione la tarjeta");
                                        for(int i=0; i<rid.getTarjetas().size();i++){
                                            System.out.println(i+1+". "+ rid.getTarjetas().get(i));
                                        }
                                        System.out.println(rid.getTarjetas().size()+1+". Otra tarjeta");
                                        int opcionTarjeta= Solicitar.opcion(rid.getTarjetas().size()+1,"Opcion tarjeta");
                                        if(opcionTarjeta==rid.getTarjetas().size()+1){
                                            Tarjeta tarj_nueva = new Tarjeta ( );
                                            tarj_nueva.solicitarDatos ( );////////////
                                            rid.setTarjeta ( tarj_nueva );
                                            p.setTarjeta(tarj_nueva);
                                            System.out.println("Pago exitoso, devolución completada");
                                            
                                        }
                                        else{
                                            Tarjeta tarj= rid.getTarjetas().get(opcionTarjeta-1); 
                                            p.setTarjeta(tarj);
                                            System.out.println("Pago exitoso, devolución completada");
                                        }
                                        
                                        v2.finalizarCarga(loca3, v2.getBateria()- bateria_usada);
                                        //actuaizo bateria, ubicacion y disponibilidad
                                        
    }
    /***
     * @author Eddy Santibañez J
     * @param rid Usuario Rider que se encuentra en el programa 
     * este metodo imprime los transportes cercanos llamando a metodo encontrarTransportesCercanos(Localizacion, double, Sistema ) del rider
     */
    public static void buscarCercanoRider(Rider rid){
                                         Localizacion local= Solicitar.ubicacion(); 
                                        int rango= Integer.parseInt (Solicitar.datos("Rango "))  ; 
                                        rid.encontrarTransportesCercanos(local,rango ,system); 
    }
    
    /***
     * @author Eddy Santibañez J
     * @param rid suario Rider que se encuentra en el programa 
     * @param v vehiculo que se va a ulizar el rider
     */
    public static void empezarPrestamo(Rider rid, Vehiculo v){
        int confirmacion= Solicitar.opcion(2, "Confimar préstamo \n1)sí \n2)no \nOpcion"); 
                                            if (confirmacion==1){
                                                v.prestar();
                                                rid.setPrestando(true);
                                                System.out.println("Proceso exitoso");
                                                Prestamo prest= new Prestamo(v,rid,LocalTime.now(),LocalDate.now());
                                                rid.getPrestamos().add(prest);
                                                
                                            if (v instanceof Bicicleta){
                                                System.out.println("Bicicleta lista para usar");
                                            }
                                             if (v instanceof Scooter){
                                                System.out.println("Scooter listo para usar");
                                            }
                                            }

        }
    /***
     *  @author Eddy Santibañez J
     * Este metodo permite solicitar el codigo de un transporte y presentar al charger y luego validarlo y oregunat al charger si confirma la caraga de este transporte 
     * 
     */
    public static void buscarTransporteCharger(){
       
                                        String cod= Solicitar.datos(" Ingrese código para cargar transporte"); 
                                        Vehiculo v= system.encontrarVehiculo(cod);
                                        
                                        while(v==null){
                                            System.out.println(noValido);
                                            cod= Solicitar.datos(" Ingrese código para cargar transporte"); 
                                            v= system.encontrarVehiculo(cod);
                                        }
                                        if (v.getDisponible()==true ){
                                            System.out.println(v);
                                        System.out.println("Nivel de Batería : "+ v.getBateria());
                                        int confirmacion= Solicitar.opcion(2, "Confimar carga \n1)sí \n2)no \nOpcion"); 
                                                if (confirmacion==1){
                                                v.Cargar();
                                                System.out.println("Trasnporte listo para ser cargado ");
                                                }
                                        }else{
                                            System.out.println(noValido);
                                        }
                                           
                                        
                                        
    }
    /***
     *  @author Eddy Santibañez J
     * @param charg Usuario charger que se encunentra en el programa 
     * pide el codigo de un transporte, lo valida y permite a un charger terminar la carga de un trasnporte y genera el objeto Recarga
     * y lo guarda en las recgardas del charger
     */
    public static void empezarRecarga(Charger charg){
        String cod2= Solicitar.datos(" Ingrese código para para finalizar de cargar un transporte"); 
                                        Vehiculo v2= system.encontrarVehiculo(cod2);
                                        
                                        while(v2==null){
                                            System.out.println(noValido);
                                            cod2= Solicitar.datos(" Ingrese código para finalizar de cargar un transporte"); 
                                            v2= system.encontrarVehiculo(cod2);
                                        }
                                        
                                        
                                        System.out.println("Finalizar carga de trasporte ");
                                        Localizacion loca2= Solicitar.ubicacion();
                                        Double nuevoNivelBateria= Double.parseDouble(Solicitar.datos("Ingrese el nuevo nivel de Batería")); 
                                        double valor= system.CalcularValorPagar(nuevoNivelBateria, v2);
                                        charg.getCuentaBancaria().generarOrdendePago(valor);
                                        v2.finalizarCarga(loca2, nuevoNivelBateria);
                                        
                                        Recarga r= new Recarga(LocalDate.now(),valor, v2,charg );
                                        charg.getRecargas().add(r); 
    }
    /***
     *  @author Eddy Santibañez J
     * @param charg Usuario charger que se encunentra en el programa 
     * pide un intervalo de fechas y muestra las recargas realizadas por el charger en ese intervalo
     */
    public static void verReporteCharg(Charger charg){
        int ano1= (int) Double.parseDouble(Solicitar.datos("Ingrese año inicial"));
                                        int mes1=  (int) Double.parseDouble(Solicitar.datos("Ingrese mes inicial"));
                                        int dia1=  (int) Double.parseDouble(Solicitar.datos("Ingrese dia inicial"));
                                        int ano2=  (int) Double.parseDouble(Solicitar.datos("Ingrese año final"));
                                        int mes2=  (int) Double.parseDouble(Solicitar.datos("Ingrese mes final"));
                                        int dia2=  (int) Double.parseDouble(Solicitar.datos("Ingrese dia final"));

                                        
                                        
                                        LocalDate fecha3 = LocalDate.of(ano1,mes1,dia1);
                                        LocalDate fecha4 = LocalDate.of(ano2,mes2,dia2);
                                        charg.verReporte(fecha3, fecha4);
    }
    /***
     * @author Eddy Santibañez J
     * @param rid Usuario  que se encunentra en el programa 
     * Presenta la interfaz del rider
     */
    public static void interfazrider(Rider rid){
                            boolean salir = false;
                            while (!salir){
                                System.out.println ( "**********Bienvenido al Menú Rider**********\n" );
                                System.out.println ( "1) Buscar Transporte Cercano" );
                                System.out.println ( "2) Emepzar Prestamo Transporte" );
                                System.out.println ( "3) Terminar prestamo Transporte" );
                                System.out.println ( "4) Ver reporte de Prestamos" );
                                System.out.println ( "5) Salir");
                                int opcion = Solicitar.opcion ( 5, opci );

                                switch (opcion) {
                                    case 1:
                                        System.out.println(op1);
                                        buscarCercanoRider(rid);
                                        
                                        break;
                                    case 2:
                                       System.out.println(op2);
                                        if(rid.getPrestando()==false){
                                            ////
                                             String cod3= Solicitar.datos(" Ingrese código para prestar transporte"); 
                                             Vehiculo v= system.encontrarVehiculo(cod3);
                                        
                                            while(v==null){
                                                System.out.println(noValido);
                                                cod3= Solicitar.datos(" Ingrese código para prestar transporte"); 
                                                v= system.encontrarVehiculo(cod3);
                                            }

                                            System.out.println(v);
                                            System.out.println("Nivel de Batería : "+ v.getBateria());
                                           
                                            if(v.getDisponible()==false){
                                                System.out.println("El transporte no esta disponible ");
                                                break;
                                            }
                                          
                                            empezarPrestamo( rid,  v); 
                                        }
                                     
                                        if(rid.getPrestando()==true) {
                                              System.out.println("Usted ya se encuentra prestando un transporte");
                                        }
                                        
                                        break;
                                    case 3:
                                        System.out.println(op3);
                                        String cod4= Solicitar.datos(" Ingrese código para para finalizar prestamo un transporte"); 
                                        terminarprestamoRider(cod4, rid);
                                        break;
                                    case 4:
                                        System.out.println(op4);
                                        reporteRider(rid); 
                                        
                                        break;
                                    default :
                                        salir = true;
                                        System.out.println("Has salido del programa Rider");
                                        break;

                                }
                            }
    }
    /***
     * @author Eddy Santibañez J
     * @param charg Usuario  que se encunentra en el programa 
     * Presenta la interfaz del charger
     */
    public static void interfazcharger(Charger charg){
        
                        //la parte del progrma con la que interactuan los charger
                            boolean salir = false;
                            while (!salir){
                                System.out.println ( "**********Bienvenido al Menú Charger**********\n" );
                                System.out.println ( "1) Buscar Transporte Cercano" );
                                System.out.println ( "2) Emepzar Recarga Transporte" );
                                System.out.println ( "3) Terminar Recarga Transporte" );
                                System.out.println ( "4) Ver reporte de Recargas" );
                                System.out.println ( "5) Salir");
                                int opcion = Solicitar.opcion ( 5, opci );

                                switch (opcion) {
                                    case 1:
                                        System.out.println(op1);
                                        Localizacion local= Solicitar.ubicacion(); 
                                        int rango= Integer.parseInt (Solicitar.datos("Rango "))  ; 
                                        charg.encontrarTransportesCercanos(local,rango ,system); 
                                        break;
                                    case 2:
                                         System.out.println(op2);
                                         buscarTransporteCharger();
                                         
                                        break; 
                                    case 3:
                                        System.out.println(op3);
                                        empezarRecarga(charg);
                                        
                                        break;
                                    case 4:
                                        System.out.println(op4);
                                        //Codigo para ver reporte de cargas
                                        verReporteCharg(charg);
                                        break;
                                  
                                    default :
                                        salir = true;
                                        System.out.println("Has salido del programa Charger");

                                        break;

                                }
                             }
        
    }
    /***
     * Presenta el menu inicial
     */
    public static void menu(){
            System.out.println ( "**********Bienvenido al Menú Inicial**********\n" );
            System.out.println ( "1) Iniciar Sesión" );
            System.out.println ( "2) Registrarse" );
            System.out.println ( "3) Salir" );
    }
    /***
     * * @author Eddy Santibañez J
     * Interfaz general donde se valida el tipo de usuario y se llama a u interfaz correspondiente
     */
    public static void interfazgneral(){
           //inicar secion
                        Usuario u = iniciarSesion(system);
                        if(u instanceof Charger) {
                            Charger charg= new Charger(); 
                            charg= (Charger)u; 
                            interfazcharger(charg);
                        
                        } 
                        
                        if(u instanceof Rider) {
                            Rider rid= new Rider(); 
                            rid= (Rider)u; 
                               // la  parte del programa con la que interactuan los riders
                           interfazrider(rid); 
        
                           
                        } 

    }
   
   
    }
    
    





