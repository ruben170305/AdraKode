package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import views.CrearPersonaje;

public class Personaje extends Data {

    // Definimos las características del Personaje
    private String nombre, clase, exp;
    private int pers_id, raza;
    private ArrayList<String> nombres = new ArrayList<String>();
    
    // Constructor
    public Personaje( int pers_id, String nombre, int raza, String clase, String exp ) {
        this.pers_id = pers_id;
        this.nombre  = nombre;
        this.raza    = raza;
        this.clase   = clase;
        this.exp     = exp;
    }
    
    
	public void crear_personaje( CrearPersonaje cPersonaje, Usuario user ) {

		// Instanciamos el modelo
		Model mysql = new Model();
		mysql.get_connection();

		// Consulta SQL
		String sql = "insert into personaje (nombre, personaje, raza, clase, expe, cod_miembro) values (?, ?, ?, ?, ?, ?)";
		try {
            Connection conn = mysql.get_connection();
            PreparedStatement pstmt = conn.prepareStatement( sql );

			// Configura los valores para la consulta
			pstmt.setString(1, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un valor fijo
			pstmt.setString(2, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un valor fijo
			pstmt.setString(3, cPersonaje.getTxtRaza().getText());
			pstmt.setString(4, cPersonaje.getTxtClase().getText());
			pstmt.setInt(5, 0); // Si 'expe' es un entero, debes definir cómo se obtiene el valor
			pstmt.setInt(6, user.getUser_id());

			// Ejecuta la inserción
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    /**
	 * Método que realiza la consulta de datos a MySQL
	 */
	public ResultSet conseguir_personajes() {

		ResultSet rs = null;

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.get_connection();

		try {
			String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion " +
			"FROM partida p " +
			"LEFT JOIN miembro m " +
			"ON p.anfitrion_id = m.cod";

			rs = mysql.Model_query( sql );
			return rs;
		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return rs;
	}

    public int get_id_personaje(String nombre) {

        int numero = 0;

        // Consulta SQL
        String sql = "SELECT cod FROM personaje WHERE nombre = ?";
        try {
            Connection conn = mysql.get_connection();
            PreparedStatement pstmt = conn.prepareStatement( sql );
            pstmt.setString( 1, nombre );

            ResultSet rsResultSet = pstmt.executeQuery( sql );

            numero = rsResultSet.getInt( 1 );

            return numero;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numero;
    }

    
	public void update_data() {
		Model mysql = new Model();
		mysql.get_connection();

		String update = "UPDATE personaje SET nombre = ?, personaje = ?, raza = ?, clase = ?, expe = ? WHERE cod_miembro = ? AND id_personaje = ?";
		try (Connection conn = mysql.get_connection(); PreparedStatement pstmt = conn.prepareStatement(update)) {
			pstmt.setString(1, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un
																					// valor fijo
			pstmt.setString(2, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un
																					// valor fijo
			pstmt.setString(3, cPersonaje.getTxtRaza().getText());
			pstmt.setString(4, cPersonaje.getTxtClase().getText());
			pstmt.setInt(5, 0); // Si 'expe' es un entero, debes definir cómo se obtiene el valor
			pstmt.setInt(6, user.getUser_id());
			pstmt.setInt(7, personaje.getPers_id());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete_data() {
		Model mysql = new Model();
		mysql.get_connection();
		
		Connection conn = mysql.get_connection();
		String delete = "DELETE FROM personaje WHERE cod_miembro = ? AND cod = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(delete);
			
			pstmt.setInt(1, user.getUser_id());
			pstmt.setInt(2, personaje.getPers_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


    // Getters y Setters
    
    public int getPers_id() {
        return pers_id;
    }

    public ArrayList<String> getNombres() {
		return nombres;
	}
	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}
	public void setPers_id( int pers_id ) {
        this.pers_id = pers_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase( String clase ) {
        this.clase = clase;
    }

    public String getExp() {
        return exp;
    }

    public void setExp( String exp ) {
        this.exp = exp;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza( int raza ) {
        this.raza = raza;
    }
}
