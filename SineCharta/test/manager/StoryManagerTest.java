package manager;


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
	private Storia storiaRecuperata;
	private Collection<Storia> listaStoria;
	private UsersManager userManager;
	private User utenteTest;
	private User utenteRecuperato;
	
	protected void setUp() throws SQLException, UserNotFoundException{
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
	}
	

	@Test
	public void testAggiungiStoria() throws SQLException, UserNullException{
		System.out.println("\n Running aggiungiStoria TEST: \n");
		//Utente moderatore che inserisce la storia
		userManager.doSave(utenteTest);
		//Storia da inserie
		storyManager.aggiungiStoria(storiaDaInserire);
		storyManager.aggiungiATable(utenteTest, 1);
		
		assertNotNull(utenteTest);
		assertNotNull(storiaDaInserire);
		assertNotNull(utenteTest);
		
		storiaRecuperata = storyManager.getSimpleStory(storyManager.selectLastId());
		assertNotNull(storiaRecuperata);
		
		storyManager.eliminaRiferimentoHaTable(utenteTest.getUsername(), storyManager.selectLastId());
		storyManager.eliminaStoria(storiaRecuperata.getId());
		userManager.eliminaUtente(utenteTest.getUsername());
		
		}


	
	@Test
	public void testGetStoria() throws SQLException, UserNullException, UserNotFoundException {
		System.out.println("\n Running getStoria TEST: \n");
		userManager.doSave(utenteTest);
		storyManager.aggiungiStoria(storiaDaInserire);
		storyManager.aggiungiATable(utenteTest, 1);
		assertNotNull(utenteTest);
		assertNotNull(storiaDaInserire);
		utenteRecuperato = userManager.doRetrieveByKey("utenteTestStory");
		assertNotNull(utenteRecuperato);
		
		listaStoria = storyManager.getStoria(utenteRecuperato);
		storyManager.eliminaRiferimentoHaTable(utenteTest.getUsername(), storyManager.selectLastId());
		storyManager.eliminaStoria(storyManager.selectLastId());
		userManager.eliminaUtente(utenteTest.getUsername());
		assertFalse(listaStoria.isEmpty());

	
	}


	@Test
	public void testGetStoriaByFlag() throws SQLException, UserNullException, UserNotFoundException {
		System.out.println("\n Running getStoriaByFlag TEST: \n");
		utenteTest.setRuolo("utenteGiocatore");
		userManager.doSave(utenteTest);
		storyManager.aggiungiStoria(storiaDaInserire);
		storyManager.aggiungiATable(utenteTest, 0);
		utenteTest.setRuolo("utenteModeratore");
		storiaDaInserire.setTitolo("TestByFLag2");
		storyManager.aggiungiStoria(storiaDaInserire);
		storyManager.aggiungiATable(utenteTest, 1);
		assertNotNull(utenteTest);
		assertNotNull(storiaDaInserire);
		utenteRecuperato = userManager.doRetrieveByKey("utenteTestStory");
		assertNotNull(utenteRecuperato);
		
		listaStoria = storyManager.getStoriaByFlag(utenteRecuperato, 0);
		assertFalse(listaStoria.isEmpty());
		
		storyManager.eliminaRiferimentoHaTable(utenteRecuperato.getUsername(), storyManager.selectLastId());
		storyManager.eliminaStoria(storyManager.selectLastId());
		storyManager.eliminaRiferimentoHaTable(utenteRecuperato.getUsername(), storyManager.selectLastId());
		storyManager.eliminaStoria(storyManager.selectLastId());
		userManager.eliminaUtente(utenteRecuperato.getUsername());
		
	}
	
	public void tearDown() {
		System.out.println("\n Running tearDown TEST: \n");
		storyManager = null;
		userManager = null;
		listaStoria.clear();
		storiaDaInserire = null;
		storiaRecuperata = null;
		utenteTest = null;
		utenteRecuperato = null;
	}
}
