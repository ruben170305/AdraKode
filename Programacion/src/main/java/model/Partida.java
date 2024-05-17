package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Partida extends Data {

    // Definimos las características de la Partida
    private int part_id, num_sesion, duracion, dificultad, numero_jugadores, en_curso, anfitrion_id;
    private String nombre, fecha, ambientacion, nombre_anfitrion, apellidos_anfitrion;

    public Partida( Model mysql ){
		this.mysql = mysql;
	}

    // Constructor
    public Partida(
            int part_id
        ,   int num_sesion
        ,   String nombre
        ,   int duracion
        ,   int dificultad
        ,   String fecha
        ,   int numero_jugadores
        ,   String ambientacion
        ,   int en_curso
        ,   int anfitrion_id
        ,   String nombre_anfitrion
        ,   String apellidos_anfitrion
    ) {
        super();
        this.part_id                = part_id;
        this.num_sesion             = num_sesion;
        this.nombre                 = nombre;
        this.duracion               = duracion;
        this.dificultad             = dificultad;
        this.fecha                  = fecha;
        this.numero_jugadores       = numero_jugadores;
        this.ambientacion           = ambientacion;
        this.en_curso               = en_curso;
        this.anfitrion_id           = anfitrion_id;
        this.nombre_anfitrion       = nombre_anfitrion;
        this.apellidos_anfitrion    = apellidos_anfitrion;
    }

    /**
	 * Método que realiza la consulta de datos a MySQL
	 */
	public void conseguir_partidas() {
		
		try {
			ArrayList<Partida> partidas = new ArrayList<>();

            // Realizamos una consulta para capturar todas las partidas con su anfitrión
			String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion " +
			"FROM partida p " +
			"LEFT JOIN miembro m " +
			"ON p.anfitrion_id = m.cod";
			ResultSet rs = this.mysql.Model_query( sql );

            // Creamos un objeto partida por cada registro y lo añadimos al Data
            while( rs.next() ) {
                Partida temp_partida = new Partida(
                        rs.getInt( 1 )
                    ,   rs.getInt( 2 )
                    ,   rs.getString( 3 )
                    ,   rs.getInt( 4 )
                    ,   rs.getInt( 5 )
                    ,   rs.getString( 6 )
                    ,   rs.getInt( 7 )
                    ,   rs.getString( 8 )
                    ,   rs.getInt( 9 )
                    ,   rs.getInt( 10 )
                    ,   rs.getString( 11 )
                    ,   rs.getString( 12 )
                );

                // Añadimos al Data
                partidas.add( temp_partida );

            }

			super.setPartidas( partidas );

		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
    
    /**
	 * Método que realiza la consulta de datos a MySQL
	 */
	public void conseguir_partidas_filtradas() {

		try {

            // Realizamos una consulta para capturar todas las partidas con su anfitrión
			String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion " +
			"FROM partida p " +
			"LEFT JOIN miembro m " +
			"ON p.anfitrion_id = m.cod";
			ResultSet rs = this.mysql.Model_query( sql );

            // Creamos un objeto partida por cada registro y lo añadimos al Data
            while( rs.next() ) {
                Partida temp_partida = new Partida(
                        rs.getInt( 1 )
                    ,   rs.getInt( 2 )
                    ,   rs.getString( 3 )
                    ,   rs.getInt( 4 )
                    ,   rs.getInt( 5 )
                    ,   rs.getString( 6 )
                    ,   rs.getInt( 7 )
                    ,   rs.getString( 8 )
                    ,   rs.getInt( 9 )
                    ,   rs.getInt( 10 )
                    ,   rs.getString( 11 )
                    ,   rs.getString( 12 )
                );

                // Añadimos al Data
                super.getPartidas().add( temp_partida );

            }
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}

	public int getNum_sesion() {
		return num_sesion;
	}

	public void setNum_sesion(int num_sesion) {
		this.num_sesion = num_sesion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public int getNumero_jugadores() {
		return numero_jugadores;
	}

	public void setNumero_jugadores(int numero_jugadores) {
		this.numero_jugadores = numero_jugadores;
	}

	public int getEn_curso() {
		return en_curso;
	}

	public void setEn_curso(int en_curso) {
		this.en_curso = en_curso;
	}

	public int getAnfitrion_id() {
		return anfitrion_id;
	}

	public void setAnfitrion_id(int anfitrion_id) {
		this.anfitrion_id = anfitrion_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getAmbientacion() {
		return ambientacion;
	}

	public void setAmbientacion(String ambientacion) {
		this.ambientacion = ambientacion;
	}

	public String getNombre_anfitrion() {
		return nombre_anfitrion;
	}

	public void setNombre_anfitrion(String nombre_anfitrion) {
		this.nombre_anfitrion = nombre_anfitrion;
	}

	public String getApellidos_anfitrion() {
		return apellidos_anfitrion;
	}

	public void setApellidos_anfitrion(String apellidos_anfitrion) {
		this.apellidos_anfitrion = apellidos_anfitrion;
	}
	
}