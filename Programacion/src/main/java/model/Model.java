package model;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import views.*;

public class Model {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/kode";
	private String usuario = "root";
	private String pword = "password";
	private Connection conn;
	
	public Connection get_connection() {
		Connection conn = null;
		
		try {
			// Cargamos el driver de MySQL
			Class.forName( driver );
			
			// Conectamos con MySQL
			conn = DriverManager.getConnection(
					url
				, 	usuario
				, 	pword
			);

			if( conn != null )
				this.conn = conn;
			
        } catch ( ClassNotFoundException cnfe ) {
            System.out.println( "MySQL JDBC Driver no encontrado" );
            cnfe.printStackTrace();
        } catch ( SQLException sqle ) {
            System.out.println( "Error al conectar a MySQL" );
            sqle.printStackTrace();
        }

		return conn;
	}
	
	public void close_connection( Connection c ) {
		try {
			c.close();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	public ResultSet Model_query( String sql ) throws SQLException {
		
		// Inicializamos el RS y el STMT a devolver
		ResultSet rs = null;
		Statement stmt = null;

		try {

			// Inicializamos el Statement y ejecutamos la consulta
			stmt = this.conn.createStatement();
			rs = stmt.executeQuery( sql );
			
			// Devolvemos el array de datos
			return rs;

		} catch( SQLException sqle ) { // Manejo de errores

			// Imprimimos el error y lo lanzamos
			System.out.println( "SQL Error: " + sqle.getMessage() );
			throw sqle;

		}
	}
	
	public void Model_execute_update( String sql, Object[] params ) throws SQLException {
		
		// Inicializamos el índice de remplazo de datos
		int index = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			// Instanciamos un PreparedStatement
			pstmt = this.conn.prepareStatement( sql );
		
			for( Object param : params ) {
				index++;
		
				// Dependiendo del tipo de dato que sea la tupla de objetos, utilizamos un método y un casteo u otro
				switch( param.getClass().getSimpleName() ) {
					
					case "Integer":
						pstmt.setInt( index, ( Integer ) param );
						break;
					case "Boolean":
						pstmt.setBoolean( index, ( Boolean ) param );
						break;
					case "String":
						pstmt.setString( index, ( String ) param );
						break;
					case "Float":
						pstmt.setFloat( index, ( Float ) param );
						break;
					default:
						break;
				}
			}
			
			// Si existe un PreparedStatement, lo ejecutamos
			if( pstmt != null )
				pstmt.executeUpdate();
			
		} catch ( SQLException sqle ) {
		    sqle.printStackTrace();
            throw sqle;
		} finally {
			pstmt.close();
		}
		
	}
	
	// -----------------------------------------------------------------------------------------------------
	// Métodos usados en Listeners
	// -----------------------------------------------------------------------------------------------------
	
	/**
	 * Método que realiza la consulta de datos a MySQL
	 * @return rs
	 */
	public ArrayList<Partida> get_partidas() {

		ArrayList<Partida> lista_partidas = new ArrayList<Partida>();

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.get_connection();

		try {
			String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion, ps.cod as personaje_id " +
			"FROM partida p " +
			"LEFT JOIN miembro m " +
			"ON p.anfitrion_id = m.cod " +
			"left join personaje ps " +
			"on m.cod = ps.cod_miembro ";

			ResultSet rs = mysql.Model_query( sql );
			while( rs.next() ) {
	            Partida temp_partida = new Partida(
	                    rs.getInt("partida_id"),
	                    rs.getInt("num_sesion"),
	                    rs.getString("nombre"),
	                    rs.getInt("duracion"),
	                    rs.getInt("dificultad"),
	                    rs.getString("fecha"),
	                    rs.getInt("numero_jugadores"),
	                    rs.getString("ambientacion"),
	                    rs.getString("en_curso"),
	                    rs.getInt("anfitrion_id"),
	                    rs.getString("nombre_anfitrion"),
	                    rs.getString("apellidos_anfitrion")
	            );
	            
	            lista_partidas.add( temp_partida );
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return lista_partidas;
	}

	/**
	 * Método que realiza la consulta de datos a MySQL
	 * @return Partida
	 */
	public Partida get_partida(int partida_id) {
	    Partida partida = null;

	    // Creamos una conexión con MySQL
	    Model mysql = new Model();
	    mysql.get_connection();

	    try {
	        String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion, ps.cod as personaje_id " +
	                "FROM partida p " +
	                "LEFT JOIN miembro m " +
	                "ON p.anfitrion_id = m.cod " +
	                "LEFT JOIN personaje ps " +
	                "ON m.cod = ps.cod_miembro " +
	                "WHERE p.partida_id = " + partida_id;

	        ResultSet rs = mysql.Model_query(sql);

	        if (rs.next()) {
	            partida = new Partida (
	                    rs.getInt("partida_id"),
	                    rs.getInt("num_sesion"),
	                    rs.getString("nombre"),
	                    rs.getInt("duracion"),
	                    rs.getInt("dificultad"),
	                    rs.getString("fecha"),
	                    rs.getInt("numero_jugadores"),
	                    rs.getString("ambientacion"),
	                    rs.getString("en_curso"),
	                    rs.getInt("anfitrion_id"),
	                    rs.getString("nombre_anfitrion"),
	                    rs.getString("apellidos_anfitrion")
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return partida;
	}

	
	public Object[][] get_table_partidas() {
	    // Designamos el nombre de las columnas de la tabla
	    String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Anfitrion", "Nº jugadores", "Estado" };

	    // Capturamos los datos de MySQL mediante una consulta
	    ArrayList<Partida> partidas = get_partidas();
	    ArrayList<Object[]> row_data_list = new ArrayList<>();

	    // Iteramos sobre la lista de partidas
	    for (Partida partida : partidas) {
	    	
	        // Inicializamos un Objeto temporal donde almacenamos los datos de la fila
	        Object[] row_data = new Object[columns.length];

	        // Insertamos los datos
	        row_data[0] = partida.getPart_id();
	        row_data[1] = partida.getNombre();
	        row_data[2] = partida.getAmbientacion();
	        row_data[3] = partida.getDuracion();
	        row_data[4] = partida.getFecha();
	        row_data[6] = partida.getNumero_jugadores();

	        // Formateo de campos
	        String anfitrion = partida.getNombre_anfitrion() + " " + partida.getApellidos_anfitrion();
	        row_data[5] = anfitrion;

	        // Determinamos el estado
	        row_data[7] = partida.getEn_curso();

	        // Añadimos los datos al arrayList final
	        row_data_list.add( row_data );
	    }

	    // Pasamos los datos al Objeto final que insertaremos en la tabla
	    Object[][] data = new Object[row_data_list.size()][columns.length];
	    row_data_list.toArray(data);

	    return data;
	}
	
	public Object[][] get_table_personajes(Usuario user) {
	    // Designamos el nombre de las columnas de la tabla
	    String[] columns_personajes = { "ID", "Nombre", "Personaje", "Raza", "Clase", "Expe", "Fuerza", "Destreza", "Constitucion", "Inteligencia", "Sabiduria", "Carisma" };

	    // Capturamos los datos de MySQL mediante una consulta
	    ArrayList<Personaje> personajes = get_personajes(user);
	    ArrayList<Object[]> row_data_list_personajes = new ArrayList<>();

	    // Iteramos sobre la lista de personajes
	    for (Personaje personaje : personajes) {
	        // Inicializamos un Objeto temporal donde almacenamos los datos de la fila
	        Object[] row_data = new Object[columns_personajes.length];

	        // Insertamos los datos
	        row_data[0] = personaje.getCod();
	        row_data[1] = personaje.getNombre();
	        row_data[2] = personaje.getPersonaje();
	        row_data[3] = personaje.getRaza();
	        row_data[4] = personaje.getClase();
	        row_data[5] = personaje.getExpe();
	        row_data[6] = personaje.getFuerza();
	        row_data[7] = personaje.getDestreza();
	        row_data[8] = personaje.getConstitucion();
	        row_data[9] = personaje.getInteligencia();
	        row_data[10] = personaje.getSabiduria();
	        row_data[11] = personaje.getCarisma();

	        // Añadimos los datos al arrayList final
	        row_data_list_personajes.add(row_data);
	    }

	    // Pasamos los datos al Objeto final que insertaremos en la tabla
	    Object[][] data_personajes = new Object[row_data_list_personajes.size()][columns_personajes.length];
	    row_data_list_personajes.toArray(data_personajes);

	    return data_personajes;
	}

	
	public Personaje get_personaje(int id) {
	    Personaje personaje = null;

	    // Creamos una conexión con MySQL
	    Model mysql = new Model();
	    mysql.get_connection();

	    try {
	        // Realizamos una consulta para capturar el personaje
	        String sql = "SELECT * FROM personaje WHERE cod = " + id;
	        ResultSet rs = mysql.Model_query(sql);

	        if (rs.next()) {
	            personaje = new Personaje(
	                rs.getInt("cod"),
	                rs.getString("nombre"),
	                rs.getString("personaje"),
	                rs.getString("raza"),
	                rs.getString("clase"),
	                rs.getInt("expe"),
	                rs.getInt("cod_miembro"),
	                rs.getInt("fuerza"),
	                rs.getInt("destreza"),
	                rs.getInt("constitucion"),
	                rs.getInt("inteligencia"),
	                rs.getInt("sabiduria"),
	                rs.getInt("carisma"),
	                new Usuario()
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return personaje;
	}

	public ArrayList<Personaje> get_personajes(Usuario user) {
	    ArrayList<Personaje> personajes = new ArrayList<>();

	    // Creamos una conexión con MySQL
	    Model mysql = new Model();
	    mysql.get_connection();

	    try {
	        // Realizamos una consulta para capturar todos los personajes
	        String sql = "SELECT p.*, j.* FROM personaje p LEFT JOIN juega j ON j.id_personaje = p.cod WHERE cod_miembro = " + user.getUser_id();
	        ResultSet rs = mysql.Model_query(sql);

	        while (rs.next()) {
	            Personaje personaje = new Personaje(
	                rs.getInt("cod"),
	                rs.getString("nombre"),
	                rs.getString("personaje"),
	                rs.getString("raza"),
	                rs.getString("clase"),
	                rs.getInt("expe"),
	                rs.getInt("cod_miembro"),
	                rs.getInt("fuerza"),
	                rs.getInt("destreza"),
	                rs.getInt("constitucion"),
	                rs.getInt("inteligencia"),
	                rs.getInt("sabiduria"),
	                rs.getInt("carisma"),
	                user
	            );
	            personajes.add(personaje);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return personajes;
	}

	public ArrayList<Personaje> get_personajes_all() {
	    ArrayList<Personaje> personajes = new ArrayList<>();

	    // Creamos una conexión con MySQL
	    Model mysql = new Model();
	    mysql.get_connection();

	    try {
	        // Realizamos una consulta para capturar todos los personajes
	        String sql = "SELECT * FROM personaje";
	        ResultSet rs = mysql.Model_query(sql);

	        while (rs.next()) {
	            Personaje personaje = new Personaje(
	                rs.getInt("cod"),
	                rs.getString("nombre"),
	                rs.getString("personaje"),
	                rs.getString("raza"),
	                rs.getString("clase"),
	                rs.getInt("expe"),
	                rs.getInt("cod_miembro"),
	                rs.getInt("fuerza"),
	                rs.getInt("destreza"),
	                rs.getInt("constitucion"),
	                rs.getInt("inteligencia"),
	                rs.getInt("sabiduria"),
	                rs.getInt("carisma"),
	                new Usuario()
	            );
	            personajes.add(personaje);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return personajes;
	}

	public ArrayList<Personaje> get_personajes_partida(int partida_id) {
	    ArrayList<Personaje> personajes = new ArrayList<>();

	    // Creamos una conexión con MySQL
	    Model mysql = new Model();
	    mysql.get_connection();

	    try {
	        // Realizamos una consulta para capturar todos los personajes de una partida
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
	            + "j.id_partida = " + partida_id;

	        ResultSet rs = mysql.Model_query(sql);

	        while (rs.next()) {
	            Personaje personaje = new Personaje(
	                rs.getInt("cod"),
	                rs.getString("nombre"),
	                rs.getString("personaje"),
	                rs.getString("raza"),
	                rs.getString("clase"),
	                rs.getInt("expe"),
	                rs.getInt("cod_miembro"),
	                rs.getInt("fuerza"),
	                rs.getInt("destreza"),
	                rs.getInt("constitucion"),
	                rs.getInt("inteligencia"),
	                rs.getInt("sabiduria"),
	                rs.getInt("carisma"),
	                new Usuario()
	            );
	            personajes.add(personaje);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return personajes;
	}

	
	/**
	 * Metodo que hace el insert a la base de datos de partida
	 */
	public boolean create_match( CrearPartida cp, Model mysql, Menu menu ) {

		// Consulta y parámetros a insertar
		String sql = "INSERT INTO partida (nombre, fecha, ambientacion, en_curso, duracion, dificultad, numero_jugadores, anfitrion_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Object[] params = {
				cp.getTxtNombrePartida().getText()
			,	cp.getTxtFecha().getText()
			,	cp.getTxtAmbientacion().getText()
			,	cp.getTxtEstado().getText()
			,	Integer.parseInt( cp.getTxtDuracion().getText() )
			,	Integer.parseInt( cp.getTxtDificultad().getText() )
			,	Integer.parseInt( cp.getTxtJugadores().getText() )
			,	Integer.parseInt( cp.getLblIdAnfitrion().getText() )
		};
		
		try {
			mysql.Model_execute_update( sql, params );
		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		} catch ( Exception e ) {
			menu.mostrarMensajeRellenaCampos();
			return false;
		}

		return true;

	}
	

	/**
	 * Metodo que actualiza los elementos en la base de datos
	 */
	public boolean update_match( EditarPartida ep, Model mysql ) {

	    String sql = "UPDATE partida SET nombre = ?, duracion = ?, dificultad = ?, fecha = ?, numero_jugadores = ?, ambientacion = ?, en_curso = ? WHERE partida_id = ?";
	    try {
	    	// Recupera los valores de los campos
	    	Object[] params = {
	    	    ep.getTxtNombrePartida().getText(), // Nombre de la partida
	    	    ep.getTxtDuracion().getText(),      // Duración
	    	    ep.getTxtDificultad().getText(),    // Dificultad
	    	    ep.getTxtFecha().getText(),         // Fecha
	    	    ep.getTxtJugadores().getText(),     // Jugadores
	    	    ep.getTxtAmbientacion().getText(),
	    	    ep.getTxtEstado().getText(),        // Estado
	    	    Integer.parseInt(ep.getLblIdPartida().getText()) // ID
	    	};

	        // Consulta para actualizar la tabla usando el método Model_execute_update
	    	mysql.Model_execute_update( sql, params );

	    } catch (SQLException sqle) {
	        sqle.printStackTrace();
	        return false;
	    }
	    
	    return true;
	}
	

	/**
	 * Metodo que actualiza los elementos en la base de datos
	 */
	public boolean borrar_partida( int id, Model mysql ) {
		
    	// Recupera los valores de los campos
    	Object[] params = {
    	    id // ID
    	};
		
	    try {
			String sql_juega = "delete from juega where id_partida = ?";
	        // Consulta para actualizar la tabla usando el método Model_execute_update
	    	mysql.Model_execute_update( sql_juega, params );
			
		    String sql = "DELETE FROM partida WHERE partida_id=?";
	        // Consulta para actualizar la tabla usando el método Model_execute_update
	    	mysql.Model_execute_update( sql, params );

	    } catch ( SQLException sqle ) {
	        sqle.printStackTrace();
	        return false;
	    }
	    
	    return true;
	}

	public void editar_partida(int partida_id, EditarPartida ep, Menu menu) {
	    // Modificar datos de la tabla
	    DefaultTableModel model = (DefaultTableModel) ep.getTable().getModel();
	    model.setRowCount(0); // Limpiar la tabla existente

	    Partida partida = get_partida(partida_id);

	    if (partida != null) {
	        ep.getTxtAmbientacion().setText(partida.getAmbientacion());
	        ep.getTxtDuracion().setText(String.valueOf(partida.getDuracion()));
	        ep.getTxtEstado().setText(partida.getEn_curso());
	        ep.getTxtFecha().setText(partida.getFecha());
	        ep.getTxtJugadores().setText(String.valueOf(partida.getNumero_jugadores()));
	        ep.getTxtNombrePartida().setText(partida.getNombre());
	        ep.getTxtDificultad().setText(String.valueOf(partida.getDificultad()));
	        ep.getLblIdPartida().setText(String.valueOf(partida.getPart_id()));
	    }

	    // Datos del personaje seleccionado
	    ArrayList<Personaje> personajes = get_personajes_partida(partida_id);

	    for (Personaje personaje : personajes) {
	        // Definimos los campos de la tabla
	        String jugador = personaje.getPersonaje();
	        String experiencia = String.valueOf(personaje.getExpe());
	        String raza = personaje.getRaza();
	        String clase = personaje.getClase();

	        model.addRow(new Object[]{jugador, experiencia, raza, clase});
	    }

	    // Cargamos el menú
	    menu.cargarPanel(ep);
	}


	/**
	 * Metodo que hace el insert a la base de datos de crearPersonaje
	 */
	public boolean insert_personaje( CrearPersonaje cp, Usuario user, Menu menu ) {
	    // Consulta SQL
	    String sql = "INSERT INTO personaje (nombre, personaje, raza, clase, expe, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma, cod_miembro)"
	            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try {
	        // Recupera los valores de los campos
	        String nombre 		 = cp.getLblSeleccionarPersonaje().getText();
	        String personaje 	 = cp.getLblSeleccionarPersonaje().getText();
	        String raza 		 = cp.getTxtRaza().getText();
	        String clase 		 = cp.getTxtClase().getText();
	        Integer expe 		 = (Integer) cp.getSpinnerExperiencia().getValue();
	        Integer fuerza 		 = (Integer) cp.getSpinnerFuerza().getValue();
	        Integer destreza 	 = (Integer) cp.getSpinnerDestreza().getValue();
	        Integer constitucion = (Integer) cp.getSpinnerConstitucion().getValue();
	        Integer inteligencia = (Integer) cp.getSpinnerInteligencia().getValue();
	        Integer sabiduria 	 = (Integer) cp.getSpinnerSabiduria().getValue();
	        Integer carisma 	 = (Integer) cp.getSpinnerCarisma().getValue();
	        Integer cod_miembro  = user.getUser_id();

	        // Verifica que los campos obligatorios no estén vacíos o nulos
	        if (
	        	nombre 		 == null || nombre.isEmpty() 	||
	            personaje 	 == null || personaje.isEmpty() ||
	            raza 		 == null || raza.isEmpty() 		||
	            clase 		 == null || clase.isEmpty() 	||
	            expe 		 == null ||
	            fuerza 		 == null ||
	            destreza 	 == null ||
	            constitucion == null ||
	            inteligencia == null ||
	            sabiduria 	 == null ||
	            carisma 	 == null ||
	            cod_miembro  == null
	        ) {
	            throw new IllegalArgumentException("Todos los campos obligatorios deben ser completados.");
	        }

	        // Crea el arreglo de parámetros
	        Object[] params = {
	        	    nombre
	        	, 	personaje
	        	, 	raza
	        	, 	clase
	        	, 	expe
	        	, 	fuerza
	        	, 	destreza
	        	, 	constitucion
	        	, 	inteligencia
	        	, 	sabiduria
	        	, 	carisma
	        	, 	cod_miembro
	        };

	        // Llama al método Model_execute_update para ejecutar la consulta
	        Model_execute_update( sql, params );
	        

	    } catch ( SQLException sqle ) {
	        sqle.printStackTrace();
	        return false;
	    } catch ( IllegalArgumentException e ) {
	        menu.mostrarMensajeRellenaCampos();
	        return false;
	    }
	    
        return true;
	}

	/**
	 * Metodo que actualiza los elementos en la base de datos
	 */
	public boolean update_personaje_ep( EditarPersonaje ep, Usuario user ) {

	    String sql = "UPDATE personaje "
	            + "SET clase=?, raza=?, expe=?, fuerza=?, destreza=?, constitucion=?, inteligencia=?, sabiduria=?, carisma=?, cod_miembro=? "
	            + "WHERE cod=?";

	    try {
	        // Recupera los valores de los campos
	        Object[] params = {
	        		ep.getTxtClase().getText()
	            ,	ep.getTxtRaza().getText()
	            , 	(int) ep.getSpinnerExperiencia().getValue() 
				, 	(int) ep.getSpinnerFuerza().getValue()
	            , 	(int) ep.getSpinnerDestreza().getValue()    
				, 	(int) ep.getSpinnerConstitucion().getValue()
	            , 	(int) ep.getSpinnerInteligencia().getValue()
				, 	(int) ep.getSpinnerSabiduria().getValue()
	            , 	(int) ep.getSpinnerCarisma().getValue()     
				, 	(int) user.getUser_id()
	            , 	Integer.parseInt(ep.getLblId().getText())
	        };

	        // Consulta para actualizar la tabla usando el método Model_execute_update
	        Model_execute_update( sql, params );

	    } catch (SQLException sqle) {
	        sqle.printStackTrace();
	        return false;
	    }
	    
	    return true;
	}
	
	public void editar_personaje(int id, Usuario user, EditarPersonaje ep, boolean esMaster, Menu menu) {
	    // Capturamos los datos de la DB
	    Personaje personaje = get_personaje(id);

	    if (personaje != null) {
	        ep.getLblSeleccionarPersonaje().setText(personaje.getNombre());
	        ep.getTxtRaza().setText(personaje.getRaza());
	        ep.getTxtClase().setText(personaje.getClase());
	        ep.getLblId().setText(String.valueOf(id));
	        ep.getSpinnerExperiencia().setValue(personaje.getExpe());
	        ep.getSpinnerFuerza().setValue(personaje.getFuerza());
	        ep.getSpinnerDestreza().setValue(personaje.getDestreza());
	        ep.getSpinnerConstitucion().setValue(personaje.getConstitucion());
	        ep.getSpinnerInteligencia().setValue(personaje.getInteligencia());
	        ep.getSpinnerSabiduria().setValue(personaje.getSabiduria());
	        ep.getSpinnerCarisma().setValue(personaje.getCarisma());
	    }

	    if (esMaster) {
	        ep.getSpinnerExperiencia().setEnabled(true);
	        ep.getSpinnerCarisma().setEnabled(false);
	        ep.getSpinnerConstitucion().setEnabled(false);
	        ep.getSpinnerDestreza().setEnabled(false);
	        ep.getSpinnerFuerza().setEnabled(false);
	        ep.getSpinnerInteligencia().setEnabled(false);
	        ep.getSpinnerSabiduria().setEnabled(false);
	        ep.getTxtClase().setEditable(false);
	        ep.getTxtRaza().setEditable(false);
	    } else {
	        ep.getSpinnerExperiencia().setEnabled(false);
	        ep.getSpinnerCarisma().setEnabled(true);
	        ep.getSpinnerConstitucion().setEnabled(true);
	        ep.getSpinnerDestreza().setEnabled(true);
	        ep.getSpinnerFuerza().setEnabled(true);
	        ep.getSpinnerInteligencia().setEnabled(true);
	        ep.getSpinnerSabiduria().setEnabled(true);
	    }

	    menu.cargarPanel(ep);
	}

	
	/**
	 * Metodo que actualiza los elementos en la base de datos
	 */
	public boolean update_personaje_vp( CrearPersonaje cp, Usuario user, Personaje personaje ) {

	    String sql = "UPDATE personaje SET nombre = ?, personaje = ?, raza = ?, clase = ?, expe = ? WHERE cod_miembro = ? AND id_personaje = ?";

	    try {
	        // Recupera los valores de los campos
	        Object[] params = {
	        		cp.getLblSeleccionarPersonaje().getText()
	            ,	cp.getLblSeleccionarPersonaje().getText()
	            , 	cp.getTxtRaza().getText()
				, 	cp.getTxtClase().getText()
	            , 	0
				, 	user.getUser_id()
	            , 	personaje.getCod()
	        };

	        // Consulta para actualizar la tabla usando el método Model_execute_update
	        Model_execute_update( sql, params );

	    } catch (SQLException sqle) {
	        sqle.printStackTrace();
	        return false;
	    }
	    
	    return true;
	}
	

	public boolean borrar_personaje( Usuario user, VerPersonajes vp ) {
    	
	    try {
			Object[] params = { Integer.parseInt(vp.getIdLbl().getText()) };
			String sql_juega = "delete from juega where id_personaje = ?";
			Model_execute_update( sql_juega, params );
	    	
			String sql = "DELETE FROM personaje WHERE cod_miembro = ? AND cod = ?";
	    	// Recupera los valores de los campos
	    	Object[] params_delete = {
	    			user.getUser_id()
	    		,	Integer.parseInt(vp.getIdLbl().getText())
	    	};

	        // Consulta para actualizar la tabla usando el método Model_execute_update
	        Model_execute_update( sql, params_delete );

	    } catch ( SQLException sqle ) {
	        sqle.printStackTrace();
	        return false;
	    }
	    
	    return true;
	}
	
	public void insertar_partida(int partida_id, int jugador_id) throws SQLException {
	    Model mysql = new Model();
	    mysql.get_connection();
	    
	    String sql_select = "select * from juega where id_partida = " + partida_id + " and id_personaje = " + jugador_id;
	    ResultSet rs = mysql.Model_query( sql_select );
	    
	    if( !rs.next() ) {
			String sql = "insert into juega( id_partida, id_personaje ) values( ?, ? )";
			
		    try {
		    	// Recupera los valores de los campos
		    	Object[] params = {
		    			partida_id
		    		,	jugador_id
		    	};

		        // Consulta para actualizar la tabla usando el método Model_execute_update
		    	mysql.Model_execute_update( sql, params );

		    } catch (SQLException sqle) {
		        sqle.printStackTrace();
		    }
		}
	}
    
    public void jugar_partida(int partida_id, int jugador_id, PartidaIniciada pIniciada, Usuario user, Menu menu) {
        // Datos de la partida seleccionada
        Partida partida = get_partida(partida_id);

        if (partida != null) {
            pIniciada.getLblNivelPartida().setText(partida.getNombre());

            pIniciada.getLblAnfitrion().setText(
                partida.getNombre_anfitrion() + " " + partida.getApellidos_anfitrion()
            );

            pIniciada.getLblJugadores().setText(String.valueOf(partida.getNumero_jugadores()));
            pIniciada.getLblDuración().setText(String.valueOf(partida.getDuracion()));
            pIniciada.getLblFecha().setText(partida.getFecha());
            pIniciada.getLblEstado().setText(partida.getEn_curso());
        }

        // Datos del personaje seleccionado
        Personaje personaje = get_personaje(jugador_id);

        if (personaje != null) {
            pIniciada.getPbFuerza().setValue(personaje.getFuerza());
            pIniciada.getPbDestreza().setValue(personaje.getDestreza());
            pIniciada.getPbConstitucion().setValue(personaje.getConstitucion());
            pIniciada.getPbInteligencia().setValue(personaje.getInteligencia());
            pIniciada.getPbSabiduria().setValue(personaje.getSabiduria());
            pIniciada.getPbCarisma().setValue(personaje.getCarisma());
        }

        // Cargamos el menú
        menu.cargarPanel(pIniciada);
    }

	
}