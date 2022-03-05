package it.prova.gestionepasta.dao;

import java.util.List;

import it.prova.gestionepasta.model.Pasta;

public interface PastaDAO extends IBaseDAO<Pasta> {
	
	public List<Pasta> listaByExample(Pasta input) throws Exception;

}
