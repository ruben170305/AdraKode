package listeners;

import java.awt.event.*;
import java.sql.*;

import javax.swing.JButton;

import model.*;
import views.*;

public class CrearPersonajeListener extends Listener implements ActionListener {

	private CrearPersonaje cPersonaje;
	private Usuario user;

	public CrearPersonajeListener(Menu menu, Home home, CrearPersonaje cPersonaje, Usuario user) {
		super(menu, home);
		this.cPersonaje = cPersonaje;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Capturamos los botones
		JButton sourceButton = (JButton) ae.getSource();
		String buttonName = sourceButton.getName();

		// Dependiendo del action event, ejecutamos un panel u otro
		if (buttonName.equals("CREAR")) {
			insert_data();
			menu.cargarPanel(home);
		} else if (buttonName.equals("subirImagen")) {
			menu.mostrarMensajeConstruccion();
		}
	}

	/**
	 * Metodo que hace el insert a la base de datos de crearPersonaje
	 */
	public void insert_data() {

		// Instanciamos el modelo
		Model mysql = new Model();
		mysql.get_connection();

		// Consulta SQL
		String insert = "INSERT INTO personaje (nombre, personaje, raza, clase, expe, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma, cod_miembro)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = mysql.get_connection(); PreparedStatement pstmt = conn.prepareStatement(insert);) {

			// Recupera los valores de los campos
		    String nombre = cPersonaje.getLblSeleccionarPersonaje().getText();
		    String personaje = cPersonaje.getLblSeleccionarPersonaje().getText();
		    String raza = cPersonaje.getTxtRaza().getText();
		    String clase = cPersonaje.getTxtClase().getText();
		    Integer expe = (Integer) cPersonaje.getSpinnerExperiencia().getValue();
		    Integer fuerza = (Integer) cPersonaje.getSpinnerFuerza().getValue();
		    Integer destreza = (Integer) cPersonaje.getSpinnerDestreza().getValue();
		    Integer constitucion = (Integer) cPersonaje.getSpinnerConstitucion().getValue();
		    Integer inteligencia = (Integer) cPersonaje.getSpinnerInteligencia().getValue();
		    Integer sabiduria = (Integer) cPersonaje.getSpinnerSabiduria().getValue();
		    Integer carisma = (Integer) cPersonaje.getSpinnerCarisma().getValue();
		    Integer cod_miembro = user.getUser_id();

		    // Verifica que los campos obligatorios no estén vacíos o nulos
		    if (nombre == null || nombre.isEmpty() ||
		        personaje == null || personaje.isEmpty() ||
		        raza == null || raza.isEmpty() ||
		        clase == null || clase.isEmpty() ||
		        expe == null ||
		        fuerza == null ||
		        destreza == null ||
		        constitucion == null ||
		        inteligencia == null ||
		        sabiduria == null ||
		        carisma == null ||
		        cod_miembro == null) {
		        
		        throw new IllegalArgumentException("Todos los campos obligatorios deben ser completados.");
		    } else {
		    	pstmt.setString(1, nombre);
		    	pstmt.setString(2, personaje);
		    	pstmt.setString(3, raza);
		    	pstmt.setString(4, clase);
		    	pstmt.setInt(5, expe);
		    	pstmt.setInt(6, fuerza);
		    	pstmt.setInt(7, destreza);
		    	pstmt.setInt(8, constitucion);
		    	pstmt.setInt(9, inteligencia);
		    	pstmt.setInt(10, sabiduria);
		    	pstmt.setInt(11, carisma);
		    	pstmt.setInt(12, cod_miembro);
		    }

			// Ejecuta la inserción
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			menu.mostrarMensajeRellenaCampos();
		}
	}

}
