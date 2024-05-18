package listeners;

import java.awt.event.*;
import java.sql.*;

import model.*;
import views.Home;
import views.Menu;
import views.PartidaIniciada;

public class VerPartidaListener extends Listener implements ActionListener {
	
	
	private PartidaIniciada partida_iniciada;
	private Usuario user;

	public VerPartidaListener( Menu menu, Home home, Usuario user ) {
		super( menu, home );
		this.user = user;
	}

	public VerPartidaListener( Menu menu, Home home, PartidaIniciada partida_iniciada, Usuario user ) {
		super( menu, home );
		this.partida_iniciada = partida_iniciada;
		this.user = user;
	}


    @Override
	public void actionPerformed( ActionEvent ae ) {

		// Dependiendo del listener, realizamos una acción u otra
		switch ( ae.getActionCommand() ) {
			case "JUGAR":
				this.menu.cargarPanel( partida_iniciada );
				break;
			default:
				break;
		}
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

		Model mysql = new Model();
		ResultSet rs = null;

		// Realizamos una consulta para capturar todos los personajes
		String sql = "SELECT * FROM personaje WHERE cod_miembro=?";
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
}