package main;

import java.awt.EventQueue;

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
				
				PMenuListener listener = 
						new PMenuListener(ventanaPpal, ePersonaje,
								cPersonaje, vPersonajes,
								cPartidas, ePartidas, vPartidas);
			
				ventanaPpal.setListener(listener);
				ventanaPpal.hacerVisible();
				ventanaPpal.cargarPanel(login);
				
			}
		});

	}
}
