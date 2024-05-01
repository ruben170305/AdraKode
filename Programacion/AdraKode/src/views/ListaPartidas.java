package views;

// Librerías
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaPartidas extends JPanel {
	private JLabel lblTitulo, lblImagen;
	private JButton btnEditar, btnBorrar, btnSeleccionar;
	private JLabel lblNewLabel;
	private JLabel lblAnfitrin;
	private JLabel lblAnfitrin_1;
	private JLabel lblAnfitrin_2;
	private JLabel lblAnfitrin_3;
	private JLabel lblAnfitrin_4;

	public ListaPartidas() {
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
		lblTitulo = new JLabel("VER PARTIDA");
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
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Anfitrión", "Jugadores", "Duración", "Fecha", "Estado" };

		// Insertamos los datos de la tabla
		Object[][] data = { { "Partida 1", "Usuario 1", 4, "30'", "13-04 16:00 pm", "En curso" },
				{ "Partida 2", "Usuario 2", 3, "15'", "16-04 15:00 pm", "En espera" },
				{ "Partida 3", "Usuario 5", 2, "25'", "12-04 11:00 am", "Finalizada" },
				{ "Partida 2", "Usuario 2", 3, "15'", "16-04 15:00 pm", "En espera" },
				{ "Partida 3", "Usuario 5", 2, "25'", "12-04 11:00 am", "Finalizada" },
				{ "Partida 2", "Usuario 2", 3, "15'", "16-04 15:00 pm", "En espera" },
				{ "Partida 2", "Usuario 2", 3, "15'", "16-04 15:00 pm", "En espera" },
				{ "Partida 3", "Usuario 5", 2, "25'", "12-04 11:00 am", "Finalizada" }

		};

		// Creamos una plantilla para la tabla
		DefaultTableModel template = new DefaultTableModel(data, columns);
		JTable table = new JTable(template);
		table.setForeground(new Color(29, 29, 27));
		table.setBackground(new Color(242, 242, 242));
		table.setFont(new Font("Open Sans", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(101, 323, 599, 141);
		add(scrollPane);

		//Botón editar partida
		btnEditar = new JButton();
		btnEditar.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonEditarW.png")));
		btnEditar.setOpaque(true);
		btnEditar.setForeground(new Color(29, 29, 27));
		btnEditar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnEditar.setBorderPainted(false);
		btnEditar.setBackground(new Color(29, 29, 27));
		btnEditar.setBounds(315, 482, 83, 36);
		add(btnEditar);

		// Boton borrar
		btnBorrar = new JButton();
		btnBorrar.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonBorrarW.png")));
		btnBorrar.setOpaque(true);
		btnBorrar.setForeground(new Color(29, 29, 27));
		btnBorrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(new Color(29, 29, 27));
		btnBorrar.setBounds(404, 482, 83, 36);
		add(btnBorrar);

		// Boton seleccionar
		btnSeleccionar = new JButton("JUGAR");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeleccionar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnSeleccionar.setForeground(new Color(242, 242, 242));
		btnSeleccionar.setBackground(new Color(29, 161, 242));
		btnSeleccionar.setOpaque(true);
		btnSeleccionar.setBorderPainted(false);
		btnSeleccionar.setBounds(315, 523, 172, 41);
		add(btnSeleccionar);

		//Imagen de la partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(ListaPartidas.class.getResource("/img/paisaje.jpeg")));
		lblImagen.setBounds(226, 125, 172, 172);
		add(lblImagen);
		
		//Label y configuracion de la etiqueta partida
		lblNewLabel = new JLabel("Partida 1");
		lblNewLabel.setIcon(new ImageIcon(ListaPartidas.class.getResource("/img/boton-de-play.png")));
		lblNewLabel.setForeground(new Color(29, 29, 27));
		lblNewLabel.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblNewLabel.setBounds(420, 125, 183, 26);
		add(lblNewLabel);
		
		//Label y configuracion de la etiqueta anfitrion
		lblAnfitrin = new JLabel("Anfitrión 1");
		lblAnfitrin.setIcon(new ImageIcon(ListaPartidas.class.getResource("/img/usuario.png")));
		lblAnfitrin.setForeground(new Color(29, 29, 27));
		lblAnfitrin.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrin.setBounds(420, 154, 183, 26);
		add(lblAnfitrin);
		
		//Label y configuracion de la etiqueta equipo
		lblAnfitrin_1 = new JLabel("4");
		lblAnfitrin_1.setIcon(new ImageIcon(ListaPartidas.class.getResource("/img/equipo.png")));
		lblAnfitrin_1.setForeground(new Color(29, 29, 27));
		lblAnfitrin_1.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrin_1.setBounds(420, 183, 183, 26);
		add(lblAnfitrin_1);

		//Label y configuracion de la etiqueta duracion
		lblAnfitrin_2 = new JLabel("30'");
		lblAnfitrin_2.setIcon(new ImageIcon(ListaPartidas.class.getResource("/img/repetir.png")));
		lblAnfitrin_2.setForeground(new Color(29, 29, 27));
		lblAnfitrin_2.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrin_2.setBounds(420, 212, 183, 26);
		add(lblAnfitrin_2);
		
		//Label y configuracion de la etiqueta fecha
		lblAnfitrin_3 = new JLabel("13-04 16:00 pm");
		lblAnfitrin_3.setIcon(new ImageIcon(ListaPartidas.class.getResource("/img/calendario.png")));
		lblAnfitrin_3.setForeground(new Color(29, 29, 27));
		lblAnfitrin_3.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrin_3.setBounds(420, 241, 183, 26);
		add(lblAnfitrin_3);
		
		//Label y configuracion de la etiqueta "En curso"
		lblAnfitrin_4 = new JLabel("En curso");
		lblAnfitrin_4.setIcon(new ImageIcon(ListaPartidas.class.getResource("/img/ajustes.png")));
		lblAnfitrin_4.setForeground(new Color(29, 29, 27));
		lblAnfitrin_4.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrin_4.setBounds(420, 270, 183, 26);
		add(lblAnfitrin_4);

	}

//	public void hacerVisible() {
//		setVisible(true);
//	}
}
