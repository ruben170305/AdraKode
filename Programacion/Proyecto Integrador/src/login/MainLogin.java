package login;

public class MainLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		java.awt.EventQueue.invokeLater(new Runnable() {
			//método para poder inicializar el programa 
			public void run() {
				// TODO Auto-generated method stub
				// AQUI DENTRO es donde vamos a ejecutar nuestra ventana
				VentanaPrincipalLogin login = new VentanaPrincipalLogin("Iniciar sesión");
				login.hacerVisible();
			}

		}

		);
	}

}
