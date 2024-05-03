package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import views.Menu;
import views.VentanaPrincipalLogin;

public class LoginListener implements ActionListener {
	
	private VentanaPrincipalLogin login;
	private Menu menu;
	private String estado = "ejecutando";
	
	public LoginListener(VentanaPrincipalLogin login, Menu menu) {
		this.login = login;
		this.menu = menu;
	
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
                boolean esGameMaster = checkBox.isSelected();
                menu.setGameMaster(esGameMaster);
                menu.crearMenu();
                System.out.println("¿Es game master? " + esGameMaster);
                menu.repaint();
            }
        } else if (source instanceof JButton) {
            if (e.getActionCommand().equals("ENTRAR")) {
                login.dispose();
                menu.dispose();
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
