package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class CrearPersonaje extends JPanel {
	
    private JLabel lblTitulo, lblNombrePersonaje, lblRaza;
    private JLabel lblFuerza, lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
	private JLabel lblSeleccionarPersonaje, lblIconoExp, lblIconoFuerza, lblIconoDestreza, lblIconoConst, lblIconoInteligencia, lblIconoSabiduria, lblIconoCarisma, lblClase, lblExp;
	private JTextField txtNombre, txtRaza, txtClase,txtExp;
    private JTextField txtFuerza, txtDestreza, txtConstitucion, txtInteligencia, txtSabiduria, txtCarisma;
    private JButton btnGuardar;
    private JSpinner spinner_1, spinner_2, spinner_3, spinner_4, spinner_5, spinner_6;
	
	public CrearPersonaje() {
		setBackground(new Color(242, 242, 242));
		//super(titulo);
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		//Adaptar la apariencia del SO donde se ejecuta
		//try {
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		//} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}

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
		lblTitulo = new JLabel("CREAR PERSONAJE");
		lblTitulo.setForeground(new Color(29, 29, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblTitulo.setBounds(281,32,238,45);
		lblTitulo.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(29, 29, 27)));
		add(lblTitulo);
		
		//Etiqueta nombre personaje
		lblNombrePersonaje = new JLabel("Nombre");
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePersonaje.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblNombrePersonaje.setBounds(274, 120, 72, 14);
		add(lblNombrePersonaje);
		
		//Campo texto nombre personaje
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(242, 242, 242));
		txtNombre.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtNombre.setBounds(359, 123, 130, 14);
		txtNombre.setColumns(10);
		txtNombre.setBorder(border);
		add(txtNombre);
		
		//Etiqueta raza
		lblRaza = new JLabel("Raza");
		lblRaza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblRaza.setBounds(305, 146, 41, 14);
		add(lblRaza);
		
		//Campo texto raza
		txtRaza = new JTextField();
		txtRaza.setBackground(new Color(242, 242, 242));
		txtRaza.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtRaza.setBounds(359, 148, 130, 14);
		txtRaza.setColumns(10);
		txtRaza.setBorder(border);
		add(txtRaza);
		
		//Etiqueta raza
		lblClase = new JLabel("Clase");
		lblClase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClase.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblClase.setBounds(305, 172, 41, 14);
		add(lblClase);
		
		//Campo texto raza
		txtClase = new JTextField();
		txtClase.setBackground(new Color(242, 242, 242));
		txtClase.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtClase.setBounds(359, 173, 130, 14);
		txtClase.setColumns(10);
		txtClase.setBorder(border);
		add(txtClase);
		
		 //Icono 
	    lblIconoExp = new JLabel();
	    lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoExp.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoExp.png")));
		lblIconoExp.setBounds(399,221,29,33);
		add(lblIconoExp);
		
	    //Icono 
		lblIconoFuerza = new JLabel();
		lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoFuerza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoFrza.png")));
		lblIconoFuerza.setBounds(393,253,35,33);
		add(lblIconoFuerza);
		
	    //Icono 
		lblIconoDestreza = new JLabel();
		lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoDestreza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoDestreza.png")));
		lblIconoDestreza.setBounds(393,285,35,33);
		add(lblIconoDestreza);
		
	    //Icono 
		lblIconoConst = new JLabel();
		lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoConst.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoConstitucion.png")));
		lblIconoConst.setBounds(393,317,35,33);
		add(lblIconoConst);
		
		//Icono 
		lblIconoInteligencia = new JLabel();
		lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoInteligencia.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoInteli.png")));
		lblIconoInteligencia.setBounds(393,349,35,33);
		add(lblIconoInteligencia);
		
		//Icono 
		lblIconoSabiduria = new JLabel();
		lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoSabiduria.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoSab.png")));
		lblIconoSabiduria.setBounds(393,381,35,33);
		add(lblIconoSabiduria);

		//Icono 
		lblIconoCarisma = new JLabel();
		lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCarisma.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoCarisma.png")));
		lblIconoCarisma.setBounds(393,413,35,33);
		add(lblIconoCarisma);
		
		//Etiqueta exp
		lblExp = new JLabel("Experiencia");
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblExp.setBounds(299, 232, 90, 14);
		add(lblExp);
		
		
		// Etiqueta fuerza
		lblFuerza = new JLabel("Fuerza");
		lblFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblFuerza.setBounds(328, 263, 61, 14);
		add(lblFuerza);

		// Etiqueta destreza
		lblDestreza = new JLabel("Destreza");
		lblDestreza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblDestreza.setBounds(317, 294, 72, 14);
		add(lblDestreza);

		// Etiqueta constitución
		lblConstitucion = new JLabel("Constitución");
		lblConstitucion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblConstitucion.setBounds(299, 325, 90, 14);
		add(lblConstitucion);

		// Etiqueta inteligencia
		lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblInteligencia.setBounds(305, 356, 84, 17);
		add(lblInteligencia);

		// Etiqueta sabiduría
		lblSabiduria = new JLabel("Sabiduría");
		lblSabiduria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblSabiduria.setBounds(315, 390, 74, 14);
		add(lblSabiduria);

		// Etiqueta carisma
		lblCarisma = new JLabel("Carisma");
		lblCarisma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblCarisma.setBounds(319, 421, 70, 14);
		add(lblCarisma);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(new Color(242, 242, 242));
		spinner.setBackground(new Color(29, 161, 242));
		spinner.setOpaque(true);
		spinner.setBounds(441, 229, 42, 20);
		add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setOpaque(true);
		spinner_1.setForeground(new Color(242, 242, 242));
		spinner_1.setBackground(new Color(29, 161, 242));
		spinner_1.setBounds(441, 260, 42, 20);
		add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setOpaque(true);
		spinner_2.setForeground(new Color(242, 242, 242));
		spinner_2.setBackground(new Color(29, 161, 242));
		spinner_2.setBounds(441, 291, 42, 20);
		add(spinner_2);
		
		spinner_3 = new JSpinner();
		spinner_3.setOpaque(true);
		spinner_3.setForeground(new Color(242, 242, 242));
		spinner_3.setBackground(new Color(29, 161, 242));
		spinner_3.setBounds(441, 322, 42, 20);
		add(spinner_3);
		
		spinner_4 = new JSpinner();
		spinner_4.setOpaque(true);
		spinner_4.setForeground(new Color(242, 242, 242));
		spinner_4.setBackground(new Color(29, 161, 242));
		spinner_4.setBounds(441, 353, 42, 20);
		add(spinner_4);
		
		spinner_5 = new JSpinner();
		spinner_5.setOpaque(true);
		spinner_5.setForeground(new Color(242, 242, 242));
		spinner_5.setBackground(new Color(29, 161, 242));
		spinner_5.setBounds(441, 384, 42, 20);
		add(spinner_5);
		
		spinner_6 = new JSpinner();
		spinner_6.setOpaque(true);
		spinner_6.setForeground(new Color(242, 242, 242));
		spinner_6.setBackground(new Color(29, 161, 242));
		spinner_6.setBounds(441, 418, 42, 20);
		add(spinner_6);
		
		//Boton seleccionar
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnGuardar.setForeground(new Color(242, 242, 242));
		btnGuardar.setBackground(new Color(29, 161, 242));
		btnGuardar.setOpaque(true);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setBounds(312, 486, 179, 45);
		add(btnGuardar);

		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
