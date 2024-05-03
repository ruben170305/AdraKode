package views;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import listeners.PMenuListener;

public class Menu extends JFrame {
	static final int ANCHO = 800;
	static final int ALTO = 650;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmVer;
	private JMenuItem mntmModificarP;
	private JMenuItem mntmTexto;
	private JMenuItem mntmSalir;
	private JScrollPane scrpContenedor;
	
	private JMenu mnPartidas;
	private JMenuItem mntmBuscar;
	private JMenuItem mntmCrearPartidas;
	private JMenuItem mntmVerPartidasMaster;
	private JMenuItem mntmVerPartidas;
	private JMenuItem mntmEditarPartidas;
	
	private boolean gameMaster;
	
	public Menu(String titulo) {
		super(titulo);
		setIcon();
		initComponents();
	}

	public void initComponents() {
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Llamar al método para mostrar la notificación
            	mostrarMensajeConfirm();
            }
        });
		setSize(ANCHO, ALTO);
		
		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		// Se obtienen las dimensiones en pixels de la ventana.       
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
		crearMenu();
	}
	
	/**
	 * Método que crea el JMenuBar y los items principales (JMenu) y el submenu de cada item (JMenuItem)
	 */
	public void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Creamos los items principales
		JMenu mnPersonajes = new JMenu("Personajes");
		menuBar.add(mnPersonajes);
		
		//Creamos los items secundarios de Personajes
		mntmNuevo = new JMenuItem("Nuevo personaje");
		mnPersonajes.add(mntmNuevo);
		
		mntmVer = new JMenuItem("Ver personajes");
		mnPersonajes.add(mntmVer);
		
		mntmModificarP = new JMenuItem("Modificar personaje");
		mnPersonajes.add(mntmModificarP);
		
		//Creamos el item principal Partidas
		mnPartidas = new JMenu("Partidas");
		menuBar.add(mnPartidas);
		
		//Creamos el submenu de partidas
		mntmBuscar = new JMenuItem("Buscar partida");
		mnPartidas.add(mntmBuscar);
		
		mntmCrearPartidas = new JMenuItem("Crear partida");
		mnPartidas.add(mntmCrearPartidas);
		
		mntmEditarPartidas = new JMenuItem("Editar partidas");
		mnPartidas.add(mntmEditarPartidas);
		
		mntmVerPartidas = new JMenuItem("Ver partidas");
		mntmVerPartidasMaster = new JMenuItem("Ver partidas Master");
		
		//Agregamos el menu de ver partidas dependiendo si eres game master o no
		if (gameMaster) {
			mnPartidas.add(mntmVerPartidasMaster);
		} else {
			mnPartidas.add(mntmVerPartidas);
		}
		
		//Creamos y asignamos el boton Login al menu principal
		mntmTexto = new JMenuItem("Login");
		menuBar.add(mntmTexto);
		
		/*mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mntmSalir);
		getContentPane().setLayout(null);*/
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setBounds(0, 0, 784, 533);
		getContentPane().add(scrpContenedor);
		
	}
	
	/**
	 * Asginamos el listener a cada JMenuItem
	 * @param listener Parametro que recibe el listener que queremos asignar
	 */
	public void setListener(PMenuListener listener) {
        mntmNuevo.addActionListener(listener);
        mntmBuscar.addActionListener(listener);
        mntmVer.addActionListener(listener);
        
        
        mntmCrearPartidas.addActionListener(listener);
        if (gameMaster) {
        	mntmVerPartidasMaster.addActionListener(listener);
		} else {
			mntmVerPartidas.addActionListener(listener);
		}
        mntmModificarP.addActionListener(listener);
        mntmEditarPartidas.addActionListener(listener);
        
        mntmTexto.addActionListener(listener);
        //mntmSalir.addActionListener(listener);
        
    }
	
	/**
	 * Método que hace visible la ventana (JFrame)
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * Método que cambia los paneles (JPanel) que se muestran en esta ventana
	 * @param panel Vista (extiende JPanel) que queremos mostrar
	 */
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	/**
	 * Método que cambia el icono de la esquina y de la barra de tareas
	 */
	private void setIcon() {
        try {
        	InputStream iconStream = getClass().getResourceAsStream("/img/iconoLogo2.png");
            Image icon = ImageIO.read(iconStream);
            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * Mostrar mensaje de confirmación de cierre
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

	public boolean isGameMaster() {
		return gameMaster;
	}

	public void setGameMaster(boolean gameMaster) {
		this.gameMaster = gameMaster;
	}
	
	
	
}
