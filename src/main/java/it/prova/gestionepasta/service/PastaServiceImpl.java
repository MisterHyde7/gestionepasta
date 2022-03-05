package it.prova.gestionepasta.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionepasta.dao.PastaDAO;
import it.prova.gestionepasta.model.Pasta;
import it.prova.gestionepasta.web.listener.LocalEntityManagerFactoryListener;

public class PastaServiceImpl implements PastaService {

	private PastaDAO pastaDao;

	public void setPastaDao(PastaDAO pastaDao) {
		this.pastaDao = pastaDao;
	}

	public List<Pasta> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			pastaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return pastaDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public Pasta caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			pastaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return pastaDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public void aggiorna(Pasta input) throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			pastaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			pastaDao.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public void inserisciNuovo(Pasta input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			pastaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			pastaDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	public void rimuovi(Pasta input) throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			pastaDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			pastaDao.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	public List<Pasta> findByExample(Pasta input) throws Exception {

		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			pastaDao.setEntityManager(entityManager);

			if (input.getPrezzo() == null)
				input.setPrezzo(0);
			if(input.getDataScadenza()==null)
				input.setDataScadenza(new Date());

			return pastaDao.listaByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}
}
