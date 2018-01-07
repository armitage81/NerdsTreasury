package de.antonafanasjew.projects.nerdstreasury.manual;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.antonafanasjew.projects.nerdstreasury.misc.customscopes.SecondScopedBean;

public class TestSecondScope {

	@Test
	public void test() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("secondscope.xml")) {
			
			for (int i = 0; i < 5; i++) {
				SecondScopedBean bean = context.getBean(SecondScopedBean.class);
				String s = bean.inspect();
				System.out.println(s);
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			
			SecondScopedBean bean = context.getBean(SecondScopedBean.class);
			String s = bean.inspect();
			System.out.println(s);
		}
	}
	
}
