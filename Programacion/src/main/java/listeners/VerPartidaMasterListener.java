package listeners;

import java.awt.event.*;
import javax.swing.*;
import views.*;

public class VerPartidaMasterListener extends Listener implements ActionListener {
	private EditarPartida ePartida;
	
	public VerPartidaMasterListener( EditarPartida ePartida, Menu menu, Home home ) {
		super( menu, home );
		this.ePartida = ePartida;
	}
	
	@Override
	public void actionPerformed( ActionEvent ae ) {

		// Capturamos el nombre del componente
		String nombreComponente = ( ( JButton ) ae.getSource() ).getName();
		// TODO Auto-generated method stub
		if ( ae.getActionCommand().equals( "JUGAR" ) ) {
            this.menu.cargarPanel(home);
            //this.ep.make_visible();
        } else if(nombreComponente.equals( "editar" )) {
        	this.menu.cargarPanel( this.ePartida );
        } else if(nombreComponente.equals( "borrar" )) {
        	if ( menu.mostrarMensajeConfirmborrado() )
				menu.cargarPanel( home );
        }
	}

}

