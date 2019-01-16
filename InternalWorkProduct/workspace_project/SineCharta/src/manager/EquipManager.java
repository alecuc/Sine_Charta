package manager;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;

import beans.Oggetto;


public class EquipManager {

	
	private static final String TABLE_NAME_OGGETTI = "Oggetti";
	private static final String TABLE_NAME_ARMI = "Armi";
	
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

	public void inserisciOggetto(Oggetto oggetto, int idPersonaggio) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + EquipManager.TABLE_NAME_OGGETTI
				+ " (NOMEOGGETTO, PESO, COSTO, QUANTITA, ID) VALUES (?, ?, ?, ?, "+idPersonaggio+")";
		
		try {
			
			connection = DriverManagerConnectionPool.getConnection();
			
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, oggetto.getNome());
			preparedStatement.setString(2, String.valueOf(oggetto.getPeso()));
			preparedStatement.setString(3, String.valueOf(oggetto.getCosto()));
			preparedStatement.setString(4, String.valueOf(oggetto.getQuantita()));
			
			
			System.out.println("doSave: "+ preparedStatement.toString());
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

	
	public void aggiornaOggetto(Oggetto oggetto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public boolean rimuoviOggetto(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
