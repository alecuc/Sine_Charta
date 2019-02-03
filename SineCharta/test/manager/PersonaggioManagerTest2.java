/**
 *
 */
package manager;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.Personaggio;
import beans.Storia;
import beans.User;
import junit.framework.TestCase;

/**
 * @author Raf
 *
 */
public class PersonaggioManagerTest2 extends TestCase{

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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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

		personaggioTest.setUsername(utenteTest.getUsername());

		managerUser.doSave(utenteTest);

		managerStory.aggiungiStoria(storiaTest);
		managerStory.aggiungiATable(utenteTest, 0);
		personaggioTest.setIdStoria(managerStory.selectLastId());
		managerPg.creaPersonaggio(personaggioTest, managerStory.selectLastId());

	}


	@After
	public void tearDown() throws Exception {
		managerPg.eliminaPG(personaggioTest);
		managerStory.eliminaRiferimentoHaTable(personaggioTest.getUsername(), managerStory.selectLastId());
		managerStory.eliminaStoria(managerStory.selectLastId());
		managerUser.eliminaUtente(personaggioTest.getUsername());
		pgDaRecuperare = null;

	}


	@Test
	public void testGetSimplePGByStory() throws SQLException {
		System.out.println("Running getSimplePgByStory: \n");

		pgDaRecuperare = managerPg.getSimplePGByStory(utenteTest, managerStory.selectLastId());

		assertNotNull(pgDaRecuperare);
		assertTrue(utenteTest.getUsername().equals(pgDaRecuperare.getUsername()));
	}

	@Test
	public void testGetStoriaPersonaggioById() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetAllPgByStory() {
		fail("Not yet implemented");
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

	/**
	 * Test method for {@link manager.PersonaggioManager#eliminaPG(beans.Personaggio)}.
	 */
	@Test
	public void testEliminaPG() {
		fail("Not yet implemented");
	}

}
