package main;

import java.awt.EventQueue;

import listeners.PMenuListener;
import views.CrearPersonaje;
import views.EditarPersonaje;

public class MenuMain {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				views.Menu ventanaPpal = new views.Menu("AdraKode");
				/*CrearPersonaje cPersonaje = new CrearPersonaje("Crear personaje");
				EditarPersonaje ePersonaje = new EditarPersonaje("Editar personaje");*/
				
				PMenuListener listener = 
						new PMenuListener(ventanaPpal);
				
				ventanaPpal.setListener(listener);
				ventanaPpal.hacerVisible();
				
			}
		});

	}
}
