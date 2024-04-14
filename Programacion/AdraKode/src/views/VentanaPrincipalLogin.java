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

public class VentanaPrincipalLogin extends JPanel {

	private JLabel inicioSesion;
	private JLabel logo;
	private JLabel usuarioIcono;
	private JLabel usuario;
	private JLabel contraseñaIcono;
	private JPasswordField contraseña ;
	private JButton entrar;
	private JCheckBox administrador;
	
	//private VentanaPrincipalLogin listener;
	public VentanaPrincipalLogin (String login) {
		super ();
		//listener = new VentanaPrincipalLogin(login);
		inicializarComponentes ();
		
	}
	private void inicializarComponentes () {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Necesario para poder cerrar la ventana
		setLayout(null);
		
		inicioSesion = new JLabel("INICIAR SESIÓN");
		inicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		inicioSesion.setFont(new Font("Calibri", Font.BOLD, 17));
		inicioSesion.setBounds(215,10,186,45);
		add(inicioSesion);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/logo.jpeg")));
		logo.setBounds(225,46,160,132);
		add(logo);
		
		usuarioIcono = new JLabel("");
		usuarioIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoUsuario.png")));
		usuarioIcono.setBounds(187,176,45,45);
		add(usuarioIcono);
		
		usuario = new JLabel("Usuario");
		usuario.setHorizontalAlignment(SwingConstants.LEFT);
		usuario.setForeground(UIManager.getColor("Button.focus"));
		usuario.setBackground(new Color(0, 0, 0));
		usuario.setFont(new Font("Calibri", Font.PLAIN, 13));
		usuario.setBounds(231,176,186,45);
		add(usuario);
		
		contraseñaIcono = new JLabel("");
		contraseñaIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoContraseña.png")));
		contraseñaIcono.setBounds(187,231,45,50);
		add(contraseñaIcono);
		
		contraseña = new JPasswordField("");
		contraseña.setBackground(new Color(255, 255, 255));
		contraseña.setBounds(231,246,186,35);
		add(contraseña);
		
		entrar = new JButton("ENTRAR");
		entrar.setBackground(new Color(0, 0, 0));
		entrar.setBounds(215,320,186,35);
		add(entrar);
		
		administrador = new JCheckBox("Administrador");
		administrador.setBounds(242,294,132,20);
		add (administrador);
		
		setSize (600,400);
		setLocation(null);
	}
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	public void hacerVisible () {
		setVisible (true);
	}
}
