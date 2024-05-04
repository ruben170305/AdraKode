package main;

import java.awt.EventQueue;

import listeners.CrearPartidaListener;
import listeners.EditarPartidaListener;
import listeners.EditarPersonajesListener;
import listeners.LoginListener;
import listeners.PMenuListener;
import listeners.VerPartidaListener;
import listeners.VerPartidaMasterListener;
import listeners.VerPersonajesListener;
import views.*;

public class MenuMain {
	static Menu ventanaPpal;
	static CrearPersonaje cPersonaje = new CrearPersonaje();
	static EditarPersonaje ePersonaje = new EditarPersonaje();
	static VerPersonajes vPersonajes = new VerPersonajes();
	static CrearPartida cPartidas = new CrearPartida();
	static EditarPartida ePartidas = new EditarPartida();
	static VerPartidas vPartidas = new VerPartidas();
	static VerPartidasMaster vPartidasMaster = new VerPartidasMaster();
	static VentanaPrincipalLogin login = new VentanaPrincipalLogin();
	static Home home = new Home();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				//Arrancamos todas las vistas del programa
				

				//Asignamos los listeners
				
				LoginListener loginlistener = new LoginListener(login);
				login.setListener(loginlistener);
				//Hacemos visible el login y cargamos el panel home a la ventana principal para que cuando se muestre este preparada
				login.hacerVisible();
				
				
			}
		});

	}
	public static Menu arranque(boolean esMaster) {
		if (esMaster) {
			ventanaPpal = new Menu("AdraKode Master", esMaster);
		} else {
			ventanaPpal = new Menu("AdraKode", esMaster);
		}
		
		//Creamos el listener del menu
		PMenuListener listener = 
				new PMenuListener(ventanaPpal, home, ePersonaje,
						cPersonaje, vPersonajes,
						cPartidas, ePartidas, vPartidas, vPartidasMaster, login);
		//Creamos el listener del login
		//Creamos el listener de VerPersonajes
		VerPersonajesListener ver_personajes_listener = new VerPersonajesListener( ePersonaje, ventanaPpal, home );
		//Creamos el listener de EditarPersonajes
		EditarPersonajesListener editar_personajes_listener = new EditarPersonajesListener( ventanaPpal, home );
		if (esMaster) {
			VerPartidaMasterListener vpartidaMasterLis = new VerPartidaMasterListener(home, ventanaPpal, ePartidas);
			vPartidasMaster.setListener(vpartidaMasterLis);
			CrearPartidaListener cPartidaListener = new CrearPartidaListener(home, ventanaPpal);
			EditarPartidaListener ePartidaListener = new EditarPartidaListener(home, ventanaPpal);
			cPartidas.setListener(cPartidaListener);
			ePartidas.setListener(ePartidaListener);
		} else {
			VerPartidaListener vpartidaListener = new VerPartidaListener(home, ventanaPpal);
			vPartidas.setListener(vpartidaListener);
		}
		
		
		//Asignamos los listeners
		vPersonajes.setListener( ver_personajes_listener );
		ePersonaje.setListener( editar_personajes_listener );
		ventanaPpal.setListener(listener);
		
		return ventanaPpal;
	}
}