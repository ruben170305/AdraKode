package model;

public class Partida {

    // Definimos las características de la Partida
    private int part_id;
    private String nombre, ambientacion, dia, hora;
    private boolean en_curso;

    // Constructor
    public Partida( int part_id, String nombre, boolean en_curso, String ambientacion, String dia, String hora ) {
        this.part_id      = part_id;
        this.nombre       = nombre;
        this.en_curso     = en_curso;
        this.ambientacion = ambientacion;
        this.dia          = dia;
        this.hora         = hora;
    }

    // Getters y Setters
    public int getPart_id() {
        return part_id;
    }

    public void setPart_id( int part_id ) {
        this.part_id = part_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public boolean isEnCurso() {
        return en_curso;
    }

    public void setEnCurso( boolean en_curso ) {
        this.en_curso = en_curso;
    }

    public String getAmbientacion() {
        return ambientacion;
    }

    public void setAmbientacion( String ambientacion ) {
        this.ambientacion = ambientacion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia( String dia ) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora( String hora ) {
        this.hora = hora;
    }
}
