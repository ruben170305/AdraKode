package listeners;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Partida;
import model.Personaje;
import model.Usuario;
import views.*;

public class VerPartidaListener extends Listener implements ActionListener {
	
	
	private PartidaIniciada pIniciada;
	private VerPartidas vPartida;
	private Partida partida;
	private Personaje personaje;

	public VerPartidaListener( Menu menu, Home home ) {
		super( menu, home );
	}

	public VerPartidaListener( Menu menu, Home home, PartidaIniciada pIniciada, VerPartidas vPartida, Usuario user ) {
		super( menu, home );
		this.pIniciada = pIniciada;
		this.vPartida = vPartida;

		this.partida = new Partida();
		this.personaje = new Personaje( user );
	}


    @Override
	public void actionPerformed( ActionEvent ae ) {

		// Dependiendo del listener, realizamos una acción u otra
		switch ( ae.getActionCommand() ) {
			case "JUGAR":

				int partida_id = Integer.parseInt( vPartida.getIdPartidaLbl().getText() );
				int jugador_id = Integer.parseInt( vPartida.getIdJugadorLbl().getText() );
				jugar_partida( partida_id, jugador_id );
				break;
			default:
				break;
		}
	}

	public void jugar_partida( int partida_id, int jugador_id ) {

		System.out.println( "Partida_id => " + partida_id + " Jugador_id =>" + jugador_id );

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
				if( Integer.parseInt( rs_partida.getString( "en_curso" ) ) == 1 )
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
}