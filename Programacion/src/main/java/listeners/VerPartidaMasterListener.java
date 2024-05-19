package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import views.*;

public class VerPartidaMasterListener extends Listener implements ActionListener, ListSelectionListener {
	private EditarPartida ePartida;
	private VerPartidasMaster vPartidaMaster;
	int selected_row = 0;

	public VerPartidaMasterListener(VerPartidasMaster vPartidaMaster, EditarPartida ePartida, Menu menu, Home home) {
		super(menu, home);
		this.vPartidaMaster = vPartidaMaster;
		this.ePartida = ePartida;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		// Capturamos el nombre del componente
		String nombreComponente = ((JButton) ae.getSource()).getName();
		if (nombreComponente.equals("editar")) {

			int partida_id = Integer.parseInt(vPartidaMaster.getIdPartidaLbl().getText());

			menu.cargarPanel(ePartida);
		} else if (nombreComponente.equals("borrar")) {
			if (menu.mostrarMensajeConfirmborrado()) {
				borrarPartida(selected_row);
				menu.cargarPanel(home);
			}
		}
	}

	public void valueChanged(ListSelectionEvent e) {

		// Capturamos la fila y el valor del ID de la partida
		int selected_row1 = vPartidaMaster.getTable().getSelectedRow();
		selected_row = Integer.parseInt(vPartidaMaster.getTable().getValueAt(selected_row1, 0).toString());
		
		System.out.println(selected_row);
	}

	public void borrarPartida(int id) {
		String sql = "DELETE FROM partida WHERE partida_id=?";
		Model mysql = new Model();

		Connection conn = mysql.get_connection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			System.out.println(ps.toString());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}

}
