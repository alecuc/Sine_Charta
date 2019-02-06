package manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.User;
import exception.UserNotFoundException;
import junit.framework.TestCase;

public class UsersManagerTest extends TestCase{

	private UsersManager managerUser;
	private User userTest;
	private User userTestRetrieve;
	private Collection<User> listTest;
	private boolean check;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("\n Running setUp:");
		managerUser = new UsersManager();
		userTest = new User();
		userTestRetrieve = new User();
		listTest = new ArrayList<User>();
		check = false;
		
		userTest.setUsername("testUserManager");
		userTest.setName("test");
		userTest.setSurname("testeste");
		userTest.setEmail("testUser@test");
		userTest.setPassword("test");
		userTest.setRuolo("utenteModeratore");
		
		managerUser.doSave(userTest);
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("\n Running tearDown TEST:\n");
		managerUser.eliminaUtente(userTest.getUsername());
		listTest.clear();
		managerUser = null;
		userTest = null;
		userTestRetrieve = null;
	}

	@Test
	public void testDoRetrieveByKey() throws SQLException, UserNotFoundException {
		System.out.println("\n Running doRetrieveByKey: \n");
		
		userTestRetrieve = managerUser.doRetrieveByKey(userTest.getUsername());
		
		assertNotNull(userTest);
		assertNotNull(userTestRetrieve);
		assertEquals(userTest.getUsername(), userTestRetrieve.getUsername());
		assertEquals(userTest.getEmail(), userTestRetrieve.getEmail());
		assertEquals(userTest.getName(), userTestRetrieve.getName());
	}

	@Test
	public void testDoRetrieveAll() throws SQLException {
		System.out.println("\n Running doRetrieveAll TEST:\n");
		
		listTest = managerUser.doRetrieveAll(null);
		
		assertFalse(listTest.isEmpty());
		
		
	}

	@Test
	public void testCheckUser() throws SQLException {
		System.out.println("\n Running checkUser TEST:\n");
		
		check = managerUser.checkUser(userTest.getUsername());
		
		assertTrue(check);		
	}

}
