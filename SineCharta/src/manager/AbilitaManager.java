package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import beans.Abilita;
import beans.Personaggio;

public class AbilitaManager {

	/**
	 * Nomi delle tabelle all''interno del database che vengono utilizzate.
	 */
	private static final String TABLE_NAME_ABILITA = "Abilita";
	
	
	public Abilita getAbilitaByName(String nome) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Abilita bean = new Abilita();
		String selectSQL = "SELECT * FROM " + AbilitaManager.TABLE_NAME_ABILITA + " WHERE  NOME = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome);
			System.out.println("getAbilitaByName: " + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				bean.setNome(rs.getString("Nome"));
				bean.setValore(rs.getInt("Valore"));
			}
		}finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
			}
		 finally {
			DriverManagerConnectionPool.releaseConnection(connection);
		 }
		}
		
		return bean;
		
	}



	/**
	 * Metodo che ritorna una collezione di abilita in base al personaggio associato all'utente
	 * @param username= identificativo dell'utente 
	 * @param idStoria= identificativo della storia in cui � presente il personaggio
	 * @return lista abilita del pg
	 */
	public Collection<Abilita> getListaAbilitaByPG(String username, int idStoria) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		Collection<Abilita> listaAbilita = new LinkedList<Abilita>();
		
		String selectSQL = "SELECT * FROM " + AbilitaManager.TABLE_NAME_ABILITA + " WHERE USERNAME = ? AND IDSTORY = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			ps.setString(1, username);
			ps.setInt(2, idStoria);
			System.out.println("getListaAbilitaByPG: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Abilita bean = new Abilita();
				
				bean.setNome(rs.getString("Nome"));
				bean.setValore(rs.getInt("Valore"));
				
				listaAbilita.add(bean);
			}
		}finally {
			try {
				if(ps != null)
					ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		  }
		
		return listaAbilita;
		
		
	}
	
	/**
	 * Metodo che aggiunge un personaggio ad una abilit�
	 * @param username= identificativo dell'utente a cui appartiene il personaggio
	 * @param idStoria= identificativo della storia a cui partecipa il personaggio
	 * @param nome= identificativo dell'abilita
	 */
	public void aggiugiPGaOggetto(String nome, int idStoria, String username)throws SQLException {
		Personaggio pg = new Personaggio();
		PersonaggioManager pgM = new PersonaggioManager();
		pg = pgM.getPersonaggioByUtente(idStoria, username);
		Abilita abilita = this.getAbilitaByName(nome);
		abilita.setAbilitaPG(pg);
	}
	
	

	
	
}
