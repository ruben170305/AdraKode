package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import model.Model;
import model.Usuario;
import views.*;

public class EditarPersonajesListener extends Listener implements ActionListener {
	
	private EditarPersonaje ep;
	private VerPersonajes vPersonajes;
	private Usuario user;

	// Constructor del Listener
	public EditarPersonajesListener(
			Menu menu
		, 	Home home
		,	Model mysql
		, 	EditarPersonaje ep
		, 	VerPersonajes vPersonaje
		, 	Usuario user
	) {
		super( menu, home, mysql );
		this.ep = ep;
		this.vPersonajes = vPersonaje;
		this.user = user;
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
		if ( buttonName.equals("GUARDAR") ) {
			if ( menu.mostrarMensajeConfirmEditado() ) {
				
				boolean renderize = mysql.update_personaje_ep( ep, user );

				// Renderizamos de nuevo la ventana del listado de partidas
				if( renderize ) {
					VerPersonajes vPersonajes = new VerPersonajes( user, false );
					VerPersonajesListener vPersonajesListener = new VerPersonajesListener( menu, home, mysql, user, ep, vPersonajes );
					vPersonajes.setListener( vPersonajesListener );
					// menu.getListener_menu().getVPartidasMaster().dispose();
					menu.getListener_menu().setVPersonajes( vPersonajes );
					menu.cargarPanel( vPersonajes );
				}
				
			} else {
				menu.cargarPanel( vPersonajes );
			}
		} else if ( buttonName.equals( "botonSubirImagen" ) ) {
			subirImagen();
		}
	}

	
	/**
	 * Metodo que permite subir imagenes
	 */
	public void subirImagen() {
		menu.mostrarMensajeConstruccion();
	}
}
