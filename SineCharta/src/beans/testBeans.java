package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import exception.UserNotFoundException;
import manager.PersonaggioManager;
import manager.SessioneManager;
import manager.StoryManager;
import manager.UsersManager;

public class testBeans {

	public static void main(String[] args) throws SQLException, UserNotFoundException {
		
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
	/*	Collection<User> lista = mana.doRetrieveAll(null);
		Iterator<User> it = lista.iterator();
		while(it.hasNext()) {
			User utente = (User) it.next();
			System.out.println(utente.toString());
		}
		
		User ute = mana.doRetrieveByKey("prova");
		System.out.println(ute.toString());
		*/
		
		String animals = "dog,ele,cat,bear";
		String[] animalArray = animals.split(",");
		
		for(int i = 0; i < animalArray.length ; i++) {
			System.out.println(animalArray[i]);
		}
		
	}
	


}
