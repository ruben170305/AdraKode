package views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class EditarPersonaje extends JPanel {
	private JTextField txtDestreza, txtConstitucion, txtInteligencia, txtSabiduria, txtCarisma;
	private JLabel lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
	private JLabel lblTitulo, lblExperiencia, lblFuerza, txtSeleccionarPersonaje, lblRaza;
	private JLabel lblSeleccionarPersonaje, lblIconoExp, lblIconoFuerza, lblIconoDestreza, lblIconoConst, lblIconoInteligencia, lblIconoSabiduria, lblIconoCarisma, lblClase, lblExp;
    private JTextField txtExperiencia, txtFuerza, txtRaza;
    private JComboBox<String> comboBoxSeleccionar;
    private JButton btnEditar, btnEliminar, btnGuardar;
    private JSpinner spinner_1, spinner_2, spinner_3, spinner_4, spinner_5, spinner_6;

	
	
	public EditarPersonaje() {
		//super(titulo);
		setBackground(new Color(242, 242, 242));
		inicializarComponentes();
		hacerVisible();
	}
	
	private void inicializarComponentes() {
		//Adaptar la apariencia del SO donde se ejecuta
		//try {
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}

		//Añadir operación de cierre de la ventana
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(800, 600);
		
		
		/* COMPONENTES */
		
		//Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));
		
		//Titulo
		lblTitulo = new JLabel("EDITAR PERSONAJES");
		lblTitulo.setForeground(new Color(29, 29, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 25));
		lblTitulo.setBounds(269,32,261,45);
		add(lblTitulo);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(29, 29, 27));
		separator.setForeground(new Color(29, 29, 27));
		separator.setBounds(333, 88, 145, 18);
		add(separator);
			
		//Etiqueta seleccionar personaje
        lblSeleccionarPersonaje = new JLabel("PERSONAJE 1");
        lblSeleccionarPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarPersonaje.setFont(new Font("Open Sans", Font.BOLD, 18));
        lblSeleccionarPersonaje.setBounds(320, 117, 159, 22);
        add(lblSeleccionarPersonaje);
        
        //Etiqueta raza
		lblRaza = new JLabel("Raza 1");
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblRaza.setBounds(457, 182, 61, 14);
		add(lblRaza);
		
		//Etiqueta clase
		lblClase = new JLabel("Clase 1");
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblClase.setBounds(461, 203, 52, 14);
		add(lblClase);
		
		 //Icono 
	    lblIconoExp = new JLabel();
	    lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoExp.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoExp.png")));
		lblIconoExp.setBounds(302,171,29,33);
		add(lblIconoExp);
		
	    //Icono 
		lblIconoFuerza = new JLabel();
		lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoFuerza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoFrza.png")));
		lblIconoFuerza.setBounds(296,203,35,33);
		add(lblIconoFuerza);
		
	    //Icono 
		lblIconoDestreza = new JLabel();
		lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoDestreza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoDestreza.png")));
		lblIconoDestreza.setBounds(296,235,35,33);
		add(lblIconoDestreza);
		
	    //Icono 
		lblIconoConst = new JLabel();
		lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoConst.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoConstitucion.png")));
		lblIconoConst.setBounds(296,267,35,33);
		add(lblIconoConst);
		
		//Icono 
		lblIconoInteligencia = new JLabel();
		lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoInteligencia.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoInteli.png")));
		lblIconoInteligencia.setBounds(296,299,35,33);
		add(lblIconoInteligencia);
		
		//Icono 
		lblIconoSabiduria = new JLabel();
		lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoSabiduria.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoSab.png")));
		lblIconoSabiduria.setBounds(296,331,35,33);
		add(lblIconoSabiduria);

		//Icono 
		lblIconoCarisma = new JLabel();
		lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCarisma.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoCarisma.png")));
		lblIconoCarisma.setBounds(296,363,35,33);
		add(lblIconoCarisma);
		
		//Etiqueta exp
		lblExp = new JLabel("Experiencia");
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblExp.setBounds(202, 182, 90, 14);
		add(lblExp);
		
		
		// Etiqueta fuerza
		lblFuerza = new JLabel("Fuerza");
		lblFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblFuerza.setBounds(231, 213, 61, 14);
		add(lblFuerza);

		// Etiqueta destreza
		lblDestreza = new JLabel("Destreza");
		lblDestreza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblDestreza.setBounds(220, 244, 72, 14);
		add(lblDestreza);

		// Etiqueta constitución
		lblConstitucion = new JLabel("Constitución");
		lblConstitucion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblConstitucion.setBounds(202, 275, 90, 14);
		add(lblConstitucion);

		// Etiqueta inteligencia
		lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblInteligencia.setBounds(208, 306, 84, 17);
		add(lblInteligencia);

		// Etiqueta sabiduría
		lblSabiduria = new JLabel("Sabiduría");
		lblSabiduria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblSabiduria.setBounds(218, 340, 74, 14);
		add(lblSabiduria);

		// Etiqueta carisma
		lblCarisma = new JLabel("Carisma");
		lblCarisma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblCarisma.setBounds(222, 371, 70, 14);
		add(lblCarisma);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(new Color(242, 242, 242));
		spinner.setBackground(new Color(29, 161, 242));
		spinner.setOpaque(true);
		spinner.setBounds(344, 179, 42, 20);
		add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setOpaque(true);
		spinner_1.setForeground(new Color(242, 242, 242));
		spinner_1.setBackground(new Color(29, 161, 242));
		spinner_1.setBounds(344, 210, 42, 20);
		add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setOpaque(true);
		spinner_2.setForeground(new Color(242, 242, 242));
		spinner_2.setBackground(new Color(29, 161, 242));
		spinner_2.setBounds(344, 241, 42, 20);
		add(spinner_2);
		
		spinner_3 = new JSpinner();
		spinner_3.setOpaque(true);
		spinner_3.setForeground(new Color(242, 242, 242));
		spinner_3.setBackground(new Color(29, 161, 242));
		spinner_3.setBounds(344, 272, 42, 20);
		add(spinner_3);
		
		spinner_4 = new JSpinner();
		spinner_4.setOpaque(true);
		spinner_4.setForeground(new Color(242, 242, 242));
		spinner_4.setBackground(new Color(29, 161, 242));
		spinner_4.setBounds(344, 303, 42, 20);
		add(spinner_4);
		
		spinner_5 = new JSpinner();
		spinner_5.setOpaque(true);
		spinner_5.setForeground(new Color(242, 242, 242));
		spinner_5.setBackground(new Color(29, 161, 242));
		spinner_5.setBounds(344, 334, 42, 20);
		add(spinner_5);
		
		spinner_6 = new JSpinner();
		spinner_6.setOpaque(true);
		spinner_6.setForeground(new Color(242, 242, 242));
		spinner_6.setBackground(new Color(29, 161, 242));
		spinner_6.setBounds(344, 365, 42, 20);
		add(spinner_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/personajes/personaje1.png")));
		lblNewLabel.setBounds(429, 231, 116, 154);
		add(lblNewLabel);
		
		//Boton seleccionar
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnGuardar.setForeground(new Color(242, 242, 242));
		btnGuardar.setBackground(new Color(29, 161, 242));
		btnGuardar.setOpaque(true);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setBounds(310, 458, 179, 45);
		add(btnGuardar);
		

		


	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
