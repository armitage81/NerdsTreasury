package de.antonafanasjew.projects.nerdstreasury.manual;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.antonafanasjew.projects.nerdstreasury.misc.autowired.Person;

public class TestAutowiring {

	/**
	 * Demonstration of autowiring
	 */
	@Test
	public void testNestedPropertySetting() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml")) {
			Person p = context.getBean(Person.class);
			assertNotNull(p.getAccount());
			assertNotNull(p.getAddress());
			assertNotNull(p.getVehicle());
		}
		
	}
	
}
