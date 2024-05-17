package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import model.Personaje;
import model.Usuario;
import views.*;

public class VerPersonajesListener extends Listener implements ActionListener {

	private EditarPersonaje ep;
	private Usuario user;
	private CrearPersonaje cPersonaje;
	private Personaje personaje;

	// Constructor del Listener
	public VerPersonajesListener(EditarPersonaje ep, Menu menu, Home home, Usuario user, CrearPersonaje cPersonaje,
			Personaje personaje) {
		super(menu, home);
		this.cPersonaje = cPersonaje;
		this.ep = ep;
		this.user = user;
		this.personaje = personaje;
	}

	/**
	 * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo del boton
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton sourceButton = ( JButton ) ae.getSource();
		String buttonName = sourceButton.getName();
		if (ae.getActionCommand().equals("SELECCIONAR")) {
			super.menu.cargarPanel(home);
		} else if (buttonName.equals("ACTUALIZAR")) {
			this.personaje.update_data( cPersonaje, user );
			super.menu.cargarPanel(home);
		} else if (buttonName.equals("BORRAR")) {
			this.personaje.delete_data( user );
			super.menu.cargarPanel(home);
		}

	}
}