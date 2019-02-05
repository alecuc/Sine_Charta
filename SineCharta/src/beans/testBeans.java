package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import exception.UserNotFoundException;
import exception.UserNullException;
import manager.PersonaggioManager;
import manager.SessioneManager;
import manager.StoryManager;
import manager.UsersManager;

public class testBeans {

	public static void main(String[] args) throws SQLException, UserNotFoundException, UserNullException {
		
		/*
		UsersManager manager = new UsersManager();
		User utente = manager.doRetrieveByKey("Raziel");
		System.out.println(utente.toString());
	
		Collection<Personaggio> personaggi = new LinkedList<Personaggio>();
		PersonaggioManager pgManager = new PersonaggioManager();
		
		
		Personaggio pg = pgManager.getPersonaggioByUtente(utente);
		StoryManager Smanager = new StoryManager();
		Storia storia = Smanager.getStoriaDelPG(pg);
		
		personaggi = pgManager.getAllPgByStory(storia);
		
		Iterator<Personaggio> ite = personaggi.iterator();
		while(ite.hasNext()) {
			Personaggio pgITe= (Personaggio) ite.next();
			System.out.println(pgITe.toString());
		}
		/*System.out.println(pg);
	*/
		/*
		Storia storiaDelPg = Smanager.getStoriaDelPG(pg);
		System.out.println(pg.toString());
		System.out.println(storiaDelPg.toString());
		
		*/
		//TEST COLLECTION STORIA da UTENTE
		
		/*
		UsersManager userManager = new UsersManager();
		User utenteListaStorie = userManager.doRetrieveByKey("RaffoV");

		System.out.println(utenteListaStorie.toString());
			*/
	
		
		
		StoryManager managerStory = new StoryManager();
		PersonaggioManager managerPg = new PersonaggioManager();
		UsersManager managerUser = new UsersManager();
		Storia storiaTest = new Storia();
		Storia storiaRecuperata = new Storia();
		User utenteTest = new User();
		Personaggio pgDaRecuperare = new Personaggio();
		Personaggio personaggioTest = new Personaggio();
		Collection<Personaggio> listaPg = new ArrayList<Personaggio>();
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
		
		storiaRecuperata = managerStory.getSimpleStory(managerStory.selectLastId());
		System.out.println(storiaRecuperata.toString());
		
		
		listaPg = managerPg.getAllPgByStory(storiaRecuperata);
		System.out.println(listaPg.toString());
		
		managerStory.eliminaRiferimentoHaTable(personaggioTest.getUsername(), managerStory.selectLastId());
		managerStory.eliminaStoria(managerStory.selectLastId());
		managerUser.eliminaUtente(personaggioTest.getUsername());
		managerPg.eliminaPG(personaggioTest);
		storiaRecuperata = null;
		pgDaRecuperare = null;
		listaPg.clear();
		
		
	}
	
	


}
