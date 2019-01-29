package control.utente;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import manager.StoryManager;
import manager.UsersManager;
import beans.Mazzo;
import beans.Storia;
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

			if (utenteLogin.getUsername()==null) {
				response.sendRedirect("jsp_page/error/error.jsp");
			}

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
				StoryManager str = new StoryManager(); 
				Collection<Storia>  listaStoria = str.getStoria(utenteLogin);
				Mazzo mazzo = new Mazzo();
				session.setAttribute("Mazzo", mazzo);
				session.setAttribute("listaStorie", listaStoria);
				response.sendRedirect("jsp_page/homeUser.jsp");
			} else {

				System.out.println("OH NON SONO UGUALI LE DUE PASSWORD");
				response.sendRedirect("jsp_page/error/loginErrorePassword.jsp");
			}

		} catch (IllegalStateException e) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp_page/error/loginErrorePassword.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			response.sendRedirect("jsp_page/error/error.jsp");
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
