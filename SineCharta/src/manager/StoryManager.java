package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;


import beans.HaTable;
import beans.Personaggio;
import beans.Storia;
import beans.User;

public class StoryManager {

	private static final String TABLE_NAME_HA = "ha";
	private static final String TABLE_NAME_STORIA = "Storia";
	
	
	/**
	 * Metodo per caricare tutte le storie associate ad un utente
	 * @param username= identificativo dell'utente
	 * @return la storia a cui si riferisce idStoria
	 */
	public Collection<Storia> getStoria(User user) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		Collection<Storia> storieutente = new LinkedList<Storia>();
		HaTable table = new HaTable();
		String selectStoria = "SELECT * FROM "+TABLE_NAME_STORIA+" NATURAL JOIN "+TABLE_NAME_HA+" WHERE USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectStoria);
			
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Storia storia = new Storia();
				
				table.setIdStoria(rs.getInt("IdStory"));
				table.setUsername(rs.getString("Username"));
				table.setFlagModeratore(rs.getBoolean("flag"));
				
				storia.setId(rs.getInt("IdStory"));
				storia.setTitolo(rs.getString("Titolo"));
				storia.setDescrizione(rs.getString("Descrizione"));
				storia.setAmbientazione(rs.getString("Ambientazione"));
				storia.setUsername(table.getUsername());
				storia.setUtenteModeratore(user);
			//da finire	storia.addPersonaggio(pg);
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
		
	
	public Storia getStoriaDelPG(Personaggio pg)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Storia storia = new Storia();
		String selectStoria = "SELECT * FROM " + TABLE_NAME_STORIA + " WHERE IDSTORY = ?";
		//
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectStoria);
			ps.setInt(1, pg.getIdStoria());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				storia.setId(rs.getInt("IdStory"));
				storia.setTitolo(rs.getString("Titolo"));
				storia.setDescrizione(rs.getString("Descrizione"));
				storia.setAmbientazione(rs.getString("Ambientazione"));
			}
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return storia;
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
	 * Metodo per assegnare un personaggio ad una Storia.
	 * @param username= identificativo del moderatore
	 * @param idStoria= identificativo della storia
	 *
	public void setPgForStory(String user, int idStory)throws SQLException {
		//PersonaggioManager pgM = new PersonaggioManager();
	//	Personaggio pg = pgM.getPersonaggioByUtente(idStory, user);
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
	*/
	
	
}