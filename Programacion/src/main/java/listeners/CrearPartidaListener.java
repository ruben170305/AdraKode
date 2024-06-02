package listeners;

import java.awt.event.*;

import javax.swing.JButton;

import model.*;
import views.*;

public class CrearPartidaListener extends Listener implements ActionListener {

	private CrearPartida cp;
	private boolean esMaster;
	private Usuario user;

	public CrearPartidaListener(Menu menu, Home home, Model mysql, CrearPartida cp, boolean esMaster, Usuario user) {
		super( menu, home, mysql );
		this.cp = cp;
		this.esMaster = esMaster;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		// Capturamos el nombre del componente
		String nombreComponente = ((JButton) ae.getSource()).getName();

		if ( nombreComponente.equals("CREAR") && nombreComponente != null ) {
			boolean renderize = mysql.create_match( cp, mysql, menu );

			// Renderizamos de nuevo la ventana del listado de partidas
			if( esMaster && renderize ) {
				VerPartidasMaster vPartidasMaster = new VerPartidasMaster();
				VerPartidaMasterListener vPartidaMasterListener = new VerPartidaMasterListener( vPartidasMaster, menu.getListener_menu().getEPartida(), menu, home, mysql, user );
				vPartidasMaster.setListener( vPartidaMasterListener );
				// menu.getListener_menu().getVPartidasMaster().dispose();
				menu.getListener_menu().setVPartidasMaster( vPartidasMaster );
				menu.cargarPanel( vPartidasMaster );
			}
		} else if (nombreComponente.equals("cargarImagen")) {
			menu.mostrarMensajeConstruccion();
		}
	}


}
