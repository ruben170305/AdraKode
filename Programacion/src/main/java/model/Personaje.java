package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Personaje {

    // Definimos las características del Personaje
    private String nombre, personaje, clase, raza;
    private int cod, cod_miembro, expe, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
    private Usuario user;
    
    // Constructores
    public Personaje( Usuario user ) {
        this.user = user;
    }

    public Personaje(
            int cod
        ,   String nombre
        ,   String personaje
        ,   String raza
        ,   String clase
        ,   int expe
        ,   int cod_miembro
        ,   int fuerza
        ,   int destreza
        ,   int constitución
        ,   int inteligencia
        ,   int sabiduria
        ,   int carisma
        ,   Usuario user
    ) {
        this.cod 			= cod;
        this.nombre  		= nombre;
        this.personaje		= personaje;
        this.raza   		= raza;
        this.clase   		= clase;
        this.expe     		= expe;
        this.cod_miembro 	= cod_miembro;
        this.fuerza         = fuerza;
        this.destreza       = destreza;
        this.constitucion   = constitución;
        this.inteligencia   = inteligencia;
        this.sabiduria      = sabiduria;
        this.carisma        = carisma;
        this.user           = user;
    }

	public ResultSet get_personajes_by_cod_miembro() {

		// Inicializamos el valor a devolver
		ResultSet rs = null;
		
		// Inicializamos la sesión en MySQL
		Model mysql = new Model();
		mysql.get_connection();

		// Realizamos una consulta para capturar todos los personajes
		String sql = "select * from personaje where cod_miembro=" + user.getUser_id();
		
		try {
			rs = mysql.Model_query( sql );
		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;

	}


	public ResultSet get_personaje( int id ) {

		// Inicializamos el valor a devolver
		ResultSet rs = null;

		// Iniciamos sesión en MySQL
		Model mysql = new Model();
		mysql.get_connection();

        try {

			// Realizamos una consulta para capturar todos los personajes
			String sql = "select * from personaje WHERE cod_miembro=" + user.getUser_id() + " AND cod=" + id;
            rs = mysql.Model_query( sql );

		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;

	}

	public ResultSet get_personajes() {

		ResultSet rs = null;

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.get_connection();

		try {
            // Realizamos una consulta para capturar todos los personajes
            String sql = "select p.*, j.* from personaje p left join juega j on j.id_personaje = p.cod where cod_miembro=" + user.getUser_id();
            rs = mysql.Model_query( sql );

		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;

	}
	
	public ResultSet get_personajes_all() {

		// Inicializamos el valor a devolver
		ResultSet rs = null;
		
		// Inicializamos la sesión en MySQL
		Model mysql = new Model();
		mysql.get_connection();

		// Realizamos una consulta para capturar todos los personajes
		String sql = "select * from personaje";
		
		try {
			rs = mysql.Model_query( sql );
		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;

	}

    public ResultSet get_personajes_partida( int partida_id ) {

		ResultSet rs = null;

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.get_connection();

		try {
            // Realizamos una consulta para capturar todos los personajes
            String sql = "SELECT "
            + "j.*, "
            + "p.*, "
            + "ps.*, "
            + "m.nombre AS nombre_anfitrion, "
            + "m.apellidos AS apellidos_anfitrion "
            + "FROM "
            + "juega j "
            + "LEFT JOIN partida p ON "
            + "p.partida_id = j.id_partida "
            + "LEFT JOIN personaje ps ON "
            + "j.id_personaje = ps.cod "
            + "LEFT JOIN miembro m ON "
            + "p.anfitrion_id = m.cod "
            + "WHERE "
            + "j.id_partida =" + partida_id;

            rs = mysql.Model_query( sql );
            System.out.println();

		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;

	}


    // Getters
    public int getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getRaza() {
        return raza;
    }

    public String getClase() {
        return clase;
    }

    public int getExpe() {
        return expe;
    }

    public int getCod_miembro() {
        return cod_miembro;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public int getCarisma() {
        return carisma;
    }

    // Setters
    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void setExpe(int expe) {
        this.expe = expe;
    }

    public void setCod_miembro(int cod_miembro) {
        this.cod_miembro = cod_miembro;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

}
