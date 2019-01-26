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
			System.out.println("getStoria : " + ps.toString());
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
				storia.addPersonaggio(getPersonaggioForStory(user));
				storia.aggiungiListaSessioni(aggiungiSessioniAllaStoria(storia, user));
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
		
	
	private Personaggio getPersonaggioForStory(User utente)throws SQLException {
		PersonaggioManager manager = new PersonaggioManager();
		Personaggio pg = manager.getPersonaggioByUtente(utente);
		return pg;
	}
	
	
	private ArrayList<SessioneDiGioco> aggiungiSessioniAllaStoria(Storia storia, User utenteMod)throws SQLException{
		SessioneManager manager = new SessioneManager();
		Collection<SessioneDiGioco> listaSessione = manager.recuperoTutteLeSessioni(storia, utenteMod);
		if(listaSessione!=null) {
			ArrayList<SessioneDiGioco> sessioni = new ArrayList<SessioneDiGioco>(listaSessione);
			return sessioni;
		}else return null;
	}
	
	public Storia getStoriaDelPG(Personaggio pg)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Storia storia = new Storia();
		String selectStoria = "SELECT * FROM " + TABLE_NAME_STORIA + " WHERE IDSTORY = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectStoria);
			ps.setInt(1, pg.getIdStoria());
			System.out.println("getStoriadelPG: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				storia.setId(rs.getInt("IdStory"));
				storia.setTitolo(rs.getString("Titolo"));
				storia.setDescrizione(rs.getString("Descrizione"));
				storia.setAmbientazione(rs.getString("Ambientazione"));
				storia.setUtenteModeratore(pg.getUser());
				storia.addPersonaggio(pg);
				storia.aggiungiListaSessioni(aggiungiSessioniAllaStoria(storia, pg.getUser()));
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
	public void aggiungiStoria(Storia storia, User utenteMod, int flag)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		//PreparedStatement ps2 = null;
		String creaStoria = "INSERT INTO "+ TABLE_NAME_STORIA 
				+ " (TITOLO, DESCRIZIONE, AMBIENTAZIONE) VALUES(?, ?, ?)";
		//String aggiungiFlag = "INSERT INTO ha (USERNAME, IDSTORY, FLAG) VALUES(?,?,?)";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(creaStoria);
			//ps2 = con.prepareStatement(aggiungiFlag);
			ps.setString(1, storia.getTitolo());
			ps.setString(2, storia.getDescrizione());
			ps.setString(3, storia.getAmbientazione());
			//ps2.setString(1, utenteMod.getUsername());
			//Storia stoTmp = 
			//ps2.setInt(2, );
			//AGGIUNGERE TRIGGER AL DB QUANDO SI INSERISCE NUOVA STORIA
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
	public boolean eliminaStoria(int idStoria) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaStoria = "DELETE FROM " + TABLE_NAME_STORIA + " WHERE ID = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaStoria);
			ps.setInt(1, idStoria);
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
		//SessioneDiGioco ssn = ssnM.prendereSessione(numero, username, idStory);
		
		//storia = stry.getStoria(username);
		//storia.aggiungiSessione(ssn);
	}
	*/
	
	
}