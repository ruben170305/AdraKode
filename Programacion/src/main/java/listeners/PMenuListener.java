package listeners;

import views.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class PMenuListener implements ActionListener {
	
	private Menu ventana;
	private Home home;
	private views.CrearPersonaje cPersonaje;
	private views.EditarPersonaje ePersonaje;
	private views.VentanaPrincipalLogin login;
	private VerPersonajes vPersonajes;
	private CrearPartida cPartida;
	private EditarPartida ePartidas;
	private VerPartidas vPartidas;
	private VerPartidasMaster vPartidasMaster;

	public PMenuListener(Menu ventana, Home home, EditarPersonaje ePersonaje, CrearPersonaje cPersonaje, VerPersonajes vPersonajes,
			CrearPartida cPartida, EditarPartida ePartidas, VerPartidas vPartidas, VerPartidasMaster vPartidasMaster, VentanaPrincipalLogin login) {
		this.ventana = ventana;
		this.home = home;
		this.cPersonaje = cPersonaje;
		this.ePersonaje = ePersonaje;
		this.vPersonajes = vPersonajes;
		this.cPartida = cPartida;
		this.ePartidas = ePartidas;
		this.vPartidas = vPartidas;
		this.vPartidasMaster = vPartidasMaster;
		this.login = login;
	}

	@Override
	/**
	 * Metodo del listener que cambia de ventana según la opcion que clickemos en el menu
	 */
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JMenuItem) {
			if (ev.getActionCommand().equals("Nuevo personaje")) {
				ventana.cargarPanel(cPersonaje);
			} else if (ev.getActionCommand().equals("Modificar personaje")) {
				ventana.cargarPanel(ePersonaje);
			} else if (ev.getActionCommand().equals("Ver personajes")) {
				ventana.cargarPanel(vPersonajes);
			} else if (ev.getActionCommand().equals("Crear partida")) {
				ventana.cargarPanel(cPartida);
			} else if (ev.getActionCommand().equals("Editar partidas")) {
				ventana.cargarPanel(ePartidas);
			} else if (ev.getActionCommand().equals("Ver partidas")) {
				ventana.cargarPanel(vPartidas);
			} else if (ev.getActionCommand().equals("Ver partidas Master")) {
				System.out.println("vPartidas Master");
				ventana.cargarPanel(vPartidasMaster);
			} else if (ev.getActionCommand().equals("Login")) {
				ventana.dispose();
				ventana.cargarPanel(home);
				login.hacerVisible();
			} else if (ev.getActionCommand().equals("Salir")) {
				ventana.mostrarMensajeConfirm();
			}
				
		}
	}

}


