package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import beans.Personaggio;
import beans.User;

public class PersonaggioManager {
	
	private static final String TABLE_NAME_PG = "Personaggio";
	
	
	/**
	 * Metodo utilizzato per prendere un personaggio in base alla storia a cui partecipa.
	 * @param idPG= valore id del personaggio
	 * @return il personaggio con tutte le informazioni
	 */
	public Personaggio getPersonaggioByUtente(User user) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		Personaggio personaggio = new Personaggio();
		String selectSQL = "SELECT * FROM "+PersonaggioManager.TABLE_NAME_PG+" WHERE USERNAME = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			ps.setString(1, user.getUsername());
			System.out.println("getPersonaggio: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
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
				//personaggio.setStoria(unaStoria);
			} 
			
		}finally {
				try {
					if(ps != null)
						ps.close();
				}finally {
					DriverManagerConnectionPool.releaseConnection(connection);
				}
	
		}
		return personaggio;
	}
	
		
	/**
	 * Metodo per avere una lista di PG di un utente
	 * @return una lista di PG
	 * @throws SQLException
	 */
	
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
			System.out.println("lista pers"+ps.toString());
			while(rs.next()) {
				
				Personaggio personaggio = new Personaggio();
				
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
	
	
	
	/**
	 * Metodo per la creazione del personaggio 
	 * @param pg= un oggetto personaggio
	 * @param idPG= id del giocatore a cui è associato
	 */
	
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


	
	/**
	 * Metodo per aggiornare le ferite del personaggio
	 * @param idPG= id del personaggio a cui è associata la ferita
	 * @param areaFerita= parte del corpo a cui aggiungere la ferita
	 * @param danno= valore della ferita
	 */
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
	
	public boolean eliminaPG(int idStoria, String username) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaPG = "DELETE FROM " + TABLE_NAME_PG + " WHERE IDSTORY = ? AND USERNAME = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaPG);
			ps.setInt(1, idStoria);
			ps.setString(2, username);
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



	/**
	 * Metodo per settare la storia al personaggio
	 * @param username= identificativo dell'utente a cui è associato il personaggio
	 * @param idStoria= identificativo della storia a cui partecipa il personaggio.
	 */
	/*public void setStoryForPG(String username, int idStoria)throws SQLException{
		StoryManager storyM = new StoryManager();
		Storia storia = storyM.getStoria(idStoria, username);
		Personaggio pg = this.getPersonaggioByUtente(idStoria, username);
		pg.setStoria(storia);
	}*/

	
	
	
	
}