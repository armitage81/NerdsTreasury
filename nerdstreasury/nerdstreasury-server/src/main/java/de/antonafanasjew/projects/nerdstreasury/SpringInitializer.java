package de.antonafanasjew.projects.nerdstreasury;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.antonafanasjew.projects.nerdstreasury.serverapi.services.TestService;


public class SpringInitializer {

	public void initContext() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			TestService testService = context.getBean(TestService.class);
			testService.chooseTestEntity();	
		}
	}
	
	
}
