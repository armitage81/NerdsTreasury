package de.antonafanasjew.projects.nerdstreasury.services;

import de.antonafanasjew.projects.nerdstreasury.business.TestEntity;
import de.antonafanasjew.projects.nerdstreasury.serverapi.services.TestService;

public class TestServiceImpl implements TestService {

	@Override
	public TestEntity chooseTestEntity() {
		
		System.out.println("TEST OK");
		
		return new TestEntity();
	}

}
