package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import model.Model;
import views.*;

public class EditarPersonajesListener extends Listener implements ActionListener {
	
	private EditarPersonaje ep;
	private VerPersonajes vPersonajes;

	// Constructor del Listener
	public EditarPersonajesListener(
			Menu menu
		, 	Home home
		, 	EditarPersonaje ep
		, 	VerPersonajes vPersonaje
	) {
		super( menu, home );
		this.ep = ep;
		this.vPersonajes = vPersonaje;
	}

	/**
	 * Listener del botón de editar personaje
	 */
	@Override
	public void actionPerformed( ActionEvent ae ) {

		// Capturamos los botones
		JButton sourceButton = ( JButton ) ae.getSource();
		String buttonName = sourceButton.getName();

		// Dependiendo del action event, ejecutamos un panel u otro
		if ( ae.getActionCommand().equals( "" ) || ae.getActionCommand().equals( "GUARDAR" ) ) {
			if ( menu.mostrarMensajeConfirmEditado() ) {
				db_update();
				menu.cargarPanel( home );
			} else {
				menu.cargarPanel( vPersonajes );
			}
		}
		
		else if ( buttonName.equals( "botonSubirImagen" ) ) {}
	}
	
	public void db_update() {

		// Inicializamos la conexión con MySQL
		Model mysql = new Model();
		String sql = "update personaje set clase=?, raza=? where cod=?";
		Connection conn = mysql.get_connection();

		try {
			// Consulta para actualizar la tabla
			PreparedStatement pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, ep.getTxtClase().getText() );
			pstmt.setString( 2, ep.getTxtRaza().getText() );
			pstmt.setInt( 3, Integer.parseInt( ep.getLblId().getText() ) );
			pstmt.executeUpdate();

		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}
	}
	
	/**
	 * Metodo que permite subir imagenes
	 */
	public void subirImagen() {
		
	}
}
