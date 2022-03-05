package it.prova.gestionepasta.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionepasta.model.Pasta;
import it.prova.gestionepasta.service.MyServiceFactory;
import it.prova.gestionepasta.service.PastaService;

@WebServlet("/PrepareEditPastaServlet")
public class PrepareEditPastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idInput = request.getParameter("idPasta");
		Long idLong = Long.parseLong(idInput);

		try {
			PastaService pastaInstance = MyServiceFactory.getPastaServiceInstance();
			Pasta pastaDaModificare = pastaInstance.caricaSingoloElemento(idLong);
			request.setAttribute("pastaDaModificare", pastaDaModificare);
		} catch (Exception e) {

		}

		request.getRequestDispatcher("/pasta/edit.jsp").forward(request, response);
	}
}
