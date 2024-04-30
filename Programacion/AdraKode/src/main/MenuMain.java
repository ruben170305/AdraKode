package main;

import java.awt.EventQueue;

import listeners.LoginListener;
import listeners.PMenuListener;
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
				
				PMenuListener listener = 
						new PMenuListener(ventanaPpal, ePersonaje,
								cPersonaje, vPersonajes,
								cPartidas, ePartidas, vPartidas, login);
				LoginListener loginlistener = new LoginListener(login, ventanaPpal);
			
				ventanaPpal.setListener(listener);
				login.setListener(loginlistener);
				login.hacerVisible();
				ventanaPpal.cargarPanel(home);
				
			}
		});

	}
}
