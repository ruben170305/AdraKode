package listeners;

import java.awt.event.*;
import javax.swing.*;
import views.*;

public class EditarPersonajesListener extends Listener implements ActionListener {

	// Constructor del Listener
	public EditarPersonajesListener( Menu menu, Home home ) {
		super( menu, home );
	}

	/**
	 * Listener del botón de editar personazje
	 */
	@Override
	public void actionPerformed( ActionEvent ae ) {
		JButton sourceButton = ( JButton ) ae.getSource();
		String buttonName = sourceButton.getName();
		if ( ae.getActionCommand().equals( "" ) || ae.getActionCommand().equals( "GUARDAR" ) ) {
			this.menu.cargarPanel( home );
		} else if ( buttonName.equals( "botonSubirImagen" ) ) {

		}
	}
	/**
	 * Metodo que permite subir imagenes
	 */
	public void subirImagen() {
		
	}
}
