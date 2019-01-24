package manager;

public class SessioneManager {

	private static final String TABLE_NAME = "Sessione";

	/**
	 * metodo che carica una sessione in base alla propria chiave primaria
	 * @param numero il numero della sessione
	 * @param Username lo username dell'utente 
	 * @param idStoria l'id della storia a cui deve essere legata la sessione
	 * @return la sessione
	 * @throws SQLException
	 */
	public SessioneDiGioco prendereSessione(int numero, String Username, int idStoria) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		SessioneDiGioco bean = new SessioneDiGioco();
		String selectSql = "SELECT * FROM " + SessioneManager.TABLE_NAME + " WHERE Nome = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSql);
			preparedStatement.setString(1, Username);
			System.out.println("doRetrieveByKey: " + preparedStatement.toString());
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				bean.setIdNumeroSessione(rs.getInt("Numero"));
				bean.setContenutoSessione(rs.getString("Contenuto"));
				bean.setUsernameModeratore(rs.getString("Username"));
				bean.setIdStoria(rs.getInt("IdStory"));
			}
			
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}
			finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
			
		return bean;
	}

	/**
	 * metodo che aggiunge una istanza di keyword alla sessione
	 * @param numero il numero della sessione
	 * @param Username lo username di un utente
	 * @param idStoria l'id della storia legata alla sessione
	 * @throws SQLException
	 */
	public void addKeywordToSession(int numero, String Username, int idStoria) throws SQLException {
		
		SessioneDiGioco sessioneKeyword = new SessioneDiGioco();
		SessioneManager session = new SessioneManager();
		
		KeywordManager kwS = new KeywordManager();
		Keyword keywordSession = kwS.prendereKeyword(numero);
		
		sessioneKeyword = session.prendereSessione(numero, Username, idStoria);
		sessioneKeyword.aggiungiKeyword(keywordSession);
		 
	}
	
	/**
	 * Metodo che aggiunge la storia ad una sessione
	 * @param numero il numero della sessione
	 * @param Username lo username legato alla storia
	 * @param idStoria l'id della storia a cui legare la sessione
	 * @throws SQLException
	 */
/*	public void aggiungiStoriaAllaSessione (int numero, String Username, int idStoria) throws SQLException{
		
		StoryManager storiaManager = new StoryManager();
		Storia story = storiaManager.getStoria(idStoria, Username);
		SessioneDiGioco ssn = this.prendereSessione(numero, Username, numero);
		ssn.setStoriaSessione(story);
				
	}*/
	
	/**
	 * Metodo che carica la collezione di sessioni di una storia
	 * @param idStory l'id della storia 
	 * @return la collezione delle sessioni
	 * @throws SQLException
	 */
	public Collection<SessioneDiGioco> prendereTutteSessioni(int idStory) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		Collection<SessioneDiGioco> sessioni = new LinkedList<SessioneDiGioco>();
		String sessioniStoria = "SELECT * FROM " + TABLE_NAME + "WHERE IdStory = ? ";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement(sessioniStoria);
			ps.setInt(1, idStory);
			ResultSet rs = ps.executeQuery();
			System.out.println("listaSessioni: " + ps.toString());
			
			while(rs.next()) {
				SessioneDiGioco session = new SessioneDiGioco();
				
				session.setIdNumeroSessione(rs.getInt("Numero"));
				session.setContenutoSessione(rs.getString("Contenuto"));
				session.setUsernameModeratore(rs.getString("Username"));
				session.setIdStoria(rs.getInt("IdStory"));
				sessioni.add(session);
				
			}
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return sessioni;
	}

	
	/**
	 * Metodo che salva le sessioni nel database
	 * @param sessioneDiGioco la sessione di Gioco
	 * @throws SQLException
	 */
	public void salvareSessioni(SessioneDiGioco sessioneDiGioco) throws SQLException {
	
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		String creaSessione = "INSERT INTO " + TABLE_NAME
				+ " (NUMERO, CONTENUTO, USERNAME, IDSTORY) VALUES (?, ?, ?, ?)";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			preparedStatement = con.prepareStatement(creaSessione);
			
			preparedStatement.setInt(1, sessioneDiGioco.getIdNumeroSessione());
			preparedStatement.setString(2, sessioneDiGioco.getContenutoSessione());
			preparedStatement.setString(3, sessioneDiGioco.getUsernameModeratore());
			preparedStatement.setInt(4, sessioneDiGioco.getIdStoria());
			
			System.out.println("salvareSessione" + preparedStatement.toString());
			preparedStatement.executeUpdate();
			con.commit();
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}

	/**
	 * Metodo che permette di aggiornare il contenuto della sessione
	 * @param sessioneDiGioco la sessione di gioco
	 * @throws SQLException
	 */
	public void aggiornareSessioni(SessioneDiGioco sessioneDiGioco) throws SQLException {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		
		String modificaSessione = "UPDATE TABLE " + TABLE_NAME 
				+ " SET CONTENUTO = ? WHERE NUMERO = ? AND USERNAME = ? AND IDSTORY = ?";
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			preparedStatement = con.prepareStatement(modificaSessione);
			preparedStatement.setString(1, sessioneDiGioco.getContenutoSessione());
			preparedStatement.setInt(2, sessioneDiGioco.getIdNumeroSessione());
			preparedStatement.setString(3, sessioneDiGioco.getUsernameModeratore());
			preparedStatement.setInt(4, sessioneDiGioco.getIdStoria());
			
			System.out.println("aggiornaSessione: " + preparedStatement.toString());
			con.commit();
			
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}

	
	public boolean doDelete(String code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void doUpName(String name) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

}
