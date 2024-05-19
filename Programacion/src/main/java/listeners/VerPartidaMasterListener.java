package listeners;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;
import views.*;

public class VerPartidaMasterListener extends Listener implements ActionListener {
	private EditarPartida ePartida;
	private VerPartidasMaster vPartidaMaster;
	private Personaje personaje;

	
	public VerPartidaMasterListener( VerPartidasMaster vPartidaMaster, EditarPartida ePartida, Menu menu, Home home, Usuario user ) {
		super( menu, home );
		this.vPartidaMaster = vPartidaMaster;
		this.ePartida = ePartida;

		this.personaje = new Personaje( user );
	}
	
	@Override
	public void actionPerformed( ActionEvent ae ) {

		// Capturamos el nombre del componente
		String nombreComponente = ( ( JButton ) ae.getSource() ).getName();
		if(nombreComponente.equals( "editar" )) {

			int partida_id = Integer.parseInt( vPartidaMaster.getIdPartidaLbl().getText());
			editar_partida( partida_id );
        } else if(nombreComponente.equals( "borrar" )) {
        	if ( menu.mostrarMensajeConfirmborrado() )
				menu.cargarPanel( home );
        }
	}

	public void editar_partida( int partida_id ) {

		// Modificar datos de la tabla
		DefaultTableModel model = ( DefaultTableModel ) ePartida.getTable().getModel();
		model.setRowCount( 0 ); // Limpiar la tabla existente

		// Datos del personaje seleccionado
		ResultSet rs_personaje = personaje.get_personajes_partida( partida_id );

		try {
			while( rs_personaje.next() ) {
				ePartida.getTxtAnfitrion().setText(
					rs_personaje.getString( "nombre_anfitrion" ) + " " +
					rs_personaje.getString( "apellidos_anfitrion" )
				);

				ePartida.getTxtDuracion().setText( String.valueOf( rs_personaje.getInt( "duracion" ) ) );

				String en_curso_text = "";
				if( Integer.parseInt( rs_personaje.getString( "en_curso" ) ) == 1 )
					en_curso_text = "En curso";
				else
					en_curso_text = "Finalizada";
				ePartida.getTxtEstado().setText( en_curso_text );

				ePartida.getTxtFecha().setText( rs_personaje.getString( "fecha" ) );
				ePartida.getTxtJugadores().setText( String.valueOf( rs_personaje.getInt( "numero_jugadores" ) ) );
				ePartida.getTxtNombrePartida().setText( rs_personaje.getString( "nombre" ) );

				// Definimos los campos de la tabla
				String jugador = rs_personaje.getString("personaje");
                String raza = rs_personaje.getString("raza");
                String clase = rs_personaje.getString("clase");

                model.addRow( new Object[]{ jugador, raza, clase } );
			}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Cargamos el menú
		menu.cargarPanel( ePartida );
	}

}


