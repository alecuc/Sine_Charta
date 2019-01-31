package manager;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import beans.User;
import exception.UserNotFoundException;
import junit.framework.TestCase;

public class UsersManagerTest extends TestCase{

	private UsersManager userManager;
	private User utenteDaTrovare;
	private User utenteInvalid;
	private Collection<User> listaUtenti;
	//private User utenteDaInserire;
	
	/*Simula le chiamate della servlet*/
	protected void setUp() {
		userManager = new UsersManager();
		listaUtenti = new ArrayList<User>();
		/*utenteDaInserire = new User();
		utenteDaInserire.setUsername("testUsername");
		utenteDaInserire.setName("testName");
		utenteDaInserire.setSurname("testSurname");
		utenteDaInserire.setPassword("testPassword");
		utenteDaInserire.setEmail("test@test.test");
		utenteDaInserire.setRuolo("utenteGiocatore");
		*/
	}
	
	
	/* Test su tutte le chiamate prima con valori verificati e poi con valori falsi*/
	@Test
	public void testDoRetrieveByKey() throws SQLException, UserNotFoundException{
		utenteDaTrovare = userManager.doRetrieveByKey("Raziel");
		assertNotNull(utenteDaTrovare);
		//assertFalse(utenteDaTrovare.getUsername().equals(null));
		
	
		
			utenteInvalid = userManager.doRetrieveByKey("prova");
			assertTrue(utenteInvalid.getUsername().equals(null));
		
		
		
	}

	@Test
	public void testDoRetrieveAll() throws SQLException{
		listaUtenti = userManager.doRetrieveAll(null);
		assertTrue(!listaUtenti.isEmpty());
	}

	@Test
	public void testDoSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminaUtente() {
		fail("Not yet implemented");
	}

	/*per rimuovere tutte le cose istanziate
	protected void tearDown() {
		fail();
	}*/
}
