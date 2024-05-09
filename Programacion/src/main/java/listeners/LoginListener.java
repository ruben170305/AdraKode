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
	private String estado = "ejecutando";
	private Usuario user;
	private boolean esMaster;
	
	public LoginListener(VentanaPrincipalLogin login) {
		this.login = login;
	
	}
	
	@Override
	/**
	 * Metodo del listener que si el login es correcto cerramos la ventana de login y mostramos la ventana principal (Menu)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
        
        if (source instanceof JCheckBox) {
            JCheckBox checkBox = (JCheckBox) source;
            if ("gamemaster".equals(checkBox.getName())) {
                esMaster = checkBox.isSelected();
                System.out.println("¿Es game master? " + esMaster);
            }
        } else if (source instanceof JButton) {
            if (e.getActionCommand().equals("ENTRAR")) {
                try {
                	user = new Usuario(login.getUsuario().getText(), login.getContraseña().getText());
					if (user.consultaLogin(login.getUsuario().toString())) {
						login.dispose();
		                //Llamamos al metodo arranque para que cree la ventana menu y nos devuelva esa ventana y poder mostrarla
		                this.menu = MenuMain.arranque(esMaster);
		                menu.hacerVisible();
					} else {
						login.mostrarMensajeErrorLogin();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }
			
		}

	public VentanaPrincipalLogin getLogin() {
		return login;
	}

	public void setLogin(VentanaPrincipalLogin login) {
		this.login = login;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getEstado() {
		return estado;
	}
	

	
}
