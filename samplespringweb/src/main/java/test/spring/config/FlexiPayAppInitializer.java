package test.spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class FlexiPayAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // use when we are going to using xml based config
        /*XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/dispatcher-config.xml");*/

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext ();
        appContext.register(TestSpringConfig.class);
        //appContext.setConfigLocation("");
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcherManual", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }


    /*@Override
	protected String[] getServletMappings() {
		return new String[]{"/*"};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{WebConfig.class*//*TestSpringConfig.class*//*};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class*//*TestSpringConfig.class*//*};
	}*/
}