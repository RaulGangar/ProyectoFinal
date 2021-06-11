package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.elorrieta.cms.modelo.Asesino;

/**
 * Clase encargada relacionar el POJO con la Tabla DAO Data Access Object
 * 
 * @author Admin
 *
 */
public class AsesinoDAO {

	/**
	 * Filtra los asesinos por nombre, apellidos o email
	 * 
	 * @param palabraBusqueda la palabra a buscar en las 3 columnas
	 * @return ArrayList con todos los asesinos filtrados
	 */
	public static ArrayList<Asesino> filtrar(String palabraBusqueda) {

		ArrayList<Asesino> coleccion = new ArrayList<Asesino>();
		String sql = " SELECT id, nombre, historia, imagen FROM asesino " + " WHERE nombre LIKE ?"
				+ " ORDER BY id ASC; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, "%" + palabraBusqueda + "%");

			try (ResultSet rs = pst.executeQuery()) { // lanza la consulta SQL y obtiene Resultados RS

				while (rs.next()) { // itero sobre los resultados de la consulta SQL

					// creamos un nuevo Objeto y lo seteamos con los valores del RS
					Asesino p = new Asesino();

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
	 * @return Lista con todos los asesinos de la bbdd
	 * @throws Exception
	 */
	public static ArrayList<Asesino> getAll() {

		ArrayList<Asesino> coleccion = new ArrayList<Asesino>();
		String sql = "SELECT id, nombre, historia, imagen FROM asesino ORDER BY id ASC; ";

		try (

				Connection con = ConnectionHelper.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(); // lanza la consulta SQL y obtiene Resultados RS

		) {

			while (rs.next()) { // itero sobre los resultados de la consulta SQL

				// creamos un nuevo Objeto y lo seteamos con los valores del RS
				Asesino p = new Asesino();

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
	 * @param id int identificador del asesinos
	 * @return Participante con datos si encuentra, NULL si no lo encuentra
	 */
	public static Asesino getById(int id) {

		Asesino p = null;
		String sql = "SELECT id,nombre,historia,imagen FROM Asesino WHERE id = ?; ";

		try (Connection con = ConnectionHelper.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) { // hemos encontrado Participante por su ID

					// cogemos los valres de las columnas
					int colId = rs.getInt("id");
					String colNombre = rs.getString("nombre");
					String colHistoria = rs.getString("historia");
					String colImagen = rs.getString("imagen");

					p = new Asesino();
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
		String sql = "DELETE FROM asesino WHERE id = ?;";
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
	public static boolean insert(Asesino p) throws Exception {
		boolean insertado = false;
		String sql = "INSERT INTO asesino (nombre,historia,imagen) VALUES (?,?,?); ";

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
	public static boolean update(Asesino p) throws Exception {
		boolean modificado = false;
		String sql = "UPDATE Asesino SET nombre = ? ,historia = ?, imagen = ?	WHERE id = ?;";
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
