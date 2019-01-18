package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Personaggio;

public class PersonaggioManager {
	
	private static final String TABLE_NAME_PG = "Personaggio";
	
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
	
	
	
}
