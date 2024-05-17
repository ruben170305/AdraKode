package model;

public class Personaje {

    // Definimos las características del Personaje
    private String nombre, personaje, clase, raza;
    private int cod, cod_miembro, expe, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma;
    
    // Constructor
    public Personaje()  {
    	
    }
    public Personaje(
            int cod
        ,   String nombre
        ,   String personaje
        ,   String raza
        ,   String clase
        ,   int expe
        ,   int cod_miembro
        ,   int fuerza
        ,   int destreza
        ,   int constitución
        ,   int inteligencia
        ,   int sabiduria
        ,   int carisma
    ) {
        this.cod 			= cod;
        this.nombre  		= nombre;
        this.personaje		= personaje;
        this.raza   		= raza;
        this.clase   		= clase;
        this.expe     		= expe;
        this.cod_miembro 	= cod_miembro;
        this.fuerza         = fuerza;
        this.destreza       = destreza;
        this.constitucion   = constitución;
        this.inteligencia   = inteligencia;
        this.sabiduria      = sabiduria;
        this.carisma        = carisma;
    }

    // Getters
    public int getCod() {
        return cod;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getRaza() {
        return raza;
    }

    public String getClase() {
        return clase;
    }

    public int getExpe() {
        return expe;
    }

    public int getCod_miembro() {
        return cod_miembro;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public int getCarisma() {
        return carisma;
    }

    // Setters
    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void setExpe(int expe) {
        this.expe = expe;
    }

    public void setCod_miembro(int cod_miembro) {
        this.cod_miembro = cod_miembro;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

}
