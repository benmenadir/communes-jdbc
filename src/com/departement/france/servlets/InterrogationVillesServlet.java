package com.departement.france.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.departement.france.dao.VilleDAO;
import com.departement.france.entities.Ville;

/**
 * Servlet implementation class InterrogationVillesServlet
 */
@WebServlet(urlPatterns={"/InterrogationVillesServlet"},loadOnStartup=10)
public class InterrogationVillesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int LENGTH_MIN = 2;
	private static VilleDAO villeDAO;

	@Resource(name="jdbc/france") private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		villeDAO = new VilleDAO(dataSource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp = request.getParameter("cp");
		String page = "/index.jsp";
		if(cp != null && cp.length() >= LENGTH_MIN){
			List<Ville> villes = villeDAO.getVillesByCodePostal(cp);
			
			request.setAttribute("cp", cp);
			request.setAttribute("villes", villes);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
