package main;

import java.awt.EventQueue;

import listeners.LoginListener;
import listeners.PMenuListener;
import listeners.VerPersonajesListener;
import views.*;

public class MenuMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
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
				
				PMenuListener listener = 
						new PMenuListener(ventanaPpal, home, ePersonaje,
								cPersonaje, vPersonajes,
								cPartidas, ePartidas, vPartidas, login);
				LoginListener loginlistener = new LoginListener(login, ventanaPpal);
				VerPersonajesListener ver_personajes_listener = new VerPersonajesListener( ePersonaje, ventanaPpal, home );
			
				ventanaPpal.setListener(listener);
				login.setListener(loginlistener);
				login.hacerVisible();
				ventanaPpal.cargarPanel(home);
				vPersonajes.setListener( ver_personajes_listener );
				
			}
		});

	}
}
