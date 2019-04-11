package japanagram.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initalizer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // Creates the root application context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.setServletContext(container);
        appContext.setDisplayName("Japanagram");
        // Registers the application configuration with the root context
        appContext.register(ApplicationConfig.class);
        // Creates the Spring Container shared by all Servlets and Filters
        container.addListener(new ContextLoaderListener(appContext));
        //filters
//        container.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, false, "/*");
//        container.addFilter("encodingFilter", CharacterEncodingFilter.class).addMappingForUrlPatterns(null, false, "/*");

        // Creates the dispatcher servlet context
        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.register(WebConfig.class);
        // Further configures the servlet context
        ServletRegistration.Dynamic dispatcher = container.addServlet("JapanagramServlet",
                                                                      new DispatcherServlet(servletContext));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }
}
