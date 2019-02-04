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

		/*****AmazonAWS Database****/
		//String username = "SineMaster";
		//String password = "SinePassword";
		//String url = "jdbc:mysql://sinechartadb.c4mcoif2kbyp.us-east-2.rds.amazonaws.com:3306/dbSineCharta";

		/*local DB*/

		// String username = "root";
		//String password = "12345";
		//String url = "jdbc:mysql://localhost:3306/dbsinecharta?useLegacyDatetimeCode=false&serverTimezone=UTC";


		String username = "sql7277168";
		String password = "vLrF71CFKY";
		String url = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7277168";
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
