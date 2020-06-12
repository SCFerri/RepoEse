package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Utente;


public class GestioneDatabase {
	private EntityManager em;
	
	public GestioneDatabase(EntityManagerFactory emf) {
		this.em = emf.createEntityManager();
	}
	public Utente aggiungiUtente(Utente utente) {
		em.getTransaction().begin();
		em.persist(utente);
		em.getTransaction().commit();
		return utente;
	}
	public List<Utente> stampaUtente() {
		List<Utente> lista = em.createQuery("SELECT * from Utente", Utente.class)
				.getResultList();
		return lista;
	}
	
}
