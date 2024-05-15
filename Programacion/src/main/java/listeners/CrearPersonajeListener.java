package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Model;
import model.Usuario;
import views.CrearPersonaje;
import views.Home;
import views.Menu;

public class CrearPersonajeListener extends Listener implements ActionListener {
	
	private CrearPersonaje cPersonaje;
	private Usuario user;
	
	public CrearPersonajeListener( Menu menu, Home home, CrearPersonaje cPersonaje, Usuario user ) {
		super( menu, home );
		this.cPersonaje = cPersonaje;
		this.user = user;
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "CREAR" ) ) {
			get_data();
			super.menu.cargarPanel( home );
		}
	}
	
	public void get_data() {
	    // Instanciamos el modelo
	    Model mysql = new Model();
	    mysql.get_connection();

	    // Consulta SQL
	    String insert = "INSERT INTO personaje (nombre, personaje, raza, clase, expe, cod_miembro) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection conn = mysql.get_connection(); 
	         PreparedStatement pstmt = conn.prepareStatement(insert)) {

	        // Configura los valores para la consulta
	        pstmt.setString(1, "Personaje");  // Suponiendo que 'Personaje' es un valor fijo
	        pstmt.setString(2, "Personaje");  // Suponiendo que 'Personaje' es un valor fijo
	        pstmt.setString(3, cPersonaje.getTxtRaza().getText());
	        pstmt.setString(4, cPersonaje.getTxtClase().getText());
	        pstmt.setInt(5, 0);  // Si 'expe' es un entero, debes definir cómo se obtiene el valor
	        pstmt.setInt(6, user.getUser_id());

	        // Ejecuta la inserción
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
