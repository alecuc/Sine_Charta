package manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import beans.Personaggio;
import beans.Storia;
import beans.User;
import exception.UserNotFoundException;
import junit.framework.TestCase;

public class PersonaggioManagerTest extends TestCase{

	private StoryManager managerStory;
	private PersonaggioManager managerPg;
	private UsersManager managerUser;
	private Storia storiaTest;
	private Storia storiaRecuperata;
	private User utenteTest;
	private User userTest2;
	private User utenteRecuperato;
	private Personaggio pgDaRecuperare;
	private Personaggio personaggioTest;
	private Personaggio persTest2;
	private Collection<Personaggio> listaPg;
	private int idStoria;
	
	public void setUp() throws Exception {
		System.out.println("\n Running setUp: \n");
		managerStory = new StoryManager();
		managerPg = new PersonaggioManager();
		managerUser = new UsersManager();
		storiaTest = new Storia();
		storiaRecuperata = new Storia();
		utenteTest = new User();
		userTest2 = new User();
		personaggioTest = new Personaggio();
		pgDaRecuperare = new Personaggio();
		persTest2 = new Personaggio();
		listaPg = new ArrayList<Personaggio>();
		utenteRecuperato = new User();
		idStoria = 0;
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
		
		persTest2.setNome("testPG2");
		persTest2.setCognome("testCogn2");
		persTest2.setAge(50);
		persTest2.setNazionalita("testNati");
		persTest2.setTaroccoDominante("testTarocco");
		persTest2.setIntuito(5);
		persTest2.setAspetto(5);
		persTest2.setCoordinazione(5);
		persTest2.setAffinOcculta(5);
		persTest2.setMemoria(5);
		persTest2.setComando(5);
		persTest2.setDestrManuale(5);
		persTest2.setDistDaMorte(5);
		persTest2.setPercezione(5);
		persTest2.setCreativita(5);
		persTest2.setForzaFisica(5);
		persTest2.setEquilibrMentale(5);
		persTest2.setVolonta(5);
		persTest2.setSocievolezza(5);
		persTest2.setMira(5);
		persTest2.setKarma(5);
		persTest2.setRisoluzione(5);
		persTest2.setSalute(5);
		persTest2.setFeritaTesta("+-");
		persTest2.setFeritaTorso("+-");
		persTest2.setFeritaBraccia("-+");
		persTest2.setFeritaGambe("+-");
		
		utenteTest.setUsername("testPersonaggio");
		utenteTest.setName("testName");
		utenteTest.setSurname("testSurn");
		utenteTest.setEmail("test@test1222");
		utenteTest.setPassword("test");
		utenteTest.setRuolo("utenteGiocatore");
		
		userTest2.setUsername("test2");
		userTest2.setName("testtst");
		userTest2.setSurname("suer");
		userTest2.setPassword("test");
		userTest2.setEmail("test2@test");
		userTest2.setRuolo("utenteGiocatore");
		
		storiaTest.setTitolo("testPGStoria");
		storiaTest.setDescrizione("test test test");
		storiaTest.setAmbientazione("Sanctum Imperum");
		
		
		personaggioTest.setUsername(utenteTest.getUsername());
		persTest2.setUsername(userTest2.getUsername());
		
		managerUser.doSave(utenteTest);
		managerUser.doSave(userTest2);
		managerStory.aggiungiStoria(storiaTest);
		managerStory.aggiungiATable(utenteTest, 0);
		managerStory.aggiungiATable(userTest2, 0);
		idStoria = managerStory.selectLastId();
		personaggioTest.setIdStoria(idStoria);
		persTest2.setIdStoria(idStoria);
		managerPg.creaPersonaggio(personaggioTest, idStoria);
		managerPg.creaPersonaggio(persTest2, idStoria);
	}

	
	
	public void tearDown() throws Exception {
		System.out.println("\n Running tearDown: \n");
		managerStory.eliminaRiferimentoHaTable(personaggioTest.getUsername(), idStoria);
		managerStory.eliminaRiferimentoHaTable(userTest2.getUsername(), idStoria);
		managerStory.eliminaStoria(idStoria);
		managerPg.eliminaPG(personaggioTest);
		managerPg.eliminaPG(persTest2);
		managerUser.eliminaUtente(personaggioTest.getUsername());
		managerUser.eliminaUtente(userTest2.getUsername());
		
		
		managerStory = null;
		managerPg = null;
		managerUser = null;
		storiaTest = null;
		storiaRecuperata = null;
		utenteTest = null;
		pgDaRecuperare = null;
		personaggioTest = null;
		userTest2 = null;
		utenteRecuperato = null;
		persTest2 = null;
		listaPg.clear();
		idStoria = 0;
	}

	@Test
	public void testGetSimplePGByStory() throws SQLException, UserNotFoundException {
		System.out.println("\n Running getSimplePgByStory: \n");

		utenteRecuperato = managerUser.doRetrieveByKey(utenteTest.getUsername());
		pgDaRecuperare = managerPg.getSimplePGByStory(utenteRecuperato, managerStory.selectLastId());
		System.out.println(pgDaRecuperare.toString());
		assertNotNull(pgDaRecuperare);
		assertEquals(personaggioTest.getUsername(), pgDaRecuperare.getUsername());
		assertEquals(personaggioTest.getNome(), pgDaRecuperare.getNome());
	}

	
	@Test
	public void testGetAllPgByStory() throws SQLException, UserNotFoundException {
		System.out.println("\n Running getAllPgByStory TEEST: \n");

		int id = managerStory.selectLastId();
		
		storiaRecuperata = managerStory.getSimpleStory(id);
		System.out.println(storiaRecuperata.toString());
		assertNotNull(storiaRecuperata);
		listaPg = managerPg.getAllPgByStory(storiaRecuperata);
		System.out.println(listaPg.toString());
		assertFalse(listaPg.isEmpty());
	}
	

	


}
