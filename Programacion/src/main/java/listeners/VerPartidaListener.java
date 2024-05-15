package listeners;

import java.awt.event.*;
import java.sql.*;
import model.*;
import views.Home;
import views.Menu;

public class VerPartidaListener extends Listener implements ActionListener {
	
	
	public VerPartidaListener( Menu menu, Home home ) {
		super( menu, home );
	}


    @Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "JUGAR" ) )
            this.menu.cargarPanel( home );
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
}