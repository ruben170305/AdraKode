package views;

import java.awt.*;
import javax.swing.*;

import listeners.PMenuListener;

public class Menu extends JFrame {
	static final int ANCHO = 800;
	static final int ALTO = 600;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmVer;
	private JMenuItem mntmModificar;
	private JMenuItem mntmTexto;
	private JMenuItem mntmSalir;
	private JScrollPane scrpContenedor;
	private JMenu mnPartidas;
	private JMenuItem mntmBuscar;
	private JMenuItem mntmVerPartidas;
	private JMenuItem mntmLogin;
	
	public Menu(String titulo) {
		super(titulo);
		initComponents();
	}

	private void initComponents() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		
		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		// Se obtienen las dimensiones en pixels de la ventana.       
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
		
		crearMenu();
	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersonajes = new JMenu("Personajes");
		menuBar.add(mnPersonajes);
		
		mntmNuevo = new JMenuItem("Nuevo personaje");
		mnPersonajes.add(mntmNuevo);
		
		mntmVer = new JMenuItem("Ver personajes");
		mnPersonajes.add(mntmVer);
		
		mntmModificar = new JMenuItem("Modificar personaje");
		mnPersonajes.add(mntmModificar);
		
		mnPartidas = new JMenu("Partidas");
		menuBar.add(mnPartidas);
		
		mntmBuscar = new JMenuItem("Buscar partida");
		mnPartidas.add(mntmBuscar);
		
		mntmVerPartidas = new JMenuItem("Ver partidas");
		mnPartidas.add(mntmVerPartidas);
		
		mntmLogin = new JMenuItem("Login");
		menuBar.add(mntmLogin);
		
		mntmTexto = new JMenuItem("");
		menuBar.add(mntmTexto);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mntmSalir);
		getContentPane().setLayout(null);
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 784, 533);
		getContentPane().add(scrpContenedor);
	}
	
	public void setListener(PMenuListener listener) {
        mntmNuevo.addActionListener(listener);
        mntmBuscar.addActionListener(listener);
        mntmLogin.addActionListener(listener);
        mntmModificar.addActionListener(listener);
        mntmSalir.addActionListener(listener);
    }
	
	public void hacerVisible() {
		setVisible(true);
	}
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}

	public void mostrarMensajeConfirm() {
		int opcion = JOptionPane.showConfirmDialog(this, 
				"Seguro que desea abandonar la aplicación?", 
				"Confirmación de salida",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		} 
		
	}
	
}