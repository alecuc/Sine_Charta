package control.utente;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import exception.UserNullException;
import interfaces.UserModelI;
import manager.UsersManager;
/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	static UserModelI<User> user = new UsersManager();
	User usr = new User();
	
    public RegistrazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
				if(action.equalsIgnoreCase("register")) {
					
					
					usr.setUsername(username);
					usr.setPassword(password);
					usr.setName(name);
					usr.setSurname(surname);
					usr.setEmail(email);
					user.doSave(usr);	
			
				System.out.println("successfully inserted");
				//RequestDispatcher rd = request.getRequestDispatcher("/jsp_page/index.jsp");
				System.out.println("OK");
				response.sendRedirect("jsp_page/regSuccess.jsp");
				//rd.forward(request, response);
				
				} 
		 } catch(SQLException e) {
			 e.printStackTrace();
			/*
			 * HttpSession session = request.getSession(); String str = "true";
			 * session.setAttribute("RegistrationError", str);
			 */ 
			 response.sendRedirect("jsp_page/error/campiGiaPresenti.jsp");
		 } catch (UserNullException e) {
			
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
			response.sendRedirect("jsp_page/error/error503.jsp");
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
