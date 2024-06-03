package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;

import main.MenuMain;
import model.Model;
import model.Usuario;
import views.Menu;
import views.RegistroMiembro;
import views.VentanaPrincipalLogin;

public class RegistroListener implements ActionListener {
	
	private RegistroMiembro registro;
	private VentanaPrincipalLogin login;
	private Menu menu;
	private Usuario user;
	private String status = "ejecutando";
	
	public RegistroListener( RegistroMiembro registro, VentanaPrincipalLogin login ) {
		this.registro = registro;
		this.login = login;
	}
	
	@Override
	/**
	 * Metodo del listener que si el login es correcto cerramos la ventana de login y mostramos la ventana principal (Menu)
	 */
	public void actionPerformed( ActionEvent e ) {
		Object source = e.getSource();
        
        if ( source instanceof JButton && e.getActionCommand().equals( "CREAR CUENTA" ) ) {

			try {

				// Capturamos los valores de los inputs
				user = registro.getUser();
				String user_name = registro.getUsuario().getText();
				String password = registro.getContraseña().getText();
				int expediente = Integer.parseInt(registro.getExpediente().getText());
				String estudios = registro.getEstudios().getText();
				
				Model mysql = new Model();
				mysql.registro_usuario(user_name, password, expediente, estudios);
				
			} catch ( Exception sqle ) {
				sqle.printStackTrace();
			}
			registro.dispose();
			login.make_visible();
        }
	}

	public RegistroMiembro getLogin() {
		return registro;
	}

	public void setLogin( RegistroMiembro login ) {
		this.registro = login;
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
