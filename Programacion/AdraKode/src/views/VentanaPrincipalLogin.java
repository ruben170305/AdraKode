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
	private JLabel usuarioIcono;
	private JLabel usuario;
	private JLabel logo;
	private JLabel contraseñaIcono;
	private JPasswordField contraseña ;
	private JButton entrar;
	private JCheckBox administrador;
	private ImageIcon imgLogo;
	
	//private VentanaPrincipalLogin listener;
	public VentanaPrincipalLogin (String login) {
		super ();
		setBackground(new Color(242, 242, 242));
		//listener = new VentanaPrincipalLogin(login);
		inicializarComponentes ();
		
	}
	private void inicializarComponentes () {
		
		//Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e){
			e.printStackTrace();
		}

		//Añadir operación de cierre de la ventana
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(600, 400);
		
		
		/* COMPONENTES */
		
		//Titulo
		inicioSesion = new JLabel("INICIAR SESIÓN");
		inicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		inicioSesion.setFont(new Font("Open Sans", Font.BOLD, 17));
		inicioSesion.setBounds(215,10,186,45);
		add(inicioSesion);
		
		//Logo
		imgLogo = new ImageIcon("/img/logo.png"); // Cambia la ruta
		logo = new JLabel(new ImageIcon("D:\\Universidad\\1º\\Proyecto Integrador\\AdraKode\\Programacion\\AdraKode\\src\\img\\logo.png"));
		logo.setBounds(39,89,551,433);
		add(logo);
		
		//Icono usuario
		usuarioIcono = new JLabel("");
		usuarioIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoUsuario.png")));
		usuarioIcono.setBounds(116,133,45,45);
		add(usuarioIcono);
		
		usuario = new JLabel("Usuario");
		usuario.setHorizontalAlignment(SwingConstants.LEFT);
		usuario.setForeground(UIManager.getColor("Button.focus"));
		usuario.setBackground(new Color(0, 0, 0));
		usuario.setFont(new Font("Calibri", Font.PLAIN, 13));
		usuario.setBounds(171,114,64,45);
		add(usuario);
		
		contraseñaIcono = new JLabel("");
		contraseñaIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoContraseña.png")));
		contraseñaIcono.setBounds(197,163,45,50);
		add(contraseñaIcono);
		
		contraseña = new JPasswordField("");
		contraseña.setBackground(new Color(255, 255, 255));
		contraseña.setBounds(215,117,186,35);
		add(contraseña);
		
		entrar = new JButton("ENTRAR");
		entrar.setFont(new Font("Oxygen", Font.BOLD, 11));
		entrar.setForeground(new Color(242, 242, 242));
		entrar.setBackground(new Color(29, 161, 242));
		entrar.setOpaque(true);
        entrar.setBorderPainted(false);
		entrar.setBounds(215,299,200,50);
		add(entrar);
		
		administrador = new JCheckBox("Administrador");
		administrador.setFont(new Font("Open Sans", Font.PLAIN, 11));
		administrador.setBounds(252,258,132,20);
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
