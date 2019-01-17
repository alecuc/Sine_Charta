package control.utente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.UsersManager;
import beans.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	static UsersManager user = new UsersManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if(username.isEmpty() || password.isEmpty()) {
			response.sendRedirect("jsp_page/index.jsp");
			out.println("Username or password is empty.");
		}else {
			
			try {
				User usr = new User();
				if(usr.getPassword().equals(password)) {
					System.out.println("Login successful.");
					session.setAttribute("username", username);
					response.sendRedirect("jsp_page/homeUser.jsp");
				}else {
					System.out.println("Password error.");
					response.sendRedirect("jsp_page/index.jsp");
				}
						
			}catch (NullPointerException e) {
				System.out.println("User not found exception.");
				response.sendRedirect("jsp_page/index.jsp");
			}
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
