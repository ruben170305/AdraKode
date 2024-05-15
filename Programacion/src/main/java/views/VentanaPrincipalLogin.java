package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import listeners.LoginListener;
import model.Usuario;

import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

public class VentanaPrincipalLogin extends JFrame {

	private JLabel lblTitulo, usuarioIcono, contrasenaIcono, logoIcono;
	private JTextField usuario;
	private JPasswordField contraseña;
	private JCheckBox administrador;
	private JButton entrar;
	private Usuario user;
	//private LoginListener listener;

	// private VentanaPrincipalLogin listener;
	public VentanaPrincipalLogin(Usuario user) {
		super("Login AdraKode");
		setBackground(new Color(242, 242, 242));
		this.user=user;
		// listener = new VentanaPrincipalLogin(login);
		setIcon();
		initialize_components();
		make_visible();

	}

	public void initialize_components() {
		// Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// layout absoluto
		getContentPane().setLayout(null);

		// Se obtienen las dimensiones en pixels de la pantalla.
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = new Dimension(800, 600);
		// Una cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

		// Tamaño y posicion de ventana
		setSize(800, 600);
		// setLocation(null);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Llamar al método para mostrar la notificación
            	mostrarMensajeConfirm();
            }
        });
		
		/* COMPONENTES */

		// Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));

		// Titulo
		lblTitulo = new JLabel("INICIAR SESIÓN");
		lblTitulo.setForeground(new Color(29, 29, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblTitulo.setBounds(239, 32, 305, 45);
		getContentPane().add(lblTitulo);

		// Separador
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator.setPreferredSize(new Dimension(0, 3));
		separator.setMaximumSize(new Dimension(32778, 32767));
		separator.setBackground(new Color(29, 29, 27));
		separator.setForeground(new Color(29, 29, 27));
		separator.setBounds(337, 88, 125, 3);
		getContentPane().add(separator);

		// Logo
		logoIcono = new JLabel();
		logoIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/imagenLogin.png")));
		logoIcono.setBounds(338, 131, 124, 142);
		getContentPane().add(logoIcono);

		// Campo usuario
		usuario = new JTextField();
		usuario.setBackground(new Color(242, 242, 242));
		usuario.setFont(new Font("Open Sans", Font.PLAIN, 11));
		usuario.setForeground(new Color(29, 29, 27));
		usuario.setBounds(315, 271, 205, 35);
		usuario.setBorder(border);
		getContentPane().add(usuario);

		// Icono usuario
		usuarioIcono = new JLabel();
		usuarioIcono.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoUsuario.png")));
		usuarioIcono.setBounds(276, 271, 34, 45);
		getContentPane().add(usuarioIcono);

		// Campo contraseña
		contraseña = new JPasswordField();
		contraseña.setToolTipText("");
		contraseña.setFont(new Font("Open Sans", Font.PLAIN, 11));
		contraseña.setForeground(new Color(29, 29, 27));
		contraseña.setBackground(new Color(242, 242, 242));
		contraseña.setEchoChar('\u2022'); // Establece el carácter de ocultación
		contraseña.setBounds(315, 327, 205, 35);
		contraseña.setBorder(border);
		getContentPane().add(contraseña);

		// Icono contraseña
		contrasenaIcono = new JLabel();
		contrasenaIcono.setHorizontalAlignment(SwingConstants.CENTER);
		contrasenaIcono.setIcon(new ImageIcon(VentanaPrincipalLogin.class.getResource("/img/IconoContraseña.png")));
		contrasenaIcono.setBounds(274, 327, 34, 45);
		getContentPane().add(contrasenaIcono);

		// Checkbox admin
		administrador = new JCheckBox("Game Master");
		administrador.setName("gamemaster");
		administrador.setHorizontalAlignment(SwingConstants.CENTER);
		administrador.setForeground(new Color(29, 29, 27));
		administrador.setFont(new Font("Open Sans", Font.BOLD, 12));
		administrador.setBounds(297, 391, 189, 20);
		getContentPane().add(administrador);
		

		// Botón entrar
		entrar = new JButton("ENTRAR");
		entrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		entrar.setForeground(new Color(242, 242, 242));
		entrar.setBackground(new Color(29, 161, 242));
		entrar.setOpaque(true);
		entrar.setBorderPainted(false);
		entrar.setBounds(295, 475, 209, 50);
		getContentPane().add(entrar);

	}

	/**
	 * Método que asigna el listener
	 * @param listener Recibe el listener que quieres asignar
	 */
	public void setListener(LoginListener listener) {
		entrar.addActionListener(listener);
		administrador.addActionListener(listener);
	}

	/**
	 * Metodo que muestra la confirmacion al salir
	 */
	public void mostrarMensajeConfirm() {
		int opcion = JOptionPane.showConfirmDialog(this, 
				"¿Seguro que desea abandonar la aplicación?", 
				"Confirmación de salida",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		} 
		
	}
	
	/**
	 * Metodo que cambia el icono de la esquina y de la barra de tareas
	 */
	private void setIcon() {
        try {
        	InputStream iconStream = getClass().getResourceAsStream("/img/iconoLogo2.png");
            Image icon = ImageIO.read(iconStream);
            setIconImage(icon);
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public boolean mostrarMensajeErrorLogin() {
		int opcion = JOptionPane.showConfirmDialog(this, 
				"Usuario o contraseña incorrecto", 
				"Error login",
				JOptionPane.CLOSED_OPTION, 
				JOptionPane.ERROR_MESSAGE);
		
		if (opcion == JOptionPane.CLOSED_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Metodo que hace visible la ventana (JFrame)
	 */
	public void make_visible() {
		setVisible(true);
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public JLabel getUsuarioIcono() {
		return usuarioIcono;
	}

	public JLabel getContrasenaIcono() {
		return contrasenaIcono;
	}

	public JLabel getLogoIcono() {
		return logoIcono;
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public JPasswordField getContraseña() {
		return contraseña;
	}

	public JCheckBox getAdministrador() {
		return administrador;
	}

	public JButton getEntrar() {
		return entrar;
	}

	public Usuario getUser() {
		return user;
	}
	
	
	
}
