package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import beans.Abilita;
import beans.Oggetto;
import beans.Personaggio;
import beans.Storia;
import beans.User;

public class PersonaggioManager {
	
	private static final String TABLE_NAME_PG = "Personaggio";
	
	
	
	
	/************************************************************************************
	 * Metodo che torna un singolo personaggio associato alla storia 					*
	 * @param utente= utente a cui appartiene il persoanggio							*
	 * @param idStory= identificativo della storia										*
	 * @return un personaggio dell'utente in base alla storia							*
	 ************************************************************************************/
	public Personaggio getSimplePGByStory(User utente, int idStory)throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Personaggio personaggio = new Personaggio();
		String selectPg = "SELECT * FROM " + TABLE_NAME_PG + " WHERE USERNAME = ? AND IDSTORY = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectPg);
			ps.setString(1, utente.getUsername());
			ps.setInt(2, idStory);
			System.out.println("getSimplePGByStory: "+ ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				personaggio.setIdStoria(rs.getInt("IdStory"));
				personaggio.setUsername(rs.getString("Username"));
				personaggio.setNome(rs.getString("Nome"));
				personaggio.setCognome(rs.getString("Cognome"));
				personaggio.setAge(rs.getInt("Eta"));
				personaggio.setNazionalita(rs.getString("Nazionalita"));
				personaggio.setTaroccoDominante(rs.getString("TaroccoDominante"));
				personaggio.setIntuito(rs.getInt("Intuito"));
				personaggio.setAspetto(rs.getInt("Aspetto"));
				personaggio.setCoordinazione(rs.getInt("Coordinazione"));
				personaggio.setAffinOcculta(rs.getInt("AffinitaOcculta"));
				personaggio.setMemoria(rs.getInt("Memoria"));
				personaggio.setComando(rs.getInt("Comando"));
				personaggio.setDestrManuale(rs.getInt("DestrezzaManuale"));
				personaggio.setDistDaMorte(rs.getInt("DistanzaDallaMorte"));
				personaggio.setPercezione(rs.getInt("Percezione"));
				personaggio.setCreativita(rs.getInt("Creativita"));
				personaggio.setForzaFisica(rs.getInt("ForzaFisica"));
				personaggio.setEquilibrMentale(rs.getInt("EquilibrioMentale"));
				personaggio.setVolonta(rs.getInt("Volonta"));
				personaggio.setSocievolezza(rs.getInt("Socievolezza"));
				personaggio.setMira(rs.getInt("Mira"));
				personaggio.setKarma(rs.getInt("Karma"));
				personaggio.setRisoluzione(rs.getInt("Risoluzione"));
				personaggio.setFeritaTesta(rs.getString("FeriteTesta"));
				personaggio.setFeritaBraccia(rs.getString("FeriteBraccia"));
				personaggio.setFeritaTorso(rs.getString("FeriteTorso"));
				personaggio.setFeritaGambe(rs.getString("FeriteGambe"));
				personaggio.setUser(utente);
				personaggio.setStoria(setStoriaPersonaggio(personaggio));
				personaggio.aggiungiListaOggetti(aggiungiListaOggettiPG(personaggio));
				personaggio.aggiungiListaAbilita(aggiungiListaAbilitaPG(personaggio));
			}
		}finally {
			try {
				if(ps != null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return personaggio;
	}
	
	/****************************************************************************
	 * Metodo per recuperare una lista di abilita'								*
	 * @param pg= personaggio a cui sono associate le abilita'					*
	 * @return la lista di abilita'												*
	 ****************************************************************************/
	private Set<Abilita> aggiungiListaAbilitaPG(Personaggio pg)throws SQLException{
		AbilitaManager ability = new AbilitaManager();
		Collection<Abilita> listaAbilita = ability.getListaAbilitaByPG(pg);
		if(listaAbilita!=null) {
			Set<Abilita> abilitaPg = new HashSet<Abilita>(listaAbilita);
			return abilitaPg;
		}else return null;
	}
	
	/************************************************************************************
	 * Metodo per settare la storia al personaggio che accede a StoryManager			*
	 * @param pg= personaggio a cui associare la storia									*
	 * @return la storia a cui partecipa il personaggio 								*
	 ************************************************************************************/
	private Storia setStoriaPersonaggio(Personaggio pg)throws SQLException {
		StoryManager storyManager = new StoryManager();
		Storia storia = storyManager.getStoriaDelPG(pg);
		return storia;
	}
	
	/********************************************************************************************
	 * Metodo per settare la lista degli oggetti al personaggio che accede a EquipManager		*
	 * @param pg= personaggio a cui sono associati gli oggetti									*
	 * @return lista degli oggetti																*
	 ********************************************************************************************/
	private Set<Oggetto> aggiungiListaOggettiPG(Personaggio pg)throws SQLException{
		EquipManager manager = new EquipManager();
		Collection<Oggetto> listaOggetti = manager.getListaOggettiPG(pg);
		if(listaOggetti!=null) {
			Set<Oggetto> oggettiPg = new HashSet<Oggetto>(listaOggetti);
			return oggettiPg;
		}else return null;
	}
	
	
	
	/***********************************************************************************************
	 *  Metodo utilizzato per ottenere ID della storia a cui partecipa un personaggio			   *
	 * @param pg = personaggio a cui associare la storia 										   *
	 * @return id della storia del personaggio													   *
	 ***********************************************************************************************/
	public int getStoriaPersonaggioById(Personaggio pg) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int idStoria = 0;
		String selectIDStoria = "SELECT IDSTORY FROM " + TABLE_NAME_PG + " WHERE USERNAME = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectIDStoria);
			ps.setString(1, pg.getUsername());
			ResultSet rs = ps.executeQuery();
			System.out.println("getStoriaPersonaggioById" + ps.toString());
			
			while(rs.next()) {
				idStoria = rs.getInt("IdStory");
			}
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return idStoria;
	}
	
	/********************************************************************************
	 * Metodo per avere tutti i personaggi di una storia specifica					*
	 * @param storia= la storia a cui fanno riferimento i personaggi				*
	 * @return lista dei personaggi della storia									*
	 ********************************************************************************/
	public Collection<Personaggio> getAllPgByStory(Storia storia)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		Collection<Personaggio> listaPG = new LinkedList<Personaggio>();
		String selectPGStoria = "SELECT * FROM " + TABLE_NAME_PG + " WHERE IDSTORY = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(selectPGStoria);
			ps.setInt(1, storia.getId());
			ResultSet rs = ps.executeQuery();
			System.out.println("getAllPgByStory: " + ps.toString());
			while(rs.next()) {
				Personaggio personaggio = new Personaggio();
				personaggio.setIdStoria(rs.getInt("IdStory"));
				personaggio.setUsername(rs.getString("Username"));
				personaggio.setNome(rs.getString("Nome"));
				personaggio.setCognome(rs.getString("Cognome"));
				personaggio.setAge(rs.getInt("Eta"));
				personaggio.setNazionalita(rs.getString("Nazionalita"));
				personaggio.setTaroccoDominante(rs.getString("TaroccoDominante"));
				personaggio.setIntuito(rs.getInt("Intuito"));
				personaggio.setAspetto(rs.getInt("Aspetto"));
				personaggio.setCoordinazione(rs.getInt("Coordinazione"));
				personaggio.setAffinOcculta(rs.getInt("AffinitaOcculta"));
				personaggio.setMemoria(rs.getInt("Memoria"));
				personaggio.setComando(rs.getInt("Comando"));
				personaggio.setDestrManuale(rs.getInt("DestrezzaManuale"));
				personaggio.setDistDaMorte(rs.getInt("DistanzaDallaMorte"));
				personaggio.setPercezione(rs.getInt("Percezione"));
				personaggio.setCreativita(rs.getInt("Creativita"));
				personaggio.setForzaFisica(rs.getInt("ForzaFisica"));
				personaggio.setEquilibrMentale(rs.getInt("EquilibrioMentale"));
				personaggio.setVolonta(rs.getInt("Volonta"));
				personaggio.setSocievolezza(rs.getInt("Socievolezza"));
				personaggio.setMira(rs.getInt("Mira"));
				personaggio.setKarma(rs.getInt("Karma"));
				personaggio.setRisoluzione(rs.getInt("Risoluzione"));
				personaggio.setFeritaTesta(rs.getString("FeriteTesta"));
				personaggio.setFeritaBraccia(rs.getString("FeriteBraccia"));
				personaggio.setFeritaTorso(rs.getString("FeriteTorso"));
				personaggio.setFeritaGambe(rs.getString("FeriteGambe"));
				personaggio.setUser(getUserByPG(personaggio));
				personaggio.setStoria(storia);
				personaggio.aggiungiListaOggetti(aggiungiListaOggettiPG(personaggio));
				personaggio.aggiungiListaAbilita(aggiungiListaAbilitaPG(personaggio));
				listaPG.add(personaggio);
			}
		}finally {
			try {
				if(ps!=null)ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return listaPG;
	}
	
	/************************************************************************
	 * Metodo che recupera un utente in base al personaggio 				*
	 * @param pg= personaggio da cui recuperare la storia					*
	 * @return un utente associato alla storia								*
	 ************************************************************************/
	private User getUserByPG(Personaggio pg)throws SQLException {
		String username = pg.getUsername();
		UsersManager userMa = new UsersManager();
		User utente = userMa.doRetrieveByKey(username);
		return utente;
		
	}
	/******************************************************************************
	 * Metodo per avere una lista di PG di un utente							  *
	 * @return una lista di PG													  *
	 * @throws SQLException														  *
	 ******************************************************************************/
	public Collection<Personaggio> listaPG(User user) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		
		Collection<Personaggio> personaggi = new LinkedList<Personaggio>();
	
		String tuttiPG = "SELECT * FROM "+ TABLE_NAME_PG+ " WHERE USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(tuttiPG);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			System.out.println("listaPG: "+ps.toString());
			while(rs.next()) {
				
				Personaggio personaggio = new Personaggio();
				personaggio.setIdStoria(rs.getInt("IdStory"));
				personaggio.setUsername(rs.getString("Username"));
				personaggio.setNome(rs.getString("Nome"));
				personaggio.setCognome(rs.getString("Cognome"));
				personaggio.setAge(rs.getInt("Eta"));
				personaggio.setNazionalita(rs.getString("Nazionalita"));
				personaggio.setTaroccoDominante(rs.getString("TaroccoDominante"));
				personaggio.setIntuito(rs.getInt("Intuito"));
				personaggio.setAspetto(rs.getInt("Aspetto"));
				personaggio.setCoordinazione(rs.getInt("Coordinazione"));
				personaggio.setAffinOcculta(rs.getInt("AffinitaOcculta"));
				personaggio.setMemoria(rs.getInt("Memoria"));
				personaggio.setComando(rs.getInt("Comando"));
				personaggio.setDestrManuale(rs.getInt("DestrezzaManuale"));
				personaggio.setDistDaMorte(rs.getInt("DistanzaDallaMorte"));
				personaggio.setPercezione(rs.getInt("Percezione"));
				personaggio.setCreativita(rs.getInt("Creativita"));
				personaggio.setForzaFisica(rs.getInt("ForzaFisica"));
				personaggio.setEquilibrMentale(rs.getInt("EquilibrioMentale"));
				personaggio.setVolonta(rs.getInt("Volonta"));
				personaggio.setSocievolezza(rs.getInt("Socievolezza"));
				personaggio.setMira(rs.getInt("Mira"));
				personaggio.setKarma(rs.getInt("Karma"));
				personaggio.setRisoluzione(rs.getInt("Risoluzione"));
				personaggio.setFeritaTesta(rs.getString("FeriteTesta"));
				personaggio.setFeritaBraccia(rs.getString("FeriteBraccia"));
				personaggio.setFeritaTorso(rs.getString("FeriteTorso"));
				personaggio.setFeritaGambe(rs.getString("FeriteGambe"));				
				personaggio.setUser(user);
				personaggio.setStoria(setStoriaPersonaggio(personaggio));
				personaggio.aggiungiListaOggetti(aggiungiListaOggettiPG(personaggio));
				personaggio.aggiungiListaAbilita(aggiungiListaAbilitaPG(personaggio));
				personaggi.add(personaggio);
			}
		}finally {
			try {
				if(ps!=null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return personaggi;
	}
	
	
	
	/**********************************************************************************
	 * Metodo per la creazione del personaggio 										  *	
	 * @param pg= un oggetto personaggio											  *
	 * @param idPG= id del giocatore a cui è associato								  *
	 **********************************************************************************/
	
	public void creaPersonaggio(Personaggio pg, int idStoria) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String aggiungiPG = "INSERT INTO "+ TABLE_NAME_PG+" (NOME, COGNOME, ETA, NAZIONALITA, TAROCCODOMINANTE, "
				+ "INTUITO, ASPETTO, COORDINAZIONE, AFFINITAOCCULTA, MEMORIA, COMANDO, DESTREZZAMANUALE, DISTANZADALLAMORTE,"
				+ " PERCEZIONE, CREATIVITA, FORZAFISICA, EQUILIBRIOMENTALE, VOLONTA, SOCIEVOLEZZA, MIRA, KARMA, RISOLUZIONE, "
				+ "SALUTE, FERITETESTA, FERITETORSO, FERITEBRACCIA, FERITEGAMBE, USERNAME, IDSTORY) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(aggiungiPG);
			
			
			ps.setString(1, pg.getNome());
			ps.setString(2, pg.getCognome());
			ps.setInt(3, pg.getAge());
			ps.setString(4, pg.getNazionalita());
			ps.setString(5, pg.getTaroccoDominante());
			
			/*caratteristiche cuori*/
			ps.setInt(6, pg.getIntuito());
			ps.setInt(10, pg.getMemoria());
			ps.setInt(14, pg.getPercezione());
			ps.setInt(18, pg.getVolonta());

			/*caratteristiche quadri*/
			ps.setInt(7, pg.getAspetto());
			ps.setInt(11, pg.getComando());
			ps.setInt(15, pg.getCreativita());
			ps.setInt(20, pg.getSocievolezza());
			
			/*caratteristiche fiori*/
			ps.setInt(8, pg.getCoordinazione());
			ps.setInt(12, pg.getDestrManuale());
			ps.setInt(16, pg.getForzaFisica());
			ps.setInt(19, pg.getMira());
			
			/*caratteristiche picche*/
			ps.setInt(9, pg.getAffinOcculta());
			ps.setInt(13, pg.getDistDaMorte());
			ps.setInt(17, pg.getEquilibrMentale());
			ps.setInt(21, pg.getKarma());
			
			
			ps.setInt(22, pg.getRisoluzione());
			ps.setInt(23, pg.getSalute());
			
			ps.setString(24, pg.getFeritaTesta());
			ps.setString(25, pg.getFeritaTorso());
			ps.setString(26, pg.getFeritaBraccia());
			ps.setString(27, pg.getFeritaGambe());
		
			ps.setString(28, pg.getUsername());
			ps.setInt(29, pg.getIdStoria());
			
			System.out.println("creaPersonaggio: " + ps.toString());
			ps.executeUpdate();
			
			
			con.commit();
			
		}finally {
			try{
				if(ps != null) ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}


	
	/********************************************************************************************
	 * Metodo per aggiornare le ferite del personaggio											*
	 * @param idPG= id del personaggio a cui è associata la ferita								*
	 * @param areaFerita= parte del corpo a cui aggiungere la ferita							*
	 * @param danno= valore della ferita														*
	 ********************************************************************************************/
	public void updateFeritePg(int idPG, String areaFerita, int danno) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String addFerita = "UPDATE  "+TABLE_NAME_PG+" SET ?=? WHERE ID = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(addFerita);
			ps.setString(1, areaFerita);
			ps.setInt(2, danno);
			ps.setInt(3, idPG);
			
			System.out.println("updateFeritePg: "+ ps.toString());
			ps.executeUpdate();
			con.commit();
		
		}finally {
			try {
				if(ps != null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}
	
	
	/****************************************************************************
	 *  Metodo per eliminare un personaggio										*
	 * @param pg = personaggio da eliminare										*
	 * @return un valore che conferma l'avvenuta eliminazione					*
	 ****************************************************************************/
	public boolean eliminaPG(Personaggio pg) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaPG = "DELETE FROM " + TABLE_NAME_PG + " WHERE IDSTORY = ? AND USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaPG);
			ps.setInt(1, pg.getIdStoria());
			ps.setString(2, pg.getUsername());
			result = ps.executeUpdate();
			System.out.println("eliminaPG: " + ps.toString());
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