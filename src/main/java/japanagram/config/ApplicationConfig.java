package japanagram.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "japanagram")
@EnableScheduling
public class ApplicationConfig {

    public static final String DATA_SOURCE = "datasource1";
    public static final String JDBC_TEMPLATE = "jdbcTemplate";
    public static final String NAMED_JDBC_TEMPLATE = "namedParameterJdbcTemplate";

// in context.xml
//   <Context>   <ResourceLink global="jdbc/japanagram" name="jdbc/japanagram" type="javax.sql.DataSource"/> </Context>

//wrapped in <GlobalNamingResources> inside of server.xml
//user and password come from catalina.properties
// <Resource name="jdbc/TestDB" auth="Container" type="javax.sql.DataSource"
//                maxActive="100" maxIdle="30" maxWait="10000"
//                username="${japanagram.user}" password="${japanagram.password}" driverClassName="com.mysql.jdbc.Driver"
//                url="jdbc:mysql://localhost:3306/javatest;libraries=${test.libl} lib1 lib2 lib3 lib4;"/>

    @Bean(name = DATA_SOURCE)
    @Primary
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(false);
        
        return dsLookup.getDataSource("java:/comp/env/jdbc/japanagram");
    }

    @Bean(name = JDBC_TEMPLATE)
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean(name = NAMED_JDBC_TEMPLATE)
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}