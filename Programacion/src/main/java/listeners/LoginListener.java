package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import main.MenuMain;
import model.Usuario;
import views.Menu;
import views.VentanaPrincipalLogin;

public class LoginListener implements ActionListener {
	
	private VentanaPrincipalLogin login;
	private Menu menu;
	private Usuario user;
	private String estado = "ejecutando";
	private boolean esMaster;
	
	public LoginListener( VentanaPrincipalLogin login ) {
		this.login = login;
	}
	
	@Override
	/**
	 * Metodo del listener que si el login es correcto cerramos la ventana de login y mostramos la ventana principal (Menu)
	 */
	public void actionPerformed( ActionEvent e ) {
		Object source = e.getSource();
        
        if ( source instanceof JCheckBox ) {

			// Capturamos el valor del Checkbox
            JCheckBox checkBox = ( JCheckBox ) source;
            if ("gamemaster".equals(checkBox.getName()))
                esMaster = checkBox.isSelected();
				
        } else if ( source instanceof JButton ) {

			// Si se ordena iniciar sesión, comparamos valores
            if ( e.getActionCommand().equals( "ENTRAR" ) ) {
                try {

					// Si el usuario y la constraseña son correctos, continuamos
                	user = login.getUser();
					if ( user.consultaLogin( login.getUsuario().getText(), login.getContraseña().getText() ) ) {
						login.dispose();

		                // Llamamos al metodo arranque para que cree la ventana menu y nos devuelva esa ventana
						// Posteriormente, mostramos la ventana
		                this.menu = MenuMain.arranque( esMaster );
		                menu.make_visible();
					} else {
						login.mostrarMensajeErrorLogin();
					}
				} catch ( SQLException sqle ) {
					sqle.printStackTrace();
				}
            }
        }
			
	}

	public VentanaPrincipalLogin getLogin() {
		return login;
	}

	public void setLogin( VentanaPrincipalLogin login ) {
		this.login = login;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu( Menu menu ) {
		this.menu = menu;
	}

	public String getEstado() {
		return estado;
	}
}
