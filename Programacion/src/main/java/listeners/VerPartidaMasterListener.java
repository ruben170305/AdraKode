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
	private EditarPartida ePartida;
	private VerPartidasMaster vPartidaMaster;
	private Personaje personaje;
	int selected_row = 0;
	private Partida partida;
	
	public VerPartidaMasterListener( VerPartidasMaster vPartidaMaster, EditarPartida ePartida, Menu menu, Home home, Usuario user ) {
		super( menu, home );
		this.vPartidaMaster = vPartidaMaster;
		this.ePartida = ePartida;

		this.personaje = new Personaje( user );
		this.partida = new Partida();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		// Capturamos el nombre del componente
		String nombreComponente = ((JButton) ae.getSource()).getName();
		if (nombreComponente.equals("editar")) {

			int partida_id = Integer.parseInt( vPartidaMaster.getIdPartidaLbl().getText());
			editar_partida( partida_id );
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
	}

	public void borrarPartida(int id) {
		String sql = "DELETE FROM partida WHERE partida_id=?";
		Model mysql = new Model();

		Connection conn = mysql.get_connection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void editar_partida( int partida_id ) {

		// Modificar datos de la tabla
		DefaultTableModel model = ( DefaultTableModel ) ePartida.getTable().getModel();
		model.setRowCount( 0 ); // Limpiar la tabla existente

		ResultSet rs = partida.get_partida( partida_id );

		try {
			while( rs.next() ) {
				ePartida.getTxtAnfitrion().setText(
					rs.getString( "nombre_anfitrion" ) + " " +
					rs.getString( "apellidos_anfitrion" )
				);

				ePartida.getTxtDuracion().setText( String.valueOf( rs.getInt( "duracion" ) ) );

				String en_curso_text = "";
				if( Integer.parseInt( rs.getString( "en_curso" ) ) == 1 )
					en_curso_text = "En curso";
				else
					en_curso_text = "Finalizada";
				ePartida.getTxtEstado().setText( en_curso_text );

				ePartida.getTxtFecha().setText( rs.getString( "fecha" ) );
				ePartida.getTxtJugadores().setText( String.valueOf( rs.getInt( "numero_jugadores" ) ) );
				ePartida.getTxtNombrePartida().setText( rs.getString( "nombre" ) );
				ePartida.getTxtDificultad().setText( String.valueOf( rs.getInt( "dificultad" ) ) );
			}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Datos del personaje seleccionado
		ResultSet rs_personaje = personaje.get_personajes_partida( partida_id );

		try {
			while( rs_personaje.next() ) {

				// Definimos los campos de la tabla
				String jugador = rs_personaje.getString("personaje");
				String experiencia = rs_personaje.getString("expe");
                String raza = rs_personaje.getString("raza");
                String clase = rs_personaje.getString("clase");

                model.addRow( new Object[]{ jugador, experiencia, raza, clase } );
			}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Cargamos el menÃº
		menu.cargarPanel( ePartida );
	}

}