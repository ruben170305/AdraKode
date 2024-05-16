package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Model;
import model.Personaje;
import model.Usuario;
import views.CrearPersonaje;
import views.Home;
import views.Menu;

public class CrearPersonajeListener extends Listener implements ActionListener {
	
	private CrearPersonaje cPersonaje;
	private Usuario user;
	private Personaje personaje; 
	
	public CrearPersonajeListener( Menu menu, Home home, CrearPersonaje cPersonaje, Usuario user, Personaje personaje ) {
		super( menu, home );
		this.cPersonaje = cPersonaje;
		this.user = user;
		this.personaje = personaje;
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		if ( ae.getActionCommand().equals( "CREAR" ) ) {
			get_data();
			super.menu.cargarPanel( home );
		}else if (ae.getActionCommand().equals("ACTUALIZAR")) {
			update_data();
			super.menu.cargarPanel(home);
		}else if(ae.getActionCommand().equals("ELIMINAR")) {
			try {
				delete_data();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.menu.cargarPanel(home);
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
	        pstmt.setString(1, cPersonaje.getLblSeleccionarPersonaje().getText());  // Suponiendo que 'Personaje' es un valor fijo
	        pstmt.setString(2, cPersonaje.getLblSeleccionarPersonaje().getText());  // Suponiendo que 'Personaje' es un valor fijo
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
	public void update_data () {
		Model mysql = new Model ();
		mysql.get_connection();
		
		String update = "UPDATE personaje SET nombre = ?, personaje = ?, raza = ?; clase = ?, expe = ? WHERE cod_miembro = ? AND id_personaje = ?";
		try ( Connection conn = mysql.get_connection();
				PreparedStatement pstmt = conn.prepareStatement(update)){
			pstmt.setString(1, cPersonaje.getLblSeleccionarPersonaje().getText());
			pstmt.setString(2, cPersonaje.getLblSeleccionarPersonaje().getText());
			pstmt.setString(3, cPersonaje.getTxtRaza().getText());
			pstmt.setString(4, cPersonaje.getTxtClase().getText());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, user.getUser_id());
			
			//Ejecuta la inserción
			pstmt.executeUpdate();
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void delete_data() throws SQLException {
		Model mysql = new Model ();
		mysql.get_connection();
		
		String delete = "DELETE FROM personaje WHERE cod_miembro = ? AND id_personaje = ?";
		try (Connection conn = mysql.get_connection();
				PreparedStatement pstmt = conn.prepareStatement(delete)){
			
			pstmt.setInt(1, user.getUser_id());
			pstmt.setInt(2, personaje.getPers_id());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	

}
