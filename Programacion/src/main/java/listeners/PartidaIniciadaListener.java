package listeners;

import java.awt.event.*;
import java.sql.*;

import model.*;
import views.Home;
import views.Menu;

public class PartidaIniciadaListener extends Listener implements ActionListener {

	private Usuario user;

	public PartidaIniciadaListener( Menu menu, Home home, Usuario user ) {
		super( menu, home );
		this.user = user;
	}

	/**
	 * Método que realiza la consulta de datos a MySQL
	 * @return rs
	 */
	public ResultSet get_data() {

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


	public ResultSet get_data_personajes() {

		ResultSet rs = null;

		// Creamos una conexión con MySQL
		Model mysql = new Model();

		// Realizamos una consulta para capturar todos los personajes
		String sql = "select p.*, j.* from personaje p left join juega j on j.id_personaje = p.cod WHERE cod_miembro=?";
		try {
			Connection conn = mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_id());
			System.out.println( pstmt.toString() );

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}