package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Superviviente;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */
public class SupervivienteDAO {

	/**
	 * Filtra los supervivientes por nombre, apellidos o email
	 * 
	 * @param palabraBusqueda la palabra a buscar en las 3 columnas
	 * @return ArrayList con todos los supervivientes filtrados
	 */
	public static ArrayList<Superviviente> filtrar(String palabraBusqueda) {

		ArrayList<Superviviente> coleccion = new ArrayList<Superviviente>();
		String sql = " SELECT id, nombre, historia, imagen FROM superviviente " + " WHERE nombre LIKE ?"
				+ " ORDER BY id ASC; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, "%" + palabraBusqueda + "%");

			try (ResultSet rs = pst.executeQuery()) { // lanza la consulta SQL y obtiene Resultados RS

				while (rs.next()) { // itero sobre los resultados de la consulta SQL

					// creamos un nuevo Objeto y lo seteamos con los valores del RS
					Superviviente p = new Superviviente();

					// cogemos los valres de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");
					String colHistoria = rs.getString("historia");

					p.setId(colId);
					p.setNombre(colNombre);
					p.setHistoria(colHistoria);
					p.setImagen(rs.getString("imagen"));

					// a�adir objeto al ArrayList
					coleccion.add(p);

				}
				// fin del bucle, ya no quedan mas lineas para leer
			} // fin del segundro try

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;

	}

	/**
	 * Consulta la tabla 'participante' para recuperar todos y devolverlos en una
	 * coleccion
	 * 
	 * @return Lista con todos los supervivientes de la bbdd
	 * @throws Exception
	 */
	public static ArrayList<Superviviente> getAll() {

		ArrayList<Superviviente> coleccion = new ArrayList<Superviviente>();
		String sql = "SELECT id, nombre, historia, imagen FROM superviviente ORDER BY id ASC; ";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// creamos un nuevo Objeto y lo seteamos con los valores del RS
				Superviviente p = new Superviviente();

				// cogemos los valres de las columnas
				int colId = rs.getInt("id");
				String colNombre = rs.getString("nombre");
				String colHistoria = rs.getString("historia");

				p.setId(colId);
				p.setNombre(colNombre);
				p.setHistoria(colHistoria);
				p.setImagen(rs.getString("imagen"));

				// a�adir objeto al ArrayList
				coleccion.add(p);

			}
			// fin del bucle, ya no quedan mas lineas para leer

		} catch (Exception e) {
			e.printStackTrace();
		}

		return coleccion;
	}

	/**
	 * Buscamos un participante por su identificador
	 * 
	 * @param id int identificador del supervivientes
	 * @return Participante con datos si encuentra, NULL si no lo encuentra
	 */
	public static Superviviente getById(int id) {

		Superviviente p = null;
		String sql = "SELECT id,nombre,historia,imagen FROM Superviviente WHERE id = ?; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) { // hemos encontrado Participante por su ID

					// cogemos los valres de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");
					String colHistoria = rs.getString("historia");
					String colImagen = rs.getString("imagen");

					p = new Superviviente();
					p.setId(colId);
					p.setNombre(colNombre);
					p.setHistoria(colHistoria);
					p.setImagen(colImagen);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Elimina un particpante por su identificador
	 * 
	 * @param id int identificador
	 * @return true si elimina, false en caso contrario
	 * @throws Exception no deberia lanzar
	 */
	public static boolean delete(int id) throws Exception {

		boolean eliminado = false;
		String sql = "DELETE FROM superviviente WHERE id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			if (pst.executeUpdate() == 1) {
				eliminado = true;
			}

		}
		return eliminado;
	}

	/**
	 * Inserta un nuevo Participante
	 * 
	 * @param p Participante con los datos nuevos a insertar
	 * @return true si lo inserta, false en caso contrario
	 * @throws Exception si el email ya existe
	 */
	public static boolean insert(Superviviente p) throws Exception {
		boolean insertado = false;
		String sql = "INSERT INTO superviviente (nombre,historia,imagen) VALUES (?,?,?); ";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getHistoria());
			pst.setString(3, p.getImagen());

			if (pst.executeUpdate() == 1) {
				insertado = true;
			}

		}

		return insertado;
	}

	/**
	 * Modifica un Participante
	 * 
	 * @param p Participante con los datos a modificar, importante que tenga un id
	 * @return true si modifica, false en caso contrario
	 * @throws Exception si el email ya existe en la tabla
	 */
	public static boolean update(Superviviente p) throws Exception {
		boolean modificado = false;
		String sql = "UPDATE Superviviente SET nombre = ? ,historia = ?, imagen = ?	WHERE id = ?;";
		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getHistoria());
			pst.setString(3, p.getImagen());
			pst.setInt(4, p.getId());

			if (pst.executeUpdate() == 1) {
				modificado = true;
			}

		}

		return modificado;
	}

}
