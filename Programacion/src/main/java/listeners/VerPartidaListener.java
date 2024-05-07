package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;

public class VerPartidaListener implements ActionListener {
	private Menu menu;
	private Home home;
	
	
	public VerPartidaListener(Home home, Menu menu) {
		this.menu = menu;
		this.home = home;
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if ( ae.getActionCommand().equals("JUGAR") ) {
            this.menu.cargarPanel(home);
            //this.ep.hacerVisible();
        }
	}

}
