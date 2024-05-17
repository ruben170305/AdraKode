package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public VerPersonajesListener(EditarPersonaje ep, Menu menu, Home home, Usuario user, CrearPersonaje cPersonaje, Personaje personaje) {
		super(menu, home);
		this.cPersonaje = cPersonaje;
		this.ep = ep;
		this.user = user;
		this.personaje = personaje;
	}

	public ArrayList<Personaje> get_data() {

		Model mysql = new Model();
		ResultSet rs = null;

		ArrayList<Personaje> personajes = new ArrayList<>();

		// Realizamos una consulta para capturar todos los personajes
		String sql = "select p.*, j.* from personaje p left join juega j on j.id_personaje = p.cod";
		try {
			Connection conn = mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement( sql );

			// Ejecutar la consulta
			rs = pstmt.executeQuery();

			// Creamos un objeto personaje por cada registro y lo añadimos al Data
			while( rs.next() ) {
				Personaje temp_personaje = new Personaje(
						rs.getInt( 1 )
					,   rs.getString( 2 )
					,   rs.getString( 3 )
					,   rs.getString( 4 )
					,   rs.getString( 5 )
					,   rs.getInt( 6 )
					,   rs.getInt( 7 )
					,   rs.getInt( 8 )
					,   rs.getInt( 9 )
					,   rs.getInt( 10 )
					,   rs.getInt( 11 )
					,   rs.getInt( 12 )
					,   rs.getInt( 13 )
				);

				// Añadimos al Data
				personajes.add( temp_personaje );

			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return personajes;

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
			pstmt.setInt(7, personaje.getCod());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete_data() {
		Model mysql = new Model();
		mysql.get_connection();

		String delete = "DELETE FROM personaje WHERE cod_miembro = ? AND cod = ?";

		try (Connection conn = mysql.get_connection(); PreparedStatement pstmt = conn.prepareStatement(delete)) {
			pstmt.setInt( 1, user.getUser_id() );
			pstmt.setInt( 2, personaje.getCod() );
			System.out.println(pstmt.toString());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}