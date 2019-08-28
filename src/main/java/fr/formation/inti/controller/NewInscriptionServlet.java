package fr.formation.inti.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Compte;
import fr.formation.inti.service.RegisterService;

/**
 * Servlet implementation class NouvelEmployeeServlet
 */
@WebServlet("/new")
public class NewInscriptionServlet extends HttpServlet {
	private static final Log log = LogFactory.getLog(NewInscriptionServlet.class);
	private static final long serialVersionUID = 1L;
	RegisterService service = new RegisterService();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewInscriptionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		doGet(request, response);
		log.debug("Method post new");
	
//// on crée notre objet service pour pouvoir utilisé ses méthodes qui sont dans l'interface LoginService
		Compte log = new Compte();

		String login = request.getParameter("login");
		log.setUser(login);
		log.setPass(request.getParameter("pass"));
		
		service.inscription(log);	

	
//		Integer id = service.save(log);
//		if(id != null) {
//			String contextPath = request.getContextPath();
//			response.sendRedirect(contextPath + "/employee");
//		}else {
//			
//		}
	}
	
}


	