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
	private JLabel lblTitulo;
	private JButton btnEditar, btnBorrar, btnSeleccionar;

	public ListaPartidas() {
		setBackground(new Color(242, 242, 242));
		inicializarComponentes();
		hacerVisible();
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
		String[] columns = { "ID", "Anfitrión", "Jugadores", "Duración", "Fecha", "Estado", "" };

		// Insertamos los datos de la tabla
		Object[][] data = { { "Partida 1", "Usuario 1", 4, "30'", "13-04 16:00 pm", "En curso", "Seleccionar" },
				{ "Partida 2", "Usuario 2", 3, "15'", "16-04 15:00 pm", "En espera", "Seleccionar" },
				{ "Partida 3", "Usuario 5", 2, "25'", "12-04 11:00 am", "Finalizada", "Seleccionar" } };

		// Creamos una plantilla para la tabla
		DefaultTableModel template = new DefaultTableModel(data, columns);
		JTable table = new JTable(template);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 120, 700, 300);
		add(scrollPane);

		btnEditar = new JButton();
		btnEditar.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonEditarW.png")));
		btnEditar.setOpaque(true);
		btnEditar.setForeground(new Color(29, 29, 27));
		btnEditar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnEditar.setBorderPainted(false);
		btnEditar.setBackground(new Color(29, 29, 27));
		btnEditar.setBounds(315, 467, 83, 36);
		add(btnEditar);

		// Boton borrar
		btnBorrar = new JButton();
		btnBorrar.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonBorrarW.png")));
		btnBorrar.setOpaque(true);
		btnBorrar.setForeground(new Color(29, 29, 27));
		btnBorrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(new Color(29, 29, 27));
		btnBorrar.setBounds(404, 467, 83, 36);
		add(btnBorrar);

		// Boton seleccionar
		btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeleccionar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnSeleccionar.setForeground(new Color(242, 242, 242));
		btnSeleccionar.setBackground(new Color(29, 161, 242));
		btnSeleccionar.setOpaque(true);
		btnSeleccionar.setBorderPainted(false);
		btnSeleccionar.setBounds(315, 509, 172, 41);
		add(btnSeleccionar);

	}

	public void hacerVisible() {
		setVisible(true);
	}
}


