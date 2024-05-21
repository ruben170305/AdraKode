package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;

import model.*;
import views.*;

public class CrearPartidaListener extends Listener implements ActionListener {

	private CrearPartida cp;
	private boolean esMaster;
	private Usuario user;

	public CrearPartidaListener(Menu menu, Home home, CrearPartida cp, boolean esMaster, Usuario user) {
		super(menu, home);
		this.cp = cp;
		this.esMaster = esMaster;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		// Capturamos el nombre del componente
		String nombreComponente = ((JButton) ae.getSource()).getName();

		if (nombreComponente.equals("CREAR") && nombreComponente != null) {
			boolean renderize = crearPartidaBBDD();

			// Renderizamos de nuevo la ventana del listado de partidas
			if( esMaster && renderize ) {
				VerPartidasMaster vPartidasMaster = new VerPartidasMaster();
				VerPartidaMasterListener vPartidaMasterListener = new VerPartidaMasterListener(vPartidasMaster, menu.getListener_menu().getEPartida(), menu, home, user);
				vPartidasMaster.setListener(vPartidaMasterListener);
				// menu.getListener_menu().getVPartidasMaster().dispose();
				menu.getListener_menu().setVPartidasMaster(vPartidasMaster);
				menu.cargarPanel(vPartidasMaster);
			}
		} else if (nombreComponente.equals("cargarImagen")) {
			menu.mostrarMensajeConstruccion();
		}
	}

	/**
	 * Metodo que hace el insert a la base de datos de partida
	 */
	public boolean crearPartidaBBDD() {

		String sql = "INSERT INTO partida (nombre, duracion, dificultad, fecha, numero_jugadores, ambientacion, en_curso, anfitrion_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		Model mysql = new Model();
		Connection conn = mysql.get_connection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cp.getTxtNombrePartida().getText());
			ps.setInt(2, Integer.parseInt(cp.getTxtDuracion().getText()));
			ps.setInt(3, Integer.parseInt(cp.getTxtDificultad().getText()));
			ps.setString(4, cp.getTxtFecha().getText());
			ps.setInt(5, Integer.parseInt(cp.getTxtJugadores().getText()));
			ps.setString(6, cp.getTxtAnfitrion().getText());
			ps.setString(7, cp.getTxtEstado().getText());
			ps.setInt(8, Integer.parseInt( cp.getLblIdAnfitrion().getText()));

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			menu.mostrarMensajeRellenaCampos();
			return false;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return true;

	}

}
