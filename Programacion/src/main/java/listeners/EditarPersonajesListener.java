package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

import model.Model;
import model.Usuario;
import views.*;

public class EditarPersonajesListener extends Listener implements ActionListener {
	
	private EditarPersonaje ep;
	private VerPersonajes vPersonajes;
	private Usuario user;

	// Constructor del Listener
	public EditarPersonajesListener(
			Menu menu
		, 	Home home
		, 	EditarPersonaje ep
		, 	VerPersonajes vPersonaje
		, 	Usuario user
	) {
		super( menu, home );
		this.ep = ep;
		this.vPersonajes = vPersonaje;
		this.user = user;
	}

	/**
	 * Listener del botón de editar personaje
	 */
	@Override
	public void actionPerformed( ActionEvent ae ) {

		// Capturamos los botones
		JButton sourceButton = ( JButton ) ae.getSource();
		String buttonName = sourceButton.getName();

		// Dependiendo del action event, ejecutamos un panel u otro
		if ( ae.getActionCommand().equals( "" ) || ae.getActionCommand().equals( "GUARDAR" ) ) {
			if ( menu.mostrarMensajeConfirmEditado() ) {
				db_update();
				menu.cargarPanel( home );
			} else {
				menu.cargarPanel( vPersonajes );
			}
		}
		
		else if ( buttonName.equals( "botonSubirImagen" ) ) {}
	}
	
	public void db_update() {

		// Inicializamos la conexión con MySQL
		Model mysql = new Model();
		String sql = "UPDATE personaje "
				+ "SET clase=?, raza=?, expe=?, fuerza=?, destreza=?, constitucion=?, inteligencia=?, sabiduria=?, carisma=?, cod_miembro=? "
				+ "WHERE cod=?";
		Connection conn = mysql.get_connection();

		try {
			// Consulta para actualizar la tabla
			PreparedStatement pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, ep.getTxtClase().getText() );
			pstmt.setString( 2, ep.getTxtRaza().getText() );
			pstmt.setInt(3, (int) ep.getSpinnerExperiencia().getValue());
			pstmt.setInt(4, (int) ep.getSpinnerFuerza().getValue());
			pstmt.setInt(5, (int) ep.getSpinnerDestreza().getValue());
			pstmt.setInt(6, (int) ep.getSpinnerConstitucion().getValue());
			pstmt.setInt(7, (int) ep.getSpinnerInteligencia().getValue());
			pstmt.setInt(8, (int) ep.getSpinnerSabiduria().getValue());
			pstmt.setInt(9, (int) ep.getSpinnerCarisma().getValue());
			pstmt.setInt(10, (int) user.getUser_id());
			pstmt.setInt(11, Integer.parseInt(ep.getLblId().getText()));
			
			pstmt.executeUpdate();

		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}
	}
	
	/**
	 * Metodo que permite subir imagenes
	 */
	public void subirImagen() {
		
	}
}
