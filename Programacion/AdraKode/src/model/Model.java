package model;

import java.sql.*;

public class Model {
	
	private String database_name, user, password, url;

	// Constructor para instanciar MySQL
	public Model( String database_name, String user, String password, String url ) {
		this.database_name = database_name;
		this.user = user;
		this.password = password;
		this.url = url;
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
				System.out.println( "Connected" );
			
        } catch (ClassNotFoundException cnfe) {
            System.out.println( "MySQL JDBC Driver no encontrado" );
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            System.out.println( "Error al conectar a la base de datos" );
            sqle.printStackTrace();
        }
	}
	
}