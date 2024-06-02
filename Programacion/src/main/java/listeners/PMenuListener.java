package listeners;

import views.*;
import java.awt.event.*;
import javax.swing.JMenuItem;

public class PMenuListener implements ActionListener {
	
	private Menu ventana;
	private Home home;
	private CrearPersonaje cPersonaje;
	private EditarPersonaje ePersonaje;
	private VentanaPrincipalLogin login;
	private VerPersonajes vPersonajes;
	private CrearPartida cPartida;
	private EditarPartida ePartida;
	private VerPartidas vPartidas;
	private VerPartidasMaster vPartidasMaster;

	public PMenuListener(
			Menu ventana
		, 	Home home
		, 	CrearPersonaje cPersonaje
		, 	EditarPersonaje ePersonaje
		, 	VerPersonajes vPersonajes
		,	CrearPartida cPartida
		, 	EditarPartida ePartida
		, 	VerPartidas vPartidas
		, 	VerPartidasMaster vPartidasMaster
		, 	VentanaPrincipalLogin login
		) {
			this.ventana 			= ventana;
			this.home 				= home;
			this.cPersonaje 		= cPersonaje;
			this.ePersonaje 		= ePersonaje;
			this.vPersonajes 		= vPersonajes;
			this.cPartida 			= cPartida;
			this.ePartida 			= ePartida;
			this.vPartidas 			= vPartidas;
			this.vPartidasMaster 	= vPartidasMaster;
			this.login 				= login;
		}	

	@Override
	/**
	 * Metodo del listener que cambia de ventana según la opcion que clickemos en el menu
	 */
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getSource() instanceof JMenuItem ) {

			// Dependiendo de la instrucción, mostramos una vista u otra
			switch ( ae.getActionCommand() ) {
				case "Nuevo personaje":
					ventana.cargarPanel( cPersonaje );
					break;

				case "Modificar personaje":
					ventana.cargarPanel( ePersonaje );
					break;

				case "Ver personajes":
					vPersonajes.getListener().cargarDatosEnComboBox();
					ventana.cargarPanel( vPersonajes );
					break;

				case "Crear partida":
					ventana.cargarPanel( cPartida );
					break;

				case "Ver partidas":
					ventana.cargarPanel( vPartidas );
					break;

				case "Ver partidas Master":
					ventana.cargarPanel( vPartidasMaster );
					break;

				case "Login":
					ventana.dispose();
					ventana.cargarPanel( home );
					login.make_visible();
					break;

				case "Salir":
					ventana.mostrarMensajeConfirm();
					break;

				default:
					break;

			}
		}
	}

	public Menu getVentana() {
		return ventana;
	}

	public void setVentana(Menu ventana) {
		this.ventana = ventana;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public CrearPersonaje getCPersonaje() {
		return cPersonaje;
	}

	public void setCPersonaje(CrearPersonaje cPersonaje) {
		this.cPersonaje = cPersonaje;
	}

	public EditarPersonaje getEPersonaje() {
		return ePersonaje;
	}

	public void setEPersonaje(EditarPersonaje ePersonaje) {
		this.ePersonaje = ePersonaje;
	}

	public VentanaPrincipalLogin getLogin() {
		return login;
	}

	public void setLogin(VentanaPrincipalLogin login) {
		this.login = login;
	}

	public VerPersonajes getVPersonajes() {
		return vPersonajes;
	}

	public void setVPersonajes(VerPersonajes vPersonajes) {
		this.vPersonajes = vPersonajes;
	}

	public CrearPartida getCPartida() {
		return cPartida;
	}

	public void setCPartida(CrearPartida cPartida) {
		this.cPartida = cPartida;
	}

	public EditarPartida getEPartida() {
		return ePartida;
	}

	public void setEPartida(EditarPartida ePartida) {
		this.ePartida = ePartida;
	}

	public VerPartidas getVPartidas() {
		return vPartidas;
	}

	public void setVPartidas(VerPartidas vPartidas) {
		this.vPartidas = vPartidas;
	}

	public VerPartidasMaster getVPartidasMaster() {
		return vPartidasMaster;
	}

	public void setVPartidasMaster(VerPartidasMaster vPartidasMaster) {
		this.vPartidasMaster = vPartidasMaster;
	}

}