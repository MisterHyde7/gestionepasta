package it.prova.gestionepasta.service;

import java.util.List;

import it.prova.gestionepasta.dao.PastaDAO;
import it.prova.gestionepasta.model.Pasta;

public interface PastaService {

	// questo mi serve per injection
	public void setPastaDao(PastaDAO articoloDao);

	public List<Pasta> listAll() throws Exception;

	public Pasta caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Pasta input) throws Exception;

	public void inserisciNuovo(Pasta input) throws Exception;

	public void rimuovi(Pasta input) throws Exception;

	public List<Pasta> findByExample(Pasta input) throws Exception;

}
