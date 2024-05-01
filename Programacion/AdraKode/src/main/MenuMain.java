package main;

import java.awt.EventQueue;

import listeners.EditarPersonajesListener;
import listeners.LoginListener;
import listeners.PMenuListener;
import listeners.VerPersonajesListener;
import views.*;

public class MenuMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				//Arrancamos todas las vistas del programa
				views.Menu ventanaPpal = new views.Menu("AdraKode");
				CrearPersonaje cPersonaje = new CrearPersonaje();
				EditarPersonaje ePersonaje = new EditarPersonaje();
				VerPersonajes vPersonajes = new VerPersonajes();
				CrearPartida cPartidas = new CrearPartida();
				EditarPartida ePartidas = new EditarPartida();
				ListaPartidas vPartidas = new ListaPartidas();
				VentanaPrincipalLogin login = new VentanaPrincipalLogin();
				Home home = new Home();
				Menu menu = new Menu( "Menú" );
				
				//Creamos el listener del menu
				PMenuListener listener = 
						new PMenuListener(ventanaPpal, home, ePersonaje,
								cPersonaje, vPersonajes,
								cPartidas, ePartidas, vPartidas, login);
				//Creamos el listener del login
				LoginListener loginlistener = new LoginListener(login, ventanaPpal);
				//Creamos el listener de VerPersonajes
				VerPersonajesListener ver_personajes_listener = new VerPersonajesListener( ePersonaje, ventanaPpal, home );
				//Creamos el listener de EditarPersonajes
				EditarPersonajesListener editar_personajes_listener = new EditarPersonajesListener( ventanaPpal, home );

				//Asignamos los listeners
				ventanaPpal.setListener(listener);
				login.setListener(loginlistener);
				vPersonajes.setListener( ver_personajes_listener );
				ePersonaje.setListener( editar_personajes_listener );
				//Hacemos visible el login y cargamos el panel home a la ventana principal para que cuando se muestre este preparada
				login.hacerVisible();
				ventanaPpal.cargarPanel(home);
				
			}
		});

	}
}
