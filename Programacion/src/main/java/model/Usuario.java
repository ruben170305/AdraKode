package model;

import java.sql.*;

public class Usuario {

	// Definimos las características del Personaje
	private String usuario, apellidos, expediente, estudio;
	private int cod;

	// Constructor
	public Usuario() {}
	public boolean login( String usuario, String pass, Usuario user ) throws SQLException {

		boolean found = false;

		// Instanciamos el modelo
		Model mysql = new Model();
		mysql.get_connection();

		// Consulta SQL
		String sql = "select * from miembro where nombre = '" + usuario + "'";
		ResultSet rs = mysql.Model_query( sql );

        if ( !rs.next() ) {
            // Si no se encuentran registros
            System.out.println( "No se encontraron resultados para el usuario: " + usuario );
            found = false;
        } else {
            // Ahora que estamos en la primera fila, podemos obtener los datos
            String found_user = rs.getString( "nombre" );
            String found_pass = rs.getString( "pass" );

            // Comparamos el nombre y la constraseña para proceder al inicio de sesión
            if ( usuario.equals( found_user ) && pass.equals( found_pass ) ) {
                found = true;

                // Designamos el ID del usuario
                this.cod = rs.getInt( "cod") ;
                user.setUser_id(rs.getInt( "cod" ) );
			}
		}

		return found;
	}

	// Getters y Setters
	public int getUser_id() {
		return cod;
	}

	public void setUser_id(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return usuario;
	}

	public void setNombre(String nombre) {
		this.usuario = nombre;
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
