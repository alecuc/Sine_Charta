package control.storia;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Storia;
import manager.StoryManager;

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
	
		try {
		
			if(action.equalsIgnoreCase("acquisireStoria"))	{
				Integer id = Integer.parseInt(idStoria);
				//Storia story = str.getStoria(id);
		
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
			
				}else if(action.equalsIgnoreCase("listaStorie")) {
				
					//inserire logica per trovare la lista delle storie
					
				}
			
		
		}finally {
		
		}/*catch (SQLException e) {
		e.printStackTrace();
		}*/
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
