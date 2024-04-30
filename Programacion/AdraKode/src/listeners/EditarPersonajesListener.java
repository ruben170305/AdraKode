package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.*;

public class EditarPersonajesListener implements ActionListener {
    
    private Menu ventana;
    private Home home;
    
    // Constructor del Listener
    public EditarPersonajesListener ( Menu ventana, Home home ) {
        this.ventana = ventana;
        this.home    = home;
    }

    // Listener del botón de editar personaje
    @Override
    public void actionPerformed( ActionEvent ae ) {
        if ( ae.getActionCommand().equals( "" ) ) {
            this.ventana.cargarPanel( home );
            this.home.hacerVisible();
        } else if( ae.getActionCommand().equals( "GUARDAR" ) ) {
            this.ventana.cargarPanel( home );
            this.home.hacerVisible();
        }
    }

}
