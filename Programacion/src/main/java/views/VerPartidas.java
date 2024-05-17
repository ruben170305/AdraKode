package views;

// Librerías
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import listeners.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.*;

public class VerPartidas extends JPanel {
	private JLabel lblTitulo, lblImagen;
	private JButton btnSeleccionar;
	private JLabel lblTituloPartida, lblAnfitrion, lblJugadores, lblDuración, lblFecha, lblEstado;
	private Data data;

	public VerPartidas( Data data ) {
		this.data = data;
		setBackground( new Color( 242, 242, 242 ) );
		initialize_components();
	}

	private void initialize_components() {

		// layout absoluto
		setLayout(null);

		// Tamaño y posicion de ventana
		setSize(800, 600);
		
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
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Anfitrion", "Nº jugadores", "Estado" };

		// Capturamos los datos de MySQL mediante una consulta
		ArrayList<Partida> rows = this.data.getPartidas();
		ArrayList<Object[]> row_data_list = new ArrayList<>();

		for ( Partida partida : rows ) {
			
			// Inicializamos un Objeto temporal donde almacenamos los datos de la fila
			Object[] row_data = new Object[ columns.length ];

			// Insertamos los datos
			row_data[0] = partida.getPart_id();
			row_data[1] = partida.getNombre();
			row_data[2] = partida.getAmbientacion();
			row_data[3] = partida.getDuracion();
			row_data[4] = partida.getFecha();
			row_data[6] = partida.getNumero_jugadores();
			// Formateo de campos
			String anfitrion = partida.getNombre_anfitrion() + " " + partida.getApellidos_anfitrion();
			row_data[5] = anfitrion;

			// Determinamos el estado
			String en_curso_text = ( partida.getEn_curso() == 1 ) ? "En curso" : "Finalizada";
			row_data[7] = en_curso_text;

			// Añadimos los datos al arrayList final
			row_data_list.add( row_data );
		}

		// Pasamos los datos al Objeto final que insertaremos en la tabla
		Object[][] data_table = new Object[ row_data_list.size() ][ columns.length ];
		row_data_list.toArray( data_table );

		// Creamos una plantilla para la tabla
		DefaultTableModel template = new DefaultTableModel(data_table, columns);
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
		lblTituloPartida = new JLabel( data_table[0][1].toString() );
		lblTituloPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPartida.setIcon(null);
		lblTituloPartida.setForeground(new Color(29, 29, 27));
		lblTituloPartida.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblTituloPartida.setBounds(302, 121, 195, 26);
		add(lblTituloPartida);
		
		lblAnfitrion = new JLabel( data_table[0][5].toString() );
		lblAnfitrion.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/usuario.png")));
		lblAnfitrion.setForeground(new Color(29, 29, 27));
		lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrion.setBounds(425, 164, 183, 26);
		add(lblAnfitrion);
		
		lblJugadores = new JLabel( data_table[0][6].toString() );
		lblJugadores.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/equipo.png")));
		lblJugadores.setForeground(new Color(29, 29, 27));
		lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblJugadores.setBounds(425, 193, 183, 26);
		add(lblJugadores);

		lblDuración = new JLabel( data_table[0][3].toString() + "'" );
		lblDuración.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/repetir.png")));
		lblDuración.setForeground(new Color(29, 29, 27));
		lblDuración.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblDuración.setBounds(425, 222, 183, 26);
		add(lblDuración);
		
		lblFecha = new JLabel( data_table[0][4].toString() );
		lblFecha.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/calendario.png")));
		lblFecha.setForeground(new Color(29, 29, 27));
		lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblFecha.setBounds(425, 251, 183, 26);
		add(lblFecha);
		
		lblEstado = new JLabel( data_table[0][7].toString() );
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

		// Añadimos un listener a cada fila de la tabla de partidas
		table.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
			
			public void valueChanged( ListSelectionEvent e ) {

				// Capturamos la fila y el valor del ID de la partida
				int selected_row = table.getSelectedRow();

				// Actualizamos los JLabel con la información de la fila seleccionada
				lblTituloPartida.setText( table.getValueAt( selected_row, 1 ).toString() );
				lblAnfitrion.setText( table.getValueAt( selected_row, 5 ).toString() );
				lblJugadores.setText( table.getValueAt( selected_row, 6 ).toString() );
				lblDuración.setText( table.getValueAt( selected_row, 3 ).toString() + "'" );
				lblFecha.setText( table.getValueAt( selected_row, 4 ).toString() );
				lblEstado.setText( table.getValueAt( selected_row, 7 ).toString() );
			}

		} );

	}
	
	public void setListener( VerPartidaListener listener ) {
		btnSeleccionar.addActionListener( listener );
	}
}
