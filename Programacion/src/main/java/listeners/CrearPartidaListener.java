package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Model;
import model.Usuario;
import views.*;

public class CrearPartidaListener extends Listener implements ActionListener {
	
	private CrearPartida cp;
	private Usuario user;
	
	public CrearPartidaListener( Menu menu, Home home, CrearPartida cp, Usuario user ) {
		super( menu, home );
		this.cp = cp;
		this.user = user;
	}

	@Override
	public void actionPerformed( ActionEvent ae ) {
		if (  ae.getActionCommand().equals( "CREAR" ) ) {
			crearPartidaBBDD();
			this.menu.cargarPanel( home );
		}
	}
	
	public void crearPartidaBBDD() {
		String sql = "INSERT INTO partida (nombre, duracion, fecha, numero_jugadores)"+
					" VALUES (?, ?, ?, ?)";

		Model mysql = new Model();
		Connection conn = mysql.get_connection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cp.getTxtNombrePartida().getText());
			ps.setInt(2, Integer.parseInt(cp.getTxtDuracion().getText()));
			ps.setString(3, cp.getTxtFecha().getText());
			ps.setInt(4, Integer.parseInt(cp.getTxtJugadores().getText()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			menu.mostrarMensajeRellenaCampos();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		}
		
		
	}

}
