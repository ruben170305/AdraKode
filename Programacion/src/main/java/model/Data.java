package model;

import java.util.ArrayList;

public class Data {

	protected Model mysql;
	
	public Data(){}

    public Data( Model mysql ) {
		this.mysql = mysql;
	}

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	
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
	
}
