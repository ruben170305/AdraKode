package views;

// Librerías
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import listeners.VerPartidaMasterListener;
import model.*;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VerPartidasMaster extends JPanel {
	private JButton btnEditar, btnBorrar;
	private JLabel lblIdPartida, lblTituloPartida, lblAnfitrion, lblJugadores, lblDuración, lblFecha, lblEstado, lblTitulo, lblImagen, lblIdJugador;
	private JTable table;
	
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
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Anfitrion", "Nº jugadores", "Estado", "ID jugador" };

		// Insertamos los datos de la tabla
		Object[][] data = { 
				{ "1", "Partida 1", "Ambientacion 1", "Duracion 1", "Fecha 1", "Anfitrion 1", "4", "Finalizado", "1"}
		};
		
		// Creamos una plantilla para la tabla
		DefaultTableModel template = new DefaultTableModel(data, columns);
		table = new JTable(template);
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
		lblIdPartida = new JLabel( "" );
		lblIdPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdPartida.setBounds(0, 0, 0, 0);
		add( lblIdPartida );

		lblTituloPartida = new JLabel("");
		lblTituloPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPartida.setIcon(null);
		lblTituloPartida.setForeground(new Color(29, 29, 27));
		lblTituloPartida.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblTituloPartida.setBounds(302, 121, 195, 26);
		add(lblTituloPartida);
		
		lblAnfitrion = new JLabel( "" );
		lblAnfitrion.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/usuario.png")));
		lblAnfitrion.setForeground(new Color(29, 29, 27));
		lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrion.setBounds(425, 164, 183, 26);
		add(lblAnfitrion);
		
		lblJugadores = new JLabel( "" );
		lblJugadores.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/equipo.png")));
		lblJugadores.setForeground(new Color(29, 29, 27));
		lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblJugadores.setBounds(425, 193, 183, 26);
		add(lblJugadores);

		lblDuración = new JLabel( "" );
		lblDuración.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/repetir.png")));
		lblDuración.setForeground(new Color(29, 29, 27));
		lblDuración.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblDuración.setBounds(425, 222, 183, 26);
		add(lblDuración);
		
		lblFecha = new JLabel( "" );
		lblFecha.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/calendario.png")));
		lblFecha.setForeground(new Color(29, 29, 27));
		lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblFecha.setBounds(425, 251, 183, 26);
		add(lblFecha);
		
		lblEstado = new JLabel( "" );
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
		
		lblIdJugador = new JLabel( "" );
		lblIdJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdJugador.setBounds(0, 0, 0, 0);
		add( lblIdJugador );
		
	}
	/**
	 * Metodo que asigna el listener
	 * @param listener Parametro que recibe el listener
	 */
	public void setListener( VerPartidaMasterListener listener ) {
		btnEditar.addActionListener( listener );
		btnBorrar.addActionListener( listener );

        listener.transfer_table_partidas();
	}

	public JLabel getIdPartidaLbl() {
		return lblIdPartida;
	}

	public void setIdPartidaLbl( JLabel lblIdPartida ) {
		this.lblIdPartida = lblIdPartida;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JLabel getLblIdPartida() {
		return lblIdPartida;
	}

	public void setLblIdPartida(JLabel lblIdPartida) {
		this.lblIdPartida = lblIdPartida;
	}

	public JLabel getLblTituloPartida() {
		return lblTituloPartida;
	}

	public void setLblTituloPartida(JLabel lblTituloPartida) {
		this.lblTituloPartida = lblTituloPartida;
	}

	public JLabel getLblAnfitrion() {
		return lblAnfitrion;
	}

	public void setLblAnfitrion(JLabel lblAnfitrion) {
		this.lblAnfitrion = lblAnfitrion;
	}

	public JLabel getLblJugadores() {
		return lblJugadores;
	}

	public void setLblJugadores(JLabel lblJugadores) {
		this.lblJugadores = lblJugadores;
	}

	public JLabel getLblDuración() {
		return lblDuración;
	}

	public void setLblDuración(JLabel lblDuración) {
		this.lblDuración = lblDuración;
	}

	public JLabel getLblFecha() {
		return lblFecha;
	}

	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public JLabel getLblIdJugador() {
		return lblIdJugador;
	}

	public void setLblIdJugador(JLabel lblIdJugador) {
		this.lblIdJugador = lblIdJugador;
	}

	
}
