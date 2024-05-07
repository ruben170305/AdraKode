package model;

public class Usuario {

    // Definimos las características del Personaje
    private String nombre, apellidos, expediente, estudio;
    private int user_id;
    
    // Constructor
    public Usuario( int user_id, String nombre, String apellidos, String expediente, String estudio ) {
        this.user_id    = user_id;
        this.nombre     = nombre;
        this.apellidos  = apellidos;
        this.expediente = expediente;
        this.estudio    = estudio;
    }

    // Getters y Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id( int user_id ) {
        this.user_id = user_id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getExpediente() {
        return expediente;
    }
    
    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }
    
    public String getEstudio() {
        return estudio;
    }
    
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
}
