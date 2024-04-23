package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerPersonajes extends JPanel {
	
    private JLabel lblTitulo, lblNombrePersonaje, lblRaza, lblExp, lblSeleccionarPersonaje, lblIconoExp, lblIconoFuerza, lblIconoDestreza, lblIconoCarisma, lblClase;
    private JLabel lblFuerza, lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma, lblIconoConst, lblIconoInteligencia, lblIconoSabiduria;
    private JButton btnCrear, btnDespues, btnAntes;
    private JProgressBar pbExp;
    private JComboBox comboBoxSeleccionar;
    private JButton btnCrear_1;

	
	public VerPersonajes() {
		setBackground(new Color(242, 242, 242));
		//super(titulo);
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		//Adaptar la apariencia del SO donde se ejecuta
		/*try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		//Añadir operación de cierre de la ventana
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(800, 600);
		//setLocation(null);
		
		
		/* COMPONENTES */
		
		//Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));
		
		//Titulo
		lblTitulo = new JLabel("VER PERSONAJES");
		lblTitulo.setForeground(new Color(29, 29, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblTitulo.setBounds(290,40,219,45);
		lblTitulo.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(29, 29, 27)));
		add(lblTitulo);
			
		//Etiqueta seleccionar personaje
        lblSeleccionarPersonaje = new JLabel("PERSONAJE");
        lblSeleccionarPersonaje.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSeleccionarPersonaje.setFont(new Font("Open Sans", Font.BOLD, 14));
        lblSeleccionarPersonaje.setBounds(298, 130, 90, 14);
        add(lblSeleccionarPersonaje);

        //ComboBox
        String[] opcionesComboBox = {"Jugador 1", "Jugador 2", "Jugador 3", "Jugador 4"};
        comboBoxSeleccionar = new JComboBox<String>(opcionesComboBox);
        comboBoxSeleccionar.setFont(new Font("Open Sans", Font.BOLD, 13));
        comboBoxSeleccionar.setForeground(new Color(29, 29, 27));
        comboBoxSeleccionar.setBackground(new Color(242, 242, 242));
        comboBoxSeleccionar.setBounds(403, 126, 105, 22);
        comboBoxSeleccionar.setBorder(BorderFactory.createEmptyBorder());
        comboBoxSeleccionar.setOpaque(true);
        add(comboBoxSeleccionar);
		
	    //Icono 
	    lblIconoExp = new JLabel();
	    lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoExp.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoExp.png")));
		lblIconoExp.setBounds(358,195,29,33);
		add(lblIconoExp);
		
	    //Icono 
		lblIconoFuerza = new JLabel();
		lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoFuerza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoFrza.png")));
		lblIconoFuerza.setBounds(355,228,35,33);
		add(lblIconoFuerza);
		
	    //Icono 
		lblIconoDestreza = new JLabel();
		lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoDestreza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoDestreza.png")));
		lblIconoDestreza.setBounds(355,261,35,33);
		add(lblIconoDestreza);
		
	    //Icono 
		lblIconoConst = new JLabel();
		lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoConst.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoConstitucion.png")));
		lblIconoConst.setBounds(355,294,35,33);
		add(lblIconoConst);
		
		//Icono 
		lblIconoInteligencia = new JLabel();
		lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoInteligencia.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoInteli.png")));
		lblIconoInteligencia.setBounds(355,327,35,33);
		add(lblIconoInteligencia);
		
		//Icono 
		lblIconoSabiduria = new JLabel();
		lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoSabiduria.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoSab.png")));
		lblIconoSabiduria.setBounds(355,360,35,33);
		add(lblIconoSabiduria);

		//Icono 
		lblIconoCarisma = new JLabel();
		lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCarisma.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoCarisma.png")));
		lblIconoCarisma.setBounds(355,393,35,33);
		add(lblIconoCarisma);
		
		//Etiqueta raza
		lblRaza = new JLabel("Raza 1");
		lblRaza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaza.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblRaza.setBounds(336, 165, 52, 14);
		add(lblRaza);
		
		//Etiqueta clase
		lblClase = new JLabel("Clase 1");
		lblClase.setHorizontalAlignment(SwingConstants.LEFT);
		lblClase.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblClase.setBounds(403, 165, 52, 14);
		add(lblClase);
		
		//Etiqueta exp
		lblExp = new JLabel("Experiencia");
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblExp.setBounds(263, 206, 90, 14);
		add(lblExp);
		
		//Barra progreso experiencia
		pbExp = new JProgressBar();
		pbExp.setBackground(new Color(242, 242, 242));
		pbExp.setForeground(new Color(52, 75, 89));
		pbExp.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbExp.setStringPainted(true);
		pbExp.setBounds(402, 208, 102, 14);
		add(pbExp);
		
		
		// Etiqueta fuerza
		lblFuerza = new JLabel("Fuerza");
		lblFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblFuerza.setBounds(292, 237, 61, 14);
		add(lblFuerza);

		// Barra progreso fuerza
		JProgressBar pbFuerza = new JProgressBar();
		pbFuerza.setBackground(new Color(242, 242, 242));
		pbFuerza.setForeground(new Color(52, 75, 89));
		pbFuerza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbFuerza.setStringPainted(true);
		pbFuerza.setBounds(402, 240, 102, 14);
		add(pbFuerza);

		// Etiqueta destreza
		lblDestreza = new JLabel("Destreza");
		lblDestreza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblDestreza.setBounds(281, 268, 72, 14);
		add(lblDestreza);

		// Barra progreso destreza
		JProgressBar pbDestreza = new JProgressBar();
		pbDestreza.setBackground(new Color(242, 242, 242));
		pbDestreza.setForeground(new Color(52, 75, 89));
		pbDestreza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbDestreza.setStringPainted(true);
		pbDestreza.setBounds(402, 272, 102, 14);
		add(pbDestreza);

		// Etiqueta constitución
		lblConstitucion = new JLabel("Constitución");
		lblConstitucion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblConstitucion.setBounds(263, 299, 90, 14);
		add(lblConstitucion);

		// Barra progreso constitución
		JProgressBar pbConstitucion = new JProgressBar();
		pbConstitucion.setBackground(new Color(242, 242, 242));
		pbConstitucion.setForeground(new Color(52, 75, 89));
		pbConstitucion.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbConstitucion.setStringPainted(true);
		pbConstitucion.setBounds(402, 304, 102, 14);
		add(pbConstitucion);

		// Etiqueta inteligencia
		lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblInteligencia.setBounds(269, 330, 84, 17);
		add(lblInteligencia);

		// Barra progreso inteligencia
		JProgressBar pbInteligencia = new JProgressBar();
		pbInteligencia.setBackground(new Color(242, 242, 242));
		pbInteligencia.setForeground(new Color(52, 75, 89));
		pbInteligencia.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbInteligencia.setStringPainted(true);
		pbInteligencia.setBounds(402, 336, 102, 14);
		add(pbInteligencia);

		// Etiqueta sabiduría
		lblSabiduria = new JLabel("Sabiduría");
		lblSabiduria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblSabiduria.setBounds(279, 364, 74, 14);
		add(lblSabiduria);

		// Barra progreso sabiduría
		JProgressBar pbSabiduria = new JProgressBar();
		pbSabiduria.setBackground(new Color(242, 242, 242));
		pbSabiduria.setForeground(new Color(52, 75, 89));
		pbSabiduria.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbSabiduria.setStringPainted(true);
		pbSabiduria.setBounds(402, 368, 102, 14);
		add(pbSabiduria);

		// Etiqueta carisma
		lblCarisma = new JLabel("Carisma");
		lblCarisma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblCarisma.setBounds(283, 395, 70, 14);
		add(lblCarisma);

		// Barra progreso carisma
		JProgressBar pbCarisma = new JProgressBar();
		pbCarisma.setBackground(new Color(242, 242, 242));
		pbCarisma.setForeground(new Color(52, 75, 89));
		pbCarisma.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbCarisma.setStringPainted(true);
		pbCarisma.setBounds(402, 400, 102, 14);
		add(pbCarisma);

		//Boton seleccionar
		btnCrear = new JButton("SELECCIONAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrear.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnCrear.setForeground(new Color(242, 242, 242));
		btnCrear.setBackground(new Color(29, 161, 242));
		btnCrear.setOpaque(true);
		btnCrear.setBorderPainted(false);
		btnCrear.setBounds(300, 441, 199, 45);
		add(btnCrear);
		
		btnCrear_1 = new JButton();
		btnCrear_1.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonEditarW.png")));
		btnCrear_1.setOpaque(true);
		btnCrear_1.setForeground(new Color(29, 29, 27));
		btnCrear_1.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnCrear_1.setBorderPainted(false);
		btnCrear_1.setBackground(new Color(29, 29, 27));
		btnCrear_1.setBounds(300, 493, 96, 45);
		add(btnCrear_1);
		
		JButton btnCrear_1_1 = new JButton();
		btnCrear_1_1.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonBorrarW.png")));
		btnCrear_1_1.setOpaque(true);
		btnCrear_1_1.setForeground(new Color(29, 29, 27));
		btnCrear_1_1.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnCrear_1_1.setBorderPainted(false);
		btnCrear_1_1.setBackground(new Color(29, 29, 27));
		btnCrear_1_1.setBounds(403, 493, 96, 45);
		add(btnCrear_1_1);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
