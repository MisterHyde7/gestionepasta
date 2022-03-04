package it.prova.gestionepasta.service;

import it.prova.gestionepasta.dao.PastaDAO;
import it.prova.gestionepasta.dao.PastaDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static PastaService PASTA_SERVICE_INSTANCE = null;
	private static PastaDAO PASTADAO_INSTANCE = null;

	public static PastaService getPastaServiceInstance() {
		if (PASTA_SERVICE_INSTANCE == null)
			PASTA_SERVICE_INSTANCE = new PastaServiceImpl();

		if (PASTADAO_INSTANCE == null)
			PASTADAO_INSTANCE = new PastaDAOImpl();

		PASTA_SERVICE_INSTANCE.setPastaDao(PASTADAO_INSTANCE);

		return PASTA_SERVICE_INSTANCE;
	}

}
