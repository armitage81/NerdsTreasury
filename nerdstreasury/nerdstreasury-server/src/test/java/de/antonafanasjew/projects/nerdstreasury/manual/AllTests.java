package de.antonafanasjew.projects.nerdstreasury.manual;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDependencyInjection.class, TestAutowiring.class, TestMethodInjection.class})
public class AllTests {

}
