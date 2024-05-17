package model;

import java.sql.Connection;
import java.util.ArrayList;

public class Personaje {

    // Definimos las características del Personaje
    private String nombre, clase, exp;
    private int pers_id, raza;
    private Model model;
    private ArrayList<Integer> id_personaje = new ArrayList<Integer>();
    private ArrayList<String> nombres = new ArrayList<String>();
    
    // Constructor
    public Personaje()  {
    	
    }
    public Personaje( int pers_id, String nombre, int raza, String clase, String exp ) {
        this.pers_id = pers_id;
        this.nombre  = nombre;
        this.raza    = raza;
        this.clase   = clase;
        this.exp     = exp;
    }
    
    public void hacerConsulta() {
    	Connection connection = model.get_connection();
    	String nPersonaje = "SELECT * FROM cod WHERE ";
    	
    }
    
    

    // Getters y Setters
    
    public int getPers_id() {
        return pers_id;
    }

    public ArrayList<String> getNombres() {
		return nombres;
	}
	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}
	public void setPers_id( int pers_id ) {
        this.pers_id = pers_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase( String clase ) {
        this.clase = clase;
    }

    public String getExp() {
        return exp;
    }

    public void setExp( String exp ) {
        this.exp = exp;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza( int raza ) {
        this.raza = raza;
    }
}
