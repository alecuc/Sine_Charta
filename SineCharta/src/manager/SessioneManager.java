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
			System.out.println("doRetrieveByKey: " + preparedStatement.toString());
			
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
			ResultSet rs = ps.executeQuery();
			System.out.println("listaSessioni: " + ps.toString());
			
			while(rs.next()) {
				SessioneDiGioco session = new SessioneDiGioco();
				
				session.setIdNumeroSessione(rs.getInt("Numero"));
				session.setContenutoSessione(rs.getString("Contenuto"));
				session.setUsernameModeratore(rs.getString("Username"));
				session.setIdStoria(rs.getInt("IdStory"));
				session.addListaKeyword(aggiungiListaKeyword(session));
				session.setStoriaSessione(storia);
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
				+ " (CONTENUTO, USERNAME, IDSTORY) VALUES (?, ?, ?, ?)";
		
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
	

}
