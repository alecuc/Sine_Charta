package control.sessione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Mazzo;
import beans.Tarocco;

/**
 * Servlet implementation class GestioneMazzoServlet
 */
@WebServlet("/GestioneMazzoServlet")
public class GestioneMazzoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneMazzoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		HttpSession session= request.getSession();
		
		String action= request.getParameter("action");
		Mazzo mazzo= (Mazzo) session.getAttribute("Mazzo");
		if(action.equalsIgnoreCase("estraiTarocco")) {
		
			Tarocco tarot= mazzo.estraiTarocco();
			String JSONtarot= 
					"{\"nome\":\""+tarot.getNome()+"\","
				+ "\"numero\":\""+tarot.getNumero()+"\","
				+ "\"descrizione\":\""+tarot.getDescrizione()+"\","
				+ "\"descrizioneDominante\":\""+tarot.getDescrizioneDominante()+"\","
				+ "\"valoreCuori\":\""+tarot.getValoreCuori()+"\","
				+ "\"valoreQuadri\":\""+tarot.getValoreQuadri()+"\","
				+ "\"valoreFiori\":\""+tarot.getValoreFiori()+"\","
				+ "\"valorePicche\":\""+tarot.getValorePicche()+"\"}";
			
			response.getWriter().write(JSONtarot);
			
		}	else if(action.equalsIgnoreCase("estraiPoker")){
			String poker= mazzo.estraiPoker();
			
			
			response.getWriter().write(poker);
		}	else if(action.equalsIgnoreCase("mischiaTarocco")) {
			mazzo.mischiaTarocco();
			
			
		}	else if(action.equalsIgnoreCase("mischiaPoker")) {
			mazzo.mischiaPoker();
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
