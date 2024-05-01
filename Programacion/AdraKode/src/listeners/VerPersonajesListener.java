package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.*;

public class VerPersonajesListener implements ActionListener {

    private Menu ventana;
    private EditarPersonaje ep;
    private Home home;
    
    // Constructor del Listener
    public VerPersonajesListener ( EditarPersonaje ep, Menu ventana, Home home ) {
        this.ep      = ep;
        this.ventana = ventana;
        this.home    = home;
    }

    /**
     * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo del boton
     */
    @Override
    public void actionPerformed( ActionEvent ae ) {
        if ( ae.getActionCommand().equals( "" ) ) {
            this.ventana.cargarPanel( ep );
            //this.ep.hacerVisible();
        } else if( ae.getActionCommand().equals( "SELECCIONAR" ) ) {
            this.ventana.cargarPanel( home );
            //this.ep.hacerVisible();
        } else {
            this.ventana.cargarPanel( home );
            //this.ep.hacerVisible();
        }
    }
}