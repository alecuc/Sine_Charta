package manager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UsersManagerTest.class,  StoryManagerTest.class, PersonaggioManagerTest.class, AbilitaManagerTest.class, SessioneManagerTest.class, 
	EquipManagerTest.class })
public class AllTests {

}
