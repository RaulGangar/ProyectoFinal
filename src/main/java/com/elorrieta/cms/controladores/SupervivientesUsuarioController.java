package com.elorrieta.cms.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Superviviente;
import com.elorrieta.cms.modelo.dao.SupervivienteDAO;

/**
 * Servlet implementation class supervivientesListarController
 */
@WebServlet("/supervivienteslista")
public class SupervivientesUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filtro = request.getParameter("filtro");
		ArrayList<Superviviente> lista = new ArrayList<Superviviente>();

		if (filtro == null) {
			lista = SupervivienteDAO.getAll();
		} else {
			lista = SupervivienteDAO.filtrar(filtro);
		}

		request.setAttribute("filtro", filtro);
		request.setAttribute("supervivientes", lista);
		request.getRequestDispatcher("supervivientesusuario.jsp?page=supervivientes").forward(request, response);

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
