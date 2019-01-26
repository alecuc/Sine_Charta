package manager;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

import beans.Oggetto;
import beans.Personaggio;


public class EquipManager {

	/**
	 * Nomi delle tabelle all''interno del database che vengono utilizzate.
	 */
	private static final String TABLE_NAME_OGGETTI = "Oggetti";
	
	/****************************************************************************************
	 * Metodo che ritorna un oggetto associato al singolo personaggio						*
	 * @param idOggetto= id dell'oggetto 													*
	 * @param pg= personaggio a cui appartiene l'oggetto									*
	 * @return un oggetto selezionato														*
	 ****************************************************************************************/
	public Oggetto getOggettoPersonaggioById(Personaggio pg, int idOggetto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Oggetto bean = new Oggetto();
		String selectSQL = "SELECT * FROM " + EquipManager.TABLE_NAME_OGGETTI + " WHERE USERNAME = ? AND IDSTORY = ? AND IDOGGETTO = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, pg.getUsername());
			preparedStatement.setInt(2, pg.getIdStoria());
			preparedStatement.setInt(3, idOggetto);
			System.out.println("getOggettoPersonaggioById: " + preparedStatement.toString());			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setNome(rs.getString("NomeOggetto"));
				bean.setPeso(rs.getDouble("Peso"));
				bean.setCosto(rs.getDouble("Costo"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setIdStoria(rs.getInt("IdStory"));
				bean.setId_oggetto(rs.getInt("IdOggetto"));
				bean.setPersonaggioOggetto(pg);
			}
		}
		finally {
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

	/********************************************************************************************
	 * Metodo che ritorna una collezione di oggetti del personaggio								*			
	 * @param pg= personaggio a cui appartiene la lista di oggetti								*		
	 * @return una collezione di oggetti del personaggio										*
	 ********************************************************************************************/
	public Collection<Oggetto> getListaOggettiPG(Personaggio pg) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		Collection<Oggetto> oggetti = new LinkedList<Oggetto>();
		String selectSQL = "SELECT * FROM " + EquipManager.TABLE_NAME_OGGETTI + " WHERE USERNAME = ? AND IDSTORY  = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			ps.setString(1, pg.getUsername());
			ps.setInt(2, pg.getIdStoria());
			System.out.println("getListaOggettiPG: " + ps.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Oggetto bean = new Oggetto();
				bean.setNome(rs.getString("NomeOggetto"));
				bean.setPeso(rs.getDouble("Peso"));
				bean.setCosto(rs.getDouble("Costo"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setIdStoria(rs.getInt("IdStory"));
				bean.setId_oggetto(rs.getInt("IdOggetto"));
				bean.setPersonaggioOggetto(pg);
				oggetti.add(bean);
			}
		}finally {
			try {
				if(ps != null)
					ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		  }
		return oggetti;
	}
	
	
	/********************************************************************************************
	 * Metodo che inserisce un oggetto ad un personaggio.										*
	 * @param oggetto=  oggetto da inserire.													*
	 * @param pg= il personaggio a cui aggiungere l'oggetto.									*
	 * @throws SQLException= eccezione per eventuale query di inserimento errata.				*
	 ********************************************************************************************/
	public void inserisciOggetto(Oggetto oggetto, Personaggio pg) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO " + EquipManager.TABLE_NAME_OGGETTI
				+ " (NOMEOGGETTO, PESO, COSTO, QUANTITA, USERNAME, IDSTORY) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, oggetto.getNome());
			preparedStatement.setDouble(2, oggetto.getPeso());
			preparedStatement.setDouble(3, oggetto.getCosto());
			preparedStatement.setInt(4, oggetto.getQuantita());
			preparedStatement.setString(5, pg.getUsername());
			preparedStatement.setInt(6, pg.getIdStoria());
			System.out.println("inserisciOggetto: "+ preparedStatement.toString());
			preparedStatement.executeUpdate();	
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	/********************************************************************************************
	 * Metodo che rimuove un oggetto in base al personaggio a cui e' associato					*
	 * @param pg=  personaggio a cui viene rimosso l'oggetto									*
	 * @param oggetto= oggetto da rimuovere al personaggio										*
	 * @return un valore diverso da 0 per conferma dell'avvenuta eliminazione					*
	 ********************************************************************************************/
	public boolean rimuoviOggetto(Oggetto oggetto, Personaggio pg) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;
		String deletoObj = "DELETE FROM "+TABLE_NAME_OGGETTI+" WHERE IDOGGETTO = ? AND USERNAME = ? AND IDSTORY = ?";
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(deletoObj);
			ps.setInt(1, oggetto.getId_oggetto());
			ps.setString(2, pg.getUsername());
			ps.setInt(3, pg.getIdStoria());
			System.out.println("rimuoviOggetto: " + ps.toString());
			result = ps.executeUpdate();
			connection.commit();
		}finally {
			try {
				if(ps!=null) ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	/****************************************************************************************
	 * Metodo per aggiornare la quantita dell'oggetto del personaggio						*
	 * @param oggetto= oggetto a cui viene aggiornata la quantita 							*
	 * @param pg= personaggio a cui appartiene l'ogggeto									*
	 * @param newQuantity= quantita da inserire 											*
	 ****************************************************************************************/
	public void updateQuantitaOggetto(Oggetto oggetto, Personaggio pg, int newQuantity)throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		String updateOgg = "UPDATE " + TABLE_NAME_OGGETTI + " SET QUANTITA = ? WHERE IDOGGETTO = ? AND USERNAME = ? AND IDSTORY = ?";
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(updateOgg);
			ps.setInt(1, newQuantity);
			ps.setInt(2, oggetto.getId_oggetto());
			ps.setString(3, pg.getUsername());
			ps.setInt(4, pg.getIdStoria());
			System.out.println("upadteQuantitaOggetto: " + ps.toString());
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
}