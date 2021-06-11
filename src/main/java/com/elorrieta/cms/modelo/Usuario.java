package com.elorrieta.cms.modelo;

/**
 * Calificacion del usuario segun su rol
 * 
 * @author Raul Alava
 *
 */

public class Usuario {

	/**
	 * Recoge el rol de usuario "usuario"
	 */
	public static final int ROL_USUARIO = 1;
	/**
	 * Recoge el rol de usuario "usuario"
	 */
	public static final int ROL_ADMIN = 2;

	private int id;
	private String nombre;
	private String password;
	private int rol;

	/**
	 * Recoge los parametros de usuario
	 */
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.password = "";
		this.rol = ROL_USUARIO;
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
	 * Recoge el nombre
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
	 * Recoge la contraseña
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setea la contraseña
	 * 
	 * @param password parametro de contraseña
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Recoge el rol
	 * 
	 * @return rol
	 */
	public int getRol() {
		return rol;
	}

	/**
	 * Setea el rol
	 * 
	 * @param rol parametro de rol
	 */
	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", rol=" + rol + "]";
	}

}
