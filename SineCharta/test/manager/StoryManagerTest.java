package manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.Storia;
import beans.User;
import exception.UserNotFoundException;
import exception.UserNullException;
import junit.framework.TestCase;

public class StoryManagerTest extends TestCase{

	private StoryManager storyManager;
	private Storia storiaDaInserire;
	private Storia storiaRecuperata;
	private Collection<Storia> listaStoria;
	private UsersManager userManager;
	private User utenteTest;
	private User utenteRecuperato;
	
	@Before
	protected void setUp() throws Exception{
		System.out.println("\n Running setUp \n");
		storyManager = new StoryManager();
		userManager = new UsersManager();
		utenteTest = new User();
		utenteRecuperato = new User();
		utenteTest.setName("testStory");
		utenteTest.setSurname("testSusrname");
		utenteTest.setUsername("utenteTestStory");
		utenteTest.setPassword("testPassword");
		utenteTest.setEmail("test@test");;
		utenteTest.setRuolo("utenteModeratore");
		listaStoria = new ArrayList<Storia>();
		storiaDaInserire = new Storia();
		storiaRecuperata = new Storia();
		storiaDaInserire.setTitolo("testTitolo");
		storiaDaInserire.setDescrizione("testDescrizioneStoria");
		storiaDaInserire.setAmbientazione("Sanctum Imperum");
		
		userManager.doSave(utenteTest);
		storyManager.aggiungiStoria(storiaDaInserire);
		storyManager.aggiungiATable(utenteTest, 1);
	}
	
	@After
	public void tearDown() throws SQLException {
		System.out.println("\n Running tearDown TEST: \n");
		storyManager.eliminaRiferimentoHaTable(utenteTest.getUsername(), storyManager.selectLastId());
		storyManager.eliminaStoria(storyManager.selectLastId());
		userManager.eliminaUtente(utenteTest.getUsername());

		storyManager = null;
		
		userManager = null;
		listaStoria.clear();
		storiaDaInserire = null;
		storiaRecuperata = null;
		utenteTest = null;
		utenteRecuperato = null;
	}

	
	
	@Test
	public void testGetStoria() throws SQLException, UserNullException, UserNotFoundException {
		System.out.println("\n Running getStoria TEST: \n");
		
		assertNotNull(utenteTest);
		assertNotNull(storiaDaInserire);
		
		utenteRecuperato = userManager.doRetrieveByKey("utenteTestStory");
		assertNotNull(utenteRecuperato);
		
		listaStoria = storyManager.getStoria(utenteRecuperato);
		
		assertFalse(listaStoria.isEmpty());

	
	}


	@Test
	public void testGetStoriaByFlag() throws SQLException, UserNullException, UserNotFoundException {
		System.out.println("\n Running getStoriaByFlag TEST: \n");
		
		utenteRecuperato = userManager.doRetrieveByKey("utenteTestStory");
		assertNotNull(utenteRecuperato);
		listaStoria = storyManager.getStoriaByFlag(utenteRecuperato, 1);
		
		assertFalse(listaStoria.isEmpty());
		
		
	}
	
}
