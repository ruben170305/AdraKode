package model;

// Clase abstracta de función ORM
public abstract class Query {
	abstract String create_sql();
	abstract String [] exec_sql();
}