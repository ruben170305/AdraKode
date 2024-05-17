package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;

import model.Model;
import model.Personaje;
import model.Usuario;
import views.*;

public class VerPersonajesListener extends Listener implements ActionListener {

	private EditarPersonaje ep;
	private Usuario user;
	private CrearPersonaje cPersonaje;
	private Personaje personaje;

	// Constructor del Listener
	public VerPersonajesListener(EditarPersonaje ep, Menu menu, Home home, Usuario user, CrearPersonaje cPersonaje,
			Personaje personaje) {
		super(menu, home);
		this.cPersonaje = cPersonaje;
		this.ep = ep;
		this.user = user;
		this.personaje = personaje;
	}

	public ArrayList<String> get_data() {
		Model mysql = new Model();
		ResultSet rs = null;
		String query = "SELECT nombre FROM personaje WHERE cod_miembro = ?";
		ArrayList<String> nombres = new ArrayList<>();
		// Obtener la conexión
		try (Connection conn = mysql.get_connection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

			// Establecer el parámetro cod_miembro
			pstmt.setInt(1, user.getUser_id());

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

			while (rs.next()) {
				nombres.add(rs.getString("nombre"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombres;
	}

	/**
	 * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo
	 * del boton
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		JButton sourceButton = ( JButton ) ae.getSource();
		String buttonName = sourceButton.getName();
		if (ae.getActionCommand().equals("SELECCIONAR")) {
			super.menu.cargarPanel(home);
		} else if (buttonName.equals("ACTUALIZAR")) {
			update_data();
			super.menu.cargarPanel(home);
		} else if (buttonName.equals("BORRAR")) {
			delete_data();
			super.menu.cargarPanel(home);
		}

	}

	public void update_data() {
		Model mysql = new Model();
		mysql.get_connection();

		String update = "UPDATE personaje SET nombre = ?, personaje = ?, raza = ?, clase = ?, expe = ? WHERE cod_miembro = ? AND id_personaje = ?";
		try (Connection conn = mysql.get_connection(); PreparedStatement pstmt = conn.prepareStatement(update)) {
			pstmt.setString(1, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un
																					// valor fijo
			pstmt.setString(2, cPersonaje.getLblSeleccionarPersonaje().getText()); // Suponiendo que 'Personaje' es un
																					// valor fijo
			pstmt.setString(3, cPersonaje.getTxtRaza().getText());
			pstmt.setString(4, cPersonaje.getTxtClase().getText());
			pstmt.setInt(5, 0); // Si 'expe' es un entero, debes definir cómo se obtiene el valor
			pstmt.setInt(6, user.getUser_id());
			pstmt.setInt(7, personaje.getPers_id());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete_data() {
		Model mysql = new Model();
		mysql.get_connection();

		String delete = "DELETE FROM personaje WHERE cod_miembro = ? AND cod = ?";

		try (Connection conn = mysql.get_connection(); PreparedStatement pstmt = conn.prepareStatement(delete)) {
			pstmt.setInt(1, user.getUser_id());
			pstmt.setInt(2, personaje.getPers_id());
			System.out.println(pstmt.toString());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}