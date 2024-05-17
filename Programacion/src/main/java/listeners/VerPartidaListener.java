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

		// Dependiendo del listener, realizamos una acción u otra
		switch ( ae.getActionCommand() ) {
			case "JUGAR":
				this.menu.cargarPanel( home );
				break;
			case "DETALLE":
				break;
		
			default:
				break;
		}
	}

}