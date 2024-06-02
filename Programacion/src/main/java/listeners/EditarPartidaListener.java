package listeners;

import java.awt.event.*;
import java.sql.SQLException;

import model.*;
import views.*;

public class EditarPartidaListener extends Listener implements ActionListener {
	
	private Usuario user;
	private EditarPartida ep;
	
	public EditarPartidaListener( Menu menu, Home home, Model mysql, Usuario user, EditarPartida ep ) {
		super( menu, home, mysql );
		this.user = user;
		this.ep = ep;
	}

    @Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "GUARDAR" ) ) {
			
			mysql.update_match( ep, mysql );
			
			// Renderizamos la ventana del listado de partidas
			VerPartidasMaster vPartidasMaster = new VerPartidasMaster();
			VerPartidaMasterListener vPartidaMasterListener = new VerPartidaMasterListener( vPartidasMaster, menu.getListener_menu().getEPartida(), menu, home, mysql, user );
			vPartidasMaster.setListener( vPartidaMasterListener );
			// menu.getListener_menu().getVPartidasMaster().dispose();
			menu.getListener_menu().setVPartidasMaster( vPartidasMaster );
			menu.cargarPanel( vPartidasMaster );
		}
	}

}
