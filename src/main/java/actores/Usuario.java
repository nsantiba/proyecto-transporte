package actores;

import entidades.Localizacion;
import entidades.Recarga;
import entidades.Sistema;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import vehiculos.Vehiculo;

/**
 * @author Devin Gaibor
 * Superclase de la cual heredan todos los usuarios que interactúan con el sistema de transporte.
 */
public abstract class Usuario
{
    private String identificacion;
    private String nombre;
    private String direccion;
    private String correo;
    private String usuario;
    private String contrasenia;
    
    /**
     * Método que permite a los usuarios registrarse en el sistema de transporte y varía según el tipo de usuario que lo invoque.
     */
   
        
    /**
     * @author Devin Gaibor
     * @param localizacion ubicacion del usuario
     * @param rango el rango de distancia entre el que se va abuscar 
     * @param sistema contien la informacion de tosos lod vehiculos
     * Método abstracto imprime la  información de los transportes cercanos y varía según el tipo de usuario que lo invoque. 
     */
    public abstract void encontrarTransportesCercanos ( Localizacion localizacion, double rango,  Sistema sistema );

    public Usuario ( ) { }
    
    public Usuario ( String identificacion, String nombre, String direccion, String correo, String usuario, String contrasenia )
    {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    } 
    
    public String getIdentificacion ( )
    {
        return identificacion;
    }

    public void setIdentificacion ( String identificacion )
    {
        this.identificacion = identificacion;
    }

    public String getNombre ( )
    {
        return nombre;
    }

    public void setNombre ( String nombre )
    {
        this.nombre = nombre;
    }

    public String getDireccion ( )
    {
        return direccion;
    }

    public void setDireccion ( String direccion )
    {
        this.direccion = direccion;
    }

    public String getCorreo ( )
    {
        return correo;
    }

    public void setCorreo ( String correo )
    {
        this.correo = correo;
    }

    public String getUsuario ( )
    {
        return usuario;
    }

    public void setUsuario ( String usuario )
    {
        this.usuario = usuario;
    }

    public String getContrasenia ( )
    {
        return contrasenia;
    }

    public void setContrasenia ( String contrasenia )
    {
        this.contrasenia = contrasenia;
    }
    
    /**
     * @author Eddy Santibañez J
     * @return 
     */
    @Override
    public String toString ( )
    {
        return ( "Nombre: " + nombre + "\nUsuario: " + usuario + "\nCorreo: " + correo + "\nDireccion: " + direccion );
    }
    
    public abstract void verReporte(LocalDate inicio, LocalDate fin); 
    /**
     * @author Eddy Santibañez J
     * @param obj el objeto que se va a comparar
     * compara 2 objeos y si son un usuario retorna si son iguales o no.
     * @return boolean 
     */
    @Override
    public boolean equals ( Object obj ) { //solo compara el usuario y la contraseña
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.identificacion, other.identificacion)) {
            return false;
        }
        
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        return true;
    }   
    
    
    
  }
    

