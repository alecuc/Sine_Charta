package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.catalina.mbeans.UserMBean;

import manager.PersonaggioManager;
import manager.SessioneManager;
import manager.StoryManager;
import manager.UsersManager;

public class testBeans {

	public static void main(String[] args) throws SQLException {
		
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
		
		
		UsersManager userManager = new UsersManager();
		User utenteListaStorie = userManager.doRetrieveByKey("RaffoV");

		System.out.println(utenteListaStorie.toString());
			
	
	
	}
	


}
