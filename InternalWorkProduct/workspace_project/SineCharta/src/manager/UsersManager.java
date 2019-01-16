package manager;
import java.util.Collection;

import beans.User;

import java.sql.*;
import interfaces.UserModelI;

public class UsersManager implements UserModelI<User>{

	private static final String TABLE_NAME = "utenteRegistrato";

	
	@Override
	public User doRetrieveByKey(String user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		User bean = new User();
		String selectSql = "SELECT * FROM " + UsersManager.TABLE_NAME + " WHERE Username = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, user);
			System.out.println("doRetrieveByKey: " + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setName(rs.getString("name"));
				bean.setSurname(rs.getString("surname"));
				bean.setEmail(rs.getString("email"));
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

	@Override
	public Collection<User> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(User user) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + UsersManager.TABLE_NAME
				+ " (USERNAME, PASSWORD, EMAIL, NOME, COGNOME, RUOLO) VALUES (?, md5(?), ?, ?, ?, 'utenteModeratore')";
		
		try {
			System.out.println("Sono prima della query");

			connection = DriverManagerConnectionPool.getConnection();
			
			System.out.println("Sono DOPO della query");

			System.out.println("sono pre prepared");
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getName());
			preparedStatement.setString(5, user.getSurname());
			

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

	@Override
	public void doUpdate(User product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(String code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doUpName(String name) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
