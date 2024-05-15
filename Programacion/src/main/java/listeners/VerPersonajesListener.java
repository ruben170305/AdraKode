package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import model.Model;
import model.Usuario;
import views.*;

public class VerPersonajesListener extends Listener implements ActionListener {

	private EditarPersonaje ep;
	private Usuario user;

	// Constructor del Listener
	public VerPersonajesListener( EditarPersonaje ep, Menu menu, Home home, Usuario user ) {
		super( menu, home );
		this.ep = ep;
		this.user = user;
	}
	
	public ArrayList<String> get_data() {
		Model mysql = new Model();
        ResultSet rs = null;
        String query = "SELECT nombre FROM personaje WHERE cod_miembro = ?";
        ArrayList<String> nombres = new ArrayList<>();
        // Obtener la conexión
        try (Connection conn = mysql.get_connection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

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
     * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo del boton
     */
    @Override
    public void actionPerformed( ActionEvent ae ) {
		
        if ( ae.getActionCommand().equals( "" ) )
            super.menu.cargarPanel( ep );
        else if( ae.getActionCommand().equals( "SELECCIONAR" ) )
			super.menu.cargarPanel( home );
        else
			super.menu.cargarPanel( home );

    }
}