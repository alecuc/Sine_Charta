package control.sessione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Oggetto;
import manager.EquipManager;

/**
 * Servlet implementation class GestionePGServlet
 */
@WebServlet("/GestionePGServlet")
public class GestionePGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EquipManager euipaggiamento = new EquipManager();
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
		
		String action = request.getParameter("action");
		
		try {
			if(action.equalsIgnoreCase("aggOggetto")) {
				String nomeOggetto = request.getParameter("nomeOggetto");
				String peso = request.getParameter("peso");
				String costo = request.getParameter("costo");
				
				oggetto.setNome(nomeOggetto);
				oggetto.setPeso(Double.parseDouble(peso));
				oggetto.setCosto(Double.parseDouble(costo));
				
				euipaggiamento.inserisciOggetto(oggetto,Integer.parseInt(request.getParameter("idPG")));
				
				System.out.println("Oggetto inserito.");
				response.sendRedirect("#");
			}
			
			if(action.equalsIgnoreCase("rimuoviOggetto")) {
				
				
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
			HttpSession session = request.getSession();
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
