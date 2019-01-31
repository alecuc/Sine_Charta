package manager;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

import beans.Keyword;
import beans.SessioneDiGioco;

public class KeywordManager {
	
	private static final String TABLE_NAME = "Keyword";
	
	/********************************************************************************
	 * Metodo che restituisce un bean di tipo keyword								*
	 * @param idKeyword l'id della keyword 											*
	 * @return il bean che rappresenta la keyword									*
	 ********************************************************************************/
	public Keyword prendereKeyword(SessioneDiGioco sessione, String chiave) throws SQLException {
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		Keyword bean = new Keyword();
		String selectSql = "SELECT * FROM " + TABLE_NAME + " WHERE CHIAVE = ? AND NUMERO = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSql);
			ps.setString(1, chiave);
			ps.setInt(2, sessione.getIdNumeroSessione());
			System.out.println("prendereKeyword: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				bean.setIdKeyword(rs.getInt("idKeyword"));
				bean.setChiave_nome(rs.getString("Chiave"));
				bean.setDescrizione(rs.getString("Descrizione"));
				bean.setIdSessione(rs.getInt("Numero"));
				bean.setSessioneKeyword(sessione);
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
	
	
	/****************************************************************************************
	 * Metodo che permette di restituire una lista di keyword								*
	 * @param session la sessione in cui su vuole recuperare la lista						*
	 * @return la lista di keyword															*
	 ****************************************************************************************/
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
				keyword.setSessioneKeyword(session);
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
	
	/********************************************************************************
	 * Metodo per eliminare una keyword 											*
	 * @param idKeyWord= identificativo della keyword da eliminare					*
	 * @param numero= numero della sessione a cui appartiene la keyword				*
	 * @return valore conferma eliminazione											*
	 ********************************************************************************/
	public boolean eliminaKeyword(int idKeyWord, int numero)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaKeyword = "DELETE FROM " + TABLE_NAME + "WHERE IDKEYWORD = ? AND NUMERO = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaKeyword);
			ps.setInt(1, idKeyWord);
			ps.setInt(2, numero);
			result = ps.executeUpdate();
			System.out.println("eliminaKeyword: " + ps.toString());
			con.commit();
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return (result!=0);
	}
	
	
}
