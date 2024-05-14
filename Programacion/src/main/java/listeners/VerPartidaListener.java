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
			rs = mysql.Model_query( "select * from partida" );
			return rs;
		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return rs;
	}
}