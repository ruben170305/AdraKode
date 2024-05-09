package model;

import java.sql.*;

public class Model {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/kode";
	private String usuario = "root";
	private String pword = "ruben";
	
	public Connection getConexion() {
		Connection con = null;
		
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