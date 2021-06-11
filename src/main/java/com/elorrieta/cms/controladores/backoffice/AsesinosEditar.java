package com.elorrieta.cms.controladores.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elorrieta.cms.modelo.Asesino;
import com.elorrieta.cms.modelo.dao.AsesinoDAO;

/**
 * Servlet implementation class asesinosEditar
 */
@WebServlet("/backoffice/asesinos-editar")
public class AsesinosEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Asesino p = new Asesino();
		String titulo = "Crear Nuevo Asesino";

		if (id > 0) {
			titulo = "Modificar Asesino";
			p = AsesinoDAO.getById(id);
		}

		request.setAttribute("titulo", titulo);
		request.setAttribute("asesino", p);
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
		Asesino p = new Asesino();
		p.setId(id);
		p.setNombre(nombre);
		p.setHistoria(historia);
		p.setImagen(imagen);

		try {
			if (id == 0) {
				AsesinoDAO.insert(p);
			} else {
				AsesinoDAO.update(p);
			}

			request.setAttribute("mensajeTipo", "primary");
			request.setAttribute("mensaje", "Datos Guardados");

		} catch (Exception e) {
			request.setAttribute("mensajeTipo", "danger");
			request.setAttribute("mensaje", "El nombre esta repetido");

		}

		request.setAttribute("titulo", "Modificar Asesino");
		request.setAttribute("participante", p);
		request.getRequestDispatcher("formulario.jsp").forward(request, response);

	}

}
