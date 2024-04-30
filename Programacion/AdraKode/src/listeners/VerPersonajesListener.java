    package listeners;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import javax.swing.JMenuItem;

    import views.EditarPersonaje;
    import views.VerPersonajes;
    import views.Menu;

    public class VerPersonajesListener implements ActionListener {

        private Menu ventana;
        private EditarPersonaje ep;
        private VerPersonajes vp;
        
        // Constructor del Listener
        public VerPersonajesListener ( VerPersonajes vp, EditarPersonaje ep, Menu ventana ) {
            this.vp      = vp;
            this.ep      = ep;
            this.ventana = ventana;
        }

        @Override
        public void actionPerformed( ActionEvent ae ) {
            if ( ae.getActionCommand().equals( "ep" ) ) {
                System.out.println( this.ventana );
                this.ventana.dispose();
                this.ventana.cargarPanel( ep );
                this.ep.hacerVisible();
            }
        }
    }