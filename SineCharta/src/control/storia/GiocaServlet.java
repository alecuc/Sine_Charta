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
 * Servlet implementation class GiocaServlet
 */
@WebServlet("/GiocaServlet")
public class GiocaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static StoryManager storia = new StoryManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiocaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		String story = request.getParameter("storia");
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		
		if(storia == null) {
			response.sendRedirect("jsp_page/error.jsp");
		}
		
		try {
		Integer idStory = Integer.parseInt(story);
		Storia str = storia.getStoria(idStory, username);
		session.setAttribute("storia", str);
		
		response.sendRedirect("jsp_page/storia.jsp");
		}catch(SQLException e) {
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
