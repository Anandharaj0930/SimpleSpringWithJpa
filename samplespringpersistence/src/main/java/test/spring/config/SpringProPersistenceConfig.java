package test.spring.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration("springProPersistenceConfig")
@ComponentScan({"test.spring"})
@EnableTransactionManagement
public class SpringProPersistenceConfig {


    @Bean(name = "entityManagerORABE")
    public LocalContainerEntityManagerFactoryBean entityManagerORABE(@Qualifier("dataSourceOraBE") DataSource dataSourceORABE, @Qualifier("hibernate.jpaProvider") JpaVendorAdapter jpaVendorAdapter, @Qualifier("hibernate.properties") Properties prop) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setDataSource(dataSourceORABE);
        factoryBean.setPersistenceUnitName("springProPersistentUnit");
        factoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        factoryBean.setPackagesToScan(new String[]{
                "test.spring.employee"});
        factoryBean.setJpaDialect(new HibernateJpaDialect());
        factoryBean.setJpaProperties(prop);
        return factoryBean;
    }


    @Bean(name = "jpaTransactionManager")
    public JpaTransactionManager getJpaTransactionManager(LocalContainerEntityManagerFactoryBean entityManagerORABE) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerORABE.getObject());
//        transactionManager.setJpaDialect(new EclipseLinkJpaDialect());
//        transactionManager.setJpaDialect(new HibernateJpaDialect());
        return transactionManager;
    }
}
