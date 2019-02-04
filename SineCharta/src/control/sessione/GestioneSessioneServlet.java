package control.sessione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Personaggio;
import beans.SessioneDiGioco;
import beans.Storia;
import beans.User;
import manager.PersonaggioManager;
import manager.SessioneManager;
import manager.StoryManager;

/**
 * Servlet implementation class GestioneSessioneServlet
 */
@WebServlet("/GestioneSessioneServlet")
public class GestioneSessioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneSessioneServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String action = request.getParameter("action");

		System.out.println("++++++++++++++++++++++++");
		System.out.println("Action: "+action);	
		System.out.println("++++++++++++++++++++++++");
		
		
		
		try {
			
			if(action.equalsIgnoreCase("nuovaSessione")) {
				String idStory = request.getParameter("idStoria");
				session.setAttribute("idStoria", idStory);
				response.sendRedirect("jsp_page/editorSessione.jsp");
			
			}

			//questo if permette di inserire una sessione
			if(action.equalsIgnoreCase("inserisciSessione")) {

				String contenuto = request.getParameter("Contenuto");
				String idStory = (String) session.getAttribute("idStoria");
				Integer id = Integer.parseInt(idStory);
				
				Storia storia= new Storia();
				SessioneDiGioco sdg= new SessioneDiGioco();
				
				StoryManager stManager= new StoryManager();
				SessioneManager sgManager= new SessioneManager();
				
				storia= stManager.getSimpleStory(id);
				
				int numSessione= sgManager.getNumeroSessioniStoria(storia);
				
				
				sdg.setContenutoSessione(contenuto);
				sdg.setIdNumeroSessione(numSessione);
				sdg.setIdStoria(id);
				sdg.setUsernameModeratore(user.getUsername());
				
				sgManager.salvareSessioni(sdg);
				
				storia.aggiungiSessione(sdg);
				sdg.setStoriaSessione(storia);
				
				
				Collection<Storia> listaStorieMod = stManager.getStoriaByFlag(user, 1);
				session.setAttribute("storieModeratore", listaStorieMod);
				
				System.out.println("successfully inserted");
				response.sendRedirect("jsp_page/sessioneSuccess.jsp");


				// questo if permette di predere la lista delle sessioni legate alla storia	
			}else if(action.equalsIgnoreCase("listaSessione")) {
/*
				Storia storia = (Storia)session.getAttribute("storia");			
				User utente = (User)session.getAttribute("user");
				Collection<SessioneDiGioco> listaSessioni = sdgManager.recuperoTutteLeSessioni(storia, utente);
				session.setAttribute("listaSessioni", listaSessioni);
				response.sendRedirect("sessioneModeratore.jsp");
*/
				//questo if permette di modificare una sessione	
			}else if(action.equalsIgnoreCase("modificaSessione")) {
/*
				String contenuto = request.getParameter("contenutoSessione");
				SessioneManager sdG = new SessioneManager();		
				sdG.aggiornareSessioni(sesDiGioco, contenuto);
*/
				//questo if permette di fare un retrieve della sessione dal database
			}else if(action.equalsIgnoreCase("prendiSessione")){

				StoryManager stManager= new StoryManager();
				SessioneManager sgManager= new SessioneManager();				
				String param= request.getParameter("numero");
				Integer num= Integer.parseInt(param);
				String idStory= request.getParameter("idStoria");
				Integer id = Integer.parseInt(idStory);
				
				Storia storia= new Storia();
				SessioneDiGioco sdg= new SessioneDiGioco();
				
				
				
				storia= stManager.getSimpleStory(id);
				sdg= sgManager.recuperoSessioneStoria(storia, user, num);
				
				
				session.setAttribute("sessione", sdg);
				response.sendRedirect("jsp_page/vistaModeratore.jsp");
			
			}else if(action.equalsIgnoreCase("gioca")) {

				System.out.println("++++++++++++++++++++++++");
				System.out.println("Sto eseguendo: "+action);	
				System.out.println("++++++++++++++++++++++++");

				String param= request.getParameter("idStoria");
				int idStoria= Integer.parseInt(param);

				PersonaggioManager pgM = new PersonaggioManager();
				Personaggio pg = pgM.getSimplePGByStory(user, idStoria);

				session.setAttribute("personaggio", pg);
				response.sendRedirect("jsp_page/vistaGiocatore.jsp");

			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
