package manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {

	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:"+ e.getMessage());
		} 
	}
	
	private static synchronized Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		
		/*****AmazonAWS Database*****/
		String username = "SineMaster";
		String password = "SinePassword";
		String url = "jdbc:mysql://sinechartadb.c2ozuap0txvr.eu-west-2.rds.amazonaws.com:3306/dbSineCharta";
		/*old DB*/
		/*String username = "sql7274119";
		String password = "bR7ZUVIv9b";
		String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7274119";*/
		newConnection = DriverManager.getConnection(url, username, password);
	
		newConnection.setAutoCommit(false);
		return newConnection;
	}

	
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();		
		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if(connection != null) freeDbConnections.add(connection);
	}


}
