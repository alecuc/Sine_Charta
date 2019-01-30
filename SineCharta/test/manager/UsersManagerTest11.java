package manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.*;

import beans.User;
import exception.UserNotFoundException;
import junit.framework.TestCase;

public class UsersManagerTest11 extends TestCase{

	private UsersManager _userManager;
	private User _anUser;
	private Collection<User> listaUtenti;
	
	public UsersManagerTest11(String name) {
		super(name);
	}
	
	protected void setUp() throws SQLException {
		_userManager = new UsersManager();
		listaUtenti = new ArrayList<User>();
		
	}
	@Test
	public void testDoRetrieveByKey() throws SQLException,UserNotFoundException {
		_anUser = _userManager.doRetrieveByKey("Vince");

		assertTrue(!_anUser.equals(null));
		assertTrue(_anUser.getUsername().equals("Vince"));
	
	}
	
	@Test
	public void testDoRetrieveAll()throws SQLException {
		listaUtenti = _userManager.doRetrieveAll("Nome");
		assertTrue(listaUtenti.isEmpty());
	}

	@Test
	public void testDoSave() {
		
	}

}
