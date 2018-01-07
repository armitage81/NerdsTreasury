package de.antonafanasjew.projects.nerdstreasury.manual;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import de.antonafanasjew.projects.nerdstreasury.misc.TestBeanWithRequiredProperties;
import de.antonafanasjew.projects.nerdstreasury.misc.TestCollectionHolder;
import de.antonafanasjew.projects.nerdstreasury.misc.TestNestedA;
import de.antonafanasjew.projects.nerdstreasury.misc.TestPojo;
import de.antonafanasjew.projects.nerdstreasury.misc.TestPojo2;
import de.antonafanasjew.projects.nerdstreasury.serverapi.services.TestService;

public class TestDependencyInjection {

	/**
	 * Initialization of Spring IoC.
	 */
	@Test
	public void testContextInitialization() {
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			TestService testService = context.getBean(TestService.class);
			testService.chooseTestEntity();	
		}
		
		try (GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("beans.groovy")) {
			TestService testService = context.getBean(TestService.class);
			testService.chooseTestEntity();	
		}
	}
	
	/**
	 * Demonstration of @Required interface.
	 * 
	 * Note: <context:annotation-config/> tag is needed for the @Required interface to work (plus namespace declaration)
	 */
	@Test(expected=BeanCreationException.class)
	public void testBeanWithRequiredProperty() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			TestBeanWithRequiredProperties b = context.getBean(TestBeanWithRequiredProperties.class);
			System.out.println(b.getName());
		}
	}
	
	/**
	 * Demonstration of bean definition with the p - schema. Check the beans.xml file to see it.
	 */
	@Test
	public void testPojo() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			TestPojo b = context.getBean(TestPojo.class);
			assertEquals(10, b.getA());
			assertEquals("anton", b.getB());
		}
		
	}
	
	/**
	 * Demonstration the definition of Properties objects (see beans.xml)
	 * Note: the bean is initialized with place holders which are defined in the 
	 * bean of type org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
	 */
	@Test
	public void testProperties() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			TestPojo2 b = context.getBean(TestPojo2.class);
			assertEquals(36, b.getAge());
			assertEquals("anton", b.getName());
		}
		
	}
	
	
	/**
	 * Demonstration of map, list, set and properties 'literals' in the bean definition when set as properties
	 */
	@Test
	public void testCollectionSetting() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			TestCollectionHolder b = context.getBean(TestCollectionHolder.class);
			assertEquals(3, b.getL().size());
			assertEquals(3, b.getS().size());
			assertEquals(3, b.getP().size());
			assertEquals(3, b.getM().size());
		}
		
	}
	
	/**
	 * Demonstration of setting nested properties
	 * Note: nested properties' parents must not be null, meaning, they have to be initialized before setting the property is set
	 */
	@Test
	public void testNestedPropertySetting() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
			TestNestedA bean = context.getBean(TestNestedA.class);
			assertEquals("MyText", bean.getB().getText());
		}
		
	}
	
}
