package main;

import java.awt.EventQueue;

import views.*;
import listeners.*;
import model.Usuario;

public class MenuMain {

	// Inicializamos la ventana principal y la ventana del Home
	static Menu menu = new Menu( "Adrakode", false );
	static Home home = new Home();
	static Listener list = new Listener( menu, home );
	static Usuario user = new Usuario();

	// Instanciamos las ventanas junto a sus listeners
	static CrearPartida cPartida 			 = new CrearPartida();
	static EditarPartida ePartida 			 = new EditarPartida();
	static VerPartidasMaster vPartidasMaster = new VerPartidasMaster();

	static VerPartidaListener ver_partidas_listener = new VerPartidaListener( menu, home );
	static VerPartidas vPartidas = new VerPartidas( ver_partidas_listener) ;
	
	static EditarPersonajesListener editar_personaje_listener = new EditarPersonajesListener( menu, home );
	static EditarPersonaje ePersonaje = new EditarPersonaje();

	static VerPersonajesListener ver_personajes_listener = new VerPersonajesListener( ePersonaje, menu, home, user );
	static VerPersonajes vPersonajes = new VerPersonajes( ver_personajes_listener );

	static CrearPersonaje cPersonaje = new CrearPersonaje(menu);
	static CrearPersonajeListener crear_personaje_listener = new CrearPersonajeListener( menu, home, cPersonaje, user );

	static VentanaPrincipalLogin login = new VentanaPrincipalLogin(user);

	public static void main( String[] args ) {
		EventQueue.invokeLater( new Runnable() {
			
			@Override
			public void run() {
				//Arrancamos la vista login para comprobar si es game master o no
				LoginListener loginlistener = new LoginListener(login);
				login.setListener( loginlistener );

				//Hacemos visible el login y cargamos el panel home a la ventana principal para que cuando se muestre este preparada
				login.make_visible();
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

		System.out.println( esMaster );

		// Creamos una ventana y cargamos el panel
		String title_window = ( esMaster ) ? "Adrakode Master" : "Adrakode";
		menu.setGameMaster( esMaster );
		menu.setTitle( title_window );
		cPersonaje.inicializarComponentes();
		menu.crearMenu();
		menu.cargarPanel( home );
		
		//Creamos el listener del menu
		PMenuListener listener = new PMenuListener(
				menu
			, 	home
			, 	ePersonaje
			,	cPersonaje
			, 	vPersonajes
			,	cPartida
			, 	ePartida
			, 	vPartidas
			, 	vPartidasMaster
			, 	login
		);
		
		if( esMaster ) {
			CrearPartidaListener crear_partida_listener = new CrearPartidaListener( menu, home );
			EditarPartidaListener editar_partida_listener = new EditarPartidaListener( menu, home );
			VerPartidaMasterListener ver_partidas_master_listener = new VerPartidaMasterListener( ePartida, menu, home );

			// Vinculación de listeners
			cPartida.setListener( crear_partida_listener );
			ePartida.setListener( editar_partida_listener );
			vPartidasMaster.setListener( ver_partidas_master_listener );
		} else {

			// Vinculación de listeners
			VerPartidaListener ver_partidas_listener = new VerPartidaListener( menu, home );
			vPartidas.setListener( ver_partidas_listener );
		}

		// Vinculación de Listeners
		cPersonaje.setListener(crear_personaje_listener);
		ePersonaje.setListener( editar_personaje_listener );
		vPersonajes.setListener();

		// Vinculamos el listener de la ventana principal a su ventana
		menu.setListener( listener );
		
		return menu;
	}
}