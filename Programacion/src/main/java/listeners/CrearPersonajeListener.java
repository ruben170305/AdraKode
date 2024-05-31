package listeners;

import java.awt.event.*;
import java.sql.*;

import javax.swing.JButton;

import model.*;
import views.*;

public class CrearPersonajeListener extends Listener implements ActionListener {

	private CrearPersonaje cp;
	private Usuario user;

	public CrearPersonajeListener(Menu menu, Home home, Model mysql, CrearPersonaje cp, Usuario user) {
		super( menu, home, mysql );
		this.cp = cp;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Capturamos los botones
		JButton sourceButton = (JButton) ae.getSource();
		String buttonName = sourceButton.getName();

		// Dependiendo del action event, ejecutamos un panel u otro
		if (buttonName.equals("CREAR")) {
			
			boolean renderize = mysql.insert_personaje( cp, user, menu );

			// Renderizamos de nuevo la ventana del listado de partidas
			if( renderize ) {
				VerPersonajes vPersonajes = new VerPersonajes( user, false );
				VerPersonajesListener vPersonajesListener = new VerPersonajesListener( menu, home, mysql, user, vPersonajes );
				vPersonajes.setListener( vPersonajesListener );
				// menu.getListener_menu().getVPartidasMaster().dispose();
				menu.getListener_menu().setVPersonajes( vPersonajes );
				menu.cargarPanel(vPersonajes);
			}
			
		} else if (buttonName.equals("subirImagen")) {
			menu.mostrarMensajeConstruccion();
		}
	}

}
