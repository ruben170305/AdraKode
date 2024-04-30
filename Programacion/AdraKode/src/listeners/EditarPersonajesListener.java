package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import views.*;

public class EditarPersonajesListener implements ActionListener {

	private Menu ventana;
	private Home home;

	// Constructor del Listener
	public EditarPersonajesListener(Menu ventana, Home home) {
		this.ventana = ventana;
		this.home = home;
	}

	// Listener del botón de editar personaje
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton sourceButton = (JButton) ae.getSource();
		String buttonName = sourceButton.getName();
		if (ae.getActionCommand().equals("")) {
			this.ventana.cargarPanel(home);
			this.home.hacerVisible();
		} else if (ae.getActionCommand().equals("GUARDAR")) {
			this.ventana.cargarPanel(home);
			this.home.hacerVisible();
		} else if (buttonName.equals("botonSubirImagen")) {

		}
	}

	public void subirImagen() {
		
	}
}
