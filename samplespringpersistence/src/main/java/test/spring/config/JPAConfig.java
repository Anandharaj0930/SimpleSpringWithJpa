package test.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration("dataSourceConfig")
public class JPAConfig {

    @Bean(name = "dataSourceOraBE")
    public DataSource dataSourceORABE() throws NamingException {
        return (DataSource) new JndiTemplate().lookup("weblogic.jdbc.P2PServicesPool");
    }

    @Bean(name = "hibernate.jpaProvider")
    public HibernateJpaVendorAdapter getJPAProvider() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabase(Database.ORACLE);
        return jpaVendorAdapter;
    }

    @Bean(name = "hibernate.properties")
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.connection.useUnicode", "true");
        properties.put("hibernate.connection.characterEncoding", "utf-8");
        return properties;
    }
}
