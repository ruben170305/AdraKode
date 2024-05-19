package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public VerPersonajesListener( Usuario user ) {
		super();
		this.user = user;
	}

	// Constructor del Listener
	public VerPersonajesListener(
			EditarPersonaje ep
		, 	Menu menu
		, 	Home home
		, 	Usuario user
		, 	CrearPersonaje cPersonaje
		, 	VerPersonajes vPersonajes
		, 	Personaje personaje
	) {
		super( menu, home );
		this.cPersonaje = cPersonaje;
		this.ep = ep;
		this.user = user;
		this.vPersonajes = vPersonajes;
		this.personaje = personaje;
	}

	/**
	 * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo
	 * del boton
	 */
	@Override
	public void actionPerformed( ActionEvent ae ) {
		Object source = ae.getSource();

		if ( source instanceof JButton ) {
			JButton sourceButton = ( JButton ) source;
			String buttonName = sourceButton.getName();

			// Dependiendo del texto del botón realizamos una acción u otra
			if ( ae.getActionCommand().equals( "SELECCIONAR" ) ) {
				menu.cargarPanel( home );

			} else if ( buttonName.equals( "EDITAR" ) ) {
				editar_personaje( Integer.parseInt( vPersonajes.getIdLbl().getText() ) );

			} else if ( buttonName.equals( "BORRAR" ) ) {
				if ( menu.mostrarMensajeConfirmborrado() ) {
					delete_data();
					menu.cargarPanel(home);
				}
			}

		} else if ( source instanceof JComboBox ) {

			// Capturamos el ComboBox y el Item seleccionado
			JComboBox<?> comboBox = ( JComboBox<?> ) source;
			String selected_index = ( String ) comboBox.getSelectedItem();

			if( selected_index != null ) {

				// Capturamos los datos de la DB
				ResultSet rs = personaje.get_personajes();

				try {
					while ( rs.next() ) {

						String nombre = rs.getString( "nombre" );
						if ( selected_index.equals( nombre ) ) {

							vPersonajes.getLblClase().setText( rs.getString("clase" ) );
							vPersonajes.getLblRaza().setText( rs.getString("raza" ) );
							vPersonajes.getIdLbl().setText( rs.getString("cod" ) );
							vPersonajes.getPbExp().setValue(rs.getInt("expe"));
							vPersonajes.getPbFuerza().setValue(rs.getInt("fuerza"));
							vPersonajes.getPbDestreza().setValue(rs.getInt("destreza"));
							vPersonajes.getPbConstitucion().setValue(rs.getInt("constitucion"));
							vPersonajes.getPbInteligencia().setValue(rs.getInt("inteligencia"));
							vPersonajes.getPbSabiduria().setValue(rs.getInt("sabiduria"));
							vPersonajes.getPbCarisma().setValue(rs.getInt("carisma"));;

							// Sale del bucle una vez que se encuentra el ítem
							break;
						}
					}
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		}
	}

	public void editar_personaje( int id ) {

		// Capturamos los datos de la DB
		ResultSet rs = personaje.get_personaje( id );
		try {
			while (rs.next()) {
				ep.getLblSeleccionarPersonaje().setText(rs.getString("nombre"));
				ep.getTxtRaza().setText(rs.getString("raza"));
				ep.getTxtClase().setText(rs.getString("clase"));
				ep.getLblId().setText(id+"");
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		menu.cargarPanel( ep );
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

		} catch (SQLException sqle) {
			sqle.printStackTrace();
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
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}