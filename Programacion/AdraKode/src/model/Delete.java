package model;

public class Delete extends Query {

	private String database_name;

	public Delete( String database_name ) {
		this.database_name = database_name;
	}
	
	// Método para crear el SQL
	@Override
	String create_sql() {
		return null;
	}

	// Método para ejecutar el SQL
	@Override
	String[] exec_sql() {
		return null;
	}
}