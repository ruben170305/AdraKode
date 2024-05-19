package listeners;

import java.awt.event.*;
import views.*;

public class VerPartidaListener extends Listener implements ActionListener {
	
	
	private PartidaIniciada partida_iniciada;

	public VerPartidaListener( Menu menu, Home home ) {
		super( menu, home );
	}

	public VerPartidaListener( Menu menu, Home home, PartidaIniciada partida_iniciada ) {
		super( menu, home );
		this.partida_iniciada = partida_iniciada;
	}


    @Override
	public void actionPerformed( ActionEvent ae ) {

		// Dependiendo del listener, realizamos una acción u otra
		switch ( ae.getActionCommand() ) {
			case "JUGAR":
				this.menu.cargarPanel( partida_iniciada );
				break;
			default:
				break;
		}
	}
}