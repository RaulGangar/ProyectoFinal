package com.elorrieta.cms.modelo;

public class Superviviente {

	private int id;
	private String nombre;
	private String historia;
	private String imagen;

	public Superviviente() {
		super();
		this.id = 0;
		this.nombre = "";
		this.historia = "";
		this.imagen = "https://randomuser.me/api/portraits/men/1.jpg";
	}

	public Superviviente(String nombre, String apellidos) {
		this();
		this.nombre = nombre;
		this.historia = historia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", nombre=" + nombre + ", historia=" + historia + ", imagen=" + imagen + "]";
	}

}
