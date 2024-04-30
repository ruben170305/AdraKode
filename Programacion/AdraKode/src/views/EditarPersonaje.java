package views;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.LineBorder;

import listeners.EditarPersonajesListener;

public class EditarPersonaje extends JPanel {
    private JLabel lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
    private JLabel lblTitulo, lblFuerza, lblSeleccionarPersonaje, lblRaza, lblIconoPersn;
    private JLabel lblIconoExp, lblIconoFuerza, lblIconoDestreza, lblIconoConst, lblIconoInteligencia, lblIconoSabiduria, lblIconoCarisma, lblClase, lblExp;
    private JSpinner spinnerExperiencia, spinnerFuerza, spinnerDestreza, spinnerConstitucion, spinnerInteligencia, spinnerSabiduria, spinnerCarisma;
    private JButton btnGuardarImagen, btnGuardar;

    public EditarPersonaje() {
        setBounds(new Rectangle(0, 0, 0, 19));
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

        // Titulo
        lblTitulo = new JLabel("EDITAR PERSONAJES");
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
        lblRaza = new JLabel("Raza 1");
        lblRaza.setForeground(new Color(29, 29, 27));
        lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
        lblRaza.setFont(new Font("Open Sans", Font.BOLD, 16));
        lblRaza.setBounds(212, 366, 140, 14);
        add(lblRaza);

        // Etiqueta clase
        lblClase = new JLabel("Clase 1");
        lblClase.setForeground(new Color(29, 29, 27));
        lblClase.setHorizontalAlignment(SwingConstants.CENTER);
        lblClase.setFont(new Font("Open Sans", Font.BOLD, 16));
        lblClase.setBounds(212, 397, 140, 14);
        add(lblClase);

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
        btnGuardarImagen.setName("botonSubirImagen");
        btnGuardarImagen.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/camara_fotografica.png")));
        btnGuardarImagen.setOpaque(true);
        btnGuardarImagen.setForeground(new Color(242, 242, 242));
        btnGuardarImagen.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardarImagen.setBorderPainted(false);
        btnGuardarImagen.setBackground(new Color(29, 29, 27));
        btnGuardarImagen.setBounds(453, 485, 61, 45);
        add(btnGuardarImagen);
    }

    public void setListener( EditarPersonajesListener listener ) {
		btnGuardar.addActionListener( listener );
        btnGuardarImagen.addActionListener( listener );
	}
    
    public void hacerVisible() {
        setVisible(true);
    }
}
