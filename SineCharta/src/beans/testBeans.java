package beans;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import manager.StoryManager;
import manager.UsersManager;

public class testBeans {

	public static void main(String[] args) throws SQLException {
		StoryManager manager = new StoryManager();
		
		Collection<Storia> storie = manager.getStoria("Raziel");
		Iterator<Storia> it = storie.iterator();
		while(it.hasNext()) {
			Storia sto = it.next();
			System.out.println(sto.toString());
		}
		
		
		
		
	}

}
