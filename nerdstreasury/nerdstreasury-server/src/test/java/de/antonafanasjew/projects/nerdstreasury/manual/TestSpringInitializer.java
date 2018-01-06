package de.antonafanasjew.projects.nerdstreasury.manual;

import org.junit.Test;

import de.antonafanasjew.projects.nerdstreasury.SpringInitializer;

public class TestSpringInitializer {

	@Test
	public void testIt() {
		SpringInitializer springInitializer = new SpringInitializer();
		springInitializer.initContext();
	}
	
}
