package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.MenuMain;
import views.Menu;
import views.VentanaPrincipalLogin;

public class LoginListener implements ActionListener {
	
	private VentanaPrincipalLogin login;
	private Menu menu;
	private String estado = "ejecutando";
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
                login.dispose();
                this.menu = MenuMain.arranque(esMaster);
                menu.hacerVisible();
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
