package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import views.*;

public class VerPartidaMasterListener implements ActionListener {
	private Menu menu;
	private Home home;
	private EditarPartida ePartida;
	
	public VerPartidaMasterListener(Home home, Menu menu, EditarPartida ePartida) {
		this.menu = menu;
		this.home = home;
		this.ePartida = ePartida;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String nombreComponente = ((JButton) ae.getSource()).getName();
		// TODO Auto-generated method stub
		if ( ae.getActionCommand().equals("JUGAR") ) {
            this.menu.cargarPanel(home);
            //this.ep.hacerVisible();
        } else if(nombreComponente.equals("editar")) {
        	this.menu.cargarPanel(ePartida);
        } else if(nombreComponente.equals("borrar")) {
        	if (menu.mostrarMensajeConfirmborrado()) {
				menu.cargarPanel(home);
			}
        }
	}

}


