package control.utente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import exception.UserNotFoundException;
import manager.UsersManager;

/**
 * Servlet implementation class UserExistServlet
 */
@WebServlet("/UserExistServlet")
public class UserExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserExistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 		Questa servlet è creata per controllare tramite AJAX
		 * 		l'esistenza degli username inseriti dall'utente durante l'invio degli 
		 * 		inviti ad una storia da parte di un UTENTE MODERATORE.
		 * 
		 */
		
		
		response.setContentType("text/plain");
		HttpSession session= request.getSession();
		UsersManager um= new UsersManager();
		String username= request.getParameter("usr");
		User utente= (User) session.getAttribute("user");
		
		boolean check=false;
		try {
			check= um.checkUser(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Username: "+username+"\n status check: "+check);
		
		if(check) {
			response.getWriter().write(username);
			
		} else if(username.equals(utente.getUsername())) {
			response.getWriter().write("TU");		
			
		} else response.getWriter().write("NO");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
