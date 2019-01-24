package beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import manager.PersonaggioManager;
import manager.StoryManager;
import manager.UsersManager;

public class testBeans {

	public static void main(String[] args) throws SQLException {
		
		
		UsersManager manager = new UsersManager();
		User utente = manager.doRetrieveByKey("Raziel");
		/*System.out.println(utente.toString());
		*/
		
		PersonaggioManager pgManager = new PersonaggioManager();
		Personaggio pg = pgManager.getPersonaggioByUtente(utente);
		System.out.println(pg);
	
	
	
	
	
	
	
	
	
	
	}
	


}
