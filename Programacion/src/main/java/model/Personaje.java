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
    private int cod, cod_miembro, expe;
    
    // Constructor
    public Personaje( Model mysql ) {
		this.mysql = mysql;
	}

    public Personaje(
            int cod
        ,   String nombre
        ,   String personaje
        ,   String raza
        ,   String clase
        ,   int expe
        ,   int cod_miembro
    ) {
		super();
        this.cod 			= cod;
        this.nombre  		= nombre;
        this.personaje		= personaje;
        this.raza   		= raza;
        this.clase   		= clase;
        this.expe     		= expe;
        this.cod_miembro 	= cod_miembro;
    }
    
	public void crear_personaje( CrearPersonaje cPersonaje, Usuario user ) {

		// Consulta SQL
		String sql = "insert into personaje (nombre, personaje, raza, clase, expe, cod_miembro) values (?, ?, ?, ?, ?, ?)";
		try {
            Connection conn = this.mysql.get_connection();
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
			
			super.getPersonajes().add( new Personaje( cod, nombre, nombre, raza, clase, 0, get_id_personaje( nombre ) ) );

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public int get_id_personaje( String nombre ) {
		// Consulta SQL
		String sql = "SELECT cod FROM personaje WHERE nombre = ?";
		int numero = 0;
		try {
            Connection conn = this.mysql.get_connection();
            PreparedStatement pstmt = conn.prepareStatement( sql );
            pstmt.setString( 1, nombre );
            
            ResultSet rsResultSet = pstmt.executeQuery( sql );
            
            numero = rsResultSet.getInt( 1 );

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return numero;
	}

    /**
	 * Método que realiza la consulta de datos a MySQL
	 */
	public void conseguir_personajes() {

		try {
			ArrayList<Personaje> personajes = new ArrayList<>();

            // Realizamos una consulta para capturar todos los personajes
			String sql = "SELECT * from personaje";
			ResultSet rs = this.mysql.Model_query( sql );

            // Creamos un objeto personaje por cada registro y lo añadimos al Data
            while( rs.next() ) {
                Personaje temp_personaje = new Personaje(
                        rs.getInt( 1 )
                    ,   rs.getString( 2 )
                    ,   rs.getString( 3 )
                    ,   rs.getString( 4 )
                    ,   rs.getString( 5 )
                    ,   rs.getInt( 6 )
                    ,   rs.getInt( 7 )
                );

                // Añadimos al Data
                personajes.add( temp_personaje );

            }

			super.setPersonajes( personajes );

		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
	
	
	public void update_data( CrearPersonaje cPersonaje, Usuario user) {

		String sql = "UPDATE personaje SET nombre = ?, personaje = ?, raza = ?, clase = ?, expe = ? WHERE cod_miembro = ? AND id_personaje = ?";
		try {
            Connection conn = this.mysql.get_connection();
            PreparedStatement pstmt = conn.prepareStatement( sql );

			pstmt.setString(1, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un valor fijo
			pstmt.setString(2, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un valor fijo
			pstmt.setString(3, cPersonaje.getTxtRaza().getText());
			pstmt.setString(4, cPersonaje.getTxtClase().getText());
			pstmt.setInt(5, 0); // Si 'expe' es un entero, debes definir cómo se obtiene el valor
			pstmt.setInt(6, user.getUser_id());
			pstmt.setInt(7, this.cod);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void delete_data( Usuario user ) {
		
		Connection conn = this.mysql.get_connection();
		String delete = "DELETE FROM personaje WHERE cod_miembro = ? AND cod = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(delete);
			
			pstmt.setInt(1, user.getUser_id());
			pstmt.setInt(2, this.cod);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return expe;
	}
	public void setExpe(int expe) {
		this.expe = expe;
	}
	
}
