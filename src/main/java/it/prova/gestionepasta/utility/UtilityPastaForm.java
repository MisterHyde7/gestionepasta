package it.prova.gestionepasta.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionepasta.model.Pasta;

//nel nome della classe vi è Articolo in quanto è una classe specifica
public class UtilityPastaForm {

	public static Pasta createPastaFromParams(String marcaInputParam, String descrizioneInputParam,
			String codiceInputStringParam, String prezzoStringParam, String dataScadenzaStringParam) {

		Pasta result = new Pasta(marcaInputParam, descrizioneInputParam, codiceInputStringParam);

		if (NumberUtils.isCreatable(prezzoStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoStringParam));
		}
		result.setDataScadenza(parseDateScadenzaFromString(dataScadenzaStringParam));

		return result;
	}

	public static boolean validatePastaBean(Pasta pastaToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(pastaToBeValidated.getMarca())
				|| StringUtils.isBlank(pastaToBeValidated.getDescrizione())
				|| StringUtils.isBlank(pastaToBeValidated.getCodice()) || pastaToBeValidated.getDataScadenza() == null
				|| pastaToBeValidated.getPrezzo() == null || pastaToBeValidated.getPrezzo() < 1) {
			return false;
		}
		return true;
	}

	public static Date parseDateScadenzaFromString(String dataScadenzaStringParam) {
		if (StringUtils.isBlank(dataScadenzaStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataScadenzaStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
