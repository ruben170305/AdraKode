package views;

// Librerías
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarPartida extends JPanel {
	private JLabel lblTitulo, lblImagen, lblAnfitrion, lblJugadores, lblDuracion, lblFecha, lblEstado;
	private JButton btnGuardar, btnGuardarImagen;
	private JTextField txtNombrePartida, txtAnfitrion, txtJugadores, txtDuracion, txtFecha, txtEstado;
	private JLabel lblNewLabel, lblIconAnfitrion, lblIconJugadores, lblIconDuracion, lblIconFecha, lblIconEstado;

	public EditarPartida() {
		setBackground(new Color(242, 242, 242));
		inicializarComponentes();
		//hacerVisible();
	}

	private void inicializarComponentes() {
		// Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// layout absoluto
		setLayout(null);

		// Tamaño y posicion de ventana
		setSize(800, 600);
		// setLocation(null);

		
		
		/* COMPONENTES */

		// Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));

		// Titulo
		lblTitulo = new JLabel("EDITAR PARTIDA");
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

		//Label partida
		lblNewLabel = new JLabel("Partida:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(null);
		lblNewLabel.setForeground(new Color(29, 29, 27));
		lblNewLabel.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblNewLabel.setBounds(291, 125, 72, 22);
		add(lblNewLabel);

		//Imagen partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/paisaje.jpeg")));
		lblImagen.setBounds(314, 169, 172, 143);
		add(lblImagen);
		
		
		// Iconos
		lblIconAnfitrion = new JLabel("");
		lblIconAnfitrion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAnfitrion.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/usuario.png")));
		lblIconAnfitrion.setForeground(new Color(29, 29, 27));
		lblIconAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconAnfitrion.setBounds(160, 325, 32, 26);
		add(lblIconAnfitrion);

		lblIconJugadores = new JLabel("");
		lblIconJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconJugadores.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/equipo.png")));
		lblIconJugadores.setForeground(new Color(29, 29, 27));
		lblIconJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconJugadores.setBounds(160, 354, 32, 26);
		add(lblIconJugadores);

		lblIconDuracion = new JLabel("");
		lblIconDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDuracion.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/repetir.png")));
		lblIconDuracion.setForeground(new Color(29, 29, 27));
		lblIconDuracion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconDuracion.setBounds(160, 383, 32, 26);
		add(lblIconDuracion);
		
		lblIconFecha = new JLabel("");
		lblIconFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconFecha.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/calendario.png")));
		lblIconFecha.setForeground(new Color(29, 29, 27));
		lblIconFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconFecha.setBounds(160, 412, 32, 26);
		add(lblIconFecha);
		
		lblIconEstado = new JLabel("");
		lblIconEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEstado.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/ajustes.png")));
		lblIconEstado.setForeground(new Color(29, 29, 27));
		lblIconEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconEstado.setBounds(160, 441, 32, 26);
		add(lblIconEstado);
        
		
		// Etiquetas 
        lblAnfitrion = new JLabel("Anfitrión");
        lblAnfitrion.setHorizontalAlignment(SwingConstants.LEFT);
        lblAnfitrion.setForeground(new Color(29, 29, 27));
        lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblAnfitrion.setBounds(202, 325, 72, 26);
        add(lblAnfitrion);
        
        lblJugadores = new JLabel("Jugadores");
        lblJugadores.setHorizontalAlignment(SwingConstants.LEFT);
        lblJugadores.setForeground(new Color(29, 29, 27));
        lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblJugadores.setBounds(202, 354, 72, 26);
        add(lblJugadores);
        
        lblDuracion = new JLabel("Duración");
        lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
        lblDuracion.setForeground(new Color(29, 29, 27));
        lblDuracion.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblDuracion.setBounds(202, 383, 72, 26);
        add(lblDuracion);
        
        lblFecha = new JLabel("Fecha");
        lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
        lblFecha.setForeground(new Color(29, 29, 27));
        lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblFecha.setBounds(202, 412, 72, 26);
        add(lblFecha);
        
        lblEstado = new JLabel("Estado");
        lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
        lblEstado.setForeground(new Color(29, 29, 27));
        lblEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblEstado.setBounds(202, 441, 72, 26);
        add(lblEstado);
        
        
        //Campo texto
  		txtNombrePartida = new JTextField();
  		txtNombrePartida.setBackground(new Color(242, 242, 242));
  		txtNombrePartida.setFont(new Font("Open Sans", Font.PLAIN, 14));
  		txtNombrePartida.setBounds(373, 133, 121, 14);
  		txtNombrePartida.setColumns(10);
  		txtNombrePartida.setBorder(border);
  		add(txtNombrePartida);
  		
  		txtAnfitrion = new JTextField();
  		txtAnfitrion.setBackground(new Color(242, 242, 242));
  		txtAnfitrion.setFont(new Font("Open Sans", Font.PLAIN, 14));
  		txtAnfitrion.setBounds(274, 331, 121, 14);
  		txtAnfitrion.setColumns(10);
  		txtAnfitrion.setBorder(border);
  		add(txtAnfitrion);
  		
  		txtJugadores = new JTextField();
  		txtJugadores.setBackground(new Color(242, 242, 242));
  		txtJugadores.setFont(new Font("Open Sans", Font.PLAIN, 14));
  		txtJugadores.setBounds(274, 360, 121, 14);
  		txtJugadores.setColumns(10);
  		txtJugadores.setBorder(border);
  		add(txtJugadores);
  		
  		txtDuracion = new JTextField();
  		txtDuracion.setBackground(new Color(242, 242, 242));
  		txtDuracion.setFont(new Font("Open Sans", Font.PLAIN, 14));
  		txtDuracion.setBounds(274, 389, 121, 14);
  		txtDuracion.setColumns(10);
  		txtDuracion.setBorder(border);
  		add(txtDuracion);
  		
  		txtFecha = new JTextField();
  		txtFecha.setBackground(new Color(242, 242, 242));
  		txtFecha.setFont(new Font("Open Sans", Font.PLAIN, 14));
  		txtFecha.setBounds(274, 418, 121, 14);
  		txtFecha.setColumns(10);
  		txtFecha.setBorder(border);
  		add(txtFecha);
  		
  		txtEstado = new JTextField();
  		txtEstado.setBackground(new Color(242, 242, 242));
  		txtEstado.setFont(new Font("Open Sans", Font.PLAIN, 14));
  		txtEstado.setBounds(274, 447, 121, 14);
  		txtEstado.setColumns(10);
  		txtEstado.setBorder(border);
  		add(txtEstado);
        
  		// Tabla
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "Jugador", "Raza", "Clase"};

		// Insertamos los datos de la tabla
		Object[][] data = { 
				{ "Jugador 1", "Raza 1", "Clase 1"},
				{ "Jugador 2", "Raza 2", "Clase 2"},
				{ "Jugador 3", "Raza 3", "Clase 3"},
				{ "Jugador 4", "Raza 4", "Clase 4"},
				{ "Jugador 5", "Raza 5", "Clase 5"},
				{ "Jugador 6", "Raza 6", "Clase 6"},
				{ "Jugador 7", "Raza 7", "Clase 7"},
				{ "Jugador 8", "Raza 8", "Clase 8"}
		};

		// Creamos una plantilla para la tabla
		DefaultTableModel template = new DefaultTableModel(data, columns);
		JTable table = new JTable(template);
		table.setLocation(599, 0);
		table.setForeground(new Color(29, 29, 27));
		table.setBackground(new Color(242, 242, 242));
		table.setFont(new Font("Open Sans", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(439, 342, 251, 122);
		add(scrollPane);
		
  		
        // Botones
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardar.setForeground(new Color(242, 242, 242));
        btnGuardar.setBackground(new Color(29, 161, 242));
        btnGuardar.setOpaque(true);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setBounds(286, 510, 159, 45);
        add(btnGuardar);

        btnGuardarImagen = new JButton("");
        btnGuardarImagen.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/camara_fotografica.png")));
        btnGuardarImagen.setOpaque(true);
        btnGuardarImagen.setForeground(new Color(242, 242, 242));
        btnGuardarImagen.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardarImagen.setBorderPainted(false);
        btnGuardarImagen.setBackground(new Color(29, 29, 27));
        btnGuardarImagen.setBounds(453, 510, 61, 45);
        add(btnGuardarImagen);

	}
}
