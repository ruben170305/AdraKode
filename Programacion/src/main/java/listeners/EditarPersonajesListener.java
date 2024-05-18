package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import model.Model;
import views.*;

public class EditarPersonajesListener extends Listener implements ActionListener {
	
	private EditarPersonaje ep;
	private VerPersonajes vPersonajes;
	// Constructor del Listener
	public EditarPersonajesListener( Menu menu, Home home, EditarPersonaje ep, VerPersonajes vPersonaje ) {
		super( menu, home );
		this.ep = ep;
		this.vPersonajes = vPersonaje;
	}

	/**
	 * Listener del botón de editar personazje
	 */
	@Override
	public void actionPerformed( ActionEvent ae ) {
		JButton sourceButton = ( JButton ) ae.getSource();
		String buttonName = sourceButton.getName();
		if ( ae.getActionCommand().equals( "" ) || ae.getActionCommand().equals( "GUARDAR" ) ) {
			if (menu.mostrarMensajeConfirmEditado()) {
				actualizarBBDD();
				this.menu.cargarPanel( home );
			} else {
				this.menu.cargarPanel(vPersonajes);
			}
		} else if ( buttonName.equals( "botonSubirImagen" ) ) {

		}
	}
	
	public void actualizarBBDD() {
		Model mysql = new Model();
		String sql = "UPDATE personaje SET clase=?, raza=? WHERE cod=?";
		Connection conn = mysql.get_connection();
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ep.getTxtClase().getText());
			pstmt.setString(2, ep.getTxtRaza().getText());
			pstmt.setInt(3, Integer.parseInt(ep.getLblId().getText()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que permite subir imagenes
	 */
	public void subirImagen() {
		
	}
}
