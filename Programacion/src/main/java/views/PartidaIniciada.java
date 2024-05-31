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

	public PartidaIniciada( Usuario user ) {
		setBackground( new Color( 242, 242, 242 ) );

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
		
		// Imagen de la partida
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/paisaje.jpeg")));
		lblImagen.setBounds(231, 149, 172, 143);
		add(lblImagen);
		
		// Etiquetas
		lblNivelPartida = new JLabel( "" );
		lblNivelPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblNivelPartida.setIcon(null);
		lblNivelPartida.setForeground(new Color(29, 29, 27));
		lblNivelPartida.setFont(new Font("Oxygen", Font.BOLD, 22));
		lblNivelPartida.setBounds(177, 51, 445, 26);
		add(lblNivelPartida);
		
		lblAnfitrion = new JLabel( "" );
		lblAnfitrion.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/usuario.png")));
		lblAnfitrion.setForeground(new Color(29, 29, 27));
		lblAnfitrion.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblAnfitrion.setBounds(425, 149, 183, 26);
		add(lblAnfitrion);
		
		lblJugadores = new JLabel( "" );
		lblJugadores.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/equipo.png")));
		lblJugadores.setForeground(new Color(29, 29, 27));
		lblJugadores.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblJugadores.setBounds(425, 178, 183, 26);
		add(lblJugadores);

		lblDuración = new JLabel( "" );
		lblDuración.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/repetir.png")));
		lblDuración.setForeground(new Color(29, 29, 27));
		lblDuración.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblDuración.setBounds(425, 207, 183, 26);
		add(lblDuración);
		
		lblFecha = new JLabel( "" );
		lblFecha.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/calendario.png")));
		lblFecha.setForeground(new Color(29, 29, 27));
		lblFecha.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblFecha.setBounds(425, 236, 183, 26);
		add(lblFecha);
		
		lblEstado = new JLabel( "" );
		lblEstado.setIcon(new ImageIcon(PartidaIniciada.class.getResource("/img/ajustes.png")));
		lblEstado.setForeground(new Color(29, 29, 27));
		lblEstado.setFont(new Font("Oxygen", Font.BOLD, 14));
		lblEstado.setBounds(425, 265, 183, 26);
		add(lblEstado);
		
		//PERSONAJE DETALLES
		
		lblNombrePersonaje = new JLabel( "" ); // *Añadir listeners
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePersonaje.setForeground(new Color(29, 29, 27));
		lblNombrePersonaje.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblNombrePersonaje.setBounds(318, 322, 163, 14);
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
		pbExp.setBackground(new Color(242, 242, 242));
		pbExp.setForeground(new Color(52, 75, 89));
		pbExp.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbExp.setStringPainted(true);
		pbExp.setBounds(372, 356, 82, 14);
		add(pbExp);

		// Barra progreso fuerza
		pbFuerza = new JProgressBar();
		pbFuerza.setBackground(new Color(242, 242, 242));
		pbFuerza.setForeground(new Color(52, 75, 89));
		pbFuerza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbFuerza.setStringPainted(true);
		pbFuerza.setBounds(372, 387, 82, 14);
		add(pbFuerza);

		// Barra progreso destreza
		pbDestreza = new JProgressBar();
		pbDestreza.setBackground(new Color(242, 242, 242));
		pbDestreza.setForeground(new Color(52, 75, 89));
		pbDestreza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbDestreza.setStringPainted(true);
		pbDestreza.setBounds(372, 418, 82, 14);
		add(pbDestreza);

		// Barra progreso constitución
		pbConstitucion = new JProgressBar();
		pbConstitucion.setBackground(new Color(242, 242, 242));
		pbConstitucion.setForeground(new Color(52, 75, 89));
		pbConstitucion.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbConstitucion.setStringPainted(true);
		pbConstitucion.setBounds(372, 449, 82, 14);
		add(pbConstitucion);

		// Barra progreso inteligencia
		pbInteligencia = new JProgressBar();
		pbInteligencia.setBackground(new Color(242, 242, 242));
		pbInteligencia.setForeground(new Color(52, 75, 89));
		pbInteligencia.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbInteligencia.setStringPainted(true);
		pbInteligencia.setBounds(372, 480, 82, 14);
		add(pbInteligencia);

		// Barra progreso sabiduría
		pbSabiduria = new JProgressBar();
		pbSabiduria.setBackground(new Color(242, 242, 242));
		pbSabiduria.setForeground(new Color(52, 75, 89));
		pbSabiduria.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbSabiduria.setStringPainted(true);
		pbSabiduria.setBounds(372, 511, 82, 14);
		add(pbSabiduria);

		// Barra progreso carisma
		pbCarisma = new JProgressBar();
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
		lblRaza = new JLabel(""); // *Añadir listeners
		lblRaza.setForeground(new Color(29, 29, 27));
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblRaza.setBounds(481, 502, 112, 22);
		add(lblRaza);

		// Etiqueta clase
		lblClase = new JLabel("Clase"); // *Añadir listeners
		lblClase = new JLabel(""); // *Añadir listeners
		lblClase.setForeground(new Color(29, 29, 27));
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblClase.setBounds(481, 533, 112, 22);
		add(lblClase);
		
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
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

	public JLabel getLblNivelPartida() {
		return lblNivelPartida;
	}

	public void setLblNivelPartida(JLabel lblNivelPartida) {
		this.lblNivelPartida = lblNivelPartida;
	}

	public JLabel getLblNivelPartidaTitulo() {
		return lblNivelPartidaTitulo;
	}

	public void setLblNivelPartidaTitulo(JLabel lblNivelPartidaTitulo) {
		this.lblNivelPartidaTitulo = lblNivelPartidaTitulo;
	}

	public JLabel getLblRaza() {
		return lblRaza;
	}

	public void setLblRaza(JLabel lblRaza) {
		this.lblRaza = lblRaza;
	}

	public JLabel getLblExp() {
		return lblExp;
	}

	public void setLblExp(JLabel lblExp) {
		this.lblExp = lblExp;
	}

	public JLabel getLblIconoExp() {
		return lblIconoExp;
	}

	public void setLblIconoExp(JLabel lblIconoExp) {
		this.lblIconoExp = lblIconoExp;
	}

	public JLabel getLblIconoFuerza() {
		return lblIconoFuerza;
	}

	public void setLblIconoFuerza(JLabel lblIconoFuerza) {
		this.lblIconoFuerza = lblIconoFuerza;
	}

	public JLabel getLblIconoDestreza() {
		return lblIconoDestreza;
	}

	public void setLblIconoDestreza(JLabel lblIconoDestreza) {
		this.lblIconoDestreza = lblIconoDestreza;
	}

	public JLabel getLblIconoCarisma() {
		return lblIconoCarisma;
	}

	public void setLblIconoCarisma(JLabel lblIconoCarisma) {
		this.lblIconoCarisma = lblIconoCarisma;
	}

	public JLabel getLblClase() {
		return lblClase;
	}

	public void setLblClase(JLabel lblClase) {
		this.lblClase = lblClase;
	}

	public JLabel getLblNombrePersonaje() {
		return lblNombrePersonaje;
	}

	public void setLblNombrePersonaje(JLabel lblNombrePersonaje) {
		this.lblNombrePersonaje = lblNombrePersonaje;
	}

	public JLabel getLblFuerza() {
		return lblFuerza;
	}

	public void setLblFuerza(JLabel lblFuerza) {
		this.lblFuerza = lblFuerza;
	}

	public JLabel getLblDestreza() {
		return lblDestreza;
	}

	public void setLblDestreza(JLabel lblDestreza) {
		this.lblDestreza = lblDestreza;
	}

	public JLabel getLblConstitucion() {
		return lblConstitucion;
	}

	public void setLblConstitucion(JLabel lblConstitucion) {
		this.lblConstitucion = lblConstitucion;
	}

	public JLabel getLblInteligencia() {
		return lblInteligencia;
	}

	public void setLblInteligencia(JLabel lblInteligencia) {
		this.lblInteligencia = lblInteligencia;
	}

	public JLabel getLblSabiduria() {
		return lblSabiduria;
	}

	public void setLblSabiduria(JLabel lblSabiduria) {
		this.lblSabiduria = lblSabiduria;
	}

	public JLabel getLblCarisma() {
		return lblCarisma;
	}

	public void setLblCarisma(JLabel lblCarisma) {
		this.lblCarisma = lblCarisma;
	}

	public JLabel getLblIconoConst() {
		return lblIconoConst;
	}

	public void setLblIconoConst(JLabel lblIconoConst) {
		this.lblIconoConst = lblIconoConst;
	}

	public JLabel getLblIconoInteligencia() {
		return lblIconoInteligencia;
	}

	public void setLblIconoInteligencia(JLabel lblIconoInteligencia) {
		this.lblIconoInteligencia = lblIconoInteligencia;
	}

	public JLabel getLblIconoSabiduria() {
		return lblIconoSabiduria;
	}

	public void setLblIconoSabiduria(JLabel lblIconoSabiduria) {
		this.lblIconoSabiduria = lblIconoSabiduria;
	}

	public JLabel getLblIconoPersn() {
		return lblIconoPersn;
	}

	public void setLblIconoPersn(JLabel lblIconoPersn) {
		this.lblIconoPersn = lblIconoPersn;
	}

	public JProgressBar getPbExp() {
		return pbExp;
	}

	public void setPbExp(JProgressBar pbExp) {
		this.pbExp = pbExp;
	}

	public JProgressBar getPbFuerza() {
		return pbFuerza;
	}

	public void setPbFuerza(JProgressBar pbFuerza) {
		this.pbFuerza = pbFuerza;
	}

	public JProgressBar getPbDestreza() {
		return pbDestreza;
	}

	public void setPbDestreza(JProgressBar pbDestreza) {
		this.pbDestreza = pbDestreza;
	}

	public JProgressBar getPbConstitucion() {
		return pbConstitucion;
	}

	public void setPbConstitucion(JProgressBar pbConstitucion) {
		this.pbConstitucion = pbConstitucion;
	}

	public JProgressBar getPbInteligencia() {
		return pbInteligencia;
	}

	public void setPbInteligencia(JProgressBar pbInteligencia) {
		this.pbInteligencia = pbInteligencia;
	}

	public JProgressBar getPbSabiduria() {
		return pbSabiduria;
	}

	public void setPbSabiduria(JProgressBar pbSabiduria) {
		this.pbSabiduria = pbSabiduria;
	}

	public JProgressBar getPbCarisma() {
		return pbCarisma;
	}

	public void setPbCarisma(JProgressBar pbCarisma) {
		this.pbCarisma = pbCarisma;
	}

}