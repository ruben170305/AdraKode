package views;

// Librerías
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import views.*;
import listeners.VerPartidaMasterListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerPartidasMaster extends JPanel {
	private JButton btnEditar, btnBorrar, btnSeleccionar;
	private JLabel lblTituloPartida, lblAnfitrion, lblJugadores, lblDuración, lblFecha, lblEstado, lblTitulo, lblImagen;

	public VerPartidasMaster() {
		initialize_components();
	}

	private void initialize_components() {
		
		setBackground(new Color(242, 242, 242));

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
		
		
		// Tabla
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Anfitrión", "Jugadores", "Duración", "Fecha", "Estado" };

		// Insertamos los datos de la tabla
		Object[][] data = { 
				{ "Partida 1", "Usuario 1", 4, "30'", "13-04 16:00 pm", "En curso" },
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
		scrollPane.setBounds(122, 331, 556, 122);
		add(scrollPane);

		
		// Imagen de la partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/paisaje.jpeg")));
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
		lblAnfitrion.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/usuario.png")));
		lblAnfitrion.setForeground(new Color(29, 29, 27));
		lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrion.setBounds(425, 164, 183, 26);
		add(lblAnfitrion);
		
		lblJugadores = new JLabel("4");
		lblJugadores.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/equipo.png")));
		lblJugadores.setForeground(new Color(29, 29, 27));
		lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblJugadores.setBounds(425, 193, 183, 26);
		add(lblJugadores);

		lblDuración = new JLabel("30'");
		lblDuración.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/repetir.png")));
		lblDuración.setForeground(new Color(29, 29, 27));
		lblDuración.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblDuración.setBounds(425, 222, 183, 26);
		add(lblDuración);
		
		lblFecha = new JLabel("13-04 16:00 pm");
		lblFecha.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/calendario.png")));
		lblFecha.setForeground(new Color(29, 29, 27));
		lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblFecha.setBounds(425, 251, 183, 26);
		add(lblFecha);
		
		lblEstado = new JLabel("En curso");
		lblEstado.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/ajustes.png")));
		lblEstado.setForeground(new Color(29, 29, 27));
		lblEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblEstado.setBounds(425, 280, 183, 26);
		add(lblEstado);
		
		
		// Botones
		btnEditar = new JButton();
		btnEditar.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonEditarW.png")));
		btnEditar.setName("editar");
		btnEditar.setOpaque(true);
		btnEditar.setForeground(new Color(29, 29, 27));
		btnEditar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnEditar.setBorderPainted(false);
		btnEditar.setBackground(new Color(29, 29, 27));
		btnEditar.setBounds(315, 482, 83, 36);
		add(btnEditar);

		btnBorrar = new JButton();
		btnBorrar.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonBorrarW.png")));
		btnBorrar.setName("borrar");
		btnBorrar.setOpaque(true);
		btnBorrar.setForeground(new Color(29, 29, 27));
		btnBorrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(new Color(29, 29, 27));
		btnBorrar.setBounds(404, 482, 83, 36);
		add(btnBorrar);

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

	}
	
	public void setListener( VerPartidaMasterListener listener ) {
		btnEditar.addActionListener( listener );
		btnSeleccionar.addActionListener( listener );
		btnBorrar.addActionListener( listener );
	}
	
}
