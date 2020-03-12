package test.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FlexipayAppContextProvider implements ApplicationContextAware {

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		FlexipayAppContextAware.setApplicationContext(applicationContext);
	}
}
