package model;

import java.sql.*;

public class Model {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/kode";
	private String usuario = "root";
<<<<<<< Updated upstream
	private String pword = "ruben";
	
	public Connection getConexion() {
		Connection con = null;
=======
	private String pword = "Ainhoa110904070305*";
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
>>>>>>> Stashed changes
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, pword);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error al conectar con la BBDD");
			e.printStackTrace();
		}
		System.out.println("¡Conexion establecida!");
		return con;
	}
	
	public void cerrarConexion(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}