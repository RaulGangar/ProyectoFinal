package com.elorrieta.cms.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Ayuda para conectar con la base de datos
 * 
 * @author Raul Alava
 *
 */

public class ConnectionHelper implements AutoCloseable {

	private static Connection con = null;
	private static final String DIRECCION_BBDD = "jdbc:sqlite:C:\\desarrollo Java\\workspace\\cms_participantes\\DBD.db";

	/**
	 * 
	 * @return con para conectar la base de datos
	 * @throws Exception no deberia saltar
	 */
	public static Connection getConnection() throws Exception {

		// cargar el driver de sqlite
		Class.forName("org.sqlite.JDBC");

		con = DriverManager.getConnection(DIRECCION_BBDD);

		return con;
	}

	@Override
	public void close() throws Exception {

		if (con != null) {
			con.close();
		}

	}

}
