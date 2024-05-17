package listeners;

import java.awt.event.*;
import model.*;
import views.*;

public class CrearPersonajeListener extends Listener implements ActionListener {

	private CrearPersonaje cPersonaje;
	private Usuario user;
	private Personaje personaje;

	public CrearPersonajeListener( Menu menu, Home home, CrearPersonaje cPersonaje, Usuario user ) {
		super( menu, home );
		this.cPersonaje = cPersonaje;
		this.user = user;
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "CREAR" ) ) {
			personaje.crear_personaje( this.cPersonaje, this.user );
			super.menu.cargarPanel( home );
		}
	}

}
