package manager;


import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.Oggetto;
import beans.Personaggio;
import beans.Storia;
import beans.User;
import junit.framework.TestCase;

public class EquipManagerTest extends TestCase{

	private EquipManager managerEq;
	private UsersManager managerUs;
	private StoryManager managerStory;
	private PersonaggioManager managerPg;
	private Oggetto oggettoTest;
	private Oggetto oggettoRecuperato;
	private User utenteTest;
	private Storia storiaTest;
	private Personaggio personaggioTest;
	private Personaggio pg2;
	private int idStory;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("\n Running setUp: \n");
		managerEq = new EquipManager();
		managerUs = new UsersManager();
		managerStory = new StoryManager();
		managerPg = new PersonaggioManager();
		oggettoTest = new Oggetto();
		oggettoRecuperato = new Oggetto();
		utenteTest = new User();
		storiaTest = new Storia();
		personaggioTest = new Personaggio(); 
		pg2 = new Personaggio();
		idStory = 0;
		oggettoTest.setNome("testNome");
		oggettoTest.setCosto(10);
		oggettoTest.setPeso(10);
		oggettoTest.setQuantita(1);
		
		utenteTest.setUsername("testPG");
		utenteTest.setName("testName");
		utenteTest.setSurname("testSurn");
		utenteTest.setEmail("testEquip@test");
		utenteTest.setPassword("test");
		utenteTest.setRuolo("utenteGiocatore");
		
		storiaTest.setTitolo("testPGStoria");
		storiaTest.setDescrizione("test test test");
		storiaTest.setAmbientazione("Sanctum Imperum");
		
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
		personaggioTest.setUsername(utenteTest.getUsername());
		
		managerUs.doSave(utenteTest);
		managerStory.aggiungiStoria(storiaTest);
		managerStory.aggiungiATable(utenteTest, 0);
		idStory = managerStory.selectLastId();
		personaggioTest.setIdStoria(idStory);
		personaggioTest.setUsername(utenteTest.getUsername());
		oggettoTest.setIdStoria(idStory);
		managerPg.creaPersonaggio(personaggioTest, idStory);
		managerEq.inserisciOggetto(oggettoTest, personaggioTest);
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("\n Running tearDown: \n");
		managerEq.rimuoviOggetto(oggettoTest, personaggioTest);
		managerPg.eliminaPG(personaggioTest);
		managerStory.eliminaStoria(managerStory.selectLastId());
		managerStory.eliminaRiferimentoHaTable(utenteTest.getUsername(), managerStory.selectLastId());
		managerUs.eliminaUtente(utenteTest.getUsername());
		
		managerEq = null;
		managerUs = null;
		managerStory = null;
		managerPg = null;
		oggettoTest = null;
		oggettoRecuperato = null;
		utenteTest = null;
		storiaTest = null;
		personaggioTest = null;
		
		
		

	}

	@Test
	public void testGetOggettoPersonaggioById() throws SQLException {
		System.out.println("\n Running getOggettoPersonaggioById TEST: \n");
		
		pg2 = managerPg.getSimplePGByStory(utenteTest, idStory);
		assertNotNull(pg2);
		oggettoRecuperato = managerEq.getOggettoPersonaggioById(pg2, idStory);
		assertNotNull(oggettoRecuperato);
		System.out.println(oggettoRecuperato.getNome());
		assertEquals(oggettoTest.getNome(), oggettoRecuperato.getNome());
	}

	
}

