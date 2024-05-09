package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    // Definimos las características del Personaje
    private String nombre, apellidos, password, expediente, estudio;
    private int cod;
    private Model model = new Model();
    
    // Constructor
    public Usuario(String nombre, String password) {
        this.nombre     = nombre;
        this.password   = password;
    }
    
    public boolean consultaLogin(String usuario) throws SQLException {
    	Connection conexion = model.getConexion();
    	String userST = "SELECT * FROM miembro WHERE nombre = '" + nombre + "'";
    	System.out.println(userST);
    	PreparedStatement userPS = conexion.prepareStatement(userST);
    	ResultSet userRS = userPS.executeQuery();
    	
    	if (!userRS.next()) {
	        System.out.println("No se encontraron resultados para el usuario: " + this.nombre);
	        return false;
	    } else {
	    	// Ahora que estamos en la primera fila, podemos obtener los datos
	    	String usuarioEncontrado = userRS.getString("nombre");
	    	String pass = userRS.getString("pass");
		    if (this.nombre.equals(usuarioEncontrado)) {
		        if (this.password.equals(pass)) {
		        	System.out.println("Correcto");
		        	return true;
				} else {
					System.out.println("Datos incorrectos");
					return false;
				}
		    } else {
		    	return false;
		    }
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
