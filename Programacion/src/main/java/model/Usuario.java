package model;

import java.sql.*;
import model.*;

public class Usuario {

    // Definimos las características del Personaje
    private String nombre, apellidos, password, expediente, estudio;
    private int cod;
    
    // Constructor
    public Usuario( String nombre, String password ) {
        this.nombre     = nombre;
        this.password   = password;
    }
    
    public boolean consultaLogin( String usuario ) throws SQLException {

        // Instanciamos el modelo
    	Model mysql = new Model();
        mysql.get_connection();

        // Consulta SQLBob
    	String userST = "SELECT * FROM miembro WHERE nombre = '" + nombre + "'";
    	ResultSet userRS = mysql.Model_query( userST );
    	
    	if ( !userRS.next() ) {
	        System.out.println( "No se encontraron resultados para el usuario: " + this.nombre );
	        return false;
	    } else {

	    	// Ahora que estamos en la primera fila, podemos obtener los datos
	    	String usuarioEncontrado = userRS.getString( "nombre" );
	    	String pass = userRS.getString( "pass" );

            // Comparamos el nombre y la constraseña para proceder al inicio de sesión
		    if ( this.nombre.equals( usuarioEncontrado ) )
                return ( this.password.equals( pass ) ? true : false );
		    else
		        return false;
	    }
    }

    // Getters y Setters
    public int getUser_id() {
        return cod;
    }

    public void setUser_id( int cod ) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getExpediente() {
        return expediente;
    }
    
    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }
    
    public String getEstudio() {
        return estudio;
    }
    
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
}
