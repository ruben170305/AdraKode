package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Usuario;
import views.Home;
import views.Menu;

public class PartidaIniciadaListener extends Listener implements ActionListener {

	private Usuario user;

	public PartidaIniciadaListener( Menu menu, Home home, Usuario user ) {
		super( menu, home );
		this.user = user;
	}

    @Override
    public void actionPerformed( ActionEvent ae ) {
        throw new UnsupportedOperationException( "Unimplemented method 'actionPerformed'" );
    }
}