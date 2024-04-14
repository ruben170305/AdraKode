package listeners;

import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class PMenuListener implements ActionListener {
	
	private Menu ventana;
	private views.CrearPersonaje cPersonaje;
	private views.EditarPersonaje ePersonaje;
	private views.VentanaPrincipalLogin login;

	public PMenuListener(Menu ventana) {
		this.ventana = ventana;
		this.cPersonaje = cPersonaje;
		this.ePersonaje = ePersonaje;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JMenuItem) {
			if (ev.getActionCommand().equals("Nuevo personaje")) {
				ventana.cargarPanel(cPersonaje);
			} else if (ev.getActionCommand().equals("Editar personaje")) {
				ventana.cargarPanel(ePersonaje);
			} else if (ev.getActionCommand().equals("Login")) {
				ventana.cargarPanel(login);
			} else if (ev.getActionCommand().equals("Salir")) {
				ventana.mostrarMensajeConfirm();
			}
				
		}
	}

}


