package listeners;

import java.awt.event.*;
import views.*;

public class EditarPartidaListener extends Listener implements ActionListener {
	
	public EditarPartidaListener( Menu menu, Home home ) {
		super( menu, home );
	}

    @Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "GUARDAR" ) )
			this.menu.cargarPanel( home );
	}

}
