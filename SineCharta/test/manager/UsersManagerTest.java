package manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import beans.User;
import exception.UserNotFoundException;
import exception.UserNullException;
import junit.framework.TestCase;

public class UsersManagerTest extends TestCase{

	private UsersManager userManager;
	private User utenteDaTrovare;
	private User utenteInvalid;
	private User utenteDaInserire;
	private User utenteTestInserito;
	private Collection<User> listaUtenti;
	//private User utenteDaInserire;
	
	/*Simula le chiamate della servlet*/
	protected void setUp() {
		System.out.println("\n Running setUP \n");
		userManager = new UsersManager();
		utenteDaTrovare = new User();
		utenteTestInserito = new User();
		utenteDaInserire = new User();
		utenteInvalid = new User();
		listaUtenti = new ArrayList<User>();
		utenteDaInserire.setUsername("testUsername");
		utenteDaInserire.setName("testName");
		utenteDaInserire.setSurname("testSurname");
		utenteDaInserire.setPassword("testPassword");
		utenteDaInserire.setEmail("test@test.test");
		utenteDaInserire.setRuolo("utenteGiocatore");

	}	
	
	/* Test su tutte le chiamate prima con valori verificati e poi con valori falsi*/

	
	@Test
	public void testDoSave() throws SQLException,UserNullException, UserNotFoundException{
		System.out.println("\n Running doSave TEST: \n");
		userManager.doSave(utenteDaInserire);
		assertNotNull(utenteDaInserire);
		utenteTestInserito = userManager.doRetrieveByKey(utenteDaInserire.getUsername());
		assertNotNull(utenteTestInserito);
		assertEquals(utenteDaInserire.getUsername(), utenteTestInserito.getUsername());
		userManager.eliminaUtente("testUsername");

	}
	
	@Test
	public void testDoRetrieveByKey() throws SQLException, UserNotFoundException, UserNullException{
		System.out.println("\n Running doRetrieveByKey TEST: \n");
		userManager.doSave(utenteDaInserire);
		utenteDaTrovare = userManager.doRetrieveByKey("testUsername");
		assertEquals(utenteDaInserire.getUsername(), utenteDaTrovare.getUsername());
		userManager.eliminaUtente("testUsername");
		utenteInvalid = userManager.doRetrieveByKey("prova");
		assertEquals(null, utenteInvalid.getUsername());
	}

	@Test
	public void testDoRetrieveAll() throws SQLException{
		System.out.println("\n Running doRetrieveAll TEST: \n");
		listaUtenti = userManager.doRetrieveAll(null);
		assertFalse(listaUtenti.isEmpty());
		
	}

	@Test
	public void testEliminaUtente() throws SQLException, UserNotFoundException, UserNullException{
		System.out.println("\n Running eliminaUtente TEST: \n");
		userManager.doSave(utenteDaInserire);
		userManager.eliminaUtente("testUsername");
		utenteDaTrovare = userManager.doRetrieveByKey("testUsername");
		assertFalse(utenteDaInserire.getUsername()==utenteDaTrovare.getUsername());
	}

	/*per rimuovere tutte le cose istanziate*/
	protected void tearDown() throws SQLException{
		System.out.println("\n Running tearDown \n");
		userManager = null;
		listaUtenti.clear();
		utenteDaInserire = null;
		utenteDaTrovare = null;
		
		
	}
}
