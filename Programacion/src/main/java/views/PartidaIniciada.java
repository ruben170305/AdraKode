package views;

// Librerías
import javax.swing.*;
import javax.swing.border.LineBorder;
import listeners.*;
import model.*;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PartidaIniciada extends JPanel {
	private JLabel lblImagen;
	private JLabel lblTituloPartida, lblAnfitrion, lblJugadores, lblDuración, lblFecha, lblEstado, lblNivelPartida, lblNivelPartidaTitulo;
	
	private JLabel lblRaza, lblExp, lblIconoExp, lblIconoFuerza, lblIconoDestreza, lblIconoCarisma, lblClase, lblNombrePersonaje;
	private JLabel lblFuerza, lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma, lblIconoConst, lblIconoInteligencia, lblIconoSabiduria, lblIconoPersn;
	private JProgressBar pbExp, pbFuerza, pbDestreza, pbConstitucion, pbInteligencia, pbSabiduria, pbCarisma;
	private Partida partida;
	private Personaje personaje;

	public PartidaIniciada( Usuario user ) {
		setBackground( new Color( 242, 242, 242 ) );

		this.partida = new Partida();
		this.personaje = new Personaje( user );

		initialize_components();
	}

	private void initialize_components() {

		// layout absoluto
		setLayout(null);

		// Tamaño y posicion de ventana
		setSize(800, 600);

		// Separador
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		separator.setPreferredSize(new Dimension(0, 3));
		separator.setMaximumSize(new Dimension(32778, 32767));
		separator.setBackground(new Color(29, 29, 27));
		separator.setForeground(new Color(29, 29, 27));
		separator.setBounds(337, 88, 125, 3);
		add(separator);
		
		//PARTIDA DETALLES
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Anfitrion", "Nº jugadores", "Estado" };

		// Capturamos los datos de MySQL mediante una consulta
		ResultSet rows = partida.get_partidas();
		ArrayList<Object[]> row_data_list = new ArrayList<>();

		// Capturamos el número de filas del resultado de la consulta
		try {
			while ( rows.next() ) {

				// Inicializamos un Objeto temporal donde almacenamos los datos de la fila
				Object[] row_data = new Object[ columns.length ];

				// Insertamos los datos
                row_data[0] = rows.getString( "partida_id" );
                row_data[1] = rows.getString( "nombre" );
                row_data[2] = rows.getString( "ambientacion" );
                row_data[3] = rows.getString( "duracion" );
                row_data[4] = rows.getString( "fecha" );
				row_data[6] = rows.getInt( "numero_jugadores" );

				// Formateo de campos
				String anfitrion = rows.getString( "nombre_anfitrion" ) + " " + rows.getString( "apellidos_anfitrion" );
				row_data[5] = anfitrion;

				// Determinamos el estado
				String en_curso_text = ( Integer.parseInt( rows.getString( "en_curso" ) ) == 1 ) ? "En curso" : "Finalizada";
                row_data[7] = en_curso_text;

				// Añadimos los datos al arrayList final
				row_data_list.add( row_data );
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		// Pasamos los datos al Objeto final que insertaremos en la tabla
        Object[][] data = new Object[ row_data_list.size() ][ columns.length ];
		row_data_list.toArray( data );
		
		// Imagen de la partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/paisaje.jpeg")));
		lblImagen.setBounds(231, 149, 172, 143);
		add(lblImagen);
		
		// Etiquetas
		lblTituloPartida = new JLabel( data[0][1].toString() );
		lblTituloPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPartida.setIcon(null);
		lblTituloPartida.setForeground(new Color(29, 29, 27));
		lblTituloPartida.setFont(new Font("Oxygen", Font.BOLD, 25));
		lblTituloPartida.setBounds(302, 44, 195, 26);
		add(lblTituloPartida);
		
		
		lblNivelPartidaTitulo = new JLabel("Nivel: ");
		lblNivelPartidaTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNivelPartidaTitulo.setIcon(null);
		lblNivelPartidaTitulo.setForeground(new Color(29, 29, 27));
		lblNivelPartidaTitulo.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblNivelPartidaTitulo.setBounds(207, 112, 195, 26);
		add(lblNivelPartidaTitulo);
		
		lblNivelPartida = new JLabel( data[0][1].toString() );
		lblNivelPartida.setHorizontalAlignment(SwingConstants.LEFT);
		lblNivelPartida.setIcon(null);
		lblNivelPartida.setForeground(new Color(29, 29, 27));
		lblNivelPartida.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblNivelPartida.setBounds(399, 112, 144, 26);
		add(lblNivelPartida);
		
		lblAnfitrion = new JLabel( data[0][5].toString() );
		lblAnfitrion.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/usuario.png")));
		lblAnfitrion.setForeground(new Color(29, 29, 27));
		lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrion.setBounds(425, 149, 183, 26);
		add(lblAnfitrion);
		
		lblJugadores = new JLabel( data[0][6].toString() );
		lblJugadores.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/equipo.png")));
		lblJugadores.setForeground(new Color(29, 29, 27));
		lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblJugadores.setBounds(425, 178, 183, 26);
		add(lblJugadores);

		lblDuración = new JLabel( data[0][3].toString() + "'" );
		lblDuración.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/repetir.png")));
		lblDuración.setForeground(new Color(29, 29, 27));
		lblDuración.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblDuración.setBounds(425, 207, 183, 26);
		add(lblDuración);
		
		lblFecha = new JLabel( data[0][4].toString() );
		lblFecha.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/calendario.png")));
		lblFecha.setForeground(new Color(29, 29, 27));
		lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblFecha.setBounds(425, 236, 183, 26);
		add(lblFecha);
		
		lblEstado = new JLabel( data[0][7].toString() );
		lblEstado.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/ajustes.png")));
		lblEstado.setForeground(new Color(29, 29, 27));
		lblEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblEstado.setBounds(425, 265, 183, 26);
		add(lblEstado);
		
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns_personajes = { "ID", "Nombre", "Personaje", "Raza", "Clase", "Expe", "Fuerza", "Destreza", "Constitucion", "Inteligencia", "Sabiduria", "Carisma" };

		// Capturamos los datos de MySQL mediante una consulta
		ResultSet rows_personajes = personaje.get_personajes();
		ArrayList<Object[]> row_data_list_personajes = new ArrayList<>();

		// Capturamos el número de filas del resultado de la consulta
		try {
			while ( rows_personajes.next() ) {

				// Inicializamos un Objeto temporal donde almacenamos los datos de la fila
				Object[] row_data = new Object[ columns_personajes.length ];

				// Insertamos los datos
                row_data[0] = rows_personajes.getInt( "cod" );
                row_data[1] = rows_personajes.getString( "nombre" );
                row_data[2] = rows_personajes.getString( "personaje" );
                row_data[3] = rows_personajes.getString( "raza" );
                row_data[4] = rows_personajes.getString( "clase" );
				row_data[5] = rows_personajes.getInt( "expe" );
                row_data[6] = rows_personajes.getString( "fuerza" );
                row_data[7] = rows_personajes.getString( "destreza" );
                row_data[8] = rows_personajes.getString( "constitucion" );
				row_data[9] = rows_personajes.getInt( "inteligencia" );
                row_data[10] = rows_personajes.getString( "sabiduria" );
				row_data[11] = rows_personajes.getInt( "carisma" );

				// Añadimos los datos al arrayList final
				row_data_list_personajes.add( row_data );
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		// Pasamos los datos al Objeto final que insertaremos en la tabla
		Object[][] data_personajes = new Object[ row_data_list_personajes.size() ][ columns_personajes.length ];
		row_data_list_personajes.toArray( data_personajes );
		
		//PERSONAJE DETALLES
		
		lblNombrePersonaje = new JLabel( data_personajes[0][1].toString() ); // *Añadir listeners
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePersonaje.setForeground(new Color(29, 29, 27));
		lblNombrePersonaje.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblNombrePersonaje.setBounds(399, 322, 78, 14);
		add(lblNombrePersonaje);
		
		// Iconos
		lblIconoExp = new JLabel();
		lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoExp.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoExp.png")));
		lblIconoExp.setBounds(232, 347, 35, 33);
		add(lblIconoExp);

		lblIconoFuerza = new JLabel();
		lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoFuerza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoFrza.png")));
		lblIconoFuerza.setBounds(232, 378, 35, 33);
		add(lblIconoFuerza);

		lblIconoDestreza = new JLabel();
		lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoDestreza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoDestreza.png")));
		lblIconoDestreza.setBounds(232, 409, 35, 33);
		add(lblIconoDestreza);

		lblIconoConst = new JLabel();
		lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoConst.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoConstitucion.png")));
		lblIconoConst.setBounds(232, 440, 35, 33);
		add(lblIconoConst);

		lblIconoInteligencia = new JLabel();
		lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoInteligencia.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoInteli.png")));
		lblIconoInteligencia.setBounds(232, 471, 35, 33);
		add(lblIconoInteligencia);

		lblIconoSabiduria = new JLabel();
		lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoSabiduria.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoSab.png")));
		lblIconoSabiduria.setBounds(232, 502, 35, 33);
		add(lblIconoSabiduria);

		lblIconoCarisma = new JLabel();
		lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCarisma.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoCarisma.png")));
		lblIconoCarisma.setBounds(232, 533, 35, 33);
		add(lblIconoCarisma);

		// Etiquetas


		// Etiqueta exp
		lblExp = new JLabel( "Expe" );
		lblExp.setHorizontalAlignment(SwingConstants.LEFT);
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblExp.setBounds(277, 354, 104, 18);
		add(lblExp);

		// Etiqueta fuerza
		lblFuerza = new JLabel( "Fuerza" );
		lblFuerza.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblFuerza.setBounds(277, 385, 104, 18);
		add(lblFuerza);

		// Etiqueta destreza
		lblDestreza = new JLabel("Destreza");
		lblDestreza.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblDestreza.setBounds(277, 416, 104, 18);
		add(lblDestreza);

		// Etiqueta constitución
		lblConstitucion = new JLabel("Constitución");
		lblConstitucion.setHorizontalAlignment(SwingConstants.LEFT);
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblConstitucion.setBounds(277, 447, 104, 18);
		add(lblConstitucion);

		// Etiqueta inteligencia
		lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setHorizontalAlignment(SwingConstants.LEFT);
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblInteligencia.setBounds(277, 478, 104, 18);
		add(lblInteligencia);

		// Etiqueta sabiduría
		lblSabiduria = new JLabel("Sabiduría");
		lblSabiduria.setHorizontalAlignment(SwingConstants.LEFT);
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblSabiduria.setBounds(277, 509, 104, 18);
		add(lblSabiduria);

		// Etiqueta carisma
		lblCarisma = new JLabel("Carisma");
		lblCarisma.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblCarisma.setBounds(277, 540, 104, 18);
		add(lblCarisma);

		// Barras

		// Barra progreso experiencia
		pbExp = new JProgressBar();
		pbExp.setValue( Integer.parseInt( data_personajes[0][5].toString() ) );
		pbExp.setBackground(new Color(242, 242, 242));
		pbExp.setForeground(new Color(52, 75, 89));
		pbExp.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbExp.setStringPainted(true);
		pbExp.setBounds(372, 356, 82, 14);
		add(pbExp);

		// Barra progreso fuerza
		pbFuerza = new JProgressBar();
		pbExp.setValue( Integer.parseInt( data_personajes[0][6].toString() ) );
		pbFuerza.setBackground(new Color(242, 242, 242));
		pbFuerza.setForeground(new Color(52, 75, 89));
		pbFuerza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbFuerza.setStringPainted(true);
		pbFuerza.setBounds(372, 387, 82, 14);
		add(pbFuerza);

		// Barra progreso destreza
		pbDestreza = new JProgressBar();
		pbExp.setValue( Integer.parseInt( data_personajes[0][7].toString() ) );
		pbDestreza.setBackground(new Color(242, 242, 242));
		pbDestreza.setForeground(new Color(52, 75, 89));
		pbDestreza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbDestreza.setStringPainted(true);
		pbDestreza.setBounds(372, 418, 82, 14);
		add(pbDestreza);

		// Barra progreso constitución
		pbConstitucion = new JProgressBar();
		pbExp.setValue( Integer.parseInt( data_personajes[0][8].toString() ) );
		pbConstitucion.setBackground(new Color(242, 242, 242));
		pbConstitucion.setForeground(new Color(52, 75, 89));
		pbConstitucion.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbConstitucion.setStringPainted(true);
		pbConstitucion.setBounds(372, 449, 82, 14);
		add(pbConstitucion);

		// Barra progreso inteligencia
		pbInteligencia = new JProgressBar();
		pbExp.setValue( Integer.parseInt( data_personajes[0][9].toString() ) );
		pbInteligencia.setBackground(new Color(242, 242, 242));
		pbInteligencia.setForeground(new Color(52, 75, 89));
		pbInteligencia.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbInteligencia.setStringPainted(true);
		pbInteligencia.setBounds(372, 480, 82, 14);
		add(pbInteligencia);

		// Barra progreso sabiduría
		pbSabiduria = new JProgressBar();
		pbExp.setValue( Integer.parseInt( data_personajes[0][10].toString() ) );
		pbSabiduria.setBackground(new Color(242, 242, 242));
		pbSabiduria.setForeground(new Color(52, 75, 89));
		pbSabiduria.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbSabiduria.setStringPainted(true);
		pbSabiduria.setBounds(372, 511, 82, 14);
		add(pbSabiduria);

		// Barra progreso carisma
		pbCarisma = new JProgressBar();
		pbExp.setValue( Integer.parseInt( data_personajes[0][11].toString() ) );
		pbCarisma.setBackground(new Color(242, 242, 242));
		pbCarisma.setForeground(new Color(52, 75, 89));
		pbCarisma.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbCarisma.setStringPainted(true);
		pbCarisma.setBounds(372, 542, 82, 14);
		add(pbCarisma);

		// Imagen del personaje
		lblIconoPersn = new JLabel("");
		lblIconoPersn.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/personajes/personaje_1.png")));
		lblIconoPersn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoPersn.setBounds(477, 354, 116, 123);
		add(lblIconoPersn);

		// Etiqueta raza
		lblRaza = new JLabel("Raza"); // *Añadir listeners
		lblRaza.setForeground(new Color(29, 29, 27));
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblRaza.setBounds(496, 513, 78, 14);
		add(lblRaza);

		// Etiqueta clase
		lblClase = new JLabel("Clase"); // *Añadir listeners
		lblClase.setForeground(new Color(29, 29, 27));
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblClase.setBounds(496, 544, 78, 14);
		add(lblClase);
		
	}

	public void setListener( PartidaIniciadaListener listener ) {
		//btnSeleccionar.addActionListener( listener );
	}

}