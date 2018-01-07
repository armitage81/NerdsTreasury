package de.antonafanasjew.projects.nerdstreasury.misc;

import org.springframework.beans.factory.annotation.Required;

import de.antonafanasjew.projects.nerdstreasury.serverapi.services.TestService;

public class TestBeanWithRequiredProperties {

	private String name;
	
	private TestService testService;
	
	public String getName() {
		return name;
	}
	
	@Required
	public void setName(String name) {
		this.name = name;
	}
	
	public TestService getTestService() {
		return testService;
	}
	
	@Required
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	
	
	
	
}
