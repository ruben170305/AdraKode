package listeners;

import java.awt.event.*;
import views.*;

public class CrearPartidaListener extends Listener implements ActionListener {
	
	public CrearPartidaListener( Menu menu, Home home ) {
		super( menu, home );
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "CREAR" ) )
            this.menu.cargarPanel( home );
	}

}
