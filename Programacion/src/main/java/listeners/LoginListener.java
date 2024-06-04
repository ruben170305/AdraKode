package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import views.*;
import main.MenuMain;
import model.Usuario;
import views.Menu;
import views.RegistroMiembro;
import views.VentanaPrincipalLogin;

public class LoginListener implements ActionListener {
	
	private VentanaPrincipalLogin login;
	private RegistroMiembro registro;
	private Menu menu;
	private Usuario user;
	private String status = "ejecutando";
	private boolean esMaster;
	
	public LoginListener( VentanaPrincipalLogin login, RegistroMiembro registro ) {
		this.login = login;
		this.registro = registro;
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
            if ( "gamemaster".equals( checkBox.getName() ) )
                esMaster = checkBox.isSelected();
				
		// Si se ordena iniciar sesión, comparamos valores
        } else if ( source instanceof JButton && e.getActionCommand().equals( "ENTRAR" ) ) {

			try {

				// Capturamos los valores de los inputs
				user = login.getUser();
				String user_name = login.getUsuario().getText();
				String password = login.getContraseña().getText();

				// Si el usuario y la constraseña son correctos, continuamos
				if ( user.login( user_name, password, user ) ) {
					
					login.dispose();

					// Llamamos al metodo arranque para que cree la ventana menu y nos devuelva esa ventana
					// Posteriormente, mostramos la ventana
					this.menu = MenuMain.boot( esMaster );
					menu.make_visible();
				} else {
					login.mostrarMensajeErrorLogin();
				}
				
			} catch ( SQLException sqle ) {
				sqle.printStackTrace();
			}
        } else if ( source instanceof JButton && e.getActionCommand().equals( "CREAR CUENTA" ) ) {
        	login.dispose();
        	registro.make_visible();
        	
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

	public String getStatus() {
		return status;
	}
}
