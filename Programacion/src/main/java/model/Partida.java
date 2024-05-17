package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Partida extends Data {

    // Definimos las características de la Partida
    private int part_id;
    private String nombre, ambientacion, dia, hora;
    private boolean en_curso;

    // Constructor
    public Partida( int part_id, String nombre, boolean en_curso, String ambientacion, String dia, String hora ) {
        this.part_id      = part_id;
        this.nombre       = nombre;
        this.en_curso     = en_curso;
        this.ambientacion = ambientacion;
        this.dia          = dia;
        this.hora         = hora;
    }

    /**
	 * Método que realiza la consulta de datos a MySQL
	 * @return rs
	 */
	public ResultSet conseguir_partidas() {

		ResultSet rs = null;

		try {
			String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion " +
			"FROM partida p " +
			"LEFT JOIN miembro m " +
			"ON p.anfitrion_id = m.cod";

			rs = super.mysql.Model_query( sql );
			return rs;
		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return rs;
	}
    
    public ArrayList<String> get_data() {
		ResultSet rs = null;
		String sql = "SELECT nombre FROM personaje WHERE cod_miembro = ?";

		// Obtener la conexión
		try {
			Connection conn = super.mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement( sql );

			// Establecer el parámetro cod_miembro
			pstmt.setInt(1, user.getUser_id());

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

			while (rs.next()) {
				nombres.add(rs.getString("nombre"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombres;
	}

    // Getters y Setters
    public int getPart_id() {
        return part_id;
    }

    public void setPart_id( int part_id ) {
        this.part_id = part_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public boolean isEnCurso() {
        return en_curso;
    }

    public void setEnCurso( boolean en_curso ) {
        this.en_curso = en_curso;
    }

    public String getAmbientacion() {
        return ambientacion;
    }

    public void setAmbientacion( String ambientacion ) {
        this.ambientacion = ambientacion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia( String dia ) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora( String hora ) {
        this.hora = hora;
    }
}
