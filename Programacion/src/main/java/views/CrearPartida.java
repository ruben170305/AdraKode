package views;

// Librerías
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import listeners.CrearPartidaListener;

import java.awt.*;

public class CrearPartida extends JPanel {
	private JLabel lblTitulo, lblImagen, lblAnfitrion, lblJugadores, lblDuracion, lblFecha, lblEstado, lblDificultad;
	private JLabel lblNewLabel, lblIconAnfitrion, lblIconJugadores, lblIconDuracion, lblIconFecha, lblIconEstado, lblIconDificultad;
	private JButton btnGuardar, btnGuardarImagen;
	private JTextField txtNombrePartida, txtAnfitrion, txtJugadores, txtDuracion, txtFecha, txtEstado, txtDificultad;

	public CrearPartida() {
		initialize_components();
	}

	private void initialize_components() {
		// Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setBackground(new Color(242, 242, 242));

		// layout absoluto
		setLayout(null);

		// Tamaño y posicion de ventana
		setSize(800, 600);
		// setLocation(null);

		/* COMPONENTES */

		// Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));

		// Titulo
		lblTitulo = new JLabel("CREAR PARTIDA");
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
		lblNewLabel.setBounds(286, 112, 77, 22);
		add(lblNewLabel);

		//Imagen partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/paisaje.jpeg")));
		lblImagen.setBounds(314, 155, 172, 143);
		add(lblImagen);
		
		
		// Iconos
		lblIconAnfitrion = new JLabel("");
		lblIconAnfitrion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAnfitrion.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/usuario.png")));
		lblIconAnfitrion.setForeground(new Color(29, 29, 27));
		lblIconAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconAnfitrion.setBounds(264, 311, 32, 26);
		add(lblIconAnfitrion);
		
		lblIconDificultad = new JLabel("");
		lblIconDificultad.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDificultad.setIcon(new ImageIcon(CrearPartida.class.getResource("/img/dificultad.png")));
		lblIconDificultad.setForeground(new Color(29, 29, 27));
		lblIconDificultad.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconDificultad.setBounds(264, 339, 32, 26);
		add(lblIconDificultad);

		lblIconJugadores = new JLabel("");
		lblIconJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconJugadores.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/equipo.png")));
		lblIconJugadores.setForeground(new Color(29, 29, 27));
		lblIconJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconJugadores.setBounds(264, 367, 32, 26);
		add(lblIconJugadores);

		lblIconDuracion = new JLabel("");
		lblIconDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDuracion.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/repetir.png")));
		lblIconDuracion.setForeground(new Color(29, 29, 27));
		lblIconDuracion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconDuracion.setBounds(264, 395, 32, 26);
		add(lblIconDuracion);
		
		lblIconFecha = new JLabel("");
		lblIconFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconFecha.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/calendario.png")));
		lblIconFecha.setForeground(new Color(29, 29, 27));
		lblIconFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconFecha.setBounds(264, 423, 32, 26);
		add(lblIconFecha);
		
		lblIconEstado = new JLabel("");
		lblIconEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEstado.setIcon(new ImageIcon(VerPartidasMaster.class.getResource("/img/ajustes.png")));
		lblIconEstado.setForeground(new Color(29, 29, 27));
		lblIconEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblIconEstado.setBounds(264, 451, 32, 26);
		add(lblIconEstado);
        
		
		// Etiquetas 
        lblAnfitrion = new JLabel("Ambientación");
        lblAnfitrion.setHorizontalAlignment(SwingConstants.LEFT);
        lblAnfitrion.setForeground(new Color(29, 29, 27));
        lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblAnfitrion.setBounds(306, 311, 108, 26);
        add(lblAnfitrion);
        
        lblDificultad = new JLabel("Dificultad");
        lblDificultad.setHorizontalAlignment(SwingConstants.LEFT);
        lblDificultad.setForeground(new Color(29, 29, 27));
        lblDificultad.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblDificultad.setBounds(306, 339, 72, 26);
        add(lblDificultad);
        
        lblJugadores = new JLabel("Jugadores");
        lblJugadores.setHorizontalAlignment(SwingConstants.LEFT);
        lblJugadores.setForeground(new Color(29, 29, 27));
        lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblJugadores.setBounds(306, 367, 72, 26);
        add(lblJugadores);
        
        lblDuracion = new JLabel("Duración");
        lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
        lblDuracion.setForeground(new Color(29, 29, 27));
        lblDuracion.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblDuracion.setBounds(306, 395, 72, 26);
        add(lblDuracion);
        
        lblFecha = new JLabel("Fecha");
        lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
        lblFecha.setForeground(new Color(29, 29, 27));
        lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblFecha.setBounds(306, 423, 72, 26);
        add(lblFecha);
        
        lblEstado = new JLabel("Estado");
        lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
        lblEstado.setForeground(new Color(29, 29, 27));
        lblEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
        lblEstado.setBounds(306, 451, 72, 26);
        add(lblEstado);
        
        
        //Campo texto
  		txtNombrePartida = new JTextField();
  		txtNombrePartida.setBackground(new Color(242, 242, 242));
  		txtNombrePartida.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtNombrePartida.setBounds(373, 120, 121, 14);
  		txtNombrePartida.setColumns(10);
  		txtNombrePartida.setBorder(border);
  		add(txtNombrePartida);
  		
  		txtAnfitrion = new JTextField();
  		txtAnfitrion.setBackground(new Color(242, 242, 242));
  		txtAnfitrion.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtAnfitrion.setBounds(405, 317, 125, 14);
  		txtAnfitrion.setColumns(10);
  		txtAnfitrion.setBorder(border);
  		add(txtAnfitrion);
  		
  		txtDificultad = new JTextField();
  		txtDificultad.setBackground(new Color(242, 242, 242));
  		txtDificultad.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtDificultad.setBounds(405, 345, 125, 14);
  		txtDificultad.setColumns(10);
  		txtDificultad.setBorder(border);
  		add(txtDificultad);
  		
  		txtJugadores = new JTextField();
  		txtJugadores.setBackground(new Color(242, 242, 242));
  		txtJugadores.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtJugadores.setBounds(405, 373, 125, 14);
  		txtJugadores.setColumns(10);
  		txtJugadores.setBorder(border);
  		add(txtJugadores);
  		
  		txtDuracion = new JTextField();
  		txtDuracion.setBackground(new Color(242, 242, 242));
  		txtDuracion.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtDuracion.setBounds(405, 401, 125, 14);
  		txtDuracion.setColumns(10);
  		txtDuracion.setBorder(border);
  		add(txtDuracion);
  		
  		txtFecha = new JTextField();
  		txtFecha.setBackground(new Color(242, 242, 242));
  		txtFecha.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtFecha.setBounds(405, 429, 125, 14);
  		txtFecha.setColumns(10);
  		txtFecha.setBorder(border);
  		add(txtFecha);
  		
  		txtEstado = new JTextField();
  		txtEstado.setBackground(new Color(242, 242, 242));
  		txtEstado.setFont(new Font("Open Sans", Font.PLAIN, 11));
  		txtEstado.setBounds(405, 457, 125, 14);
  		txtEstado.setColumns(10);
  		txtEstado.setBorder(border);
  		add(txtEstado);
  		
        // Botones
        btnGuardar = new JButton("CREAR");
        btnGuardar.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardar.setForeground(new Color(242, 242, 242));
        btnGuardar.setBackground(new Color(29, 161, 242));
        btnGuardar.setOpaque(true);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setBounds(286, 501, 159, 45);
        add(btnGuardar);

        btnGuardarImagen = new JButton("");
        btnGuardarImagen.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/camara_fotografica.png")));
        btnGuardarImagen.setOpaque(true);
        btnGuardarImagen.setForeground(new Color(242, 242, 242));
        btnGuardarImagen.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardarImagen.setBorderPainted(false);
        btnGuardarImagen.setBackground(new Color(29, 29, 27));
        btnGuardarImagen.setBounds(453, 501, 61, 45);
        add(btnGuardarImagen);

	}
	
	public void setListener( CrearPartidaListener listener ) {
		btnGuardar.addActionListener( listener );
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

	public JLabel getLblDuracion() {
		return lblDuracion;
	}

	public void setLblDuracion(JLabel lblDuracion) {
		this.lblDuracion = lblDuracion;
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

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblIconAnfitrion() {
		return lblIconAnfitrion;
	}

	public void setLblIconAnfitrion(JLabel lblIconAnfitrion) {
		this.lblIconAnfitrion = lblIconAnfitrion;
	}

	public JLabel getLblIconJugadores() {
		return lblIconJugadores;
	}

	public void setLblIconJugadores(JLabel lblIconJugadores) {
		this.lblIconJugadores = lblIconJugadores;
	}

	public JLabel getLblIconDuracion() {
		return lblIconDuracion;
	}

	public void setLblIconDuracion(JLabel lblIconDuracion) {
		this.lblIconDuracion = lblIconDuracion;
	}

	public JLabel getLblIconFecha() {
		return lblIconFecha;
	}

	public void setLblIconFecha(JLabel lblIconFecha) {
		this.lblIconFecha = lblIconFecha;
	}

	public JLabel getLblIconEstado() {
		return lblIconEstado;
	}

	public void setLblIconEstado(JLabel lblIconEstado) {
		this.lblIconEstado = lblIconEstado;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnGuardarImagen() {
		return btnGuardarImagen;
	}

	public void setBtnGuardarImagen(JButton btnGuardarImagen) {
		this.btnGuardarImagen = btnGuardarImagen;
	}

	public JTextField getTxtNombrePartida() {
		return txtNombrePartida;
	}

	public void setTxtNombrePartida(JTextField txtNombrePartida) {
		this.txtNombrePartida = txtNombrePartida;
	}

	public JTextField getTxtAnfitrion() {
		return txtAnfitrion;
	}

	public void setTxtAnfitrion(JTextField txtAnfitrion) {
		this.txtAnfitrion = txtAnfitrion;
	}

	public JTextField getTxtJugadores() {
		return txtJugadores;
	}

	public void setTxtJugadores(JTextField txtJugadores) {
		this.txtJugadores = txtJugadores;
	}

	public JTextField getTxtDuracion() {
		return txtDuracion;
	}

	public void setTxtDuracion(JTextField txtDuracion) {
		this.txtDuracion = txtDuracion;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public void setTxtFecha(JTextField txtFecha) {
		this.txtFecha = txtFecha;
	}

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(JTextField txtEstado) {
		this.txtEstado = txtEstado;
	}
	
	
}
