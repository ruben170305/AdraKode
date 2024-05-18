package listeners;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import model.Model;
import views.*;

public class VerPartidaMasterListener extends Listener implements ActionListener {
	private EditarPartida ePartida;
	
	public VerPartidaMasterListener( EditarPartida ePartida, Menu menu, Home home ) {
		super( menu, home );
		this.ePartida = ePartida;
	}
	
	@Override
	public void actionPerformed( ActionEvent ae ) {

		// Capturamos el nombre del componente
		String nombreComponente = ( ( JButton ) ae.getSource() ).getName();
		if ( ae.getActionCommand().equals( "JUGAR" ) ) {
            this.menu.cargarPanel(home);
            //this.ep.make_visible();
        } else if(nombreComponente.equals( "editar" )) {
        	this.menu.cargarPanel( this.ePartida );
        } else if(nombreComponente.equals( "borrar" )) {
        	if ( menu.mostrarMensajeConfirmborrado() )
				menu.cargarPanel( home );
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

}


