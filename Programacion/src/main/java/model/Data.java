package model;

import java.util.ArrayList;

public class Data {

	protected Model mysql;
	public ArrayList<Usuario> usuarios;
    public ArrayList<Partida> partidas;
    public ArrayList<Personaje> personajes;

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
		this.personajes.clear();
        Personaje personaje = new Personaje( mysql );
        personaje.conseguir_personajes();
        this.personajes.add( personaje );
    }

    public void initialize_partidas() {
		this.personajes.clear();
        Partida partida = new Partida( mysql );
        partida.conseguir_partidas();
        this.partidas.add( partida );
    }
	
}
