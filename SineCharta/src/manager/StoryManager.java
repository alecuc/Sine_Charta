package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import beans.HaTable;
import beans.Personaggio;
import beans.SessioneDiGioco;
import beans.Storia;
import beans.User;

public class StoryManager {

	private static final String TABLE_NAME_HA = "ha";
	private static final String TABLE_NAME_STORIA = "Storia";
	
	
	/**
	 * Metodo per caricare la storia 
	 * @param idStoria= identificativo della storia
	 * @return la storia a cui si riferisce idStoria
	 */
	public Collection<Storia> getStoria(String username) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		Collection<Storia> storieutente = new LinkedList<Storia>();
		HaTable table = new HaTable();
		String selectStoria = "SELECT * FROM "+TABLE_NAME_STORIA+" NATURAL JOIN "+TABLE_NAME_HA+" WHERE USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectStoria);
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Storia storia = new Storia();
				
				table.setIdStoria(rs.getInt("IdStory"));
				table.setUsername(rs.getString("Username"));
				table.setFlagModeratore(rs.getBoolean("flag"));
				
				storia.setId(rs.getInt("IdStory"));
				storia.setTitolo(rs.getString("Nome"));
				storia.setDescrizione(rs.getString("Descrizione"));
				storia.setAmbientazione(rs.getString("Ambientazione"));
				storia.setUsername(table.getUsername());
				
				
				storieutente.add(storia);
			}
			
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return storieutente;
	}
		
	
	/**
	 * Metodo che carica la lista delle storie di un Utente moderatore 
	 * @return lista di tutte le storie associate alla username
	 */
	public Collection<Storia> listaStorie(String username) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		Collection<Storia> storie = new LinkedList<Storia>();
		String storieUtente = "SELECT * FROM "+TABLE_NAME_STORIA+" WHERE Username = ?";
		
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
	/**
	 * Metodo per aggiungere un utente moderatore alla storia creata.
	 * @param username= identificativo del moderatore
	 * @param idStoria= identificativo della storia
	 */
	public void setUserModeratoreForStory(String username, int idStoria)throws SQLException {
		UsersManager user = new UsersManager();
		User utenteModeratore = user.doRetrieveByKey(username);
//		Storia storia = this.getStoria(username);
		//storia.setUtenteModeratore(utenteModeratore);
		
	}
	
	
	/**
	 * Metodo per assegnare un personaggio ad una Storia.
	 * @param username= identificativo del moderatore
	 * @param idStoria= identificativo della storia
	 */
	public void setPgForStory(String user, int idStory)throws SQLException {
		PersonaggioManager pgM = new PersonaggioManager();
		Personaggio pg = pgM.getPersonaggioByUtente(idStory, user);
	//	Storia storia = this.getStoria(user);
	//	storia.addPersonaggio(pg);
	}
	
	public void aggiungiSessioneallaStoria(int numero, String username, int idStory) throws SQLException{
		
		Storia storia = new Storia();
		StoryManager stry = new StoryManager(); 
		SessioneManager ssnM = new SessioneManager();
		SessioneDiGioco ssn = ssnM.prendereSessione(numero, username, idStory);
		
		//storia = stry.getStoria(username);
		storia.aggiungiSessione(ssn);
	}
	
	
	
}