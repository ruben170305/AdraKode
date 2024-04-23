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
    private JSlider sliderExperiencia, sliderFuerza, sliderDestreza,  sliderConstitucion, sliderInteligencia, sliderSabiduria, sliderCarisma;

	
	
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
		lblTitulo.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(29, 29, 27)));
		add(lblTitulo);
			
		//Etiqueta seleccionar personaje
        lblSeleccionarPersonaje = new JLabel("PERSONAJE 1");
        lblSeleccionarPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarPersonaje.setFont(new Font("Open Sans", Font.BOLD, 18));
        lblSeleccionarPersonaje.setBounds(320, 117, 159, 22);
        add(lblSeleccionarPersonaje);
		
	    //Icono 
	    lblIconoExp = new JLabel();
	    lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoExp.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoExp.png")));
		lblIconoExp.setBounds(357,186,29,33);
		add(lblIconoExp);
		
	    //Icono 
		lblIconoFuerza = new JLabel();
		lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoFuerza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoFrza.png")));
		lblIconoFuerza.setBounds(354,217,35,33);
		add(lblIconoFuerza);
		
	    //Icono 
		lblIconoDestreza = new JLabel();
		lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoDestreza.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoDestreza.png")));
		lblIconoDestreza.setBounds(354,248,35,33);
		add(lblIconoDestreza);
		
	    //Icono 
		lblIconoConst = new JLabel();
		lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoConst.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoConstitucion.png")));
		lblIconoConst.setBounds(354,279,35,33);
		add(lblIconoConst);
		
		//Icono 
		lblIconoInteligencia = new JLabel();
		lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoInteligencia.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoInteli.png")));
		lblIconoInteligencia.setBounds(354,310,35,33);
		add(lblIconoInteligencia);
		
		//Icono 
		lblIconoSabiduria = new JLabel();
		lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoSabiduria.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoSab.png")));
		lblIconoSabiduria.setBounds(354,341,35,33);
		add(lblIconoSabiduria);

		//Icono 
		lblIconoCarisma = new JLabel();
		lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCarisma.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/IconoCarisma.png")));
		lblIconoCarisma.setBounds(354,372,35,33);
		add(lblIconoCarisma);
		
		//Etiqueta raza
		lblRaza = new JLabel("Raza 1");
		lblRaza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRaza.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblRaza.setBounds(326, 157, 52, 14);
		add(lblRaza);
		
		//Etiqueta clase
		lblClase = new JLabel("Clase 1");
		lblClase.setHorizontalAlignment(SwingConstants.LEFT);
		lblClase.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblClase.setBounds(406, 157, 52, 14);
		add(lblClase);
		
		//Etiqueta exp
		lblExp = new JLabel("Experiencia");
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblExp.setBounds(262, 197, 90, 14);
		add(lblExp);
		
		
		// Etiqueta fuerza
		lblFuerza = new JLabel("Fuerza");
		lblFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblFuerza.setBounds(291, 227, 61, 14);
		add(lblFuerza);

		// Etiqueta destreza
		lblDestreza = new JLabel("Destreza");
		lblDestreza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblDestreza.setBounds(280, 257, 72, 14);
		add(lblDestreza);

		// Etiqueta constitución
		lblConstitucion = new JLabel("Constitución");
		lblConstitucion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblConstitucion.setBounds(262, 287, 90, 14);
		add(lblConstitucion);

		// Etiqueta inteligencia
		lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblInteligencia.setBounds(268, 317, 84, 17);
		add(lblInteligencia);

		// Etiqueta sabiduría
		lblSabiduria = new JLabel("Sabiduría");
		lblSabiduria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblSabiduria.setBounds(278, 350, 74, 14);
		add(lblSabiduria);

		// Etiqueta carisma
		lblCarisma = new JLabel("Carisma");
		lblCarisma.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblCarisma.setBounds(282, 380, 70, 14);
		add(lblCarisma);
		
		sliderExperiencia = new JSlider();
		sliderExperiencia.setPaintTicks(true);
		sliderExperiencia.setBounds(404, 198, 130, 22);
		add(sliderExperiencia);
		
		sliderFuerza = new JSlider();
		sliderFuerza.setPaintTicks(true);
		sliderFuerza.setBounds(404, 229, 130, 22);
		add(sliderFuerza);
		
		sliderDestreza = new JSlider();
		sliderDestreza.setPaintTicks(true);
		sliderDestreza.setBounds(404, 260, 130, 22);
		add(sliderDestreza);
		
		sliderConstitucion = new JSlider();
		sliderConstitucion.setPaintTicks(true);
		sliderConstitucion.setBounds(404, 291, 130, 22);
		add(sliderConstitucion);
		
		sliderInteligencia = new JSlider();
		sliderInteligencia.setPaintTicks(true);
		sliderInteligencia.setBounds(404, 322, 130, 22);
		add(sliderInteligencia);
		
		sliderSabiduria = new JSlider();
		sliderSabiduria.setPaintTicks(true);
		sliderSabiduria.setBounds(404, 353, 130, 22);
		add(sliderSabiduria);
		
		sliderCarisma = new JSlider();
		sliderCarisma.setPaintTicks(true);
		sliderCarisma.setBounds(404, 382, 130, 22);
		add(sliderCarisma);
		
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
