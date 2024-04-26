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
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSpinner;

public class CrearPersonaje extends JPanel {
	private JTextField txtRaza, txtClase;
    private JLabel lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
    private JLabel lblTitulo, lblFuerza, lblSeleccionarPersonaje, lblRaza, lblIconoPersn;
    private JLabel lblIconoExp, lblIconoFuerza, lblIconoDestreza, lblIconoConst, lblIconoInteligencia, lblIconoSabiduria, lblIconoCarisma, lblClase, lblExp;
    private JSpinner spinnerExperiencia, spinnerFuerza, spinnerDestreza, spinnerConstitucion, spinnerInteligencia, spinnerSabiduria, spinnerCarisma;
    private JButton btnGuardarImagen, btnGuardar;
	
	public CrearPersonaje() {
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
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize(800, 600);
		//setLocation(null);
		
		
		/* COMPONENTES */
		
		//Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));
		
		/* COMPONENTES */

        // Titulo
        lblTitulo = new JLabel("CREAR PERSONAJE");
        lblTitulo.setForeground(new Color(29, 29, 27));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 25));
        lblTitulo.setBounds(269, 32, 261, 45);
        add(lblTitulo);

        // Separador
        JSeparator separator = new JSeparator();
        separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        separator.setPreferredSize(new Dimension(0, 3));
        separator.setMaximumSize(new Dimension(32778, 32767));
        separator.setBackground(new Color(29, 29, 27));
        separator.setForeground(new Color(29, 29, 27));
        separator.setBounds(337, 88, 125, 3);
        add(separator);

        // Etiqueta seleccionar personaje
        lblSeleccionarPersonaje = new JLabel("PERSONAJE 1");
        lblSeleccionarPersonaje.setForeground(new Color(29, 29, 27));
        lblSeleccionarPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarPersonaje.setFont(new Font("Open Sans", Font.BOLD, 20));
        lblSeleccionarPersonaje.setBounds(320, 142, 159, 22);
        add(lblSeleccionarPersonaje);

        // Iconos
        lblIconoExp = new JLabel();
        lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoExp.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoExp.png")));
        lblIconoExp.setBounds(464, 197, 29, 33);
        add(lblIconoExp);

        lblIconoFuerza = new JLabel();
        lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoFuerza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoFrza.png")));
        lblIconoFuerza.setBounds(458, 229, 35, 33);
        add(lblIconoFuerza);

        lblIconoDestreza = new JLabel();
        lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoDestreza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoDestreza.png")));
        lblIconoDestreza.setBounds(458, 261, 35, 33);
        add(lblIconoDestreza);

        lblIconoConst = new JLabel();
        lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoConst.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoConstitucion.png")));
        lblIconoConst.setBounds(458, 293, 35, 33);
        add(lblIconoConst);

        lblIconoInteligencia = new JLabel();
        lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoInteligencia.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoInteli.png")));
        lblIconoInteligencia.setBounds(458, 325, 35, 33);
        add(lblIconoInteligencia);

        lblIconoSabiduria = new JLabel();
        lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoSabiduria.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoSab.png")));
        lblIconoSabiduria.setBounds(458, 357, 35, 33);
        add(lblIconoSabiduria);

        lblIconoCarisma = new JLabel();
        lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoCarisma.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoCarisma.png")));
        lblIconoCarisma.setBounds(458, 389, 35, 33);
        add(lblIconoCarisma);

        // Etiqueta exp
        lblExp = new JLabel("Experiencia");
        lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
        lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblExp.setBounds(364, 208, 90, 14);
        add(lblExp);

        // Etiqueta fuerza
        lblFuerza = new JLabel("Fuerza");
        lblFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblFuerza.setBounds(393, 239, 61, 14);
        add(lblFuerza);

        // Etiqueta destreza
        lblDestreza = new JLabel("Destreza");
        lblDestreza.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblDestreza.setBounds(382, 270, 72, 14);
        add(lblDestreza);

        // Etiqueta constitución
        lblConstitucion = new JLabel("Constitución");
        lblConstitucion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblConstitucion.setBounds(364, 301, 90, 14);
        add(lblConstitucion);

        // Etiqueta inteligencia
        lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setHorizontalAlignment(SwingConstants.RIGHT);
        lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblInteligencia.setBounds(370, 332, 84, 17);
        add(lblInteligencia);

        // Etiqueta sabiduría
        lblSabiduria = new JLabel("Sabiduría");
        lblSabiduria.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblSabiduria.setBounds(380, 366, 74, 14);
        add(lblSabiduria);

        // Etiqueta carisma
        lblCarisma = new JLabel("Carisma");
        lblCarisma.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblCarisma.setBounds(384, 397, 70, 14);
        add(lblCarisma);

        // Spinners
        spinnerExperiencia = new JSpinner();
        spinnerExperiencia.setForeground(new Color(242, 242, 242));
        spinnerExperiencia.setBackground(new Color(29, 161, 242));
        spinnerExperiencia.setOpaque(true);
        spinnerExperiencia.setBounds(506, 205, 42, 20);
        add(spinnerExperiencia);

        spinnerFuerza = new JSpinner();
        spinnerFuerza.setOpaque(true);
        spinnerFuerza.setForeground(new Color(242, 242, 242));
        spinnerFuerza.setBackground(new Color(29, 161, 242));
        spinnerFuerza.setBounds(506, 236, 42, 20);
        add(spinnerFuerza);

        spinnerDestreza = new JSpinner();
        spinnerDestreza.setOpaque(true);
        spinnerDestreza.setForeground(new Color(242, 242, 242));
        spinnerDestreza.setBackground(new Color(29, 161, 242));
        spinnerDestreza.setBounds(506, 267, 42, 20);
        add(spinnerDestreza);

        spinnerConstitucion = new JSpinner();
        spinnerConstitucion.setOpaque(true);
        spinnerConstitucion.setForeground(new Color(242, 242, 242));
        spinnerConstitucion.setBackground(new Color(29, 161, 242));
        spinnerConstitucion.setBounds(506, 298, 42, 20);
        add(spinnerConstitucion);

        spinnerInteligencia = new JSpinner();
        spinnerInteligencia.setOpaque(true);
        spinnerInteligencia.setForeground(new Color(242, 242, 242));
        spinnerInteligencia.setBackground(new Color(29, 161, 242));
        spinnerInteligencia.setBounds(506, 329, 42, 20);
        add(spinnerInteligencia);

        spinnerSabiduria = new JSpinner();
        spinnerSabiduria.setOpaque(true);
        spinnerSabiduria.setForeground(new Color(242, 242, 242));
        spinnerSabiduria.setBackground(new Color(29, 161, 242));
        spinnerSabiduria.setBounds(506, 360, 42, 20);
        add(spinnerSabiduria);

        spinnerCarisma = new JSpinner();
        spinnerCarisma.setOpaque(true);
        spinnerCarisma.setForeground(new Color(242, 242, 242));
        spinnerCarisma.setBackground(new Color(29, 161, 242));
        spinnerCarisma.setBounds(506, 391, 42, 20);
        add(spinnerCarisma);

        // Imagen del personaje
        lblIconoPersn = new JLabel("");
        lblIconoPersn.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/personajes/personaje_1.png")));
        lblIconoPersn.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoPersn.setBounds(240, 208, 84, 123);
        add(lblIconoPersn);
        
        // Etiqueta raza
        lblRaza = new JLabel("Raza");
        lblRaza.setForeground(new Color(29, 29, 27));
        lblRaza.setHorizontalAlignment(SwingConstants.LEFT);
        lblRaza.setFont(new Font("Open Sans", Font.BOLD, 16));
        lblRaza.setBounds(194, 364, 49, 14);
        add(lblRaza);

        // Etiqueta clase
        lblClase = new JLabel("Clase");
        lblClase.setForeground(new Color(29, 29, 27));
        lblClase.setHorizontalAlignment(SwingConstants.LEFT);
        lblClase.setFont(new Font("Open Sans", Font.BOLD, 16));
        lblClase.setBounds(194, 395, 49, 14);
        add(lblClase);
        
        //Campo texto raza
  		txtRaza = new JTextField();
  		txtRaza.setBackground(new Color(242, 242, 242));
  		txtRaza.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtRaza.setBounds(245, 364, 107, 14);
  		txtRaza.setColumns(10);
  		txtRaza.setBorder(border);
  		add(txtRaza);
  		
  		//Campo texto raza
  		txtClase = new JTextField();
  		txtClase.setBackground(new Color(242, 242, 242));
  		txtClase.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtClase.setBounds(245, 395, 107, 14);
  		txtClase.setColumns(10);
  		txtClase.setBorder(border);
  		add(txtClase);

        // Botones
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardar.setForeground(new Color(242, 242, 242));
        btnGuardar.setBackground(new Color(29, 161, 242));
        btnGuardar.setOpaque(true);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setBounds(286, 485, 159, 45);
        add(btnGuardar);

        btnGuardarImagen = new JButton("");
        btnGuardarImagen.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/camara_fotografica.png")));
        btnGuardarImagen.setOpaque(true);
        btnGuardarImagen.setForeground(new Color(242, 242, 242));
        btnGuardarImagen.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardarImagen.setBorderPainted(false);
        btnGuardarImagen.setBackground(new Color(29, 29, 27));
        btnGuardarImagen.setBounds(453, 485, 61, 45);
        add(btnGuardarImagen);

		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
