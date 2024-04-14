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
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerPersonajes extends JPanel {
	
    private JLabel lblTitulo, lblNombrePersonaje, lblRaza, lblExp;
    private JLabel lblFuerza, lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
    private JButton btnCrear, btnDespues, btnAntes;
    private JProgressBar pbExp;

	
	public VerPersonajes(String titulo) {
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
		lblTitulo = new JLabel("VER PERSONAJES");
		lblTitulo.setForeground(new Color(29, 29, 27));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 19));
		lblTitulo.setBounds(206,23,186,33);
		add(lblTitulo);
		
		//Etiqueta nombre personaje
		lblNombrePersonaje = new JLabel("Personaje 1");
		lblNombrePersonaje.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblNombrePersonaje.setBounds(253, 82, 102, 14);
		add(lblNombrePersonaje);
		
		
		
		//Etiqueta raza
		lblRaza = new JLabel("Raza 1");
		lblRaza.setFont(new Font("Open Sans", Font.BOLD, 14));
		lblRaza.setBounds(276, 107, 52, 14);
		add(lblRaza);
		
		
		//Etiqueta exp
		lblExp = new JLabel("Experiencia");
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblExp.setBounds(206, 138, 70, 14);
		add(lblExp);
		
		//Barra progreso experiencia
		pbExp = new JProgressBar();
		pbExp.setBackground(new Color(242, 242, 242));
		pbExp.setForeground(new Color(52, 75, 89));
		pbExp.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbExp.setStringPainted(true);
		pbExp.setBounds(286, 140, 102, 14);
		add(pbExp);
		
		
		// Etiqueta fuerza
		lblFuerza = new JLabel("Fuerza");
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblFuerza.setBounds(235, 164, 41, 14);
		add(lblFuerza);

		// Barra progreso fuerza
		JProgressBar pbFuerza = new JProgressBar();
		pbFuerza.setBackground(new Color(242, 242, 242));
		pbFuerza.setForeground(new Color(52, 75, 89));
		pbFuerza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbFuerza.setStringPainted(true);
		pbFuerza.setBounds(286, 166, 102, 14);
		add(pbFuerza);

		// Etiqueta destreza
		lblDestreza = new JLabel("Destreza");
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblDestreza.setBounds(224, 190, 52, 14);
		add(lblDestreza);

		// Barra progreso destreza
		JProgressBar pbDestreza = new JProgressBar();
		pbDestreza.setBackground(new Color(242, 242, 242));
		pbDestreza.setForeground(new Color(52, 75, 89));
		pbDestreza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbDestreza.setStringPainted(true);
		pbDestreza.setBounds(286, 192, 102, 14);
		add(pbDestreza);

		// Etiqueta constitución
		lblConstitucion = new JLabel("Constitución");
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblConstitucion.setBounds(206, 216, 70, 14);
		add(lblConstitucion);

		// Barra progreso constitución
		JProgressBar pbConstitucion = new JProgressBar();
		pbConstitucion.setBackground(new Color(242, 242, 242));
		pbConstitucion.setForeground(new Color(52, 75, 89));
		pbConstitucion.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbConstitucion.setStringPainted(true);
		pbConstitucion.setBounds(286, 218, 102, 14);
		add(pbConstitucion);

		// Etiqueta inteligencia
		lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblInteligencia.setBounds(212, 241, 64, 17);
		add(lblInteligencia);

		// Barra progreso inteligencia
		JProgressBar pbInteligencia = new JProgressBar();
		pbInteligencia.setBackground(new Color(242, 242, 242));
		pbInteligencia.setForeground(new Color(52, 75, 89));
		pbInteligencia.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbInteligencia.setStringPainted(true);
		pbInteligencia.setBounds(286, 243, 102, 14);
		add(pbInteligencia);

		// Etiqueta sabiduría
		lblSabiduria = new JLabel("Sabiduría");
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblSabiduria.setBounds(222, 268, 54, 14);
		add(lblSabiduria);

		// Barra progreso sabiduría
		JProgressBar pbSabiduria = new JProgressBar();
		pbSabiduria.setBackground(new Color(242, 242, 242));
		pbSabiduria.setForeground(new Color(52, 75, 89));
		pbSabiduria.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbSabiduria.setStringPainted(true);
		pbSabiduria.setBounds(286, 270, 102, 14);
		add(pbSabiduria);

		// Etiqueta carisma
		lblCarisma = new JLabel("Carisma");
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblCarisma.setBounds(226, 294, 50, 14);
		add(lblCarisma);

		// Barra progreso carisma
		JProgressBar pbCarisma = new JProgressBar();
		pbCarisma.setBackground(new Color(242, 242, 242));
		pbCarisma.setForeground(new Color(52, 75, 89));
		pbCarisma.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbCarisma.setStringPainted(true);
		pbCarisma.setBounds(286, 296, 102, 14);
		add(pbCarisma);

		//Boton seleccionar
		btnCrear = new JButton("SELECCIONAR");
		btnCrear.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnCrear.setForeground(new Color(242, 242, 242));
		btnCrear.setBackground(new Color(29, 161, 242));
		btnCrear.setOpaque(true);
		btnCrear.setBorderPainted(false);
		btnCrear.setBounds(221, 345, 167, 33);
		add(btnCrear);
		
		btnAntes = new JButton("<");
		btnAntes.setOpaque(true);
		btnAntes.setForeground(new Color(242, 242, 242));
		btnAntes.setFont(new Font("Oxygen", Font.BOLD, 14));
		btnAntes.setBorderPainted(false);
		btnAntes.setBackground(new Color(52, 75, 89));
		btnAntes.setBounds(27, 189, 52, 33);
		add(btnAntes);
		
		btnDespues = new JButton(">");
		btnDespues.setOpaque(true);
		btnDespues.setForeground(new Color(242, 242, 242));
		btnDespues.setFont(new Font("Oxygen", Font.BOLD, 14));
		btnDespues.setBorderPainted(false);
		btnDespues.setBackground(new Color(52, 75, 89));
		btnDespues.setBounds(518, 189, 52, 33);
		add(btnDespues);
				
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
