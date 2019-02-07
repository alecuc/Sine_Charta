package manager;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import beans.Personaggio;
import beans.Storia;
import beans.User;
import exception.UserNotFoundException;
import exception.UserNullException;

import java.sql.*;
import interfaces.UserModelI;

public class UsersManager implements UserModelI<User>{
	
	/**
	 * Riferimento alla tabella Utente del DataBase	
	 */
	private static final String TABLE_NAME = "utenteRegistrato";

	/* **********************************************************************
	 * Metodo per caricare un utente										*
	 * (non-Javadoc)														*
	 * @see interfaces.UserModelI#doRetrieveByKey(java.lang.String)			*
	 ************************************************************************/
	@Override
	public synchronized User doRetrieveByKey(String user) throws SQLException, UserNotFoundException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		User bean;
		String selectSql = "SELECT * FROM " + UsersManager.TABLE_NAME + " WHERE Username = ?;";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, user);
			
			ResultSet rs = preparedStatement.executeQuery();

			//if(!rs.next()) throw new UserNotFoundException("utente non presente"); 

			
				System.out.println("doRetrieveByKey: " + preparedStatement.toString());
				bean = new User();

				while(rs.next()) {
					bean.setUsername(rs.getString("Username"));
					bean.setPassword(rs.getString("Password"));
					bean.setEmail(rs.getString("EMail"));
					bean.setName(rs.getString("Nome"));
					bean.setSurname(rs.getString("Cognome"));
					bean.setRuolo(rs.getString("Ruolo"));
					bean.aggiungiListaStorie(aggiungiStorieUser(bean));
					bean.aggiungiListaPG(aggiungiListaPGUser(bean));
				}			
			
		}
		finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			}
		 finally {
			DriverManagerConnectionPool.releaseConnection(connection);
		 }
		
		}
		return bean;
	}


	
	/***************************************OK*************************************************************
	 * 		Metodo che comunica con PersonaggioManager per aggiungere una lista di personaggio all'utente *											  *
	 * @param username= identificativo dell'utente								                          *
	 * @return				Lista dei personaggi associati all'utente			                          *
	 ******************************************************************************************************/
	private synchronized Set<Personaggio> aggiungiListaPGUser(User user)throws SQLException {
			
			PersonaggioManager pgM = new PersonaggioManager();
			Collection<Personaggio> listaPG = pgM.listaPG(user);
			if(listaPG!=null) {
				Set<Personaggio> pgUtente = new HashSet<Personaggio>(listaPG);
				return pgUtente;
			}else return null;
	}
	

	/***************************************OK***********************************************
	 * Metodo che comunica con StoryManager per aggiunger una lista di storie ad un utente	*
	 * @param idStoria= identificativo della storia da aggiungere							*
	 * @param username= utente a cui viene inserita una storia.								*
	 ***************************************************************************************/
	private synchronized Set<Storia> aggiungiStorieUser(User user) throws SQLException{
		
		StoryManager storyM = new StoryManager();
		Collection<Storia> listaStorie = storyM.getStoria(user);//Da aggiustare!
		if(listaStorie != null) {
			Set<Storia> storie = new HashSet<Storia>(listaStorie);
			return storie;
		} else return null;
	}
	
	
	
	/* Metodo che ritorna una lista di tutti gli utenti
	 * (non-Javadoc) 
	 * @see interfaces.UserModelI#doRetrieveAll(java.lang.String)
	 */
	@Override
	public synchronized Collection<User> doRetrieveAll(String order) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Collection<User> utenti;
		String selectUtenti = "SELECT * FROM "+TABLE_NAME;
		
		if(order != null && !order.equals("")) {
			selectUtenti += " ORDER BY " + order;
		}
		
		try {
			utenti = new LinkedList<User>();
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectUtenti);
			System.out.println("doRetrieveAll: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User utente = new User();
				utente.setUsername(rs.getString("Username"));
				utente.setName(rs.getString("Nome"));
				utente.setSurname(rs.getString("Cognome"));
				utente.setEmail(rs.getString("Email"));
				utente.setPassword(rs.getString("Password"));
				utente.setRuolo(rs.getString("Ruolo"));
				utente.aggiungiListaStorie(aggiungiStorieUser(utente));
				utente.aggiungiListaPG(aggiungiListaPGUser(utente));
				utenti.add(utente);
				
			}
		}finally {
			try {
				if(ps!=null)con.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return utenti;
	}

	/* Metodo per salvare un nuovo utente
	 * (non-Javadoc) 
	 * @see interfaces.UserModelI#doSave(java.lang.Object)
	 */
	@Override
	public synchronized void doSave(User user) throws SQLException, UserNullException{
		if(user==null) throw new UserNullException("Utente NULL");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + UsersManager.TABLE_NAME
				+ " (USERNAME, PASSWORD, EMAIL, NOME, COGNOME, RUOLO) VALUES (?, md5(?), ?, ?, ?, 'utenteGiocatore')";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();

			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getName());
			preparedStatement.setString(5, user.getSurname());
			System.out.println("doSave: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	/************************************************************************
	 * Metodo per eliminare un utente										*
	 * @param username= identificativo dell'utente							*
	 * @return conferma dell'eliminazione									*
	 ************************************************************************/
	public synchronized boolean eliminaUtente(String username)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String delete = "DELETE FROM "+ TABLE_NAME+ " WHERE USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(delete);
			ps.setString(1, username);
			System.out.println("eliminaUtente: " + ps.toString());
			result = ps.executeUpdate();
			con.commit();
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return (result != 0);
	}
	
	/************************************************************************
	 * Metodo per controllare l'esistenza di un utente						*
	 * @param username= identificativo dell'utente							*
	 * @return conferma del controllo										*
	 ************************************************************************/
	
	public synchronized boolean checkUser(String username)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		String check = "SELECT USERNAME FROM "+ TABLE_NAME+ " WHERE USERNAME = ?";
		User usr= new User();

		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(check);
			ps.setString(1, username);
			System.out.println("checkUser: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			usr.setUsername(rs.getString("Username"));
			}
			con.commit();
			
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		System.out.println(usr.toString());
		
		if(usr.getUsername()==null) {
			System.out.println("NON L'HO TROVATO");
			return false;
			}
		else return true;
	}
	
}
