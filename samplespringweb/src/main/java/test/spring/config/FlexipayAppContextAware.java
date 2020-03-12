package test.spring.config;

import org.springframework.context.ApplicationContext;

public class FlexipayAppContextAware {

	private static ApplicationContext context;

	protected static void setApplicationContext(final ApplicationContext applicationContext) {
		context = applicationContext;
	}
	/**
	 * <p> Return an instance, which may be shared or independent, of the specified bean. Behaves the same as {@link #getBean(String)}, 
	 * but provides a measure of type safety if the bean is not of the required type. This means that 
	 * ClassCastException can't be thrown on casting the result correctly, as can happen with {@link #getBean(String)}. </p>
	 * 
	 * <p> Translates aliases back to the corresponding canonical bean name. Will ask the parent spring bean factory 
	 * if the bean cannot be found in this factory instance. </p>
	 * 
	 * @param clazz - type the bean must match. Can be an interface or superclass of the actual class, or null for any match. 
	 *                For example, if the value is Object.class, this method will succeed whatever the class of the returned instance.
	 *                 
	 * @param upServiceBean - Contain name of the bean id to retrieve using bean util.
	 *                
	 * @return - an instance of the bean 
	 * 
	 * @throws RuntimeException - if there is no bean definition with the specified name or if the bean could 
	 *                            not be obtained
	 */
	public static <BeanObject>  BeanObject getBean(final Class<BeanObject> clazz, final String beanId) {
		return context.getBean(beanId,clazz);
	}
}
