package listeners;

import java.awt.event.*;

import javax.swing.*;

import model.*;
import views.*;

public class VerPartidaMasterListener extends Listener implements ActionListener {
	private EditarPartida ePartida;
	private VerPartidasMaster vPartidaMaster;

	
	public VerPartidaMasterListener( VerPartidasMaster vPartidaMaster, EditarPartida ePartida, Menu menu, Home home ) {
		super( menu, home );
		this.vPartidaMaster = vPartidaMaster;
		this.ePartida = ePartida;
	}
	
	@Override
	public void actionPerformed( ActionEvent ae ) {

		// Capturamos el nombre del componente
		String nombreComponente = ( ( JButton ) ae.getSource() ).getName();
		if(nombreComponente.equals( "editar" )) {

			int partida_id = Integer.parseInt( vPartidaMaster.getIdPartidaLbl().getText());


        	menu.cargarPanel( ePartida );
        } else if(nombreComponente.equals( "borrar" )) {
        	if ( menu.mostrarMensajeConfirmborrado() )
				menu.cargarPanel( home );
        }
	}

}


