package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Superviviente;
import com.elorrieta.cms.modelo.dao.SupervivienteDAO;

/**
 * Servlet implementation class supervivientesEditar
 */
@WebServlet("/backoffice/supervivientes-editar")
public class SupervivientesEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Superviviente p = new Superviviente();
		String titulo = "Crear Nuevo Superviviente";

		if (id > 0) {
			titulo = "Modificar Superviviente";
			p = SupervivienteDAO.getById(id);
		}

		request.setAttribute("titulo", titulo);
		request.setAttribute("superviviente", p);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recoger parametro del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String historia = request.getParameter("historia");
		String imagen = request.getParameter("imagen");

		// creamos POJO de Participante con los datos del formulario
		Superviviente p = new Superviviente();
		p.setId(id);
		p.setNombre(nombre);
		p.setHistoria(historia);
		p.setImagen(imagen);

		try {
			if (id == 0) {
				SupervivienteDAO.insert(p);
			} else {
				SupervivienteDAO.update(p);
			}

			request.setAttribute("mensajeTipo", "primary");
			request.setAttribute("mensaje", "Datos Guardados");

		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "El email esta repetido");

		}

		request.setAttribute("titulo", "Modificar Participante");
		request.setAttribute("participante", p);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

}
