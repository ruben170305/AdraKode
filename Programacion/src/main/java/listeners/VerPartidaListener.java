package listeners;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import model.*;
import views.Home;
import views.Menu;

public class VerPartidaListener extends Listener implements ActionListener {
	
	
	public VerPartidaListener( Menu menu, Home home ) {
		super( menu, home );
	}


    @Override
	public void actionPerformed( ActionEvent ae ) {

		// Dependiendo del listener, realizamos una acción u otra
		switch ( ae.getActionCommand() ) {
			case "JUGAR":
				this.menu.cargarPanel( home );
				break;
			case "DETALLE":
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


	public ArrayList<Partida> get_data_arrays() {

		Model mysql = new Model();
		ResultSet rs = null;

		ArrayList<Partida> partidas = new ArrayList<>();

		// Realizamos una consulta para capturar todas las partidas
		String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion " +
		"FROM partida p " +
		"LEFT JOIN miembro m " +
		"ON p.anfitrion_id = m.cod";
		try {
			Connection conn = mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

			// Creamos un objeto partida por cada registro y lo añadimos al Data
			while( rs.next() && rs != null ) {
                Partida temp_partida = new Partida(
                        rs.getInt( 1 )
                    ,   rs.getInt( 2 )
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
				partidas.add( temp_partida );

			}


		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return partidas;

	}
}