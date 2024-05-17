package model;

import java.sql.*;

public class Usuario extends Data {

	// Definimos las características del Personaje
	private String usuario, apellidos, password, expediente, estudio;
	private int cod;

	// Constructor
	public Usuario( Model mysql ) {
		super( mysql );
	}

	public boolean consultaLogin(String usuario, String pass) throws SQLException {

		// Instanciamos el modelo
		Model mysql = new Model();
		mysql.get_connection();

		// Consulta SQLBob
		String userST = "SELECT * FROM miembro WHERE nombre = '" + usuario + "'";
		ResultSet userRS = mysql.Model_query(userST);

		if ( !userRS.next() ) {
			System.out.println( "No se encontraron resultados para el usuario: " + usuario );
			return false;
		} else {

			// Ahora que estamos en la primera fila, podemos obtener los datos
			String usuarioEncontrado = userRS.getString("nombre");
			String passComp = userRS.getString("pass");

			// Comparamos el nombre y la constraseña para proceder al inicio de sesión
			if (usuario.equals(usuarioEncontrado)) {
				this.cod = userRS.getInt("cod");
				if (pass.equals(passComp)) {
					return true;
				} else {
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
