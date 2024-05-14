package listeners;

import java.awt.event.*;

import views.Home;
import views.Menu;

public class CrearPersonajeListener extends Listener implements ActionListener {
	
	public CrearPersonajeListener( Menu menu, Home home ) {
		super( menu, home );
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "CREAR" ) )
            this.menu.cargarPanel( home );
	}

}
