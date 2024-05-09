package main;

import java.awt.EventQueue;

import listeners.*;
import views.*;

public class MenuMain {

	// Inicializamos todas las vistas
	static Menu ventanaPpal;

	// Inicializamos el Home y arrancamos la aplicación
	static Home home = new Home();

	static VerPartidaListener vPartidaListener = new VerPartidaListener(home, ventanaPpal);

	static CrearPersonaje cPersonaje 		 = new CrearPersonaje();
	static EditarPersonaje ePersonaje 		 = new EditarPersonaje();
	static VerPersonajes vPersonajes 		 = new VerPersonajes();
	static CrearPartida cPartidas 			 = new CrearPartida();
	static EditarPartida ePartidas 			 = new EditarPartida();
	static VerPartidas vPartidas 			 = new VerPartidas( vPartidaListener );
	static VerPartidasMaster vPartidasMaster = new VerPartidasMaster();
	static VentanaPrincipalLogin login 		 = new VentanaPrincipalLogin();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				//Arrancamos la vista login para comprobar si es game master o no
				LoginListener loginlistener = new LoginListener(login);
				login.setListener(loginlistener);

				//Hacemos visible el login y cargamos el panel home a la ventana principal para que cuando se muestre este preparada
				login.hacerVisible();
			}
		});
	}

	/**
	 * Método que inicializa la ventana principal (Menu) este se encarga de decir al menu si es game master o no.
	 * Se llama desde el loginlistener para que cuando se cierre el login se ejecuten estas sentencias y se actualice
	 * correctamente el menu
	 * @param esMaster Recibe true or false dependiendo del checkbox de login
	 * @return Devuelve Menu ventanaPpal para asignar todos los listeners a la ventana creada
	 */
	public static Menu arranque( boolean esMaster ) {

		// Creamos una ventana y cargamos el panel
		String title_window = ( esMaster ) ? "Adrakode Master" : "Adrakode";
		ventanaPpal 		= new Menu( title_window, esMaster );
		ventanaPpal.cargarPanel( home );
		
		//Creamos el listener del menu
		PMenuListener listener = new PMenuListener(
				ventanaPpal
			, 	home
			, 	ePersonaje
			,	cPersonaje
			, 	vPersonajes
			,	cPartidas
			, 	ePartidas
			, 	vPartidas
			, 	vPartidasMaster
			, 	login
		);
						
		//Creamos el listener de VerPersonajes
		VerPersonajesListener ver_personajes_listener = new VerPersonajesListener( ePersonaje, ventanaPpal, home );

		//Creamos el listener de EditarPersonajes
		EditarPersonajesListener editar_personajes_listener = new EditarPersonajesListener( ventanaPpal, home );

		if ( esMaster ) {
			CrearPartidaListener cPartidaListener 		= new CrearPartidaListener(home, ventanaPpal);
			EditarPartidaListener ePartidaListener 		= new EditarPartidaListener(home, ventanaPpal);
			VerPartidaMasterListener vPartidaMasterListener			= new VerPartidaMasterListener( home, ventanaPpal, ePartidas );

			vPartidasMaster.setListener( vPartidaMasterListener );
			cPartidas.setListener(cPartidaListener);
			ePartidas.setListener(ePartidaListener);
		} else {
			vPartidas.setListener(vPartidaListener);
		}
		
		
		//Asignamos los listeners
		vPersonajes.setListener( ver_personajes_listener );
		ePersonaje.setListener( editar_personajes_listener );
		ventanaPpal.setListener(listener);
		
		return ventanaPpal;
	}
}