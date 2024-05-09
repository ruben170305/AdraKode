package views;

// Librerías
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import listeners.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerPartidas extends JPanel {
	private JLabel lblTitulo, lblImagen;
	private JButton btnSeleccionar;
	private JLabel lblTituloPartida, lblAnfitrion, lblJugadores, lblDuración, lblFecha, lblEstado;
	private VerPartidaListener listener;

	public VerPartidas( VerPartidaListener listener ) {
		this.listener = listener;
		setBackground(new Color(242, 242, 242));
		inicializarComponentes();
	}

	private void inicializarComponentes() {

		// layout absoluto
		setLayout(null);

		// Tamaño y posicion de ventana
		setSize(800, 600);

		// Capturamos la colección de datos de MySQL
		this.listener.get_data();
		
		/* COMPONENTES */

		// Titulo
		lblTitulo = new JLabel("VER PARTIDAS");
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
		
		
		// Tabla

		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Estado" };

		// Generamos el array de datos de la tabla
        Object[][] data = new Object[100][6];

		// Capturamos los datos de MySQL mediante una consulta
		ResultSet rows = this.listener.get_data();
		try {
			// Mientras haya registros, rellenamos el array
            for ( int i = 0; rows.next() && i < data.length; i++ ) {

				// Insertamos los datos
                data[i][0] = rows.getString( "cod" );
                data[i][1] = rows.getString( "nombre" );
                data[i][2] = rows.getString( "ambientacion" );
                data[i][3] = rows.getString( "duracion" );
                data[i][4] = rows.getString( "dia" );

				// Determinamos el estado
				String en_curso_text = ( Integer.parseInt( rows.getString( "enCurso" ) ) == 1 ) ? "En curso" : "Finalizada";
                data[i][5] = en_curso_text;
            }
		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Creamos una plantilla para la tabla
		DefaultTableModel template = new DefaultTableModel(data, columns);
		JTable table = new JTable(template);
		table.setForeground(new Color(29, 29, 27));
		table.setBackground(new Color(242, 242, 242));
		table.setFont(new Font("Open Sans", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(122, 343, 556, 122);
		add(scrollPane);

		
		// Imagen de la partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/paisaje.jpeg")));
		lblImagen.setBounds(231, 164, 172, 143);
		add(lblImagen);
		
		// Etiquetas
		lblTituloPartida = new JLabel("Partida 1");
		lblTituloPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPartida.setIcon(null);
		lblTituloPartida.setForeground(new Color(29, 29, 27));
		lblTituloPartida.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblTituloPartida.setBounds(302, 121, 195, 26);
		add(lblTituloPartida);
		
		lblAnfitrion = new JLabel("Anfitrión 1");
		lblAnfitrion.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/usuario.png")));
		lblAnfitrion.setForeground(new Color(29, 29, 27));
		lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrion.setBounds(425, 164, 183, 26);
		add(lblAnfitrion);
		
		lblJugadores = new JLabel("4");
		lblJugadores.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/equipo.png")));
		lblJugadores.setForeground(new Color(29, 29, 27));
		lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblJugadores.setBounds(425, 193, 183, 26);
		add(lblJugadores);

		lblDuración = new JLabel("30'");
		lblDuración.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/repetir.png")));
		lblDuración.setForeground(new Color(29, 29, 27));
		lblDuración.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblDuración.setBounds(425, 222, 183, 26);
		add(lblDuración);
		
		lblFecha = new JLabel("13-04 16:00 pm");
		lblFecha.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/calendario.png")));
		lblFecha.setForeground(new Color(29, 29, 27));
		lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblFecha.setBounds(425, 251, 183, 26);
		add(lblFecha);
		
		lblEstado = new JLabel("En curso");
		lblEstado.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/ajustes.png")));
		lblEstado.setForeground(new Color(29, 29, 27));
		lblEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblEstado.setBounds(425, 280, 183, 26);
		add(lblEstado);

		btnSeleccionar = new JButton("JUGAR");
		btnSeleccionar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnSeleccionar.setForeground(new Color(242, 242, 242));
		btnSeleccionar.setBackground(new Color(29, 161, 242));
		btnSeleccionar.setOpaque(true);
		btnSeleccionar.setBorderPainted(false);
		btnSeleccionar.setBounds(314, 493, 172, 41);
		add(btnSeleccionar);

	}
	
	public void setListener(VerPartidaListener listener) {
		btnSeleccionar.addActionListener(listener);
	}
}
