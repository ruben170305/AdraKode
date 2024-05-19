package listeners;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import model.*;
import views.*;

public class VerPartidaMasterListener extends Listener implements ActionListener {
	private EditarPartida ePartida;
	private PartidaIniciada pIniciada;
	private Partida partida;
	private Personaje personaje;

	
	public VerPartidaMasterListener( EditarPartida ePartida, Menu menu, Home home, Usuario user, PartidaIniciada pIniciada ) {
		super( menu, home );
		this.ePartida = ePartida;
		this.pIniciada = pIniciada;

		this.partida = new Partida();
		this.personaje = new Personaje( user );
	}
	
	@Override
	public void actionPerformed( ActionEvent ae ) {

		// Capturamos el nombre del componente
		String nombreComponente = ( ( JButton ) ae.getSource() ).getName();
		if ( ae.getActionCommand().equals( "JUGAR" ) ) {

			jugar_partida(0, 0);
        } else if(nombreComponente.equals( "editar" )) {
        	menu.cargarPanel( ePartida );
        } else if(nombreComponente.equals( "borrar" )) {
        	if ( menu.mostrarMensajeConfirmborrado() )
				menu.cargarPanel( home );
        }
	}

	public void jugar_partida( int partida_id, int jugador_id ) {

		// Datos de la partida seleccionada
		ResultSet rs_partida = partida.get_partida( partida_id );

		try {
			while( rs_partida.next() ) {
				pIniciada.getLblNivelPartida().setText( rs_partida.getString( "nombre" ) );

				pIniciada.getLblAnfitrion().setText(
					rs_partida.getString( "nombre_anfitrion" ) +
					rs_partida.getString( "apellidos_anfitrion" )
				);

				pIniciada.getLblJugadores().setText( String.valueOf( rs_partida.getInt( "numero_jugadores" ) ) );
				pIniciada.getLblDuración().setText( String.valueOf( rs_partida.getInt( "duracion" ) ) );
				pIniciada.getLblFecha().setText( rs_partida.getString( "fecha" ) );

				String en_curso_text = "";
				if( Integer.parseInt( rs_partida.getString( "estado" ) ) == 1 )
					en_curso_text = "En curso";
				else
					en_curso_text = "Finalizada";
				pIniciada.getLblEstado().setText( en_curso_text );
			}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Datos del personaje seleccionado
		ResultSet rs_personaje = personaje.get_personaje( jugador_id );

		try {
			while( rs_personaje.next() ) {
				pIniciada.getPbFuerza().setValue( rs_personaje.getInt( "fuerza" ) );
				pIniciada.getPbDestreza().setValue( rs_personaje.getInt( "destreza" ) );
				pIniciada.getPbConstitucion().setValue( rs_personaje.getInt( "constitucion" ) );
				pIniciada.getPbInteligencia().setValue( rs_personaje.getInt( "inteligencia" ) );
				pIniciada.getPbSabiduria().setValue( rs_personaje.getInt( "sabiduria" ) );
				pIniciada.getPbCarisma().setValue( rs_personaje.getInt( "carisma" ) );
			}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Cargamos el menú
		menu.cargarPanel( pIniciada );
	}

	/*
	public void editarPersonaje(int id) {
		ResultSet rs = get_data_personaje(id);
		try {
			while (rs.next()) {
				ep.getLblSeleccionarPersonaje().setText(rs.getString("nombre"));
				ep.getTxtRaza().setText(rs.getString("raza"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		menu.cargarPanel(ep);
	}
	*/

}


