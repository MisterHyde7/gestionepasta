package it.prova.gestionepasta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	@Override
	public List<Pasta> listaByExample(Pasta input) throws Exception {

		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		TypedQuery<Pasta> query = entityManager.createQuery(
				"select p FROM Pasta p where 1=1 and p.marca like :marcaInput  and p.descrizione like :descrizioneInput and p.codice like :codiceInput and p.prezzo > :prezzoInput and p.dataScadenza > :dataScadenzaInput",
				Pasta.class);

		query.setParameter("marcaInput", "'%" + input.getMarca() + "%'");
		query.setParameter("descrizioneInput", "'%" + input.getDescrizione() + "%'");
		query.setParameter("codiceInput", "'%" + input.getCodice() + "%'");
		query.setParameter("prezzoInput", input.getPrezzo());
		query.setParameter("dataScadenzaInput", input.getDataScadenza());

		return query.getResultList();
	}

}
