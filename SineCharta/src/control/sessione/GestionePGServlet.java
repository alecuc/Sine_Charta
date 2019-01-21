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
import manager.EquipManager;

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
		
		HttpSession session = request.getSession();
		ArrayList<Oggetto> listaOggetti = (ArrayList<Oggetto>) session.getAttribute("listaOggettiPG");
		String action = request.getParameter("action");
		
		try {
			if(action.equalsIgnoreCase("aggOggetto")) {
				String nomeOggetto = request.getParameter("nomeOggetto");
				String peso = request.getParameter("peso");
				String costo = request.getParameter("costo");
				
				oggetto.setNome(nomeOggetto);
				oggetto.setPeso(Double.parseDouble(peso));
				oggetto.setCosto(Double.parseDouble(costo));
				
				equipaggiamento.inserisciOggetto(oggetto,Integer.parseInt(request.getParameter("idPG")));
				
				System.out.println("Oggetto inserito.");
				response.sendRedirect("/*PAGINA PERSONAGGIO*/");
			}
			/*  DA COMPLETARE    */
			else if(action.equalsIgnoreCase("rimuoviOggetto")) {
				int idPG = Integer.parseInt(request.getParameter("idPG"));
				
				equipaggiamento.rimuoviOggetto(idPG);
				
				
				
			}else if(action.equalsIgnoreCase("listaOggettiPg")) {
				Collection<Oggetto> listaOggettiPg = equipaggiamento.getListaOggettiPG("Peso",  Integer.parseInt(request.getParameter("idPG")));
				
			}else if(action.equalsIgnoreCase("aggArma")) {
				
				
			}else if(action.equalsIgnoreCase("rimuoviArma")) {
				
			}else if(action.equalsIgnoreCase("listaArmiPg")) {
				
			}
			/* DA COMPLETARE*/
		} catch(SQLException e) {
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
