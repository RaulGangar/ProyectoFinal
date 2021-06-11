package com.elorrieta.cms.modelo;

/**
 * Clase para supervivientes
 * 
 * @author Raul Alava
 *
 */
public class Superviviente {

	private int id;
	private String nombre;
	private String historia;
	private String imagen;

	/**
	 * Recoge los parametros de superviviente
	 */
	public Superviviente() {
		super();
		this.id = 0;
		this.nombre = "";
		this.historia = "";
		this.imagen = "https://randomuser.me/api/portraits/men/1.jpg";
	}

	/**
	 * Recoge los parametros de superviviente por nombre e historia
	 * 
	 * @param nombre   nombre del superviviente
	 * @param historia historia del superviviente
	 */
	public Superviviente(String nombre, String historia) {
		this();
		this.nombre = nombre;
		this.historia = historia;
	}

	/**
	 * recoge la id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setea la id
	 * 
	 * @param id parametro de id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * recoge el nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setea el nombre
	 * 
	 * @param nombre parametro de nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * recoge la historia
	 * 
	 * @return historia
	 */
	public String getHistoria() {
		return historia;
	}

	/**
	 * Setea la historia
	 * 
	 * @param historia parametro de historia
	 */
	public void setHistoria(String historia) {
		this.historia = historia;
	}

	/**
	 * recoge la imagen
	 * 
	 * @return imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Setea la imagen
	 * 
	 * @param imagen parametro de imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Superviviente [id=" + id + ", nombre=" + nombre + ", historia=" + historia + ", imagen=" + imagen + "]";
	}

}
