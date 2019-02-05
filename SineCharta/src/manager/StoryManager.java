package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import beans.HaTable;
import beans.Personaggio;
import beans.SessioneDiGioco;
import beans.Storia;
import beans.User;
import exception.UserNotFoundException;

public class StoryManager {

	private static final String TABLE_NAME_HA = "ha";
	private static final String TABLE_NAME_STORIA = "Storia";


	/********************************************************************************
	 * Metodo per caricare tutte le storie associate ad un utente					*
	 * @param username= identificativo dell'utente									*
	 * @return la storia a cui si riferisce idStoria								*
	 ********************************************************************************/
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
				storia.addPersonaggio(getPersonaggioForStory(user,storia.getId()));
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


	/****************************************************************************
	 * Metodo per selezionare l'ultima storia inserita							*
	 * @return id dell'ultima storia inserita									*
	 ****************************************************************************/
	public int selectLastId()throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int id = 0;

		String selectMax = "SELECT MAX(IDSTORY) FROM " + TABLE_NAME_STORIA;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectMax);
			System.out.println("selectLastId: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("max(IdStory)");
			}
		}finally {
			try {
				if(ps!=null)ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return id;
	}

	/***********************************************************************************************
	 * Metodo per caricare tutte le storie associate ad un utente tramite flag						*
	 * @param username= identificativo dell'utente													*
	 * @param flag= identificativo di un utente Moderatore rispetto ad un utente giocatore			*
	 * @return la storia a cui si riferisce idStoria												*
	 ************************************************************************************************/
	public Collection<Storia> getStoriaByFlag(User user, int flag) throws SQLException{

		Connection con = null;
		PreparedStatement ps = null;
		Collection<Storia> storieutente = new LinkedList<Storia>();
		HaTable table = new HaTable();
		String selectStoria = "SELECT * FROM "+TABLE_NAME_STORIA+" NATURAL JOIN "+TABLE_NAME_HA+" WHERE USERNAME = ? AND FLAG = ?";

		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectStoria);

			ps.setString(1, user.getUsername());
			ps.setInt(2, flag);
			System.out.println("getStoriaByFlag : " + ps.toString());
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
				storia.addPersonaggio(getPersonaggioForStory(user,storia.getId()));
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

	/********************************************************************************************
	 * Metodo per poter recuperare un persoanggio tramite un utente da PersonaggioManager		*
	 * @param utente= utente a cui � associato il personaggio									*
	 * @return un personaggio																	*
	 ********************************************************************************************/
	private Personaggio getPersonaggioForStory(User utente, int idStory)throws SQLException {
		PersonaggioManager manager = new PersonaggioManager();
		Personaggio pg = manager.getSimplePGByStory(utente, idStory);
		return pg;
	}

	/****************************************************************************
	 * Metodo per recuperare una storia											*
	 * @param idStory= identificativo della storia								*
	 * @return una storia														*
	 ****************************************************************************/
	public Storia getSimpleStory(int idStory)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Storia storia = new Storia();
		String selectStoria = "SELECT * FROM "+TABLE_NAME_STORIA+" WHERE IDSTORY = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectStoria);
			ps.setInt(1, idStory);
			System.out.println("getSimpleStoria : " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				storia.setId(rs.getInt("IdStory"));
				storia.setTitolo(rs.getString("Titolo"));
				storia.setDescrizione(rs.getString("Descrizione"));
				storia.setAmbientazione(rs.getString("Ambientazione"));
				storia.aggiungiListaSessioni(aggiungiSessioniById(idStory));
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


	/********************************************************************
	 * Metodo per recuperare un utente da UserManager					*
	 * @param username= utente da recuperare							*
	 * @return un utente
	 * @throws UserNotFoundException *
	 ********************************************************************/
	@SuppressWarnings("unused")
	private User getUtente(String username)throws SQLException, UserNotFoundException {
		UsersManager manager = new UsersManager();
		User utente = manager.doRetrieveByKey(username);
		return utente;
	}

	/****************************************************************************
	 * Metodo per recuperare la lista delle sessioni di una storia				*
	 * @param idStory= identificativo della storia								*
	 * @return lista di sessioni appartenenti alla storia						*
	 ****************************************************************************/
	private Set<SessioneDiGioco> aggiungiSessioniById(int idStory)throws SQLException{
		SessioneManager manager = new SessioneManager();
		Collection<SessioneDiGioco> se = manager.recuperoSessioni(idStory);
		if(se!= null) {
			Set<SessioneDiGioco> sessioni = new HashSet<SessioneDiGioco>(se);
			return sessioni;
		} else return null;
	}

	/****************************************************************************
	 * Metodo per recupere una lista di sessioni per la storia					*
	 * @param storia= a cui appartengono le sessioni							*
	 * @param utenteMod= utente a cui � associata la storia						*
	 * @return una lista di sessioni											*
	 ****************************************************************************/
	private Set<SessioneDiGioco> aggiungiSessioniAllaStoria(Storia storia, User utenteMod)throws SQLException{
		SessioneManager manager = new SessioneManager();
		Collection<SessioneDiGioco> listaSessione = manager.recuperoTutteLeSessioni(storia, utenteMod);
		if(listaSessione!=null) {
			Set<SessioneDiGioco> sessioni = new HashSet<SessioneDiGioco>(listaSessione);
			return sessioni;
		}else return null;
	}

	/****************************************************************************************
	 * Metodo per recuperare una storia in base al personaggio a cui vi partecipa			*
	 * @param pg= personaggio a cui � associata la storia 									*
	 * @return una storia del personaggio													*
	 ****************************************************************************************/
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
				storia.aggiungiListaSessioni(aggiungiSessioniAllaStoria(storia, pg.getUser()));
				storia.addPersonaggio(pg);
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


	/********************************************************************************************
	 * Metodo per inserire una nuova storia														*
	 * @param storia= un oggetto di tipo storia 												*
	 * @param username= utente che inserisce la storia											*
	 ********************************************************************************************/
	public void aggiungiStoria(Storia storia)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		String creaStoria = "INSERT INTO "+ TABLE_NAME_STORIA
				+ " (TITOLO, DESCRIZIONE, AMBIENTAZIONE) VALUES(?, ?, ?)";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(creaStoria);
			ps.setString(1, storia.getTitolo());
			ps.setString(2, storia.getDescrizione());
			ps.setString(3, storia.getAmbientazione());
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

	/********************************************************************************************
	 * Metodo per aggiungere riga alla tabella delle associazioni tra utente e storia			*
	 * @param storia= storia con un identificativo												*
	 * @param utente= utente da aggiungere														*
	 * @param flag= identifica il tipo di utente												*
	 ********************************************************************************************/
	public void aggiungiATable(User utente, int flag) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		String aggiungiHaTable = "INSERT INTO ha (USERNAME, IDSTORY, FLAG) VALUES(?, ?, ?)";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(aggiungiHaTable);
			ps.setString(1, utente.getUsername());
			ps.setInt(2, selectLastId());
			ps.setInt(3, flag);
			System.out.println("aggiungiATable: " + ps.toString());
			ps.executeUpdate();
			con.commit();
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}

	/************************************************************************************
	 * Metodo per eliminare una storia													*
	 * @param idStoria= identificativo della storia da eliminare						*
	 * @return risultato dell'avvenuta eliminazione										*
	 ************************************************************************************/
	public boolean eliminaStoria(int idStoria) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaStoria = "DELETE FROM " + TABLE_NAME_STORIA + " WHERE IDSTORY = ?";
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


	/********************************************************************************
	 * Metodo per eliminare il riferimento ad HaTable della storia					*
	 * @param username= identificativo dell'utente a cui � riferita la storia		*
	 * @param idStory= identificativo della storia 									*
	 * @return valore di conferma eliminazione										*
	 ********************************************************************************/
	public boolean eliminaRiferimentoHaTable(String username, int idStory)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaHaRow = "DELETE FROM " + TABLE_NAME_HA + " WHERE USERNAME = ? AND IDSTORY = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaHaRow);
			ps.setString(1, username);
			ps.setInt(2, idStory);
			result  = ps.executeUpdate();
			System.out.println("eliminaRiferimentoHaTable: "+ ps.toString());
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
