package views;

// Librerías
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;

import listeners.*;
import model.*;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VerPartidas extends JPanel {
	private JLabel lblTitulo, lblImagen, lblIdPartida, lblIdJugador;
	private JButton btnSeleccionar;
	private JLabel lblTituloPartida, lblAnfitrion, lblJugadores, lblDuración, lblFecha, lblEstado, lblTituloComboBox;
	private JComboBox comboBoxJugador;
	private JTable table;
	private DefaultTableModel template;
	private VerPartidaListener listener;

	public VerPartidas( Usuario user ) {		
		initialize_components();
	}

	private void initialize_components() {

		setBackground( new Color( 242, 242, 242 ) );

		// layout absoluto
		setLayout( null );

		// Tamaño y posicion de ventana
		setSize( 800, 600 );
		
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

		// Insertamos los datos de la tabla
		Object[][] data = {
				{ "1", "Partida 1", "Ambientacion 1", "Duracion 1", "Fecha 1", "Anfitrion 1", "4", "Finalizado"}
		};
		
		// Creamos una plantilla para la tabla
		template = new DefaultTableModel(data, columns);
		table = new JTable(template);
		table.setForeground(new Color(29, 29, 27));
		table.setBackground(new Color(242, 242, 242));
		table.setFont(new Font("Open Sans", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(122, 343, 556, 122);
		add(scrollPane);
		
		// Imagen de la partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/paisaje.jpeg")));
		lblImagen.setBounds(231, 177, 172, 143);
		add(lblImagen);

		// Etiquetas
		lblIdPartida = new JLabel( "" );
		lblIdPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdPartida.setBounds(0, 0, 0, 0);
		add( lblIdPartida );
		
		// Etiquetas
		lblTituloPartida = new JLabel( "" );
		lblTituloPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPartida.setIcon(null);
		lblTituloPartida.setForeground(new Color(29, 29, 27));
		lblTituloPartida.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblTituloPartida.setBounds(302, 106, 195, 26);
		add(lblTituloPartida);
		
		lblAnfitrion = new JLabel( "" );
		lblAnfitrion.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/usuario.png")));
		lblAnfitrion.setForeground(new Color(29, 29, 27));
		lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrion.setBounds(425, 177, 183, 26);
		add(lblAnfitrion);
		
		lblJugadores = new JLabel( "" );
		lblJugadores.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/equipo.png")));
		lblJugadores.setForeground(new Color(29, 29, 27));
		lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblJugadores.setBounds(425, 206, 183, 26);
		add(lblJugadores);

		lblDuración = new JLabel( "" );
		lblDuración.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/repetir.png")));
		lblDuración.setForeground(new Color(29, 29, 27));
		lblDuración.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblDuración.setBounds(425, 235, 183, 26);
		add(lblDuración);
		
		lblFecha = new JLabel( "" );
		lblFecha.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/calendario.png")));
		lblFecha.setForeground(new Color(29, 29, 27));
		lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblFecha.setBounds(425, 264, 183, 26);
		add(lblFecha);
		
		lblEstado = new JLabel( "" );
		lblEstado.setIcon(new ImageIcon(VerPartidas.class.getResource("/img/ajustes.png")));
		lblEstado.setForeground(new Color(29, 29, 27));
		lblEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblEstado.setBounds(425, 293, 183, 26);
		add(lblEstado);
		
		lblTituloComboBox = new JLabel("Jugador: ");
		lblTituloComboBox.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTituloComboBox.setIcon(null);
		lblTituloComboBox.setForeground(new Color(29, 29, 27));
		lblTituloComboBox.setFont(new Font("Oxygen", Font.BOLD, 18));
		lblTituloComboBox.setBounds(302, 479, 83, 26);
		add(lblTituloComboBox);

        comboBoxJugador = new JComboBox<>();
        comboBoxJugador.setFont(new Font("Open Sans", Font.BOLD, 14));
        comboBoxJugador.setForeground(new Color(29, 29, 27));
        comboBoxJugador.setBackground(new Color(242, 242, 242));
        comboBoxJugador.setBounds(395, 483, 91, 22);
        comboBoxJugador.setBorder(BorderFactory.createEmptyBorder());
        comboBoxJugador.setOpaque(true);
        add(comboBoxJugador);

		btnSeleccionar = new JButton("JUGAR");
		btnSeleccionar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnSeleccionar.setForeground(new Color(242, 242, 242));
		btnSeleccionar.setBackground(new Color(29, 161, 242));
		btnSeleccionar.setOpaque(true);
		btnSeleccionar.setBorderPainted(false);
		btnSeleccionar.setBounds(314, 516, 172, 41);
		add(btnSeleccionar);

		lblIdJugador = new JLabel( "" );
		lblIdJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdJugador.setBounds(0, 0, 0, 0);
		add( lblIdJugador );

	}
	
	public void setListener( VerPartidaListener listener ) {
		this.listener = listener;
		btnSeleccionar.addActionListener( listener );
		listener.cargarDatosEnComboBox();
        listener.transfer_table_partidas();
	}
	
	public DefaultTableModel getTemplate() {
		return template;
	}

	public VerPartidaListener getListener() {
		return listener;
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

	public JLabel getLblIdPartida() {
		return lblIdPartida;
	}

	public void setLblIdPartida(JLabel lblIdPartida) {
		this.lblIdPartida = lblIdPartida;
	}

	public JLabel getLblIdJugador() {
		return lblIdJugador;
	}

	public void setLblIdJugador(JLabel lblIdJugador) {
		this.lblIdJugador = lblIdJugador;
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
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

	public JLabel getLblTituloComboBox() {
		return lblTituloComboBox;
	}

	public void setLblTituloComboBox(JLabel lblTituloComboBox) {
		this.lblTituloComboBox = lblTituloComboBox;
	}

	public JComboBox getComboBoxJugador() {
		return comboBoxJugador;
	}

	public void setComboBoxJugador(JComboBox comboBoxJugador) {
		this.comboBoxJugador = comboBoxJugador;
	}

	public JLabel getIdPartidaLbl() {
		return lblIdPartida;
	}

	public void setIdPartidaLbl( JLabel lblIdPartida ) {
		this.lblIdPartida = lblIdPartida;
	}

	public JLabel getIdJugadorLbl() {
		return lblIdJugador;
	}

	public void setIdJugadorLbl( JLabel lblIdJugador ) {
		this.lblIdJugador = lblIdJugador;
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public DefaultTableModel getModel() {
		return template;
	}
	
	
}