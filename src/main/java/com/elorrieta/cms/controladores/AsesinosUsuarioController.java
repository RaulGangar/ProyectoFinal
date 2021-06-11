package com.elorrieta.cms.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Asesino;
import com.elorrieta.cms.modelo.dao.AsesinoDAO;

/**
 * Servlet implementation class asesinosListarController
 */
@WebServlet("/asesinoslista")
public class AsesinosUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filtro = request.getParameter("filtro");
		ArrayList<Asesino> lista = new ArrayList<Asesino>();

		if (filtro == null) {
			lista = AsesinoDAO.getAll();
		} else {
			lista = AsesinoDAO.filtrar(filtro);
		}

		request.setAttribute("filtro", filtro);
		request.setAttribute("asesinos", lista);
		request.getRequestDispatcher("asesinosusuario.jsp?page=asesinos").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
