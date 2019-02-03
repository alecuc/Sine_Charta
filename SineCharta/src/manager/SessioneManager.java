package manager;

import java.sql.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import beans.Keyword;
import beans.SessioneDiGioco;
import beans.Storia;
import beans.User;

public class SessioneManager {

	private static final String TABLE_NAME = "Sessione";

	/************************************************************************************************
	 * metodo che carica una sessione in base alla storia e all'utente moderatore					*
	 * @param storia= storia a cui appartiene la sessione											*
	 * @param utente= moderatore a cui appartiene la sessione										*
	 * @param numSessione= numero della sessione da recuperare										*
	 * @return la sessione																			*
	 ************************************************************************************************/
	public SessioneDiGioco recuperoSessioneStoria(Storia storia, User utente, int numSessione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		SessioneDiGioco bean = new SessioneDiGioco();
		String selectSql = "SELECT * FROM " + SessioneManager.TABLE_NAME + " WHERE NUMERO = ? AND USERNAME = ? AND IDSTORY = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setInt(1, numSessione);
			preparedStatement.setString(2, utente.getUsername());
			preparedStatement.setInt(3, storia.getId());
			System.out.println("recuperoSessioneStoria: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setIdNumeroSessione(rs.getInt("Numero"));
				bean.setContenutoSessione(rs.getString("Contenuto"));
				bean.setUsernameModeratore(rs.getString("Username"));
				bean.setIdStoria(rs.getInt("IdStory"));
				bean.setStoriaSessione(storia);
				bean.addListaKeyword(aggiungiListaKeyword(bean));
			}
			
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}
			finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}			
		return bean;
	}


	/************************************************************************************
	 * Metodo che carica tutte le sessioni relative alla storia							*
	 * @param storia= storia a cui appartengono le sessioni								*
	 * @param utente= utente moderatore a cui appartengono le sessioni					*
	 * @return la lista delle sessioni di una storia									*
	 ************************************************************************************/
	public Collection<SessioneDiGioco> recuperoTutteLeSessioni(Storia storia, User utente) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		Collection<SessioneDiGioco> sessioni = new LinkedList<SessioneDiGioco>();
		String sessioniStoria = "SELECT * FROM " + TABLE_NAME + " WHERE IDSTORY = ? AND USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(sessioniStoria);
			ps.setInt(1, storia.getId());
			ps.setString(2, utente.getUsername());
			System.out.println("recuperoTutteLeSessioni: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SessioneDiGioco session = new SessioneDiGioco();
				session.setIdNumeroSessione(rs.getInt("Numero"));
				session.setContenutoSessione(rs.getString("Contenuto"));
				session.setUsernameModeratore(rs.getString("Username"));
				session.setIdStoria(rs.getInt("IdStory"));
				session.setStoriaSessione(getAnStory(session.getIdStoria()));
				session.addListaKeyword(aggiungiListaKeyword(session));
				
				sessioni.add(session);
			}
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return sessioni;
	}
	
	/********************************************************************
	 * Metodo per ottenere una storia tramite lo StoryManager			*
	 * @param idStoria= identificativo della storia						*
	 * @return una storia 												*
	 ********************************************************************/
	private Storia getAnStory(int idStoria) throws SQLException{
		StoryManager manager = new StoryManager();
		Storia sto = manager.getSimpleStory(idStoria);
		return sto;
	}

	/********************************************************************
	 * Metodo per recuperare una lista di Keyword						*					
	 * @param sessione= a cui sono associate le keyword					*
	 * @return una lista di keyword										*
	 * @throws SQLException												*
	 ********************************************************************/
	private Set<Keyword> aggiungiListaKeyword(SessioneDiGioco sessione)throws SQLException{
		KeywordManager manager = new KeywordManager();
		Collection<Keyword> listaKeyword = manager.listaKeyword(sessione);
		if(listaKeyword!=null) {
			Set<Keyword> keywordList = new HashSet<Keyword>(listaKeyword);
			return keywordList;
		} else return null;
	}
	
	/****************************************************************************
	 * Metodo che salva le sessioni nel database								*
	 * @param sessioneDiGioco la sessione di Gioco da salvare					*
	 ****************************************************************************/
	public void salvareSessioni(SessioneDiGioco sessioneDiGioco) throws SQLException {
	
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		String creaSessione = "INSERT INTO " + TABLE_NAME
				+ " (NUMERO, CONTENUTO, USERNAME, IDSTORY) VALUES (?, ?, ?, ?)";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			preparedStatement = con.prepareStatement(creaSessione);
			
			preparedStatement.setInt(1, sessioneDiGioco.getIdNumeroSessione());
			preparedStatement.setString(2, sessioneDiGioco.getContenutoSessione());
			preparedStatement.setString(3, sessioneDiGioco.getUsernameModeratore());
			preparedStatement.setInt(4, sessioneDiGioco.getIdStoria());
			
			System.out.println("salvareSessione" + preparedStatement.toString());
			preparedStatement.executeUpdate();
			con.commit();
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}

	/************************************************************************************
	 * Metodo che permette di aggiornare il contenuto della sessione					*
	 * @param sessioneDiGioco la sessione di gioco										*
	 * @param nuovoContenuto il nuovo contenuto della sessione							*
	 ************************************************************************************/
	public void aggiornareSessioni(SessioneDiGioco sessioneDiGioco, String nuovoContenuto) throws SQLException {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		String modificaSessione = "UPDATE TABLE " + TABLE_NAME 
				+ " SET CONTENUTO = ? WHERE NUMERO = ? AND USERNAME = ? AND IDSTORY = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			preparedStatement = con.prepareStatement(modificaSessione);
			preparedStatement.setString(1, nuovoContenuto);
			preparedStatement.setInt(2, sessioneDiGioco.getIdNumeroSessione());
			preparedStatement.setString(3, sessioneDiGioco.getUsernameModeratore());
			preparedStatement.setInt(4, sessioneDiGioco.getIdStoria());
			preparedStatement.executeUpdate();
			System.out.println("aggiornaSessione: " + preparedStatement.toString());
			con.commit();
			
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
	
	/****************************************************************************
	 * Metodo per eliminare una singola sessione								*
	 * @param numero= numero della sessione da eliminare						*
	 * @param IdStory= identificativo della sessione per la storia				*
	 * @param username= utente a cui si riferisce la sessione					*
	 * @return valore di avvenuta eliminazione									*	
	 ****************************************************************************/
	public boolean eliminaSingolaSessione(int numero, int IdStory, String username)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaSessione = "DELETE FROM "+ TABLE_NAME + " WHERE NUMERO = ? AND USERNAME = ? AND IDSTORY = ?";
		result = 0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaSessione);
			ps.setInt(1, numero);
			ps.setInt(2, IdStory);
			ps.setString(3, username);
			result = ps.executeUpdate();
			System.out.println("eliminaSingolaSessione: " + ps.toString());
			con.commit();
		}finally {
			try {
				if(ps!=null)ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return (result!=0);
	}
	
	
	/****************************************************************************
	 * Metodo per eliminare tutte le sessioni									*
	 * @param IdStory= identificativo delle sessioni per la storia				*
	 * @param username= utente a cui si riferiscono le sessioni					*
	 * @return valore di avvenuta eliminazione									*	
	 ****************************************************************************/
	public boolean eliminaSessioni(int IdStory, String username)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaSessione = "DELETE FROM "+ TABLE_NAME + " WHERE USERNAME = ? AND IDSTORY = ?";
		result = 0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaSessione);
			ps.setInt(1, IdStory);
			ps.setString(2, username);
			result = ps.executeUpdate();
			System.out.println("eliminaSessioni: " + ps.toString());
			con.commit();
		}finally {
			try {
				if(ps!=null)ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return (result!=0);
	}
	
	
	public Collection<SessioneDiGioco> recuperoSessioni(int idStory)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		Collection<SessioneDiGioco> sessioni = new LinkedList<SessioneDiGioco>();
		String sessioniStoria = "SELECT * FROM " + TABLE_NAME + " WHERE IDSTORY = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(sessioniStoria);
			ps.setInt(1, idStory);
			System.out.println("recuperoTutteLeSessioniById: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SessioneDiGioco session = new SessioneDiGioco();
				session.setIdNumeroSessione(rs.getInt("Numero"));
				session.setContenutoSessione(rs.getString("Contenuto"));
				session.setUsernameModeratore(rs.getString("Username"));
				session.setIdStoria(rs.getInt("IdStory"));
				session.addListaKeyword(aggiungiListaKeyword(session));
				
				sessioni.add(session);
			}
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return sessioni;
	}
	
	/********************************************************************
	 * Metodo per contare tutte le sessioni di una storia				*
	 * @param storia= a cui appartengono le sessioni					*
	 * @return numero delle sessioni									*
	 ********************************************************************/
	public int getNumeroSessioniStoria(Storia storia) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		
		String countSession = "SELECT COUNT (*) FROM " + TABLE_NAME + " WHERE IDSTORY = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(countSession);
			ps.setInt(1, storia.getId());
			System.out.println("getNumeroSessioniStoria: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("count(*)");
			}
		}finally {
			try {
				if(ps!=null)ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return count;
	}
		
	
	
}
