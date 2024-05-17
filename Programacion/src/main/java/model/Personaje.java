package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import views.CrearPersonaje;

public class Personaje extends Data {

    // Definimos las características del Personaje
    private String nombre, personaje, clase, raza;
    private int cod, cod_miembro, exp;
    
    // Constructor
    public Personaje() {
    	
    }
    public Personaje( int cod, String nombre, String personaje, String raza, String clase, int exp, int cod_miembro ) {
        this.cod 			= cod;
        this.nombre  		= nombre;
        this.personaje		= personaje;
        this.raza   		= raza;
        this.clase   		= clase;
        this.exp     		= exp;
        this.cod_miembro 	= cod_miembro;
    }
    
    
	public void crear_personaje( CrearPersonaje cPersonaje, Usuario user ) {
		// Instanciamos el modelo
		super.mysql.get_connection();

		// Consulta SQL
		String sql = "insert into personaje (nombre, personaje, raza, clase, expe, cod_miembro) values (?, ?, ?, ?, ?, ?)";
		try {
            Connection conn = mysql.get_connection();
            PreparedStatement pstmt = conn.prepareStatement( sql );
            
            String nombre = cPersonaje.getLblSeleccionarPersonaje().getText();
            String raza = cPersonaje.getTxtRaza().getText();
            String clase = cPersonaje.getTxtClase().getText();
            int user_id = user.getUser_id();

			// Configura los valores para la consulta
			pstmt.setString(1, nombre); // Suponiendo que 'Personaje' es un valor fijo
			pstmt.setString(2, nombre); // Suponiendo que 'Personaje' es un valor fijo
			pstmt.setString(3, raza);
			pstmt.setString(4, clase);
			pstmt.setInt(5, 0); // Si 'expe' es un entero, debes definir cómo se obtiene el valor
			pstmt.setInt(6, user_id);

			// Ejecuta la inserción
			pstmt.executeUpdate();
			
			super.getPersonajes().add( new Personaje(cod, nombre, nombre, raza, clase, 0, get_id_personaje(nombre) ) );

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int get_id_personaje(String nombre) {
		// Consulta SQL
		String sql = "SELECT cod FROM personaje WHERE nombre = ?";
		try {
            Connection conn = mysql.get_connection();
            PreparedStatement pstmt = conn.prepareStatement( sql );
            pstmt.setString(1, nombre);
            
            ResultSet rsResultSet = pstmt.executeQuery( sql );
            
            int numero = rsResultSet.getInt(1);
			
			return numero;

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	/**
    
	Método que realiza la consulta de datos a MySQL*/
	  public void conseguir_personajes() {

	        try {
	            // Realizamos una consulta para capturar todas las partidas con su anfitrión
	            String sql = "SELECT * FROM personajes WHERE cod = ?";
	            ResultSet rs = super.mysql.Model_query( sql );

	            // Creamos un objeto partida por cada registro y lo añadimos al Data
	            while( rs.next() ) {
	                Partida temp_partida = new Partida(
	                        rs.getString( 1 )
	                    ,   rs.getString( 2 )
	                    ,   rs.getString( 3 )
	                    ,   rs.getInt( 4 )
	                    ,   rs.getInt( 5 )
	                    ,   rs.getString( 6 )
	                    ,   rs.getInt( 7 )
	                    ,   rs.getString( 8 )
	                    ,   rs.getInt( 9 )
	                    ,   rs.getInt( 10 )
	                    ,   rs.getString( 11 )
	                    ,   rs.getString( 12 )
	                );

	                // Añadimos al Data
	                super.getPartidas().add( temp_partida );

	            }
	        } catch ( SQLException e ) {
	            e.printStackTrace();
	        }
	    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPersonaje() {
		return personaje;
	}
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getCod_miembro() {
		return cod_miembro;
	}
	public void setCod_miembro(int cod_miembro) {
		this.cod_miembro = cod_miembro;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
}
