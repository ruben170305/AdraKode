package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
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

public class CrearPersonaje extends JPanel {
	
    private JLabel lblTitulo, lblNombrePersonaje, lblRaza, lblExp;
    private JLabel lblFuerza, lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
	private JTextField txtNombre, txtRaza, txtExp;
    private JTextField txtFuerza, txtDestreza, txtConstitucion, txtInteligencia, txtSabiduria, txtCarisma;
    private JButton btnCrear;
	
	public CrearPersonaje(String titulo) {
		setBackground(new Color(242, 242, 242));
		//super(titulo);
		inicializarComponentes();
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
		lblTitulo = new JLabel("CREAR PERSONAJE");
		lblTitulo.setForeground(new Color(29, 29, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 19));
		lblTitulo.setBounds(206,23,186,33);
		add(lblTitulo);
		
		//Etiqueta nombre personaje
		lblNombrePersonaje = new JLabel("Nombre del personaje:");
		lblNombrePersonaje.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblNombrePersonaje.setBounds(139, 87, 135, 14);
		add(lblNombrePersonaje);
		
		//Campo texto nombre personaje
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(242, 242, 242));
		txtNombre.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtNombre.setBounds(286, 87, 130, 14);
		txtNombre.setColumns(10);
		txtNombre.setBorder(border);
		add(txtNombre);
		
		//Etiqueta raza
		lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblRaza.setBounds(246, 112, 30, 14);
		add(lblRaza);
		
		//Campo texto raza
		txtRaza = new JTextField();
		txtRaza.setBackground(new Color(242, 242, 242));
		txtRaza.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtRaza.setBounds(286, 110, 130, 14);
		txtRaza.setColumns(10);
		txtRaza.setBorder(border);
		add(txtRaza);
		
		//Etiqueta exp
		lblExp = new JLabel("Experiencia:");
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblExp.setBounds(206, 138, 70, 14);
		add(lblExp);
		
		//Campo texto exp
		txtExp = new JTextField();
		txtExp.setBackground(new Color(242, 242, 242));
		txtExp.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtExp.setBounds(286, 136, 130, 14);
		txtExp.setColumns(10);
		txtExp.setBorder(border);
		add(txtExp);
		
		// Etiqueta fuerza
		JLabel lblFuerza = new JLabel("Fuerza:");
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblFuerza.setBounds(235, 164, 41, 14);
		add(lblFuerza);

		// Campo de texto fuerza
		JTextField txtFuerza = new JTextField();
		txtFuerza.setBackground(new Color(242, 242, 242));
		txtFuerza.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtFuerza.setBounds(286, 164, 130, 14);
		txtFuerza.setColumns(10);
		txtFuerza.setBorder(border);
		add(txtFuerza);

		// Etiqueta destreza
		JLabel lblDestreza = new JLabel("Destreza:");
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblDestreza.setBounds(216, 190, 60, 14);
		add(lblDestreza);

		// Campo de texto destreza
		JTextField txtDestreza = new JTextField();
		txtDestreza.setBackground(new Color(242, 242, 242));
		txtDestreza.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtDestreza.setBounds(286, 190, 130, 14);
		txtDestreza.setColumns(10);
		txtDestreza.setBorder(border);
		add(txtDestreza);

		// Etiqueta constitución
		JLabel lblConstitucion = new JLabel("Constitución:");
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblConstitucion.setBounds(196, 216, 80, 14);
		add(lblConstitucion);

		// Campo de texto constitución
		JTextField txtConstitucion = new JTextField();
		txtConstitucion.setBackground(new Color(242, 242, 242));
		txtConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtConstitucion.setBounds(286, 216, 130, 14);
		txtConstitucion.setColumns(10);
		txtConstitucion.setBorder(border);
		add(txtConstitucion);

		// Etiqueta inteligencia
		JLabel lblInteligencia = new JLabel("Inteligencia:");
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblInteligencia.setBounds(206, 241, 70, 17);
		add(lblInteligencia);

		// Campo de texto inteligencia
		JTextField txtInteligencia = new JTextField();
		txtInteligencia.setBackground(new Color(242, 242, 242));
		txtInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtInteligencia.setBounds(286, 242, 130, 14);
		txtInteligencia.setColumns(10);
		txtInteligencia.setBorder(border);
		add(txtInteligencia);

		// Etiqueta sabiduría
		JLabel lblSabiduria = new JLabel("Sabiduría:");
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblSabiduria.setBounds(216, 268, 60, 14);
		add(lblSabiduria);

		// Campo de texto sabiduría
		JTextField txtSabiduria = new JTextField();
		txtSabiduria.setBackground(new Color(242, 242, 242));
		txtSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtSabiduria.setBounds(286, 268, 130, 14);
		txtSabiduria.setColumns(10);
		txtSabiduria.setBorder(border);
		add(txtSabiduria);

		// Etiqueta carisma
		JLabel lblCarisma = new JLabel("Carisma:");
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblCarisma.setBounds(226, 294, 50, 14);
		add(lblCarisma);

		// Campo de texto carisma
		JTextField txtCarisma = new JTextField();
		txtCarisma.setBackground(new Color(242, 242, 242));
		txtCarisma.setFont(new Font("Open Sans", Font.PLAIN, 11));
		txtCarisma.setBounds(286, 294, 130, 14);
		txtCarisma.setColumns(10);
		txtCarisma.setBorder(border);
		add(txtCarisma);
		
		//Boton crear
		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnCrear.setForeground(new Color(242, 242, 242));
		btnCrear.setBackground(new Color(29, 161, 242));
		btnCrear.setOpaque(true);
		btnCrear.setBorderPainted(false);
		btnCrear.setBounds(246, 344, 142, 33);
		add(btnCrear);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
