package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Personaggio;

public class PersonaggioManager {
	
	private static final String TABLE_NAME_PG = "Personaggio";
	
	
	/**
	 * Metodo utilizzato per prendere un personaggio in base all'id del giocatore.
	 * @param idPG= valore id del personaggio
	 * @return il personaggio con tutte le informazioni
	 */
	public Personaggio getPersonaggio(int idPG) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		Personaggio personaggio = new Personaggio();
		String selectSQL = "SELECT * FROM "+PersonaggioManager.TABLE_NAME_PG+" WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			ps.setInt(1, idPG);
			System.out.println("getPersonaggio: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				personaggio.setId(rs.getInt("Id"));
				personaggio.setNome(rs.getString("Nome"));
				personaggio.setCognome(rs.getString("Cognome"));
				personaggio.setAge(rs.getInt("Et‡"));
				personaggio.setNazionalita(rs.getString("Nazionalit‡"));
				personaggio.setTaroccoDominante(rs.getString("TaroccoDominante"));
				personaggio.setIntuito(rs.getInt("Intuito"));
				personaggio.setAspetto(rs.getInt("Aspetto"));
				personaggio.setCoordinazione(rs.getInt("Coordinazione"));
				personaggio.setAffinOcculta(rs.getInt("Affinit‡Occulta"));
				personaggio.setMemoria(rs.getInt("Memoria"));
				personaggio.setComando(rs.getInt("Comando"));
				personaggio.setDestrManuale(rs.getInt("DestrezzaManuale"));
				personaggio.setDistDaMorte(rs.getInt("DistanzaDallaMorte"));
				personaggio.setPercezione(rs.getInt("Percezione"));
				personaggio.setCreativita(rs.getInt("Creativit‡"));
				personaggio.setForzaFisica(rs.getInt("ForzaFisica"));
				personaggio.setEquilibrMentale(rs.getInt("EquilibrioMentale"));
				personaggio.setVolonta(rs.getInt("Volont‡"));
				personaggio.setSocievolezza(rs.getInt("Socievolezza"));
				personaggio.setMira(rs.getInt("Mira"));
				personaggio.setKarma(rs.getInt("Karma"));
				personaggio.setRisoluzione(rs.getInt("Risoluzione"));
				personaggio.setFerite(rs.getString("Ferite"));
				personaggio.setUsername(rs.getString("Username"));
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
	 * Metodo per la creazione del personaggio 
	 * @param pg= un oggetto personaggio
	 * @param idPG= id del giocatore a cui Ë associato
	 */
	
	public void creaPersonaggio(Personaggio pg, int idPG) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String aggiungiPG = "INSERT INTO "+ TABLE_NAME_PG+" (ID, NOME, COGNOME, ET‡, NAZIONALIT‡, TAROCCODOMINANTE, "
				+ "INTUITO, ASPETTO, COORDINAZIONE, AFFINIT‡OCCULTA, MEMORIA, COMANDO, DESTREZZAMANUALE, DISTANZADALLAMORTE,"
				+ " PERCEZIONE, CREATIVIT‡, FORZAFISICA, EQUILIBRIOMENTALE, VOLONT‡, SOCIEVOLEZZA, MIRA, KARMA, RISOLUZIONE, SALUTE, FERITE, USERNAME) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(aggiungiPG);
			
			ps.setInt(1, pg.getId());
			ps.setString(2, pg.getNome());
			ps.setString(3, pg.getCognome());
			ps.setInt(4, pg.getAge());
			ps.setString(5, pg.getNazionalita());
			ps.setString(6, pg.getTaroccoDominante());
			
			/*caratteristiche cuori*/
			ps.setInt(7, pg.getIntuito());
			ps.setInt(11, pg.getMemoria());
			ps.setInt(15, pg.getPercezione());
			ps.setInt(19, pg.getVolonta());

			/*caratteristiche quadri*/
			ps.setInt(8, pg.getAspetto());
			ps.setInt(12, pg.getComando());
			ps.setInt(16, pg.getCreativita());
			ps.setInt(21, pg.getSocievolezza());
			
			/*caratteristiche fiori*/
			ps.setInt(9, pg.getCoordinazione());
			ps.setInt(13, pg.getDestrManuale());
			ps.setInt(17, pg.getForzaFisica());
			ps.setInt(20, pg.getMira());
			
			/*caratteristiche picche*/
			ps.setInt(10, pg.getAffinOcculta());
			ps.setInt(14, pg.getDistDaMorte());
			ps.setInt(18, pg.getEquilibrMentale());
			ps.setInt(22, pg.getKarma());
			
			
			ps.setInt(23, pg.getRisoluzione());
			ps.setInt(24, pg.getSalute());
			ps.setString(25, pg.getFerite());
			ps.setString(26, pg.getUsername());
			
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
	
	
	public void updateFeritePg(int idPG) throws SQLException{
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String addFerita = " "+TABLE_NAME_PG+" ";		
	}
	
	
}
