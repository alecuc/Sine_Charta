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
	 * Nomi delle tabelle all'interno del database che vengono utilizzate.
	 */
	private static final String TABLE_NAME_ABILITA = "Abilita";
	
	/********************************************************************************************
	 * Metodo che torna una singola abilita' di un personaggio									*
	 * @param pg= personaggio a cui è associata l'abilita'										*
	 * @param nome= nome dell'abilita'															*
	 * @return abilita' del personaggio 														*
	 ********************************************************************************************/
	public synchronized Abilita getAbilitaByName(Personaggio pg, String nome) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Abilita bean = new Abilita();
		String selectSQL = "SELECT * FROM " + AbilitaManager.TABLE_NAME_ABILITA + " WHERE NOME = ? AND USERNAME = ? AND IDSTORY = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, pg.getUsername());
			preparedStatement.setInt(3, pg.getIdStoria());
			System.out.println("getAbilitaByName: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setNome(rs.getString("Nome"));
				bean.setValore(rs.getInt("Valore"));
				bean.setPersonaggio(pg);
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



	/************************************************************************************************
	 * Metodo che ritorna una collezione di abilita in base al personaggio							*						
	 * @param pg= personaggio che possiede le abilità												*
	 * @return lista abilita del pg																	*
	 ************************************************************************************************/
	public synchronized Collection<Abilita> getListaAbilitaByPG(Personaggio pg) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		Collection<Abilita> listaAbilita = new LinkedList<Abilita>();
		String selectSQL = "SELECT * FROM " + AbilitaManager.TABLE_NAME_ABILITA + " WHERE USERNAME = ? AND IDSTORY = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			ps.setString(1, pg.getUsername());
			ps.setInt(2, pg.getIdStoria());
			System.out.println("getListaAbilitaByPG: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Abilita bean = new Abilita();
				bean.setNome(rs.getString("Nome"));
				bean.setValore(rs.getInt("Valore"));
				bean.setPersonaggio(pg);
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
	
	/********************************************************************************
	 * Metodo che aggiunge un abilita' ad un personaggio							*
	 * @param ability= abilita' da aggiunger										*
	 * @param pg= personaggio a cui è associata l'abilita'							*
	 ********************************************************************************/
	public synchronized void aggiungiAbilita(Abilita ability, Personaggio pg)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		String nuovoAbilita = "INSERT INTO " + TABLE_NAME_ABILITA + " (NOME, VALORE, USERNAME, IDSTORY) VALUES (?, ?, ?, ?)";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(nuovoAbilita);
			ps.setString(1, ability.getNome());
			ps.setInt(2, ability.getValore());
			ps.setString(3, pg.getUsername());
			ps.setInt(4, pg.getIdStoria());
			System.out.println("aggiungiAbilita: " + ps.toString());
			ps.executeUpdate();
			con.commit();
		}finally {
			try {
				if(ps!= null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}
	
	/************************************************************************************
	 * Metodo che elimina un abilita quando viene eliminato un personaggio 				*
	 * @param pg= personaggio associato all'abilità										*
	 * @return conferma dell'eliminazione avvenuta										*
	 ************************************************************************************/
	public synchronized boolean eliminaAbilita(Personaggio pg) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String eliminaAbilita = "DELETE FROM " + TABLE_NAME_ABILITA + " WHERE USERNAME = ? AND IDSTORY = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(eliminaAbilita);
			ps.setString(1, pg.getUsername());
			ps.setInt(2, pg.getIdStoria());
			System.out.println("eliminaAbilita: " + ps.toString());
			result = ps.executeUpdate();
			con.commit();
		}finally {
			try {
				if(ps!= null) ps.close();
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return (result!=0);
	}
}
