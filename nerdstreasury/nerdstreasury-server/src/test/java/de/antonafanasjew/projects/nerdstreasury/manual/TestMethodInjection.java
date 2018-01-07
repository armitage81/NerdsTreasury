package de.antonafanasjew.projects.nerdstreasury.manual;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

import de.antonafanasjew.projects.nerdstreasury.misc.methodinjections.CurrentDateFormatter;

public class TestMethodInjection {
		
	/**
	 * Demonstration of method injection. Check the xml configuration for details.
	 */
	@Test
	public void testPojo() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("methodinjections.xml")) {
			CurrentDateFormatter bean = context.getBean(CurrentDateFormatter.class);
			String s = bean.currentDateRepresentation();
			assertNotNull(s);
			System.out.println(s);
		}
		
	}
	
}
