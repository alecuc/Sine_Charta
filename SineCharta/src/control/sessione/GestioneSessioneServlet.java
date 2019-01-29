package control.sessione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SessioneDiGioco;
import beans.Storia;
import beans.User;
import manager.SessioneManager;

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
		String action = request.getParameter("action");
		SessioneDiGioco sesDiGioco = new SessioneDiGioco();
		SessioneManager ssn = new SessioneManager();
		HttpSession session = request.getSession();

		try {

			//questo if permette di inserire una sessione
			if(action.equalsIgnoreCase("inserisciSessione")) {

				String contenuto = request.getParameter("contenutoSessione");
				String username = request.getParameter("Username");
				String idStory = request.getParameter("idStoria");

				Integer idStor = Integer.parseInt(idStory);

				sesDiGioco.setContenutoSessione(contenuto);
				sesDiGioco.setUsernameModeratore(username);
				sesDiGioco.setIdStoria(idStor);

				ssn.salvareSessioni(sesDiGioco);		

				System.out.println("successfully inserted");
				response.sendRedirect("jps_page/vistaSessione.jsp");
				
				
				// questo if permette di predere la lista delle sessioni legate alla storia	
			}else if(action.equalsIgnoreCase("listaSessione")) {
				
				Storia storia = (Storia)session.getAttribute("storiaDelPg");			
				User utente = (User)session.getAttribute("user");
				Collection<SessioneDiGioco> listaSessioni = ssn.recuperoTutteLeSessioni(storia, utente);
				session.setAttribute("listaSessioni", listaSessioni);
				response.sendRedirect("sessioneModeratore.jsp");
				
				//questo if permette di modificare una sessione	
			}else if(action.equalsIgnoreCase("modificaSessione")) {

				String idSessione = request.getParameter("idSessione");
				String contenuto = request.getParameter("contenutoSessione");
				String username = (String)session.getAttribute("Username");
				String idStoria = (String)session.getAttribute("idStor");

				SessioneDiGioco sdg = new SessioneDiGioco(); 				
				Integer idStor = Integer.parseInt(idStoria);
				Integer idSess = Integer.parseInt(idSessione);

				sdg.setContenutoSessione(contenuto);
				sdg.setIdNumeroSessione(idSess);

			}else if(action.equalsIgnoreCase("prendiSessione")){
				
				Storia storia = (Storia)session.getAttribute("storiaDelPg");			
				User utente = (User)session.getAttribute("user");
				String numSessione = request.getParameter("numSessione");
				Integer nSessione = Integer.parseInt(numSessione);
				sesDiGioco = ssn.recuperoSessioneStoria(storia, utente, nSessione);
				session.setAttribute("sessione", sesDiGioco);
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
