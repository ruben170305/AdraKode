package listeners;

import java.awt.event.*;
import javax.swing.*;
import views.*;

public class EditarPersonajesListener implements ActionListener {

	private Menu ventana;
	private Home home;

	// Constructor del Listener
	public EditarPersonajesListener(Menu ventana, Home home) {
		this.ventana = ventana;
		this.home = home;
	}

	/**
	 * Listener del botón de editar personaje
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton sourceButton = (JButton) ae.getSource();
		String buttonName = sourceButton.getName();
		if (ae.getActionCommand().equals("")) {
			this.ventana.cargarPanel(home);
			//this.home.hacerVisible();
		} else if (ae.getActionCommand().equals("GUARDAR")) {
			this.ventana.cargarPanel(home);
			//this.home.hacerVisible();
		} else if (buttonName.equals("botonSubirImagen")) {

		}
	}
	/**
	 * Metodo que permite subir imagenes
	 */
	public void subirImagen() {
		
	}
}
