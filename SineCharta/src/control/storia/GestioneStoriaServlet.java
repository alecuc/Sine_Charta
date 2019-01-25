package control.storia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import beans.Mazzo;
import beans.Personaggio;
import beans.Storia;
import beans.User;
import manager.PersonaggioManager;
import manager.StoryManager;
import manager.UsersManager;

/**
 * Servlet implementation class EditorStoriaServlet
 */
@WebServlet("/EditorStoriaServlet")
public class GestioneStoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneStoriaServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String idStoria = request.getParameter("idStoria"); 
		String titolo = request.getParameter("nome");
		String contenuto = request.getParameter("descrizione");
		String action = request.getParameter("action");
		StoryManager str = new StoryManager();
		Storia storia = new Storia();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");

		try {

			//questo if permette di predere una storia in base ad un pg
			if(action.equalsIgnoreCase("acquisireStoria"))	{

				// prenderlo dall'utente Personaggio pg = (Personaggio)session.getAttribute("pe");
				
				UsersManager usr = new UsersManager();
				User utente = usr.doRetrieveByKey(username);
				PersonaggioManager pgM = new PersonaggioManager();
				Personaggio pg = pgM.getPersonaggioByUtente(utente);
				storia = str.getStoriaDelPG(pg);
				session.setAttribute("storiaDelPg", storia);
				response.sendRedirect("scheda pg");
				
				//questo if permette di inserire una storia nel database	
			}else if(action.equalsIgnoreCase("inserisciStoria")) {

				String nome = request.getParameter("Nome");
				String descrizione = request.getParameter("Descrizione");
				String ambientazione = request.getParameter("Ambientazione");

				storia.setTitolo(titolo);
				storia.setDescrizione(descrizione);
				storia.setAmbientazione(ambientazione);

				//str.aggiungiStoria(storia);

				System.out.println("successfully inserted");
				response.sendRedirect("jsp_page/riepilogoStoria(da vedere)");

				//questo if permette di prendere la lista delle storie
			}else if(action.equalsIgnoreCase("listaStorie")) {

				User usr = (User)session.getAttribute("user");
				Collection<Storia>  listaStoria = str.getStoria(usr);
				session.setAttribute("listaStorie", listaStoria);
				
				//questo if permette di fare un redirect alla pagina di creazione personaggio
			}else if(action.equalsIgnoreCase("creaPg")) {
				
				Mazzo mazzo = new Mazzo();
				session.setAttribute("mazzo", mazzo);
				String idSto = request.getParameter("idStoria");
				Integer idS = Integer.parseInt(idSto);
				session.setAttribute("idStory", idS);
				response.sendRedirect("jsp_page/creazionePG.jsp");
				
			}

		}catch (SQLException e) {
			e.printStackTrace();
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
