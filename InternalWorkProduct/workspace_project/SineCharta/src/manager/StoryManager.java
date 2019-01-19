package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import beans.Storia;

public class StoryManager {

	private static final String TABLE_NAME_STORIA = "Storia";
	
	
	/**
	 * Metodo per caricare la storia 
	 * @param idStoria= identificativo della storia
	 * @return la storia a cui si riferisce idStoria
	 */
	public Storia getStoria(int idStoria, String username) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		Storia storia = new Storia();
		String selectStoria = "SELECT * FROM "+TABLE_NAME_STORIA+" WHERE ID = ? AND USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectStoria);
			ps.setInt(1, idStoria);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				storia.setId(rs.getInt("Id"));
				storia.setTitolo(rs.getString("Titolo"));
				storia.setDescrizione(rs.getString("Descrizione"));
				storia.setAmbientazione(rs.getString("Ambientazione"));
				storia.setUsername(rs.getString("Username"));
			}
			
		}finally {
			try {
				
			}finally {
				
			}
		}
		
		return storia;
	}
	
	
	/**
	 * Metodo che carica la lista delle storie di un Utente moderatore 
	 * @return lista di tutte le storie associate alla username
	 */
	public Collection<Storia> listaStorie(String username) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		Collection<Storia> storie = new LinkedList<Storia>();
		String storieUtente = "SELECT * FROM "+TABLE_NAME_STORIA+" WHERE USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(storieUtente);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			System.out.println("listaStorie: " + ps.toString());
			
			while(rs.next()) {
				
				Storia storia = new Storia();
				
				storia.setId(rs.getInt("Id"));
				storia.setTitolo(rs.getString("Titolo"));
				storia.setDescrizione(rs.getString("Descrizione"));
				storia.setAmbientazione(rs.getString("Ambientazione"));
				storia.setUsername(rs.getString("Username"));
				storie.add(storia);
			}
		}finally {
			try {
				if(ps != null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return storie;
	}
	
	/**
	 * Metodo per inserire una nuova storia
	 * @param storia= un oggetto di tipo storia 
	 * @param username= utente che inserisce la storia
	 */
	public void aggiungiStoria(Storia storia , String username)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		
		String creaStoria = "INSERT INTO "+ TABLE_NAME_STORIA 
				+ " (TITOLO, DESCRIZIONE, AMBIENTAZIONE, USERNAME) VALUES(?, ?, ?, ?)";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(creaStoria);
			
			ps.setString(1, storia.getTitolo());
			ps.setString(2, storia.getDescrizione());
			ps.setString(3, storia.getAmbientazione());
			ps.setString(4, username);
			
			System.out.println("aggiungiStoria" + ps.toString());
			ps.executeUpdate();
			con.commit();
		} finally {
			try {if(ps!=null) ps.close();
				
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
	
	/**
	 * Metodo per eliminare una storia
	 * @param idStoria= identificativo della storia da eliminare
	 * @return risultato dell'avvenuta eliminazione
	 */
	public boolean eliminaStoria(int idStoria, String username) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaStoria = "DELETE FROM " + TABLE_NAME_STORIA + " WHERE ID = ? AND USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaStoria);
			ps.setInt(1, idStoria);
			ps.setString(2,	username);
			result = ps.executeUpdate();
			System.out.println("eliminaStoria: " + ps.toString());
			con.commit();
		}finally {
			try {
				if(ps!=null)ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return (result != 0);
	}
	
	
	
}
