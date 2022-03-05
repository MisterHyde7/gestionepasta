package it.prova.gestionepasta.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionepasta.model.Pasta;
import it.prova.gestionepasta.service.MyServiceFactory;
import it.prova.gestionepasta.service.PastaService;

@WebServlet("/ExecuteDeletePastaServlet")
public class ExecuteDeletePastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idDaEliminareInput = request.getParameter("idDaEliminare");
		Long idLong = Long.parseLong(idDaEliminareInput);
		if (idLong < 1) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {

			PastaService pastaInstance = MyServiceFactory.getPastaServiceInstance();
			Pasta articoloDaEliminare = pastaInstance.caricaSingoloElemento(idLong);
			pastaInstance.rimuovi(articoloDaEliminare);
			List<Pasta> listaDiPastaAggiornata = pastaInstance.listAll();
			request.setAttribute("listaPastaAttribute", listaDiPastaAggiornata);

		} catch (Exception e) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/pasta/results.jsp").forward(request, response);
	}
}
