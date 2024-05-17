package model;

import java.util.ArrayList;

public class Data {

	protected Model mysql;
	protected ArrayList<Usuario> usuarios;
    protected ArrayList<Partida> partidas;
    protected ArrayList<Personaje> personajes;
	
	public Data(){}

    public Data( Model mysql ) {
		this.mysql = mysql;
        this.usuarios = new ArrayList<>();
        this.partidas = new ArrayList<>();
        this.personajes = new ArrayList<>();
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}
	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}
	
    public void initialize_personajes() {
        Personaje personaje = new Personaje( mysql );
        personaje.conseguir_personajes();
        this.personajes.add( personaje );
    }

    public void initialize_partidas() {
        Partida partida = new Partida( mysql );
        partida.conseguir_partidas();
        this.partidas.add( partida );
    }
	
}
