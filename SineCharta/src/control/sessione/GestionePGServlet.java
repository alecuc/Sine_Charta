package control.sessione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Oggetto;
import beans.Personaggio;
import manager.EquipManager;
import manager.PersonaggioManager;

/**
 * Servlet implementation class GestionePGServlet
 */
@WebServlet("/GestionePGServlet")
public class GestionePGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EquipManager equipaggiamento = new EquipManager();
	Oggetto oggetto = new Oggetto();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionePGServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*
		 * Questa servlet non sarà completata.
		 * */
		
		
		HttpSession session = request.getSession();
		Collection<Oggetto> listaOggetti = (Collection<Oggetto>) session.getAttribute("listaOggettiPG");
		String action = request.getParameter("action");
		Personaggio pg = (Personaggio)session.getAttribute("pg");

		try {
			if(action.equalsIgnoreCase("aggOggetto")) {
				String nomeOggetto = request.getParameter("nomeOggetto");
				String peso = request.getParameter("peso");
				String costo = request.getParameter("costo");
				String quantita = request.getParameter("quantita");

				oggetto.setNome(nomeOggetto);
				oggetto.setPeso(Double.parseDouble(peso));
				oggetto.setCosto(Double.parseDouble(costo));
				oggetto.setQuantita(Integer.parseInt(quantita));
				PersonaggioManager pgM = new PersonaggioManager();

				equipaggiamento.inserisciOggetto(oggetto, pg);
				System.out.println("Oggetto inserito.");
				response.sendRedirect("/*PAGINA PERSONAGGIO*/");
			}
			/*  DA COMPLETARE    */
			else if(action.equalsIgnoreCase("rimuoviOggetto")) {

				EquipManager eqp = new EquipManager();
				oggetto = (Oggetto)session.getAttribute("oggetto");
				eqp.rimuoviOggetto(oggetto, pg);

			}else if(action.equalsIgnoreCase("listaOggettiPg")) {

				EquipManager eqp = new EquipManager();
				listaOggetti = eqp.getListaOggettiPG(pg);
				session.setAttribute("listaOggetti", listaOggetti);

			}	
		}catch(SQLException e) {
			e.printStackTrace();
			session.setAttribute("InsertError", "inserimento errato");
			response.sendRedirect("#");

		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
