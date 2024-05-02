package model;

import java.sql.*;

public class Model {
	
	private String database_name, user, password, url;
	private Connection conn;

	// Constructor para instanciar MySQL
	public Model( String database_name, String url, String user, String password ) {
		this.database_name = database_name;
		this.url 		   = url;
		this.user 		   = user;
		this.password 	   = password;
	}
	
	public void Model_mysql_connect() {
		try {
			// Cargamos el driver de MySQL
			Class.forName( "con.mysql.cj.jdbc.Driver" );
			
			// Conectamos con MySQL
			Connection conn = DriverManager.getConnection(
					this.url
				, 	this.user
				, 	this.password
			);
			
			if( conn != null )
				this.conn = conn;
			
        } catch ( ClassNotFoundException cnfe ) {
            System.out.println( "MySQL JDBC Driver no encontrado" );
            cnfe.printStackTrace();
        } catch ( SQLException sqle ) {
            System.out.println( "Error al conectar a la base de datos" );
            sqle.printStackTrace();
        }
	}

	public ResultSet Model_query( String sql ) throws SQLException {
		
		// Inicializamos el RS y el STMT a devolver
		ResultSet rs   = null;
		Statement stmt = null;

		try {

			// Inicializamos el Statement y ejecutamos la consulta
			stmt = this.conn.createStatement();
			rs   = stmt.executeQuery( sql );

			// Devolvemos el array de datos
			return rs;

		} catch( SQLException sqle ) { // Manejo de errores

			// Imprimimos el error y lo lanzamos
			System.out.println( "SQL Error: " + sqle.getMessage() );
			throw sqle;

		} finally {
			try {
				// Si existe un Statement por cerrar, lo cerramos
				if ( stmt != null )
					stmt.close();
			} catch( SQLException sqle ) {
				System.out.println( "Error al cerrar el Statement: " + sqle.getMessage() );
			}
		}
	}
}