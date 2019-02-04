package manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.Personaggio;
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
	private Collection<Storia> listStoria2;
	private UsersManager userManager;
	private User utenteTest;
	private User utenteRecuperato;
	private Personaggio personaggio;
	private int idStoria;
	
	@Before
	protected void setUp() throws Exception{
		System.out.println("\n Running setUp \n");
		storyManager = new StoryManager();
		userManager = new UsersManager();
		listaStoria = new ArrayList<Storia>();
		listStoria2 = new ArrayList<Storia>();
		storiaDaInserire = new Storia();
		storiaRecuperata = new Storia();
		utenteTest = new User();
		utenteRecuperato = new User();
		idStoria = 0;
		
		utenteTest.setName("testStory");
		utenteTest.setSurname("testSusrname");
		utenteTest.setUsername("utenteTestStory");
		utenteTest.setPassword("testPassword");
		utenteTest.setEmail("testStory@test");;
		utenteTest.setRuolo("utenteModeratore");
		
		storiaDaInserire.setTitolo("testTitolo");
		storiaDaInserire.setDescrizione("testDescrizioneStoria");
		storiaDaInserire.setAmbientazione("Sanctum Imperum");
		
		userManager.doSave(utenteTest);
		storyManager.aggiungiStoria(storiaDaInserire);
		storyManager.aggiungiATable(utenteTest, 1);
		idStoria = storyManager.selectLastId();
	}
	
	@After
	public void tearDown() throws SQLException {
		System.out.println("\n Running tearDown TEST: \n");
		storyManager.eliminaRiferimentoHaTable(utenteTest.getUsername(), idStoria);
		storyManager.eliminaStoria(idStoria);
		userManager.eliminaUtente(utenteTest.getUsername());

		storyManager = null;
		
		userManager = null;
		listaStoria.clear();
		listStoria2.clear();
		storiaDaInserire = null;
		storiaRecuperata = null;
		utenteTest = null;
		utenteRecuperato = null;
		idStoria = 0;
	}

	
	
	@Test
	public void testGetStoria() throws SQLException, UserNullException, UserNotFoundException {
		System.out.println("\n Running getStoria TEST: \n");
		
		assertNotNull(utenteTest);
		assertNotNull(storiaDaInserire);
		
		utenteRecuperato = userManager.doRetrieveByKey(utenteTest.getUsername());
		assertNotNull(utenteRecuperato);
		listaStoria = storyManager.getStoria(utenteRecuperato);
		
		assertFalse(listaStoria.isEmpty());

	
	}


	@Test
	public void testGetStoriaByFlag() throws SQLException, UserNullException, UserNotFoundException {
		System.out.println("\n Running getStoriaByFlag TEST: \n");
		
		utenteRecuperato = userManager.doRetrieveByKey(utenteTest.getUsername());
		assertNotNull(utenteRecuperato);
		listStoria2 = storyManager.getStoriaByFlag(utenteRecuperato, 1);
		
		assertFalse(listStoria2.isEmpty());
		
		
	}
	
	
	@Test
	public void testGetSimpleStory() throws SQLException {
		System.out.println("\n Running getSimpleStory TEST: \n");
		
	
		storiaRecuperata = storyManager.getSimpleStory(idStoria);
		assertNotNull(storiaRecuperata);
		assertEquals("testTitolo", storiaRecuperata.getTitolo());
		
	}
	
	@Test
	public void testGetStoriaDelPg()throws SQLException{
		System.out.println("\n Running getStoriaDelPg TEST: \n");
		
		personaggio = new Personaggio();
		personaggio.setIdStoria(idStoria);
		personaggio.setUser(utenteTest);
		personaggio.setStoria(storiaDaInserire);
		System.out.println(idStoria);
		storiaRecuperata = storyManager.getStoriaDelPG(personaggio);
		
		assertNotNull(storiaRecuperata);
		assertEquals("testTitolo", storiaRecuperata.getTitolo());
	}
}
