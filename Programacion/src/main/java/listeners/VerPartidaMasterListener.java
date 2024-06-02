package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import views.*;

public class VerPartidaMasterListener extends Listener implements ActionListener, ListSelectionListener {
	private EditarPartida ep;
	private VerPartidasMaster vp;
	int selected_row = 0;
	private Usuario user;
	
	public VerPartidaMasterListener( VerPartidasMaster vp, EditarPartida ep, Menu menu, Home home, Model mysql, Usuario user ) {
		super( menu, home, mysql );
		this.vp = vp;
		this.ep = ep;
		this.user = user;
		
		vp.getTable().getSelectionModel().addListSelectionListener(this);
	}
	
	public void transfer_table_partidas() {
		
		Object[][] data = mysql.get_table_partidas();
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Anfitrion", "Nº jugadores", "Estado", "ID jugador" };
		
        DefaultTableModel template = new DefaultTableModel(data, columns);
        vp.getTable().setModel(template);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		// Capturamos el nombre del componente
		String nombreComponente = ((JButton) ae.getSource()).getName();
		if (nombreComponente.equals("editar")) {

			int partida_id = Integer.parseInt( vp.getIdPartidaLbl().getText());
			mysql.editar_partida( partida_id, ep, menu );
		} else if (nombreComponente.equals("borrar")) {
			if (menu.mostrarMensajeConfirmborrado()) {
				
				// Capturamos la fila y el valor del ID de la partida
				int selected_row = vp.getTable().getSelectedRow();
				int partida_id = Integer.parseInt( vp.getTable().getValueAt( selected_row, 0 ).toString() );
				
				mysql.borrar_partida(partida_id, mysql);
				
				// Renderizamos la ventana del listado de partidas
				VerPartidasMaster vPartidasMaster = new VerPartidasMaster();
				VerPartidaMasterListener vPartidaMasterListener = new VerPartidaMasterListener( vPartidasMaster, menu.getListener_menu().getEPartida(), menu, home, mysql, user );
				vPartidasMaster.setListener( vPartidaMasterListener );
				// menu.getListener_menu().getVPartidasMaster().dispose();
				menu.getListener_menu().setVPartidasMaster( vPartidasMaster );
				menu.cargarPanel( vPartidasMaster );
			}
		}
		
	}

	public void valueChanged(ListSelectionEvent e) {

		// Capturamos la fila y el valor del ID de la partida
		int selected_row = vp.getTable().getSelectedRow();

		// Actualizamos los JLabel con la información de la fila seleccionada
		vp.getLblIdPartida().setText( vp.getTable().getValueAt( selected_row, 0 ).toString() );
		vp.getLblTituloPartida().setText( vp.getTable().getValueAt( selected_row, 1 ).toString() );
		vp.getLblAnfitrion().setText( vp.getTable().getValueAt( selected_row, 5 ).toString() );
		vp.getLblJugadores().setText( vp.getTable().getValueAt( selected_row, 6 ).toString() );
		vp.getLblDuración().setText( vp.getTable().getValueAt( selected_row, 3 ).toString() + "'" );
		vp.getLblFecha().setText( vp.getTable().getValueAt( selected_row, 4 ).toString() );
		vp.getLblEstado().setText( vp.getTable().getValueAt( selected_row, 7 ).toString() );
		vp.getLblIdJugador().setText( vp.getTable().getValueAt( selected_row, 8 ).toString() );
	}

}