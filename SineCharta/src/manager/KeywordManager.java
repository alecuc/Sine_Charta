package manager;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

import beans.Keyword;
import beans.SessioneDiGioco;

public class KeywordManager {
	
	private static final String TABLE_NAME = "Keyword";
	
	/**
	 * Metodo che restituisce un bean di tipo keyword
	 * @param idKeyword l'id della keyword 
	 * @return il bean che rappresenta la keyword
	 * @throws SQLException
	 */
	public Keyword prendereKeyword(int idKeyword) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		Keyword bean = new Keyword();
		String selectSql = "SELECT * FROM " + TABLE_NAME + " WHERE idKeyword = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSql);
			ps.setInt(1, idKeyword);
			System.out.println("prendereKeyword: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bean.setIdKeyword(rs.getInt("idKeyword"));
				bean.setChiave_nome(rs.getString("Chiave"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setIdSessione(rs.getInt("Numero"));
				
			}
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return bean;
	}
	
	/**
	 * aggiunge la sessione alla keyword creata
	 * @param username
	 * @param idStoria
	 * @param numSessione
	 * @throws SQLException
	 */
	public void aggiungiLaSessioneAllaKeyword(String username, int idStoria, int numSessione) throws SQLException {
		
		SessioneManager sessioneManager = new SessioneManager();
		SessioneDiGioco sessione = sessioneManager.prendereSessione(numSessione, username, idStoria);
		Keyword key = this.prendereKeyword(numSessione);
		key.setSessioneKeyword(sessione);
		
	}

	/**
	 * metodo che permette di restituire una lista di keyword
	 * @param session la sessione in cui su vuole recuperare la lista
	 * @return la lista di keyword
	 * @throws SQLException
	 */
	public Collection<Keyword> listaKeyword(SessioneDiGioco session) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		Collection<Keyword> listaKeyword = new LinkedList<Keyword>();
		String keywordSessioni = "SELECT * FROM " + TABLE_NAME + " WHERE NUMERO = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(keywordSessioni);
			ps.setInt(1, session.getIdNumeroSessione());
			ResultSet rs = ps.executeQuery();
			System.out.println("listaKeyword: " + ps.toString());
			
			while(rs.next()) {
				Keyword keyword = new Keyword();
				
				keyword.setIdKeyword(rs.getInt("idKeyword"));
				keyword.setChiave_nome(rs.getString("Chiave"));
				keyword.setDescrizione(rs.getString("Descrizione"));
				keyword.setIdSessione(rs.getInt("Numero"));
				listaKeyword.add(keyword);
				
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
		
		return listaKeyword;
	}
	
	
	
}
>>>>>>> 1bbdfca491d4d256cb87b5d8a703d86e179950a2
