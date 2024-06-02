package listeners;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import model.Model;
import model.Partida;
import model.Personaje;
import model.Usuario;
import views.*;

public class VerPartidaListener extends Listener implements ActionListener {
	
	
	private PartidaIniciada pIniciada;
	private VerPartidas vp;
	private Usuario user;

	public VerPartidaListener( Menu menu, Home home, Model mysql ) {
		super( menu, home, mysql );
	}

	public VerPartidaListener( Menu menu, Home home, Model mysql, PartidaIniciada pIniciada, VerPartidas vp, Usuario user ) {
		super( menu, home, mysql );
		this.pIniciada = pIniciada;
		this.vp = vp;
		this.user = user;
	}
	
	public void transfer_table_partidas() {
		
		Object[][] data = mysql.get_table_partidas();
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Anfitrion", "Nº jugadores", "Estado", "ID jugador" };
		
        DefaultTableModel template = new DefaultTableModel(data, columns);
        vp.getTable().setModel(template);
	}

    @Override
	public void actionPerformed( ActionEvent ae ) {

		// Dependiendo del listener, realizamos una acción u otra
		switch ( ae.getActionCommand() ) {
			case "JUGAR":
				
				// Capturamos la fila y el valor del ID de la partida
				int selected_row = vp.getTable().getSelectedRow();
				int partida_id = Integer.parseInt( vp.getTable().getValueAt( selected_row, 0 ).toString() );
				int jugador_id = Integer.parseInt( vp.getTable().getValueAt( selected_row, 8 ).toString() );
				
				// Insertamos el registro y cambiamos la vista a la de PartidaIniciada
				mysql.insertar_partida( partida_id, jugador_id );
				mysql.jugar_partida( partida_id, jugador_id, pIniciada, user, menu );
				break;
			default:
				break;
		}
	}
    
	/**
	 * Metodo que asigna el listener
	 * 
	 * @param listener Recibe el listener con el que quieres asignar los objetos
	 */

	 public void cargarDatosEnComboBox() {
		 vp.getComboBoxJugador().removeAllItems();
		ResultSet rs = mysql.get_personajes( user );
		try {
			while (rs.next()) {
				vp.getIdJugadorLbl().setText( String.valueOf( rs.getInt( "cod" ) ) );
				vp.getComboBoxJugador().addItem(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
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