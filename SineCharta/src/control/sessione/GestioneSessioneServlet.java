package control.sessione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SessioneDiGioco;
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
			
			if(action.equalsIgnoreCase("inserisciSessione")) {
				
				String contenuto = request.getParameter("contenutoSessione");
				String username = request.getParameter("Username");
				String idStory = request.getParameter("idStoria");
				
				Integer idStor = Integer.parseInt(idStory);
				
				sesDiGioco.setContenutoSessione(contenuto);
				sesDiGioco.setUsernameModeratore(username);
				sesDiGioco.setIdStoria(idStor);
				
				//ssn.salvareSessioni(sesDiGioco);		
				
				System.out.println("successfully inserted");
				response.sendRedirect("jps_page/vistaSessione.jsp");
			}else if(action.equalsIgnoreCase("listaSessione")) {
				//logica per lista delle sessioni
			}else if(action.equalsIgnoreCase("modificaSessione")) {
				
				String idSessione = request.getParameter("idSessione");
				String contenuto = request.getParameter("contenutoSessione");
				String username = (String)session.getAttribute("Username");
				String idStoria = (String)session.getAttribute("idStor");
				
				Integer id = Integer.parseInt(idStoria);
				
				//chiamare il manager per modificare il contenuto della sessione di gioco
				
				
			}
		}finally {
			
		}/* catch(SQLException e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
