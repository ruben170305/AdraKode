package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import listeners.LoginListener;
import listeners.RegistroListener;
import model.Usuario;

import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

public class RegistroMiembro extends JFrame {

	private JLabel lblTitulo, usuarioIcono, contrasenaIcono, logoIcono;
	private JTextField usuario;
	private JPasswordField contraseña;
	private JButton entrar, iniciarSesion;
	private Usuario user;
	private JTextField expediente;
	private JTextField estudios;
	private VentanaPrincipalLogin login;
	//private LoginListener listener;

	// private VentanaPrincipalLogin listener;
	public RegistroMiembro(VentanaPrincipalLogin login) {
		super("Nuevo usuario | AdraKode");
		this.login = login;
		setBackground(new Color(242, 242, 242));
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
		lblTitulo = new JLabel("CREAR CUENTA");
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
		separator.setBounds(329, 88, 125, 3);
		getContentPane().add(separator);

		// Logo
		logoIcono = new JLabel();
		logoIcono.setIcon(new ImageIcon(RegistroMiembro.class.getResource("/img/imagenLogin.png")));
		logoIcono.setBounds(330, 102, 124, 142);
		getContentPane().add(logoIcono);

		// Campo usuario
		usuario = new JTextField();
		usuario.setBackground(new Color(242, 242, 242));
		usuario.setFont(new Font("Open Sans", Font.PLAIN, 11));
		usuario.setForeground(new Color(29, 29, 27));
		usuario.setBounds(301, 227, 205, 35);
		usuario.setBorder(border);
		getContentPane().add(usuario);

		// Icono usuario
		usuarioIcono = new JLabel();
		usuarioIcono.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioIcono.setIcon(new ImageIcon(RegistroMiembro.class.getResource("/img/IconoUsuario.png")));
		usuarioIcono.setBounds(257, 227, 34, 45);
		getContentPane().add(usuarioIcono);

		// Campo contraseña
		contraseña = new JPasswordField();
		contraseña.setToolTipText("");
		contraseña.setFont(new Font("Open Sans", Font.PLAIN, 11));
		contraseña.setForeground(new Color(29, 29, 27));
		contraseña.setBackground(new Color(242, 242, 242));
		contraseña.setEchoChar('\u2022'); // Establece el carácter de ocultación
		contraseña.setBounds(301, 265, 205, 35);
		contraseña.setBorder(border);
		getContentPane().add(contraseña);

		// Icono contraseña
		contrasenaIcono = new JLabel();
		contrasenaIcono.setHorizontalAlignment(SwingConstants.CENTER);
		contrasenaIcono.setIcon(new ImageIcon(RegistroMiembro.class.getResource("/img/IconoContraseña.png")));
		contrasenaIcono.setBounds(255, 266, 34, 45);
		getContentPane().add(contrasenaIcono);
	
		
		expediente = new JTextField();
		expediente.setBackground(new Color(242, 242, 242));
		expediente.setFont(new Font("Open Sans", Font.PLAIN, 11));
		expediente.setForeground(new Color(29, 29, 27));
		expediente.setBorder(border);
		expediente.setBounds(301, 303, 205, 35);
		getContentPane().add(expediente);
		
		estudios = new JTextField();
		estudios.setBackground(new Color(242, 242, 242));
		estudios.setFont(new Font("Open Sans", Font.PLAIN, 11));
		estudios.setForeground(new Color(29, 29, 27));
		estudios.setBorder(border);
		estudios.setBounds(301, 341, 205, 35);
		getContentPane().add(estudios);
		
		JLabel expedienteIco = new JLabel();
		expedienteIco.setIcon(new ImageIcon(RegistroMiembro.class.getResource("/img/expediente.png")));
		expedienteIco.setHorizontalAlignment(SwingConstants.CENTER);
		expedienteIco.setBounds(257, 305, 34, 45);
		getContentPane().add(expedienteIco);
		
		JLabel estudiosIco = new JLabel();
		estudiosIco.setIcon(new ImageIcon(RegistroMiembro.class.getResource("/img/estudios.png")));
		estudiosIco.setHorizontalAlignment(SwingConstants.CENTER);
		estudiosIco.setBounds(257, 344, 34, 45);
		getContentPane().add(estudiosIco);
		
		
		
		
		// Botón entrar
		entrar = new JButton("CREAR CUENTA");
		entrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		entrar.setForeground(new Color(242, 242, 242));
		entrar.setBackground(new Color(29, 161, 242));
		entrar.setOpaque(true);
		entrar.setBorderPainted(false);
		entrar.setBounds(287, 409, 209, 50);
		getContentPane().add(entrar);
		
		
		iniciarSesion = new JButton("INICIAR SESION");
		iniciarSesion.setFont(new Font("Oxygen", Font.BOLD, 17));
		iniciarSesion.setForeground(new Color(242, 242, 242));
		iniciarSesion.setBackground(new Color(29, 29, 27));
		iniciarSesion.setOpaque(true);
		iniciarSesion.setBorderPainted(false);
		iniciarSesion.setBounds(287, 488, 209, 50);
		getContentPane().add(iniciarSesion);
		
		
		//Separadores botones
		JSeparator separator_1 = new JSeparator();
		separator_1.setMaximumSize(new Dimension(32778, 32767));
		separator_1.setForeground(new Color(29, 29, 27));
		separator_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator_1.setBackground(new Color(29, 29, 27));
		separator_1.setBounds(287, 470, 80, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setMaximumSize(new Dimension(32778, 32767));
		separator_1_1.setForeground(new Color(29, 29, 27));
		separator_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator_1_1.setBackground(new Color(29, 29, 27));
		separator_1_1.setBounds(416, 470, 80, 2);
		getContentPane().add(separator_1_1);
		
		JLabel lblNewLabel = new JLabel("o");
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(369, 452, 46, 35);
		getContentPane().add(lblNewLabel);

	}

	/**
	 * Método que asigna el listener
	 * @param listener Recibe el listener que quieres asignar
	 */
	public void setListener(RegistroListener listener) {
		entrar.addActionListener(listener);
		iniciarSesion.addActionListener(listener);
	}

	/**
	 * Metodo que muestra la confirmacion al salir
	 */
	public void mostrarMensajeConfirm() {
		int opcion = JOptionPane.showConfirmDialog(this, 
				"¿Seguro que desea abandonar la pantalla de crear cuenta?", 
				"Cancelar",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		
		if (opcion == JOptionPane.YES_OPTION) {
			dispose();
			login.make_visible();
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

	public JButton getEntrar() {
		return entrar;
	}

	public Usuario getUser() {
		return user;
	}

	public JTextField getExpediente() {
		return expediente;
	}

	public JTextField getEstudios() {
		return estudios;
	}
	
	
}