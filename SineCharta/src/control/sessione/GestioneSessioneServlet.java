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

				
		try {

			/*
			 * Questo metodo indirizza l'utente alla pagina editorSessione,
			 * inserendo come attributo di sessione l'id della storia corretto
			 * */
			
			if(action.equalsIgnoreCase("nuovaSessione")) {
				String idStory = request.getParameter("idStoria");
				session.setAttribute("idStoria", idStory);
				response.sendRedirect("jsp_page/editorSessione.jsp");
			
			}
			
			/*
			 * Questo metodo permette di inserire una nuova sessione.
			 * */
			
			else if(action.equalsIgnoreCase("inserisciSessione")) {

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


				/*
				 * Questo metodo permette di modificare il contenuto di una sessione.
				 * Non sarà implementato.
				 * */	
			}else if(action.equalsIgnoreCase("modificaSessione")) {
/*
				String contenuto = request.getParameter("contenutoSessione");
				SessioneManager sdG = new SessioneManager();		
				sdG.aggiornareSessioni(sesDiGioco, contenuto);
*/			}
			
						
			/*
			 * Questo metodo indirizza l'utente alla pagina dove può visualizzare la sessione di gioco,
			 * inserendo come attributo di sessione la sessione di gioco corretta
			 * */
			
			else if(action.equalsIgnoreCase("prendiSessione")){

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
			
			}
			
			/*
			 * Questo metodo reindirizza l'utente alla pagina per visualizzare il personaggio
			 * e aggiunge il personaggio agli attributi di sessione
			 * */
			
			else if(action.equalsIgnoreCase("gioca")) {

			
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
