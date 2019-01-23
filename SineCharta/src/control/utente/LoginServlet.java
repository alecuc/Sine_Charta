package control.utente;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
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
		String usernameInput = request.getParameter("username");
		String passwordInput = request.getParameter("password");
		HttpSession session = request.getSession();
		
		
		try {
			User utenteLogin= user.doRetrieveByKey(usernameInput);
			
			String password= utenteLogin.getPassword();

			/*if (utenteLogin.getUsername()==null) {
				response.sendRedirect("jsp_page/login404.jsp");
			}*/
			
			
				String passEncr = passwordInput;
				if (passwordInput != null) {
				    MessageDigest md = MessageDigest.getInstance("MD5"); 
				    md.update(passwordInput.getBytes());
				    BigInteger hash = new BigInteger(1, md.digest());
				    passEncr = hash.toString(16);
				    while (passEncr.length() < 32) {
				    	passEncr = "0" + passEncr;
				    }
				}	
				
				
			if (passEncr.equals(password)) {

				session.setAttribute("user", utenteLogin);

				

				/*
				 * caricare in sessione la lista delle storie
				 * 
				 */
				response.sendRedirect("jsp_page/homeUser.jsp");
			} else {
			
			System.out.println("OH NON SONO UGUALI LE DUE PASSWORD");
			response.sendRedirect("jsp_page/loginErrorePassword.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();


		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
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
