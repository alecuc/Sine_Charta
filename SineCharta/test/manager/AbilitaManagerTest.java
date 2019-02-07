package manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import beans.Abilita;
import beans.Personaggio;
import beans.Storia;
import beans.User;
import junit.framework.TestCase;

public class AbilitaManagerTest extends TestCase {

	private AbilitaManager managerAbilita;
	private UsersManager managerUs;
	private StoryManager managerStory;
	private PersonaggioManager managerPg;
	
	private Abilita abilitaDaInserire;
	private Abilita abilitaDaRecuperare;
	private Collection<Abilita> listaAb;
	private User utenteTest;
	private Storia storiaTest;
	private Personaggio personaggioTest;
	private int idStory;

	
	@Before
	public void setUp() throws Exception {
		System.out.println("\n Running setUp: \n");
		managerUs = new UsersManager();
		managerAbilita = new AbilitaManager();
		managerStory = new StoryManager();
		managerPg = new PersonaggioManager();
		utenteTest = new User();
		storiaTest = new Storia();
		personaggioTest = new Personaggio();
		abilitaDaInserire = new Abilita();
		abilitaDaRecuperare = new Abilita();
		listaAb = new ArrayList<Abilita>();
		idStory = 0;
		utenteTest.setUsername("testPGAbilty");
		utenteTest.setName("testName");
		utenteTest.setSurname("testSurn");
		utenteTest.setEmail("testAbility@test");
		utenteTest.setPassword("test");
		utenteTest.setRuolo("utenteGiocatore");
		
		storiaTest.setTitolo("testAbilitaStory");
		storiaTest.setDescrizione("test test test");
		storiaTest.setAmbientazione("Sanctum Imperum");
		
		personaggioTest.setNome("testPGAbil");
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
		
		abilitaDaInserire.setNome("TestAbilita");
		abilitaDaInserire.setValore(10);
		
		
		
		
		managerUs.doSave(utenteTest);
		managerStory.aggiungiStoria(storiaTest);
		managerStory.aggiungiATable(utenteTest, 0);
		idStory = managerStory.selectLastId();
		personaggioTest.setIdStoria(idStory);
		abilitaDaInserire.setPersonaggio(personaggioTest);
		managerPg.creaPersonaggio(personaggioTest, idStory);
		managerAbilita.aggiungiAbilita(abilitaDaInserire, personaggioTest);
	}
	

	@After
	public void tearDown() throws Exception {
		System.out.println("\n Running tearDown: \n");
		
		managerAbilita.eliminaAbilita(personaggioTest);
		managerPg.eliminaPG(personaggioTest);
		managerStory.eliminaStoria(idStory);
		managerStory.eliminaRiferimentoHaTable(utenteTest.getUsername(), idStory);
		managerUs.eliminaUtente(utenteTest.getUsername());
		
		managerAbilita = null;
		managerPg = null;
		managerStory = null;
		managerUs = null;
		abilitaDaInserire = null;
		abilitaDaRecuperare = null;
		personaggioTest = null;
		storiaTest = null;
		utenteTest = null;
		idStory = 0;
		listaAb.clear();
		
		
	}

	@Test
	public void testGetAbilitaByName() throws SQLException {
		System.out.println("\n Running getAbilitaByName TEST: \n");
		
		abilitaDaRecuperare = managerAbilita.getAbilitaByName(personaggioTest, abilitaDaInserire.getNome());
		assertNotNull(abilitaDaInserire);
		assertNotNull(personaggioTest);
		assertNotNull(abilitaDaRecuperare);
		assertEquals(abilitaDaInserire.getNome(), abilitaDaRecuperare.getNome());
		assertEquals(abilitaDaInserire.getValore(), abilitaDaRecuperare.getValore());
	
	}

	@Test
	public void testGetListaAbilitaByPG() throws SQLException {
		System.out.println("\n Running getListaAbilitaByPg TEST: \n");
		
		listaAb = managerAbilita.getListaAbilitaByPG(personaggioTest);
		assertNotNull(personaggioTest);
		assertFalse(listaAb.isEmpty());
		
	}

}
