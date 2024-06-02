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
	public ResultSet get_partidas() {

		ResultSet rs = null;

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

			rs = mysql.Model_query( sql );

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return rs;
	}

		/**
	 * Método que realiza la consulta de datos a MySQL
	 * @return rs
	 */
	public ResultSet get_partida( int partida_id ) {

		ResultSet rs = null;

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.get_connection();

		try {
			String sql = "SELECT p.*, m.nombre as nombre_anfitrion, m.apellidos as apellidos_anfitrion " +
			"FROM partida p " +
			"LEFT JOIN miembro m " +
			"ON p.anfitrion_id = m.cod " +
			"where p.partida_id = " + partida_id;

			rs = mysql.Model_query( sql );

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return rs;
	}
	
	public Object[][] get_table_partidas() {
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns = { "ID", "Nombre", "Ambientación", "Duración", "Fecha", "Anfitrion", "Nº jugadores", "Estado", "ID jugador" };

		// Capturamos los datos de MySQL mediante una consulta
		ResultSet rows = get_partidas();
		ArrayList<Object[]> row_data_list = new ArrayList<>();

		// Capturamos el número de filas del resultado de la consulta
		try {
			while ( rows.next() ) {

				// Inicializamos un Objeto temporal donde almacenamos los datos de la fila
				Object[] row_data = new Object[ columns.length ];
        
				// Insertamos los datos
                row_data[0] = rows.getString( "partida_id" );
                row_data[1] = rows.getString( "nombre" );
                row_data[2] = rows.getString( "ambientacion" );
                row_data[3] = rows.getString( "duracion" );
                row_data[4] = rows.getString( "fecha" );
				row_data[6] = rows.getInt( "numero_jugadores" );

				// Formateo de campos
				String anfitrion = rows.getString( "nombre_anfitrion" ) + " " + rows.getString( "apellidos_anfitrion" );
				row_data[5] = anfitrion;

				// Determinamos el estado
                row_data[7] =  rows.getString( "en_curso" );
                
                row_data[8] = rows.getInt( "personaje_id" );
                
				// Añadimos los datos al arrayList final
				row_data_list.add( row_data );
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		// Pasamos los datos al Objeto final que insertaremos en la tabla
        Object[][] data = new Object[ row_data_list.size() ][ columns.length ];
		row_data_list.toArray( data );
		
		return data;
	}
	
	public Object[][] get_table_personajes( Usuario user ) {
		
		// Designamos el nombre de las columnas de la tabla
		String[] columns_personajes = { "ID", "Nombre", "Personaje", "Raza", "Clase", "Expe", "Fuerza", "Destreza", "Constitucion", "Inteligencia", "Sabiduria", "Carisma" };

		// Capturamos los datos de MySQL mediante una consulta
		ResultSet rows_personajes = get_personajes( user );
		ArrayList<Object[]> row_data_list_personajes = new ArrayList<>();

		// Capturamos el número de filas del resultado de la consulta
		try {
			while ( rows_personajes.next() ) {

				// Inicializamos un Objeto temporal donde almacenamos los datos de la fila
				Object[] row_data = new Object[ columns_personajes.length ];

				// Insertamos los datos
                row_data[0] = rows_personajes.getInt( "cod" );
                row_data[1] = rows_personajes.getString( "nombre" );
                row_data[2] = rows_personajes.getString( "personaje" );
                row_data[3] = rows_personajes.getString( "raza" );
                row_data[4] = rows_personajes.getString( "clase" );
				row_data[5] = rows_personajes.getInt( "expe" );
                row_data[6] = rows_personajes.getString( "fuerza" );
                row_data[7] = rows_personajes.getString( "destreza" );
                row_data[8] = rows_personajes.getString( "constitucion" );
				row_data[9] = rows_personajes.getInt( "inteligencia" );
                row_data[10] = rows_personajes.getString( "sabiduria" );
				row_data[11] = rows_personajes.getInt( "carisma" );

				// Añadimos los datos al arrayList final
				row_data_list_personajes.add( row_data );
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		// Pasamos los datos al Objeto final que insertaremos en la tabla
		Object[][] data_personajes = new Object[ row_data_list_personajes.size() ][ columns_personajes.length ];
		row_data_list_personajes.toArray( data_personajes );
		
		return data_personajes;
	}
	
	public ResultSet get_personaje( int id ) {

		// Inicializamos el valor a devolver
		ResultSet rs = null;

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.get_connection();

        try {

			// Realizamos una consulta para capturar todos los personajes
			String sql = "select * from personaje where cod=" + id;
            rs = mysql.Model_query( sql );

		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;

	}

	public ResultSet get_personajes( Usuario user ) {

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

		// Creamos una conexión con MySQL
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

		} catch ( SQLException sqle ) {
			sqle.printStackTrace();
		}

		return rs;

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
		
		System.out.println(id);

	    String sql = "DELETE FROM partida WHERE partida_id=?";
	    try {
	    	// Recupera los valores de los campos
	    	Object[] params = {
	    	    id // ID
	    	};

	        // Consulta para actualizar la tabla usando el método Model_execute_update
	    	mysql.Model_execute_update( sql, params );

	    } catch ( SQLException sqle ) {
	        sqle.printStackTrace();
	        return false;
	    }
	    
	    return true;
	}

	public void editar_partida( int partida_id, EditarPartida ep, Menu menu ) {

		// Modificar datos de la tabla
		DefaultTableModel model = ( DefaultTableModel ) ep.getTable().getModel();
		model.setRowCount( 0 ); // Limpiar la tabla existente

		ResultSet rs = get_partida( partida_id );

		try {
			while( rs.next() ) {
				ep.getTxtAmbientacion().setText( rs.getString( "ambientacion" ) );
				ep.getTxtDuracion().setText( String.valueOf( rs.getInt( "duracion" ) ) );
				ep.getTxtEstado().setText( rs.getString( "en_curso" ) );
				ep.getTxtFecha().setText( rs.getString( "fecha" ) );
				ep.getTxtJugadores().setText( String.valueOf( rs.getInt( "numero_jugadores" ) ) );
				ep.getTxtNombrePartida().setText( rs.getString( "nombre" ) );
				ep.getTxtDificultad().setText( String.valueOf( rs.getInt( "dificultad" ) ) );
				ep.getLblIdPartida().setText( String.valueOf( rs.getInt( "partida_id" ) ) );
			}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Datos del personaje seleccionado
		ResultSet rs_personaje = get_personajes_partida( partida_id );

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

		// Cargamos el menú
		menu.cargarPanel( ep );
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
		ResultSet rs = get_personaje(id);
		try {
			while (rs.next()) {
				
				System.out.println(rs.getString("nombre"));
				ep.getLblSeleccionarPersonaje().setText(rs.getString("nombre"));
				ep.getTxtRaza().setText(rs.getString("raza"));
				ep.getTxtClase().setText(rs.getString("clase"));
				ep.getLblId().setText(id + "");
				ep.getSpinnerExperiencia().setValue(rs.getInt("expe"));
				ep.getSpinnerFuerza().setValue(rs.getInt("fuerza"));
				ep.getSpinnerDestreza().setValue(rs.getInt("destreza"));
				ep.getSpinnerConstitucion().setValue(rs.getInt("constitucion"));
				ep.getSpinnerInteligencia().setValue(rs.getInt("inteligencia"));
				ep.getSpinnerSabiduria().setValue(rs.getInt("sabiduria"));
				ep.getSpinnerCarisma().setValue(rs.getInt("carisma"));
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		
	    String sql = "DELETE FROM personaje WHERE cod_miembro = ? AND cod = ?";
	    try {
	    	// Recupera los valores de los campos
	    	Object[] params = {
	    			user.getUser_id()
	    		,	Integer.parseInt(vp.getIdLbl().getText())
	    	};

	        // Consulta para actualizar la tabla usando el método Model_execute_update
	        Model_execute_update( sql, params );

	    } catch ( SQLException sqle ) {
	        sqle.printStackTrace();
	        return false;
	    }
	    
	    return true;
	}
	

    public void insertar_partida( int partida_id, int jugador_id ) {
    	
    	Model mysql = new Model();
    	mysql.get_connection();
    	
    	try {
    		
    		ResultSet partida = mysql.get_partida( partida_id );
    		
    		while( !partida.next() ) {
    		
        		// Definimos la consulta
        		String sql = "insert into juega( id_partida, id_personaje ) values( ?, ? )";
        		
        		// Recupera los valores de los campos
    	    	Object[] params = {
    	    			partida_id
    	    		,	jugador_id
    	    	};

    	        // Insertamos la partida
    	        Model_execute_update( sql, params );
                
                break;
    			
    		}
    		
    	} catch( SQLException e ) {
    		e.printStackTrace();
    	}
    	
    }

	public void jugar_partida( int partida_id, int jugador_id, PartidaIniciada pIniciada, Usuario user, Menu menu ) {

		// Datos de la partida seleccionada
		ResultSet rs_partida = get_partida( partida_id );

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

				pIniciada.getLblEstado().setText( rs_partida.getString( "en_curso" ) );
			}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}

		// Datos del personaje seleccionado
		ResultSet rs_personaje = get_personaje( jugador_id );

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