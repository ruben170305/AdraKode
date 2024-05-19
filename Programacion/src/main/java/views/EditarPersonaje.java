package views;

import javax.swing.*;

import java.awt.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import listeners.EditarPersonajesListener;

public class EditarPersonaje extends JPanel {
	private JTextField txtRaza, txtClase;
    private JLabel lblDestreza, lblConstitucion, lblInteligencia, lblSabiduria, lblCarisma;
    private JLabel lblTitulo, lblFuerza, lblSeleccionarPersonaje, lblRaza, lblIconoPersn;
    private JLabel lblIconoExp, lblIconoFuerza, lblIconoDestreza, lblIconoConst, lblIconoInteligencia, lblIconoSabiduria, lblIconoCarisma, lblClase, lblExp;
    private JSpinner spinnerExperiencia, spinnerFuerza, spinnerDestreza, spinnerConstitucion, spinnerInteligencia, spinnerSabiduria, spinnerCarisma;
    private JButton btnGuardarImagen, btnGuardar;
    private JLabel lblId;
    
    private boolean esMaster;

    public EditarPersonaje(boolean esMaster) {
        initialize_components();
        this.esMaster = esMaster;
    }

    private void initialize_components() {
		//Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
        setBounds( new Rectangle( 0, 0, 0, 19 ) );
        setBackground( new Color( 242, 242, 242 ) );
		
		//layout absoluto
		setLayout(null);
		
		//Tamaño y posicion de ventana
		setSize( 800, 600 );		
		
		/* COMPONENTES */
		
		// Creo border para cajas de texto (solo linea inferior)
		Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(29, 29, 27));

        // Titulo
        lblTitulo = new JLabel("EDITAR PERSONAJE");
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
        lblSeleccionarPersonaje = new JLabel("PERSONAJE 1");
        lblSeleccionarPersonaje.setForeground(new Color(29, 29, 27));
        lblSeleccionarPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblSeleccionarPersonaje.setFont(new Font("Open Sans", Font.BOLD, 18));
        lblSeleccionarPersonaje.setBounds(293, 136, 214, 28);
        add(lblSeleccionarPersonaje);

        // Iconos
        lblIconoExp = new JLabel();
        lblIconoExp.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoExp.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoExp.png")));
        lblIconoExp.setBounds(367, 199, 35, 33);
        add(lblIconoExp);

        lblIconoFuerza = new JLabel();
        lblIconoFuerza.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoFuerza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoFrza.png")));
        lblIconoFuerza.setBounds(367, 230, 35, 33);
        add(lblIconoFuerza);

        lblIconoDestreza = new JLabel();
        lblIconoDestreza.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoDestreza.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoDestreza.png")));
        lblIconoDestreza.setBounds(367, 261, 35, 33);
        add(lblIconoDestreza);

        lblIconoConst = new JLabel();
        lblIconoConst.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoConst.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoConstitucion.png")));
        lblIconoConst.setBounds(367, 292, 35, 33);
        add(lblIconoConst);

        lblIconoInteligencia = new JLabel();
        lblIconoInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoInteligencia.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoInteli.png")));
        lblIconoInteligencia.setBounds(367, 323, 35, 33);
        add(lblIconoInteligencia);

        lblIconoSabiduria = new JLabel();
        lblIconoSabiduria.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoSabiduria.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoSab.png")));
        lblIconoSabiduria.setBounds(367, 354, 35, 33);
        add(lblIconoSabiduria);

        lblIconoCarisma = new JLabel();
        lblIconoCarisma.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoCarisma.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/IconoCarisma.png")));
        lblIconoCarisma.setBounds(367, 385, 35, 33);
        add(lblIconoCarisma);

        // Etiqueta exp
        lblExp = new JLabel("Experiencia");
        lblExp.setHorizontalAlignment(SwingConstants.LEFT);
        lblExp.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblExp.setBounds(412, 206, 104, 18);
        add(lblExp);

        // Etiqueta fuerza
        lblFuerza = new JLabel("Fuerza");
        lblFuerza.setHorizontalAlignment(SwingConstants.LEFT);
        lblFuerza.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblFuerza.setBounds(412, 237, 104, 18);
        add(lblFuerza);

        // Etiqueta destreza
        lblDestreza = new JLabel("Destreza");
        lblDestreza.setHorizontalAlignment(SwingConstants.LEFT);
        lblDestreza.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblDestreza.setBounds(412, 268, 104, 18);
        add(lblDestreza);

        // Etiqueta constitución
        lblConstitucion = new JLabel("Constitución");
        lblConstitucion.setHorizontalAlignment(SwingConstants.LEFT);
        lblConstitucion.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblConstitucion.setBounds(412, 299, 104, 18);
        add(lblConstitucion);

        // Etiqueta inteligencia
        lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setHorizontalAlignment(SwingConstants.LEFT);
        lblInteligencia.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblInteligencia.setBounds(412, 330, 104, 18);
        add(lblInteligencia);

        // Etiqueta sabiduría
        lblSabiduria = new JLabel("Sabiduría");
        lblSabiduria.setHorizontalAlignment(SwingConstants.LEFT);
        lblSabiduria.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblSabiduria.setBounds(412, 361, 104, 18);
        add(lblSabiduria);

        // Etiqueta carisma
        lblCarisma = new JLabel("Carisma");
        lblCarisma.setHorizontalAlignment(SwingConstants.LEFT);
        lblCarisma.setFont(new Font("Open Sans", Font.PLAIN, 14));
        lblCarisma.setBounds(412, 392, 104, 18);
        add(lblCarisma);

        // Spinners
        spinnerExperiencia = new JSpinner();
        spinnerExperiencia.setForeground(new Color(242, 242, 242));
        spinnerExperiencia.setBackground(new Color(29, 161, 242));
        spinnerExperiencia.setOpaque(true);
        spinnerExperiencia.setBounds(515, 206, 42, 20);
        add(spinnerExperiencia);

        spinnerFuerza = new JSpinner();
        spinnerFuerza.setOpaque(true);
        spinnerFuerza.setForeground(new Color(242, 242, 242));
        spinnerFuerza.setBackground(new Color(29, 161, 242));
        spinnerFuerza.setBounds(515, 237, 42, 20);
        add(spinnerFuerza);

        spinnerDestreza = new JSpinner();
        spinnerDestreza.setOpaque(true);
        spinnerDestreza.setForeground(new Color(242, 242, 242));
        spinnerDestreza.setBackground(new Color(29, 161, 242));
        spinnerDestreza.setBounds(515, 268, 42, 20);
        add(spinnerDestreza);

        spinnerConstitucion = new JSpinner();
        spinnerConstitucion.setOpaque(true);
        spinnerConstitucion.setForeground(new Color(242, 242, 242));
        spinnerConstitucion.setBackground(new Color(29, 161, 242));
        spinnerConstitucion.setBounds(515, 299, 42, 20);
        add(spinnerConstitucion);

        spinnerInteligencia = new JSpinner();
        spinnerInteligencia.setOpaque(true);
        spinnerInteligencia.setForeground(new Color(242, 242, 242));
        spinnerInteligencia.setBackground(new Color(29, 161, 242));
        spinnerInteligencia.setBounds(515, 330, 42, 20);
        add(spinnerInteligencia);

        spinnerSabiduria = new JSpinner();
        spinnerSabiduria.setOpaque(true);
        spinnerSabiduria.setForeground(new Color(242, 242, 242));
        spinnerSabiduria.setBackground(new Color(29, 161, 242));
        spinnerSabiduria.setBounds(515, 361, 42, 20);
        add(spinnerSabiduria);

        spinnerCarisma = new JSpinner();
        spinnerCarisma.setOpaque(true);
        spinnerCarisma.setForeground(new Color(242, 242, 242));
        spinnerCarisma.setBackground(new Color(29, 161, 242));
        spinnerCarisma.setBounds(515, 392, 42, 20);
        add(spinnerCarisma);

        // Imagen del personaje
        lblIconoPersn = new JLabel("");
        lblIconoPersn.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/personajes/personaje_1.png")));
        lblIconoPersn.setHorizontalAlignment(SwingConstants.CENTER);
        lblIconoPersn.setBounds(240, 208, 84, 123);
        add(lblIconoPersn);
        
        // Etiqueta raza
        lblRaza = new JLabel("Raza");
        lblRaza.setForeground(new Color(29, 29, 27));
        lblRaza.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRaza.setFont(new Font("Open Sans", Font.BOLD, 16));
        lblRaza.setBounds(165, 364, 78, 14);
        add(lblRaza);

        // Etiqueta clase
        lblClase = new JLabel("Clase");
        lblClase.setForeground(new Color(29, 29, 27));
        lblClase.setHorizontalAlignment(SwingConstants.RIGHT);
        lblClase.setFont(new Font("Open Sans", Font.BOLD, 16));
        lblClase.setBounds(165, 395, 78, 14);
        add(lblClase);
        
        //Campo texto raza
        txtRaza = new JTextField();
        txtRaza.setBackground(new Color(242, 242, 242));
        txtRaza.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtRaza.setBounds(251, 364, 101, 14);
        txtRaza.setColumns(10);
        txtRaza.setBorder(border);
        add(txtRaza);
        
        //Campo texto raza
        txtClase = new JTextField();
        txtClase.setBackground(new Color(242, 242, 242));
        txtClase.setFont(new Font("Open Sans", Font.PLAIN, 11));
        txtClase.setBounds(251, 395, 101, 14);
        txtClase.setColumns(10);
        txtClase.setBorder(border);
        add(txtClase);

        // Botones
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardar.setForeground(new Color(242, 242, 242));
        btnGuardar.setBackground(new Color(29, 161, 242));
        btnGuardar.setOpaque(true);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setBounds(286, 485, 159, 45);
        add(btnGuardar);

        btnGuardarImagen = new JButton("");
        btnGuardarImagen.setName("botonSubirImagen");
        btnGuardarImagen.setIcon(new ImageIcon(EditarPersonaje.class.getResource("/img/camara_fotografica.png")));
        btnGuardarImagen.setOpaque(true);
        btnGuardarImagen.setForeground(new Color(242, 242, 242));
        btnGuardarImagen.setFont(new Font("Oxygen", Font.BOLD, 17));
        btnGuardarImagen.setBorderPainted(false);
        btnGuardarImagen.setBackground(new Color(29, 29, 27));
        btnGuardarImagen.setBounds(453, 485, 61, 45);
        add(btnGuardarImagen);
        
        lblId = new JLabel("ID");
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblId.setForeground(new Color(29, 29, 27));
        lblId.setFont(new Font("Dialog", Font.BOLD, 16));
        lblId.setBounds(345, 174, 78, 14);
        
        if (esMaster) {
			spinnerExperiencia.setEnabled(true);
			spinnerCarisma.setEnabled(false);
			spinnerConstitucion.setEnabled(false);
			spinnerDestreza.setEnabled(false);
			spinnerFuerza.setEnabled(false);
			spinnerInteligencia.setEnabled(false);
			spinnerSabiduria.setEnabled(false);
			txtClase.setEditable(false);
			txtRaza.setEditable(false);
		} else {
			getSpinnerExperiencia().setEnabled(false);
			getSpinnerCarisma().setEnabled(true);
			getSpinnerConstitucion().setEnabled(true);
			getSpinnerDestreza().setEnabled(true);
			spinnerFuerza.setEnabled(true);
			spinnerInteligencia.setEnabled(true);
			spinnerSabiduria.setEnabled(true);
		}
    }

    /**
     * Método que asigna los listeners
     */
    public void setListener( EditarPersonajesListener listener ) {
		btnGuardar.addActionListener( listener );
        btnGuardarImagen.addActionListener( listener );
	}

	public JTextField getTxtRaza() {
		return txtRaza;
	}

	public void setTxtRaza(JTextField txtRaza) {
		this.txtRaza = txtRaza;
	}

	public JTextField getTxtClase() {
		return txtClase;
	}

	public void setTxtClase(JTextField txtClase) {
		this.txtClase = txtClase;
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

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblFuerza() {
		return lblFuerza;
	}

	public void setLblFuerza(JLabel lblFuerza) {
		this.lblFuerza = lblFuerza;
	}

	public JLabel getLblSeleccionarPersonaje() {
		return lblSeleccionarPersonaje;
	}

	public void setLblSeleccionarPersonaje(JLabel lblSeleccionarPersonaje) {
		this.lblSeleccionarPersonaje = lblSeleccionarPersonaje;
	}

	public JLabel getLblRaza() {
		return lblRaza;
	}

	public void setLblRaza(JLabel lblRaza) {
		this.lblRaza = lblRaza;
	}

	public JLabel getLblIconoPersn() {
		return lblIconoPersn;
	}

	public void setLblIconoPersn(JLabel lblIconoPersn) {
		this.lblIconoPersn = lblIconoPersn;
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

	public JLabel getLblExp() {
		return lblExp;
	}

	public void setLblExp(JLabel lblExp) {
		this.lblExp = lblExp;
	}

	public JSpinner getSpinnerExperiencia() {
		return spinnerExperiencia;
	}

	public void setSpinnerExperiencia(JSpinner spinnerExperiencia) {
		this.spinnerExperiencia = spinnerExperiencia;
	}

	public JSpinner getSpinnerFuerza() {
		return spinnerFuerza;
	}

	public void setSpinnerFuerza(JSpinner spinnerFuerza) {
		this.spinnerFuerza = spinnerFuerza;
	}

	public JSpinner getSpinnerDestreza() {
		return spinnerDestreza;
	}

	public void setSpinnerDestreza(JSpinner spinnerDestreza) {
		this.spinnerDestreza = spinnerDestreza;
	}

	public JSpinner getSpinnerConstitucion() {
		return spinnerConstitucion;
	}

	public void setSpinnerConstitucion(JSpinner spinnerConstitucion) {
		this.spinnerConstitucion = spinnerConstitucion;
	}

	public JSpinner getSpinnerInteligencia() {
		return spinnerInteligencia;
	}

	public void setSpinnerInteligencia(JSpinner spinnerInteligencia) {
		this.spinnerInteligencia = spinnerInteligencia;
	}

	public JSpinner getSpinnerSabiduria() {
		return spinnerSabiduria;
	}

	public void setSpinnerSabiduria(JSpinner spinnerSabiduria) {
		this.spinnerSabiduria = spinnerSabiduria;
	}

	public JSpinner getSpinnerCarisma() {
		return spinnerCarisma;
	}

	public void setSpinnerCarisma(JSpinner spinnerCarisma) {
		this.spinnerCarisma = spinnerCarisma;
	}

	public JButton getBtnGuardarImagen() {
		return btnGuardarImagen;
	}

	public void setBtnGuardarImagen(JButton btnGuardarImagen) {
		this.btnGuardarImagen = btnGuardarImagen;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}
	
	
    
    
}
