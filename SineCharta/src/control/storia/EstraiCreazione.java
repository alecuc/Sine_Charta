package control.storia;

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
 * Servlet implementation class EstraiCreazione
 */
@WebServlet("/EstraiCreazione")
public class EstraiCreazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstraiCreazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain");

		
		HttpSession session= request.getSession();
		Mazzo tDeck= new Mazzo();
		//tDeck= (Mazzo)session.getAttribute("mazzo");
		Tarocco tarot= tDeck.estraiTarocco();
		String JSONtarot= 
				"{\"nome\":\""+tarot.getNome()+"\","
			+ "\"numero\":\""+tarot.getNumero()+"\","
			+ "\"descrizioneDominante\":\""+tarot.getDescrizioneDominante()+"\","
			+ "\"valoreCuori\":\""+tarot.getValoreCuori()+"\","
			+ "\"valoreQuadri\":\""+tarot.getValoreQuadri()+"\","
			+ "\"valoreFiori\":\""+tarot.getValoreFiori()+"\","
			+ "\"valorePicche\":\""+tarot.getValorePicche()+"\"}";
		
		response.getWriter().write(JSONtarot);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
