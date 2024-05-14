package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import model.Model;
import views.*;

public class VerPersonajesListener extends Listener implements ActionListener {

	private EditarPersonaje ep;

	// Constructor del Listener
	public VerPersonajesListener( EditarPersonaje ep, Menu menu, Home home ) {
		super( menu, home );
		this.ep = ep;
	}
	
	public ResultSet get_data() {
		
		ResultSet rs = null;

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.get_connection();

		try {
			rs = mysql.Model_query( "select * from miembro" );
			return rs;
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;
	}

	/**
     * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo del boton
     */
    @Override
    public void actionPerformed( ActionEvent ae ) {
		
        if ( ae.getActionCommand().equals( "" ) )
            super.menu.cargarPanel( ep );
        else if( ae.getActionCommand().equals( "SELECCIONAR" ) )
			super.menu.cargarPanel( home );
        else
			super.menu.cargarPanel( home );

    }
}