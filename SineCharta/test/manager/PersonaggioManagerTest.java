package manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import beans.Personaggio;
import beans.Storia;
import beans.User;
import exception.UserNotFoundException;
import exception.UserNullException;
import junit.framework.TestCase;

public class PersonaggioManagerTest extends TestCase{

	

	private PersonaggioManager managerPg;
	private UsersManager managerUser;
	private StoryManager managerStory;
	
	private Personaggio personaggioTest;
	private Personaggio pgDaRecuperare;
	private User utenteTest;
	private Storia storiaTest;
	private Storia storiaRecuperata;
	private Collection<Personaggio> listaPg;
	private int id;
	
	protected void setUp() {
		System.out.println("\n Running setUp TEST: \n");
		managerStory = new StoryManager();
		managerPg = new PersonaggioManager();
		managerUser = new UsersManager();
		storiaTest = new Storia();
		storiaRecuperata = new Storia();
		utenteTest = new User();
		pgDaRecuperare = new Personaggio();
		personaggioTest = new Personaggio();
		listaPg = new ArrayList<Personaggio>();
		personaggioTest.setNome("testPG");
		personaggioTest.setCognome("testCogn");
		personaggioTest.setAge(50);
		personaggioTest.setNazionalita("testNati");
		personaggioTest.setTaroccoDominante("testTarocco");
		personaggioTest.setIntuito(5);
		personaggioTest.setAspetto(5);
		personaggioTest.setCoordinazione(5);
		personaggioTest.setAffinOcculta(5);
		personaggioTest.setMemoria(5);
		personaggioTest.setComando(5);
		personaggioTest.setDestrManuale(5);
		personaggioTest.setDistDaMorte(5);
		personaggioTest.setPercezione(5);
		personaggioTest.setCreativita(5);
		personaggioTest.setForzaFisica(5);
		personaggioTest.setEquilibrMentale(5);
		personaggioTest.setVolonta(5);
		personaggioTest.setSocievolezza(5);
		personaggioTest.setMira(5);
		personaggioTest.setKarma(5);
		personaggioTest.setRisoluzione(5);
		personaggioTest.setSalute(5);
		personaggioTest.setFeritaTesta("+");
		personaggioTest.setFeritaTorso("+");
		personaggioTest.setFeritaBraccia("+");
		personaggioTest.setFeritaGambe("+");
		
		utenteTest.setUsername("testPG");
		utenteTest.setName("testName");
		utenteTest.setSurname("testSurn");
		utenteTest.setEmail("test@test");
		utenteTest.setPassword("test");
		utenteTest.setRuolo("utenteGiocatore");
		
		storiaTest.setTitolo("testPGStoria");
		storiaTest.setDescrizione("test test test");
		storiaTest.setAmbientazione("Sanctum Imperum");
	}

	@Test
	public void testGetSimplePGByStory() throws SQLException, UserNullException {
		System.out.println("\n Running getSimplePGByStory TEST: \n");
		managerUser.doSave(utenteTest);
		managerStory.aggiungiStoria(storiaTest);
		managerStory.aggiungiATable(utenteTest, 0);
		personaggioTest.setUsername(utenteTest.getUsername());
		personaggioTest.setIdStoria(managerStory.selectLastId());
		managerPg.creaPersonaggio(personaggioTest, managerStory.selectLastId());
	
		pgDaRecuperare = managerPg.getSimplePGByStory(utenteTest, managerStory.selectLastId());
		managerPg.eliminaPG(personaggioTest);
		managerStory.eliminaRiferimentoHaTable(utenteTest.getUsername(), managerStory.selectLastId());
		managerStory.eliminaStoria(managerStory.selectLastId());
		managerUser.eliminaUtente(utenteTest.getUsername());
		assertNotNull(pgDaRecuperare);
		
		
	}

	@Test
	public void testGetStoriaPersonaggioById() throws SQLException, UserNullException {
		System.out.println("\n Running getStoriaPersonaggioById TEST: \n");
		managerUser.doSave(utenteTest);
		managerStory.aggiungiStoria(storiaTest);
		managerStory.aggiungiATable(utenteTest, 0);
		personaggioTest.setUsername(utenteTest.getUsername());
		personaggioTest.setIdStoria(managerStory.selectLastId());
		managerPg.creaPersonaggio(personaggioTest, personaggioTest.getIdStoria());
 		assertNotNull(personaggioTest);
 		assertNotNull(storiaTest);
		id = managerPg.getStoriaPersonaggioById(personaggioTest);
		managerPg.eliminaPG(personaggioTest);
		managerStory.eliminaRiferimentoHaTable(utenteTest.getUsername(), managerStory.selectLastId());
		managerStory.eliminaStoria(managerStory.selectLastId());
		managerUser.eliminaUtente(utenteTest.getUsername());
		
		assertTrue(id == managerStory.selectLastId());
		
	}

	@Test
	public void testGetAllPgByStory() throws SQLException, UserNullException, UserNotFoundException {
		System.out.println("\n Running getAllPgByStory TEST: \n");
		managerUser.doSave(utenteTest);
		managerStory.aggiungiStoria(storiaTest);
		managerStory.aggiungiATable(utenteTest, 0);
		personaggioTest.setUsername(utenteTest.getUsername());
		personaggioTest.setIdStoria(managerStory.selectLastId());
		managerPg.creaPersonaggio(personaggioTest, personaggioTest.getIdStoria());
		assertNotNull(utenteTest);
		assertNotNull(storiaTest);
		
		storiaRecuperata = managerStory.getSimpleStory(managerStory.selectLastId());
		assertNotNull(storiaRecuperata);
		listaPg = managerPg.getAllPgByStory(storiaRecuperata);
		System.out.println(listaPg.toString());
		managerPg.eliminaPG(personaggioTest);
		managerStory.eliminaRiferimentoHaTable(utenteTest.getUsername(), managerStory.selectLastId());
		managerStory.eliminaStoria(managerStory.selectLastId());
		managerUser.eliminaUtente(utenteTest.getUsername());
		assertFalse(listaPg.isEmpty());

	}

	@Test
	public void testListaPG() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreaPersonaggio() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateFeritePg() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminaPG() {
		fail("Not yet implemented");
	}

	
	protected void tearDown() {
		System.out.println("\n Running tearDown TEST: \n");
		managerPg = null;
		listaPg.clear();
		managerStory = null;
		managerUser = null;
		personaggioTest = null;
		pgDaRecuperare = null;
		utenteTest = null;
		storiaTest = null;
		id = 0;
	}
	
}
