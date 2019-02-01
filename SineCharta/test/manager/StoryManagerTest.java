package manager;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import org.junit.Test;

import beans.Storia;
import beans.User;
import exception.UserNotFoundException;
import exception.UserNullException;
import junit.framework.TestCase;

public class StoryManagerTest extends TestCase{

	private StoryManager storyManager;
	private Storia storiaDaInserire;
	private Collection<Storia> listaStoria;
	private UsersManager userManager;
	private User utenteTest;
	
	protected void setUp() throws SQLException, UserNotFoundException{
		System.out.println("\n Running setUp \n");
		storyManager = new StoryManager();
		userManager = new UsersManager();
		utenteTest = new User();
		utenteTest.setName("testStory");
		utenteTest.setSurname("testSusrname");
		utenteTest.setUsername("utenteTestStory");
		utenteTest.setPassword("testPassword");
		utenteTest.setEmail("test@test");;
		utenteTest.setRuolo("utenteModeratore");
		listaStoria = new ArrayList<Storia>();
		storiaDaInserire = new Storia();
		storiaDaInserire.setTitolo("testTitolo");
		storiaDaInserire.setDescrizione("testDescrizioneStoria");
		storiaDaInserire.setAmbientazione("Sanctum Imperum");
	}
	

	@Test
	public void testAggiungiStoria() throws SQLException, UserNullException{
		System.out.println("\n Running aggiungiStoria TEST: \n");
		userManager.doSave(utenteTest);
		storyManager.aggiungiStoria(storiaDaInserire);
		storyManager.aggiungiATable(storiaDaInserire, utenteTest, 1);
		listaStoria = storyManager.getStoria(utenteTest);
		int last = listaStoria.size();
		System.out.println(last);
		assertTrue(!storiaDaInserire.equals(null));
		assertNotNull(storiaDaInserire);
		assertNotNull(utenteTest);
		storyManager.eliminaRiferimentoHaTable(utenteTest.getUsername(), storiaDaInserire.getId());
		storyManager.eliminaStoria(storiaDaInserire.getId());
		userManager.eliminaUtente(utenteTest.getUsername());
		
		}

	@Test
	public void testAggiungiATable() throws SQLException {
		System.out.println("\n Running aggiungiATable TEST: \n");
		/*storyManager.aggiungiATable(storiaDaInserire, utenteTest, 0);
		assertNotNull(storiaDaInserire);
		assertNotNull(utenteTest);*/
	}
	
	@Test
	public void testGetStoria() throws SQLException {
		System.out.println("\n Running getStoria TEST: \n");
		listaStoria = storyManager.getStoria(utenteTest);
		assertFalse(listaStoria.isEmpty());
	}

	@Test
	public void testGetSimpleStory() {
		fail();
	}

	@Test
	public void testGetStoriaDelPG() {
		fail("Not yet implemented");
	}


	@Test
	public void testEliminaStoria() {
		System.out.println("\n Running eliminaStoria TEST: \n");
		fail();
	}

	@Test
	public void testEliminaRiferimentoHaTable() {
		
	}
	
	public void tearDown() {
		
	}
}
