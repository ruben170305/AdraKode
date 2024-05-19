package listeners;

import java.awt.event.*;
import java.sql.*;

import model.*;
import views.Home;
import views.Menu;
import views.PartidaIniciada;

public class VerPartidaListener extends Listener implements ActionListener {
	
	
	private PartidaIniciada partida_iniciada;
	private Usuario user;

	public VerPartidaListener( Menu menu, Home home, Usuario user ) {
		super( menu, home );
		this.user = user;
	}

	public VerPartidaListener( Menu menu, Home home, PartidaIniciada partida_iniciada, Usuario user ) {
		super( menu, home );
		this.partida_iniciada = partida_iniciada;
		this.user = user;
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