package views;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.*;

import com.mysql.cj.protocol.Resultset;

import listeners.VerPersonajesListener;
import model.Partida;
import model.Personaje;
import model.Usuario;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerPersonajes extends JPanel {

	private JLabel lblTitulo, lblRaza, lblExp, lblSeleccionarPersonaje, lblIconoExp, lblIconoFuerza, lblIconoDestreza,
			lblIconoCarisma, lblClase;
	private JLabel lblFuerza, lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma, lblIconoConst,
			lblIconoInteligencia, lblIconoSabiduria, lblIconoPersn;
	private JButton btnSeleccionar, btnEditar, btnBorrar;
	private JProgressBar pbExp, pbFuerza, pbDestreza, pbConstitucion, pbInteligencia, pbSabiduria, pbCarisma;
	private JComboBox comboBoxSeleccionar;

	private Personaje personaje;
	private VerPersonajesListener listener;

	public VerPersonajes(VerPersonajesListener listener) {
		this.listener = listener;
		setBackground(new Color(242, 242, 242));
		initialize_components();
		// make_visible();
	}

	private void initialize_components() {
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

		/* COMPONENTES */

		// Titulo
		lblTitulo = new JLabel("VER PERSONAJES");
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

		// Etiqueta seleccionar personaje
		lblSeleccionarPersonaje = new JLabel("PERSONAJE");
		lblSeleccionarPersonaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccionarPersonaje.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblSeleccionarPersonaje.setBounds(236, 144, 152, 19);
		add(lblSeleccionarPersonaje);

		ArrayList<Personaje> opcionesComboBox = new ArrayList<Personaje>();

		// Crear un ArrayList para almacenar los nombres de los personajes
		ArrayList<String> nombresPersonajes = new ArrayList<>();

		// Iterar sobre la lista de Personaje y agregar los nombres a la lista de
		// nombres
//        for (Personaje personaje : opcionesComboBox) {
//            nombresPersonajes.add( personaje.getNombre() );
//        }

		// Convertir el ArrayList de nombres a un array de cadenas
		// Ahora puedes usar opcionesArray como las opciones para tu JComboBox
		comboBoxSeleccionar = new JComboBox<>();
		comboBoxSeleccionar.setFont(new Font("Open Sans", Font.BOLD, 14));
		comboBoxSeleccionar.setForeground(new Color(29, 29, 27));
		comboBoxSeleccionar.setBackground(new Color(242, 242, 242));
		comboBoxSeleccionar.setBounds(403, 142, 114, 22);
		comboBoxSeleccionar.setBorder(BorderFactory.createEmptyBorder());
		comboBoxSeleccionar.setOpaque(true);
		add(comboBoxSeleccionar);

		// Iconos
		lblIconoExp = new JLabel();
		lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoExp.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoExp.png")));
		lblIconoExp.setBounds(346, 199, 35, 33);
		add(lblIconoExp);

		lblIconoFuerza = new JLabel();
		lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoFuerza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoFrza.png")));
		lblIconoFuerza.setBounds(346, 230, 35, 33);
		add(lblIconoFuerza);

		lblIconoDestreza = new JLabel();
		lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoDestreza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoDestreza.png")));
		lblIconoDestreza.setBounds(346, 261, 35, 33);
		add(lblIconoDestreza);

		lblIconoConst = new JLabel();
		lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoConst.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoConstitucion.png")));
		lblIconoConst.setBounds(346, 292, 35, 33);
		add(lblIconoConst);

		lblIconoInteligencia = new JLabel();
		lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoInteligencia.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoInteli.png")));
		lblIconoInteligencia.setBounds(346, 323, 35, 33);
		add(lblIconoInteligencia);

		lblIconoSabiduria = new JLabel();
		lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoSabiduria.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoSab.png")));
		lblIconoSabiduria.setBounds(346, 354, 35, 33);
		add(lblIconoSabiduria);

		lblIconoCarisma = new JLabel();
		lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCarisma.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoCarisma.png")));
		lblIconoCarisma.setBounds(346, 385, 35, 33);
		add(lblIconoCarisma);

		// Etiquetas

		// Etiqueta exp
		lblExp = new JLabel("Experiencia");
		lblExp.setHorizontalAlignment(SwingConstants.LEFT);
		lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblExp.setBounds(391, 206, 104, 18);
		add(lblExp);

		// Etiqueta fuerza
		lblFuerza = new JLabel("Fuerza");
		lblFuerza.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblFuerza.setBounds(391, 237, 104, 18);
		add(lblFuerza);

		// Etiqueta destreza
		lblDestreza = new JLabel("Destreza");
		lblDestreza.setHorizontalAlignment(SwingConstants.LEFT);
		lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblDestreza.setBounds(391, 268, 104, 18);
		add(lblDestreza);

		// Etiqueta constitución
		lblConstitucion = new JLabel("Constitución");
		lblConstitucion.setHorizontalAlignment(SwingConstants.LEFT);
		lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblConstitucion.setBounds(391, 299, 104, 18);
		add(lblConstitucion);

		// Etiqueta inteligencia
		lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setHorizontalAlignment(SwingConstants.LEFT);
		lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblInteligencia.setBounds(391, 330, 104, 18);
		add(lblInteligencia);

		// Etiqueta sabiduría
		lblSabiduria = new JLabel("Sabiduría");
		lblSabiduria.setHorizontalAlignment(SwingConstants.LEFT);
		lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblSabiduria.setBounds(391, 361, 104, 18);
		add(lblSabiduria);

		// Etiqueta carisma
		lblCarisma = new JLabel("Carisma");
		lblCarisma.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblCarisma.setBounds(391, 392, 104, 18);
		add(lblCarisma);

		// Barras

		// Barra progreso experiencia
		pbExp = new JProgressBar();
		pbExp.setBackground(new Color(242, 242, 242));
		pbExp.setForeground(new Color(52, 75, 89));
		pbExp.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbExp.setStringPainted(true);
		pbExp.setBounds(486, 208, 82, 14);
		add(pbExp);

		// Barra progreso fuerza
		pbFuerza = new JProgressBar();
		pbFuerza.setBackground(new Color(242, 242, 242));
		pbFuerza.setForeground(new Color(52, 75, 89));
		pbFuerza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbFuerza.setStringPainted(true);
		pbFuerza.setBounds(486, 239, 82, 14);
		add(pbFuerza);

		// Barra progreso destreza
		pbDestreza = new JProgressBar();
		pbDestreza.setBackground(new Color(242, 242, 242));
		pbDestreza.setForeground(new Color(52, 75, 89));
		pbDestreza.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbDestreza.setStringPainted(true);
		pbDestreza.setBounds(486, 270, 82, 14);
		add(pbDestreza);

		// Barra progreso constitución
		pbConstitucion = new JProgressBar();
		pbConstitucion.setBackground(new Color(242, 242, 242));
		pbConstitucion.setForeground(new Color(52, 75, 89));
		pbConstitucion.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbConstitucion.setStringPainted(true);
		pbConstitucion.setBounds(486, 301, 82, 14);
		add(pbConstitucion);

		// Barra progreso inteligencia
		pbInteligencia = new JProgressBar();
		pbInteligencia.setBackground(new Color(242, 242, 242));
		pbInteligencia.setForeground(new Color(52, 75, 89));
		pbInteligencia.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbInteligencia.setStringPainted(true);
		pbInteligencia.setBounds(486, 332, 82, 14);
		add(pbInteligencia);

		// Barra progreso sabiduría
		pbSabiduria = new JProgressBar();
		pbSabiduria.setBackground(new Color(242, 242, 242));
		pbSabiduria.setForeground(new Color(52, 75, 89));
		pbSabiduria.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbSabiduria.setStringPainted(true);
		pbSabiduria.setBounds(486, 363, 82, 14);
		add(pbSabiduria);

		// Barra progreso carisma
		pbCarisma = new JProgressBar();
		// pbCarisma.setValue( opcionesComboBox.get( 0 ).getCarisma() );
		pbCarisma.setBackground(new Color(242, 242, 242));
		pbCarisma.setForeground(new Color(52, 75, 89));
		pbCarisma.setFont(new Font("Oxygen", Font.PLAIN, 11));
		pbCarisma.setStringPainted(true);
		pbCarisma.setBounds(486, 394, 82, 14);
		add(pbCarisma);

		// Imagen del personaje
		lblIconoPersn = new JLabel("");
		lblIconoPersn.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/personajes/personaje_1.png")));
		lblIconoPersn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoPersn.setBounds(219, 208, 84, 123);
		add(lblIconoPersn);

		// Etiqueta raza
		lblRaza = new JLabel("Raza");
		lblRaza.setForeground(new Color(29, 29, 27));
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblRaza.setBounds(222, 364, 78, 14);
		add(lblRaza);

		// Etiqueta clase
		lblClase = new JLabel("Clase");
		lblClase.setForeground(new Color(29, 29, 27));
		lblClase.setHorizontalAlignment(SwingConstants.CENTER);
		lblClase.setFont(new Font("Open Sans", Font.BOLD, 16));
		lblClase.setBounds(222, 395, 78, 14);
		add(lblClase);

		// Boton seleccionar
		btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnSeleccionar.setForeground(new Color(242, 242, 242));
		btnSeleccionar.setBackground(new Color(29, 161, 242));
		btnSeleccionar.setOpaque(true);
		btnSeleccionar.setBorderPainted(false);
		btnSeleccionar.setBounds(315, 509, 172, 41);
		add(btnSeleccionar);

		// Boton editar
		btnEditar = new JButton("");
		btnEditar.setName("EDITAR");
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
		btnBorrar.setName("BORRAR");
		btnBorrar.setIcon(new ImageIcon(VerPersonajes.class.getResource("/img/botonBorrarW.png")));
		btnBorrar.setOpaque(true);
		btnBorrar.setForeground(new Color(29, 29, 27));
		btnBorrar.setFont(new Font("Oxygen", Font.BOLD, 17));
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(new Color(29, 29, 27));
		btnBorrar.setBounds(404, 467, 83, 36);
		add(btnBorrar);

	}

	/**
	 * Metodo que asigna el listener
	 * 
	 * @param listener Recibe el listener con el que quieres asignar los objetos
	 */

	public void cargarDatosEnComboBox() {
		comboBoxSeleccionar.removeAllItems();
		ResultSet rs = listener.get_data();
		try {
			while (rs.next()) {
				getComboBoxSeleccionar().addItem(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Guardar los datos en el ArrayList y actualizar el JComboBox

	}

	public void setListener(VerPersonajesListener listener) {
		btnEditar.addActionListener(listener);
		btnSeleccionar.addActionListener(listener);
		btnBorrar.addActionListener(listener);
		comboBoxSeleccionar.addActionListener(listener);
		this.listener = listener;
		cargarDatosEnComboBox();
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
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

	public JLabel getLblSeleccionarPersonaje() {
		return lblSeleccionarPersonaje;
	}

	public void setLblSeleccionarPersonaje(JLabel lblSeleccionarPersonaje) {
		this.lblSeleccionarPersonaje = lblSeleccionarPersonaje;
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

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
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

	public JComboBox getComboBoxSeleccionar() {
		return comboBoxSeleccionar;
	}

	public void setComboBoxSeleccionar(JComboBox comboBoxSeleccionar) {
		this.comboBoxSeleccionar = comboBoxSeleccionar;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public VerPersonajesListener getListener() {
		return listener;
	}

}
