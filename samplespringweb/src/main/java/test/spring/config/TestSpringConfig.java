package test.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"test.spring"})
@EnableWebMvc
@EnableAspectJAutoProxy
public class TestSpringConfig {

/*@Bean
@Lazy(value = false)
public FlexipayAppContextProvider createSpringTestContextProvider() {
    return new FlexipayAppContextProvider();
}*/
}
