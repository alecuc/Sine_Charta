package manager;

import java.sql.SQLException;

import org.junit.*;
import org.junit.Test;


import beans.SessioneDiGioco;
import beans.Storia;
import beans.User;
import exception.UserNotFoundException;
import junit.framework.TestCase;

public class SessioneManagerTest extends TestCase{
	
	private SessioneManager managerSessione;
	private UsersManager managerUs;
	private StoryManager managerStory;
	private SessioneDiGioco sessioneTest;
	private SessioneDiGioco sessioneRecuperata;
	private User utenteTest;
	private User utenteRecuperato;
	private Storia storiaTest;
	private Storia storiaRecuperata;
	private int idStoria;
	private int numSessioni;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("\n Running setUp: \n");
		managerUs = new UsersManager();
		managerStory = new StoryManager();
		managerSessione = new SessioneManager();
		utenteTest = new User();
		utenteRecuperato = new User();
		storiaTest = new Storia();
		storiaRecuperata = new Storia();
		sessioneTest = new SessioneDiGioco();
		sessioneRecuperata = new SessioneDiGioco();
		
		utenteTest.setUsername("testSessione");
		utenteTest.setName("testName");
		utenteTest.setSurname("testSurn");
		utenteTest.setEmail("testSessione@test");
		utenteTest.setPassword("test");
		utenteTest.setRuolo("utenteGiocatore");
		
		storiaTest.setTitolo("testSessione");
		storiaTest.setDescrizione("test test test");
		storiaTest.setAmbientazione("Sanctum Imperum");
		sessioneTest.setIdNumeroSessione(0);
		sessioneTest.setContenutoSessione("test contenuto");
		sessioneTest.setUsernameModeratore(utenteTest.getUsername());
		
		managerUs.doSave(utenteTest);
		managerStory.aggiungiStoria(storiaTest);
		idStoria = managerStory.selectLastId();
		managerStory.aggiungiATable(utenteTest, 1);
		sessioneTest.setIdStoria(idStoria);
		managerSessione.salvareSessioni(sessioneTest);
		

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("\n Running tearDown: \n");

		managerSessione.eliminaSessioni(idStoria, utenteTest.getUsername());
		managerStory.eliminaStoria(idStoria);
		managerStory.eliminaRiferimentoHaTable(utenteTest.getUsername(), idStoria);
		managerUs.eliminaUtente(utenteTest.getUsername());
		
		managerUs = null;
		managerStory = null;
		managerSessione = null;
		utenteTest = null;
		utenteRecuperato = null;
		storiaTest = null;
		storiaRecuperata = null;
		sessioneTest = null;
		sessioneRecuperata = null;
		idStoria = 0;
		numSessioni = 0;
	}

	@Test
	public void testRecuperoSessioneStoria() throws SQLException, UserNotFoundException {
		System.out.println("\n Running recuperoSessioneStoria TEST: \n");
		
		storiaRecuperata = managerStory.getSimpleStory(idStoria);
		utenteRecuperato = managerUs.doRetrieveByKey(utenteTest.getUsername());
		assertNotNull(storiaRecuperata);
		assertNotNull(utenteRecuperato);
		sessioneRecuperata = managerSessione.recuperoSessioneStoria(storiaRecuperata, utenteRecuperato, 0);
		assertNotNull(sessioneRecuperata);
		assertEquals(sessioneTest.getContenutoSessione(), sessioneRecuperata.getContenutoSessione());
		
	}

	

	@Test
	public void testGetNumeroSessioniStoria() throws SQLException {
		System.out.println("\n Running getNumeroSessioniStoria TEST: \n");
			
			storiaRecuperata = managerStory.getSimpleStory(idStoria);
			numSessioni = managerSessione.getNumeroSessioniStoria(storiaRecuperata);
			assertEquals(1, numSessioni);
		
	}

}
