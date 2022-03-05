package it.prova.gestionepasta.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionepasta.model.Pasta;

@WebServlet("/PrepareSearchPastaServlet")
public class PrepareSearchPastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("searchPasta", new Pasta());
		request.getRequestDispatcher("/pasta/search.jsp").forward(request, response);

	}
}
