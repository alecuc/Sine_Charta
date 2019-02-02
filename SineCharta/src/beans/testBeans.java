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
		UsersManager mana = new UsersManager();

		User utente = new User();
		utente.setUsername("testUser");
		utente.setRuolo("utenteModeratore");
		utente.setPassword("test");
		utente.setName("tstName");
		utente.setSurname("testSru");
		utente.setEmail("testMail");
	//	mana.doSave(utente);
		StoryManager manager = new StoryManager();
		Storia sto = new Storia();
		sto.setAmbientazione("Sanctum Imperum");
		sto.setTitolo("TestTitolo");
		sto.setDescrizione("Test test Test");
		//manager.aggiungiStoria(sto);

		

		
		int x = manager.selectLastId();
		sto.setId(x);
		//manager.aggiungiATable(utente, 1);
		System.out.println(x);
		
		manager.eliminaRiferimentoHaTable(utente.getUsername(), sto.getId());
		manager.eliminaStoria(sto.getId());
		mana.eliminaUtente(utente.getUsername());
	}
	
	


}
