package japanagram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  @Bean
  public TilesConfigurer tilesConfigurer() {
      final TilesConfigurer configurer = new TilesConfigurer();
      String[] definitions = { "/WEB-INF/views/views.xml" };
      configurer.setDefinitions(definitions);
      return configurer;
  }

  @Bean
  public TilesViewResolver tilesViewResolver() {
      final TilesViewResolver resolver = new TilesViewResolver();
      resolver.setViewClass(TilesView.class);
      return resolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("*.css").addResourceLocations("/**");
      registry.addResourceHandler("*.js").addResourceLocations("/*");
      registry.addResourceHandler("*.jpg").addResourceLocations("/*");
      registry.addResourceHandler("*.png").addResourceLocations("/*");
      registry.addResourceHandler("*.html").addResourceLocations("/*");
      registry.addResourceHandler("*.gif").addResourceLocations("/*");
  }

  // equivalent for <mvc:default-servlet-handler/> tag
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
  }

  @Bean(name = "multipartResolver")
  public CommonsMultipartResolver multipartResolver() {
      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
      multipartResolver.setMaxUploadSize(100000000);
      return multipartResolver;
  }

}
