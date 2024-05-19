package listeners;

import java.awt.event.*;
import java.sql.*;
import model.*;
import views.*;

public class CrearPersonajeListener extends Listener implements ActionListener {

	private CrearPersonaje cPersonaje;
	private Usuario user;

	public CrearPersonajeListener(
			Menu menu
		, 	Home home
		, 	CrearPersonaje cPersonaje
		, 	Usuario user
	) {
		super( menu, home );
		this.cPersonaje = cPersonaje;
		this.user = user;
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "CREAR" ) ) {
			insert_data();
			super.menu.cargarPanel( home );
		}
	}

	public void insert_data() {
		
		// Instanciamos el modelo
		Model mysql = new Model();
		mysql.get_connection();

		// Consulta SQL
		String insert = "insert into personaje (nombre, personaje, raza, clase, expe, cod_miembro) values (?, ?, ?, ?, ?, ?)";
		try (
			Connection conn = mysql.get_connection();
			PreparedStatement pstmt = conn.prepareStatement( insert );
		) {

			// Configura los valores para la consulta
			pstmt.setString( 1, cPersonaje.getLblSeleccionarPersonaje().getText() );
			pstmt.setString( 2, cPersonaje.getLblSeleccionarPersonaje().getText() );
			pstmt.setString( 3, cPersonaje.getTxtRaza().getText() );
			pstmt.setString( 4, cPersonaje.getTxtClase().getText() );
			pstmt.setInt( 5, 0 ); // Si 'expe' es un entero, debes definir cómo se obtiene el valor
			pstmt.setInt( 6, user.getUser_id() );

			// Ejecuta la inserción
			pstmt.executeUpdate();
		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}
	}

}
