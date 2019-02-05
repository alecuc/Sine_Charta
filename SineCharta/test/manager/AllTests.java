package manager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EquipManagerTest.class, PersonaggioManagerTest.class, SessioneManagerTest.class, StoryManagerTest.class,
		UsersManagerTest.class })
public class AllTests {

}
