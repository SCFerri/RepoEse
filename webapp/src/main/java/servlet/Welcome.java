package servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import service.GestioneDatabase;

public class Welcome extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "Iscriviti!");
		req.getRequestDispatcher("welcome.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GestioneDatabase gestioneDB = new GestioneDatabase(
				(EntityManagerFactory) getServletContext().getAttribute("emf"));
		Utente utente = new Utente();
		utente.setNome(req.getParameter("nome"));
		utente.setCognome(req.getParameter("cognome"));
		utente.setNumero(req.getParameter("numero"));
		gestioneDB.aggiungiUtente(utente);
		
	}
}
