package model;

import java.sql.*;

public class Model {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/kode";
	private String usuario = "root";
	private String pword = "password";
	private Connection conn;
	
	public Connection getConexion() {
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
	
	public void cerrarConexion(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
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