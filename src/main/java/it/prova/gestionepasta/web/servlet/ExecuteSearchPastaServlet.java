package it.prova.gestionepasta.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionepasta.model.Pasta;
import it.prova.gestionepasta.service.MyServiceFactory;
import it.prova.gestionepasta.utility.UtilityPastaForm;

@WebServlet("/ExecuteSearchPastaServlet")
public class ExecuteSearchPastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// estraggo input
		String marcaInputParam = request.getParameter("marca");
		String descrizioneInputParam = request.getParameter("descrizione");
		String codiceInputParam = request.getParameter("codice");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String dataScadenzaStringParam = request.getParameter("dataScadenza");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Pasta pastaInstance = UtilityPastaForm.createPastaFromParams(marcaInputParam, descrizioneInputParam, codiceInputParam,
				prezzoInputStringParam, dataScadenzaStringParam);

		try {
			request.setAttribute("listaPastaAttribute", MyServiceFactory.getPastaServiceInstance().findByExample(pastaInstance));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/pasta/results.jsp").forward(request, response);

	}
}
