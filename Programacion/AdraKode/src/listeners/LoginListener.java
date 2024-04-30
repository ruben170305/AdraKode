package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.Menu;
import views.VentanaPrincipalLogin;

public class LoginListener implements ActionListener {
	
	private VentanaPrincipalLogin login;
	private Menu menu;
	
	public LoginListener(VentanaPrincipalLogin login, Menu menu) {
		this.login = login;
		this.menu = menu;
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			login.dispose();
			menu.hacerVisible();
		}

}
