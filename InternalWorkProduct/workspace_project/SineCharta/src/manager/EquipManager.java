package manager;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

import beans.Arma;
import beans.Oggetto;


public class EquipManager {

	/**
	 * Nomi delle tabelle all''interno del database che vengono utilizzate.
	 */
	private static final String TABLE_NAME_OGGETTI = "Oggetti";
	private static final String TABLE_NAME_ARMI = "Armi";
	
	/**
	 * Metodo che ritorna un oggetto in base a id dell'input
	 * @param idOggetto= id dell'oggetto 
	 * @return un oggetto selezionato
	 */
	public Oggetto getOggettoId(int idOggetto) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Oggetto bean = new Oggetto();
		String selectSQL = "SELECT * FROM " + EquipManager.TABLE_NAME_OGGETTI + " WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idOggetto);
			System.out.println("getOggettoId: " + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				bean.setNome(rs.getString("NomeOggetto"));
				bean.setPeso(rs.getInt("Peso"));
				bean.setCosto(rs.getInt("Costo"));
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

	/**
	 * Metodo che ritorna una collezione di oggetti in base al tipo dell'oggetto dato in input
	 * @param tipoOggetto= il tipo dell'oggetto (Es. arma, armatura, materiali ecc..)
	 * @return una collezione di oggetti di quel tipo specifico
	 */
	
	public Collection<Oggetto> getListaOggettiTipo(String tipoOggetto) throws SQLException{
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		Collection<Oggetto> oggetti = new LinkedList<Oggetto>();
		
		String selectSQL = "SELECT * FROM " + EquipManager.TABLE_NAME_OGGETTI + " WHERE TIPO = "+"'"+tipoOggetto+"'";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			System.out.println("getListaOggettiTipo: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Oggetto bean = new Oggetto();
				
				bean.setNome(rs.getString("NomeOggetto"));
				bean.setPeso(rs.getInt("Peso"));
				bean.setCosto(rs.getInt("Costo"));
				
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
	
	
	/**
	 * Metodo che ritorna tutta una collezione di oggetti che sono equipaggiati da un personaggio specifico.
	 * @param order= ordine in cui vengono selezionati
	 * @param idPersonaggio= id personaggio a cui sono associati gli oggetti
	 * @return una lista di oggetti ordinata del personaggio
	 */

	public Collection<Oggetto> getListaOggettiPG(String order, int idPersonaggio) throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		
		Collection<Oggetto> oggetti = new LinkedList<Oggetto>();
		
		String selectSQL = "SELECT * FROM " + EquipManager.TABLE_NAME_OGGETTI + "WHERE ID = " + "'" + idPersonaggio + "'";
		
		if(order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			System.out.println("getListaOggettiPG: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Oggetto bean = new Oggetto();
				
				bean.setNome(rs.getString("NomeOggetto"));
				bean.setPeso(rs.getInt("Peso"));
				bean.setCosto(rs.getInt("Costo"));
				
				oggetti.add(bean);
			}
		
		} finally {
			try {
				if(ps != null)
					ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		  }
		
		return oggetti;
		
	}

	/**
	 * Metodo che inserisce un oggetto ad un personaggio.
	 * @param oggetto= è l'oggetto da inserire.
	 * @param idPersonaggio= è l'identificativo del personaggio a cui aggiungere l'oggetto.
	 * @throws SQLException= eccezione per eventuale query di inserimento errata.
	 */
	public void inserisciOggetto(Oggetto oggetto, int idPersonaggio) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO " + EquipManager.TABLE_NAME_OGGETTI
				+ " (NOMEOGGETTO, PESO, COSTO, QUANTITA, ID) VALUES (?, ?, ?, ?, "+"'"+idPersonaggio+"'"+")";
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, oggetto.getNome());
			preparedStatement.setString(2, String.valueOf(oggetto.getPeso()));
			preparedStatement.setString(3, String.valueOf(oggetto.getCosto()));
			preparedStatement.setString(4, String.valueOf(oggetto.getQuantita()));
			
			
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
	
	/**
	 * Metodo che rimuove un oggetto in base a ID del personaggio a cui è associato
	 * @param id= del personaggio a cui viene rimosso l'oggetto
	 * @return un valore diverso da 0 per conferma dell'avvenuta eliminazione
	 */
	public boolean rimuoviOggetto(int idPG) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;
		String deletoObj = "DELETE FROM "+TABLE_NAME_OGGETTI+" WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(deletoObj);
			ps.setInt(1, idPG);
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
	
	
	
	/**
	 * Metodo per inserire un arma al personaggio
	 * @param armaDaInserire= un tipo di arma
	 * @throws SQLException 
	 * 
	 */
	public void inserisciArma(Arma armaDaInserire) throws SQLException {
	
		Connection connection = null;
		PreparedStatement ps = null;
		String insertSQL = "INSERT INTO " + TABLE_NAME_ARMI + " (ID, TIPO, MODELLO, DANNO, MUNIZIONE, RICARICA, NOMEOGGETTO)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {

			connection = DriverManagerConnectionPool.getConnection();

			ps = connection.prepareStatement(insertSQL);
			ps.setInt(1, armaDaInserire.getId());
			ps.setString(2, armaDaInserire.toStringArma());
			ps.setString(3, armaDaInserire.getModello());
			ps.setInt(4, armaDaInserire.getDanno());
			ps.setString(5, armaDaInserire.getMunizione());
			ps.setInt(6, armaDaInserire.getRicarica());
			ps.setString(7, armaDaInserire.getNome());
			
			
			System.out.println("inserisciArma: "+ ps.toString());
			ps.executeUpdate();



			connection.commit();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}

	}

	/**
	 * Metodo per avere tutta la lista di armi di uno specifico personaggio
	 * @param order= ordine in cui vengono mostrati
	 * @param idPersonaggio= id del personaggio a cui sono associate le armi
	 * @return la lista delle armi del personaggio
	 */
	
	public Collection<Arma> getListaArmiPG(String order, int idPersonaggio) throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		
		Collection<Arma> armi = new LinkedList<Arma>();
		
		String selectSQL = "SELECT * FROM " + EquipManager.TABLE_NAME_ARMI + "WHERE ID = " + "'" + idPersonaggio + "'";
		
		if(order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(selectSQL);
			System.out.println("getListaArmiiPG: " + ps.toString());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Arma bean = new Arma();
				bean.setId(rs.getInt("Id"));
				String arma = rs.getString("Tipo");
				if(arma.equalsIgnoreCase("pistola")) {
					bean.setPistola();
				}else if(arma.equalsIgnoreCase("mitra")) {
					bean.setMitra();
				} else bean.setFucile();
				bean.setModello(rs.getString("Modello"));
				bean.setDanno(rs.getInt("Danno"));
				bean.setMunizione(rs.getString("Munizione"));
				bean.setRicarica(rs.getInt("Ricarica"));
				bean.setNome(rs.getString("NomeOggetto"));
				
				
				armi.add(bean);
			}
		
		} finally {
			try {
				if(ps != null)
					ps.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		  }
		
		return armi;
		
	}
	
	/**
	 * Metedo per rimuovere un arma da un personaggio
	 * @param id= id del personaggio a cui è associata l'arma
	 * @return conferma dell'eliminazione dell'arma del personaggio
	 */
	public boolean deleteArma(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;
		String deleteArma = "DELETE FROM "+TABLE_NAME_ARMI+" WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			ps = connection.prepareStatement(deleteArma);
			ps.setInt(1, id);
			System.out.println("rimuoviArma: " + ps.toString());
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

}
