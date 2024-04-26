package views;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.SystemColor;

import javax.swing.border.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaPrincipalLogin extends JPanel {

	private JLabel lblTitulo, usuarioIcono, contrasenaIcono, logoIcono;
	private JTextField usuario;
	private JPasswordField contraseña ;
	private JCheckBox administrador;
	private JButton entrar;


	//private VentanaPrincipalLogin listener;
	public VentanaPrincipalLogin () {
		setBackground(new Color(242, 242, 242));
		//listener = new VentanaPrincipalLogin(login);
		inicializarComponentes();
		hacerVisible();
		
	}
	private void inicializarComponentes () {
		//Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(800, 600);
		//setLocation(null);
		
		
		/* COMPONENTES */
		
		//Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));
		
		// Titulo
        lblTitulo = new JLabel("INICIAR SESIÓN");
        lblTitulo.setForeground(new Color(29, 29, 27));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 25));
        lblTitulo.setBounds(269, 32, 261, 45);
        add(lblTitulo);

        // Separador
        JSeparator separator = new JSeparator();
        separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        separator.setPreferredSize(new Dimension(0, 3));
        separator.setMaximumSize(new Dimension(32778, 32767));
        separator.setBackground(new Color(29, 29, 27));
        separator.setForeground(new Color(29, 29, 27));
        separator.setBounds(337, 88, 125, 3);
        add(separator);

		//Logo
	    logoIcono = new JLabel();
		logoIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/imagenLogin.png")));
		logoIcono.setBounds(338,131,124,142);
		add(logoIcono);
		
		//Campo usuario
		usuario = new JTextField();
		usuario.setBackground(new Color(242, 242, 242));
		usuario.setFont(new Font("Open Sans", Font.PLAIN, 11));
		usuario.setForeground(new Color(29, 29, 27));
	    usuario.setBounds(314, 271, 200, 35); 
	    usuario.setBorder(border);
	    add(usuario);
		
	    //Icono usuario
	    usuarioIcono = new JLabel();
	    usuarioIcono.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoUsuario.png")));
		usuarioIcono.setBounds(270,271,34,45);
		add(usuarioIcono);
		
	    //Campo contraseña
		contraseña = new JPasswordField();
		contraseña.setToolTipText("");
		contraseña.setFont(new Font("Open Sans", Font.PLAIN, 11));
		contraseña.setForeground(new Color(29, 29, 27));
		contraseña.setBackground(new Color(242, 242, 242));
		contraseña.setEchoChar('\u2022'); // Establece el carácter de ocultación 
		contraseña.setBounds(314,327,200,35);
	    contraseña.setBorder(border);
		add(contraseña);
		
	    //Icono contraseña
	    contrasenaIcono = new JLabel();
	    contrasenaIcono.setHorizontalAlignment(SwingConstants.CENTER);
		contrasenaIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoContraseña.png")));
		contrasenaIcono.setBounds(268,327,34,45);
		add(contrasenaIcono);
		
		//Checkbox admin
		administrador = new JCheckBox("Game Master");
		administrador.setForeground(new Color(29, 29, 27));
		administrador.setFont(new Font("Open Sans", Font.BOLD, 11));
		administrador.setBounds(351,391,97,20);
		add (administrador);
		
		//Botón entrar
		entrar = new JButton("ENTRAR");
		entrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		entrar.setForeground(new Color(242, 242, 242));
		entrar.setBackground(new Color(29, 161, 242));
		entrar.setOpaque(true);
        entrar.setBorderPainted(false);
		entrar.setBounds(295,475,209,50);
		add(entrar);
		

	}
	public void hacerVisible () {
		setVisible (true);
	}
}
