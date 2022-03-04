package it.prova.gestionepasta.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionepasta.model.Pasta;

public class PastaDAOImpl implements PastaDAO {

	private EntityManager entityManager;

	public List<Pasta> list() throws Exception {
		return entityManager.createQuery("from Pasta", Pasta.class).getResultList();
	}

	public Pasta findOne(Long id) throws Exception {
		return entityManager.find(Pasta.class, id);
	}

	public void update(Pasta input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	public void insert(Pasta input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	public void delete(Pasta input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
