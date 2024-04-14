package views;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class VentanaPrincipalLogin extends JPanel {

	private JLabel inicioSesion, usuarioIcono;
	private JPasswordField contraseña ;
	private JButton entrar;
	private JCheckBox administrador;
	private JTextField usuario;
	
	//private VentanaPrincipalLogin listener;
	public VentanaPrincipalLogin (String login) {
		super ();
		setBackground(new Color(242, 242, 242));
		//listener = new VentanaPrincipalLogin(login);
		inicializarComponentes();
		
	}
	private void inicializarComponentes () {
		
		//Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Añadir operación de cierre de la ventana
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(600, 400);
		setLocation(null);
		
		
		/* COMPONENTES */
		
		//Titulo
		inicioSesion = new JLabel("INICIAR SESIÓN");
		inicioSesion.setForeground(new Color(29, 29, 27));
		inicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		inicioSesion.setFont(new Font("Open Sans", Font.BOLD, 19));
		inicioSesion.setBounds(215,10,186,45);
		add(inicioSesion);
		
		
		
		//Campo usuario
		usuario = new JTextField();
		usuario.setFont(new Font("Open Sans", Font.PLAIN, 11));
		usuario.setForeground(new Color(29, 29, 27));
	    usuario.setBounds(215, 133, 186, 35); 
	    add(usuario);
		
	    
	    //Icono usuario
	    usuarioIcono = new JLabel("");
		usuarioIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoUsuario.png")));
		usuarioIcono.setBounds(175,123,45,45);
		add(usuarioIcono);
	
		
	    //Campo contraseña
		contraseña = new JPasswordField();
		contraseña.setFont(new Font("Open Sans", Font.PLAIN, 11));
		contraseña.setForeground(new Color(29, 29, 27));
		contraseña.setBackground(new Color(255, 255, 255));
		contraseña.setEchoChar('\u2022'); // Establece el carácter de ocultación 
		contraseña.setBounds(215,183,186,35);
		add(contraseña);
		
		//Checkbox admin
		administrador = new JCheckBox("Administrador");
		administrador.setForeground(new Color(29, 29, 27));
		administrador.setFont(new Font("Open Sans", Font.PLAIN, 11));
		administrador.setBounds(251,237,132,20);
		add (administrador);
		
		//Botón entrar
		entrar = new JButton("ENTRAR");
		entrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		entrar.setForeground(new Color(242, 242, 242));
		entrar.setBackground(new Color(29, 161, 242));
		entrar.setOpaque(true);
        entrar.setBorderPainted(false);
		entrar.setBounds(215,287,186,50);
		add(entrar);
		

	}
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	public void hacerVisible () {
		setVisible (true);
	}
}
