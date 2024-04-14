package views;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Color;

public class EditarPersonaje extends JPanel {
	private JTextField txtDestreza, txtConstitucion, txtInteligencia, txtSabiduria, txtCarisma;
	private JLabel lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
	private JLabel lblTitulo, lblExperiencia, lblFuerza, txtSeleccionarPersonaje, lblRaza;
    private JTextField txtExperiencia, txtFuerza, txtRaza;
    private JComboBox<String> comboBoxSeleccionar;
    private JButton btnEditar, btnEliminar;
	
	
	public EditarPersonaje(String titulo) {
		//super(titulo);
		setBackground(new Color(242, 242, 242));
		inicializarComponentes();
		hacerVisible();
	}
	
	private void inicializarComponentes() {
		//Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Añadir operación de cierre de la ventana
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(600, 400);
		setLocation(null);
		
		
		/* COMPONENTES */
		
		//Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));

		
		//Titulo
		JLabel txtTitulo = new JLabel("EDITAR PERSONAJE");
        txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(new Color(29, 29, 27));
        txtTitulo.setFont(new Font("Open Sans", Font.BOLD, 19));
        txtTitulo.setBounds(206, 11, 200, 31);
        add(txtTitulo);

        //Etiqueta seleccionar personaje
        txtSeleccionarPersonaje = new JLabel("Seleccione personaje:");
        txtSeleccionarPersonaje.setFont(new Font("Open Sans", Font.BOLD, 12));
        txtSeleccionarPersonaje.setBounds(161, 71, 130, 14);
        add(txtSeleccionarPersonaje);

        //ComboBox
        String[] opcionesComboBox = {"Jugador 1", "Jugador 2", "Jugador 3", "Jugador 4"};
        comboBoxSeleccionar = new JComboBox<String>(opcionesComboBox);
        comboBoxSeleccionar.setFont(new Font("Open Sans", Font.PLAIN, 11));
        comboBoxSeleccionar.setForeground(new Color(29, 29, 27));
        comboBoxSeleccionar.setBackground(new Color(242, 242, 242));
        comboBoxSeleccionar.setBounds(301, 67, 105, 22);
        add(comboBoxSeleccionar);

        //Etiqueta raza
		lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblRaza.setBounds(239, 107, 30, 14);
		add(lblRaza);
		
		//Campo texto raza
		txtRaza = new JTextField();
		txtRaza.setBackground(new Color(242, 242, 242));
		txtRaza.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtRaza.setBounds(279, 107, 102, 14);
		txtRaza.setColumns(10);
		txtRaza.setBorder(border);
		add(txtRaza);

        //Etiqueta experiencia
        lblExperiencia = new JLabel("Experiencia:");
        lblExperiencia.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lblExperiencia.setBounds(201, 132, 68, 14);
        add(lblExperiencia);

        //Campo texto experiencia
        txtExperiencia = new JTextField();
        txtExperiencia.setBackground(new Color(242, 242, 242));
        txtExperiencia.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtExperiencia.setBounds(279, 132, 102, 14);
        txtExperiencia.setColumns(10);
        txtExperiencia.setBorder(border);
        add(txtExperiencia);

        //Etiqueta fuerza
        lblFuerza = new JLabel("Fuerza:");
        lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lblFuerza.setBounds(228, 160, 41, 14);
        add(lblFuerza);

        //Campo texto fuerza
        txtFuerza = new JTextField();
        txtFuerza.setBackground(new Color(242, 242, 242));
        txtFuerza.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtFuerza.setBounds(279, 160, 102, 14);
        txtFuerza.setColumns(10);
        txtFuerza.setBorder(border);
        add(txtFuerza);

     // Etiqueta destreza
        lblDestreza = new JLabel("Destreza:");
        lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lblDestreza.setBounds(215, 188, 54, 14);
        add(lblDestreza);

        // Campo texto destreza
        txtDestreza = new JTextField();
        txtDestreza.setBackground(new Color(242, 242, 242));
        txtDestreza.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtDestreza.setBounds(279, 188, 102, 14);
        txtDestreza.setColumns(10);
        txtDestreza.setBorder(border);
        add(txtDestreza);

        // Etiqueta constitución
        lblConstitucion = new JLabel("Constitución:");
        lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lblConstitucion.setBounds(197, 216, 72, 14);
        add(lblConstitucion);

        // Campo texto constitución
        txtConstitucion = new JTextField();
        txtConstitucion.setBackground(new Color(242, 242, 242));
        txtConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtConstitucion.setBounds(279, 216, 102, 14);
        txtConstitucion.setColumns(10);
        txtConstitucion.setBorder(border);
        add(txtConstitucion);

        // Etiqueta inteligencia
        lblInteligencia = new JLabel("Inteligencia:");
        lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lblInteligencia.setBounds(201, 244, 68, 14);
        add(lblInteligencia);

        // Campo texto inteligencia
        txtInteligencia = new JTextField();
        txtInteligencia.setBackground(new Color(242, 242, 242));
        txtInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtInteligencia.setBounds(279, 244, 102, 14);
        txtInteligencia.setColumns(10);
        txtInteligencia.setBorder(border);
        add(txtInteligencia);

        // Etiqueta sabiduría
        lblSabiduria = new JLabel("Sabiduría:");
        lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lblSabiduria.setBounds(213, 272, 56, 14);
        add(lblSabiduria);

        // Campo texto sabiduría
        txtSabiduria = new JTextField();
        txtSabiduria.setBackground(new Color(242, 242, 242));
        txtSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtSabiduria.setBounds(279, 272, 102, 14);
        txtSabiduria.setColumns(10);
        txtSabiduria.setBorder(border);
        add(txtSabiduria);

        // Etiqueta carisma
        lblCarisma = new JLabel("Carisma:");
        lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 12));
        lblCarisma.setBounds(219, 300, 50, 14);
        add(lblCarisma);

        // Campo texto carisma
        txtCarisma = new JTextField();
        txtCarisma.setBackground(new Color(242, 242, 242));
        txtCarisma.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtCarisma.setBounds(279, 300, 102, 14);
        txtCarisma.setColumns(10);
        txtCarisma.setBorder(border);
        add(txtCarisma);
        
        
        // Botón editar
        btnEditar = new JButton("GUARDAR");
        btnEditar.setFont(new Font("Oxygen", Font.BOLD, 15));
        btnEditar.setForeground(new Color(242, 242, 242));
        btnEditar.setBackground(new Color(29, 161, 242));
        btnEditar.setOpaque(true);
        btnEditar.setBorderPainted(false);
        btnEditar.setBounds(161, 336, 110, 35);
        add(btnEditar);

        // Botón eliminar
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setFont(new Font("Oxygen", Font.BOLD, 15));
        btnEliminar.setForeground(new Color(242, 242, 242));
        btnEliminar.setBackground(new Color(29, 29, 27));
        btnEliminar.setOpaque(true);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setBounds(326, 336, 110, 35);
        add(btnEliminar);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
