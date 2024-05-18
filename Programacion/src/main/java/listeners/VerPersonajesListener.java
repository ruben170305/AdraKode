package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.Model;
import model.Personaje;
import model.Usuario;
import views.*;

public class VerPersonajesListener extends Listener implements ActionListener {

	private EditarPersonaje ep;
	private Usuario user;
	private CrearPersonaje cPersonaje;
	private VerPersonajes vPersonajes;
	private Personaje personaje;

	// Constructor del Listener
	public VerPersonajesListener(Usuario user) {
		super();
		this.user = user;
	}

	// Constructor del Listener
	public VerPersonajesListener(EditarPersonaje ep, Menu menu, Home home, Usuario user, CrearPersonaje cPersonaje,
			VerPersonajes vPersonajes, Personaje personaje) {
		super(menu, home);
		this.cPersonaje = cPersonaje;
		this.ep = ep;
		this.user = user;
		this.vPersonajes = vPersonajes;
		this.personaje = personaje;
	}

	public ResultSet get_data() {

		Model mysql = new Model();
		ResultSet rs = null;

		ArrayList<Personaje> personajes = new ArrayList<>();

		// Realizamos una consulta para capturar todos los personajes
		String sql = "SELECT * FROM personaje WHERE cod_miembro=?";
		try {
			Connection conn = mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_id());
			System.out.println(pstmt.toString());

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

			// Creamos un objeto personaje por cada registro y lo añadimos al Data
//			while( rs.next() && rs != null ) {
//				Personaje temp_personaje = new Personaje(
//						rs.getInt( 1 )
//					,   rs.getString( 2 )
//					,   rs.getString( 3 )
//					,   rs.getString( 4 )
//					,   rs.getString( 5 )
//					,   rs.getInt( 6 )
//					,   rs.getInt( 7 )
//					,   rs.getInt( 8 )
//					,   rs.getInt( 9 )
//					,   rs.getInt( 10 )
//					,   rs.getInt( 11 )
//					,   rs.getInt( 12 )
//					,   rs.getInt( 13 )
//				);
//
//				// Añadimos al Data
//				personajes.add( temp_personaje );
//
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	public ResultSet get_data_personaje(int id) {

		Model mysql = new Model();
		ResultSet rs = null;

		// Realizamos una consulta para capturar todos los personajes
		String sql = "SELECT * FROM personaje WHERE cod_miembro=? AND cod=?";
		try {
			Connection conn = mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_id());
			pstmt.setInt(2, id);
			System.out.println(pstmt.toString());

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	/**
	 * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo
	 * del boton
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source instanceof JButton) {
			JButton sourceButton = (JButton) source;
			String buttonName = sourceButton.getName();

			if (ae.getActionCommand().equals("SELECCIONAR")) {
				super.menu.cargarPanel(home);
			} else if (buttonName.equals("EDITAR")) {
				editarPersonaje(Integer.parseInt(vPersonajes.getIdLbl().getText()));
			} else if (buttonName.equals("BORRAR")) {
				if (menu.mostrarMensajeConfirmborrado()) {
					delete_data();
					super.menu.cargarPanel(home);
				} else {
					
				}
			}
		} else if (source instanceof JComboBox) {
			JComboBox<?> comboBox = (JComboBox<?>) source;
			System.out.println("Se seleccionó un JComboBox: " + comboBox.getSelectedItem());
			String selected_index = (String) comboBox.getSelectedItem(); // Asumiendo que el ítem seleccionado es un
																			// String
			ResultSet rs = get_data();
			try {
				while (rs.next()) {
					String nombre = rs.getString("nombre");
					if (selected_index.equals(nombre)) {
						vPersonajes.getLblClase().setText(rs.getString("clase"));
						vPersonajes.getLblRaza().setText(rs.getString("raza"));
						vPersonajes.getIdLbl().setText(rs.getString("cod"));
						break; // Sale del bucle una vez que se encuentra el ítem
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void editarPersonaje(int id) {
		ResultSet rs = get_data_personaje(id);
		try {
			while (rs.next()) {
				ep.getLblSeleccionarPersonaje().setText(rs.getString("nombre"));
				ep.getTxtRaza().setText(rs.getString("raza"));
				ep.getTxtClase().setText(rs.getString("clase"));
				ep.getLblId().setText(id+"");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		menu.cargarPanel(ep);
	}

	public void update_data() {
		Model mysql = new Model();
		mysql.get_connection();

		String update = "UPDATE personaje SET nombre = ?, personaje = ?, raza = ?, clase = ?, expe = ? WHERE cod_miembro = ? AND id_personaje = ?";
		try (Connection conn = mysql.get_connection(); PreparedStatement pstmt = conn.prepareStatement(update)) {
			pstmt.setString(1, cPersonaje.getLblSeleccionarPersonaje().getText());
			pstmt.setString(2, cPersonaje.getLblSeleccionarPersonaje().getText());
			pstmt.setString(3, cPersonaje.getTxtRaza().getText());
			pstmt.setString(4, cPersonaje.getTxtClase().getText());
			pstmt.setInt(5, 0); // Si 'expe' es un entero, debes definir cómo se obtiene el valor
			pstmt.setInt(6, user.getUser_id());
			pstmt.setInt(7, personaje.getCod());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete_data() {
		Model mysql = new Model();
		mysql.get_connection();

		try {
			String delete = "DELETE FROM personaje WHERE cod_miembro = ? AND cod = ?";
			Connection conn = mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, user.getUser_id());
			pstmt.setInt(2, Integer.parseInt(vPersonajes.getIdLbl().getText()));
			System.out.println(pstmt.toString());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}