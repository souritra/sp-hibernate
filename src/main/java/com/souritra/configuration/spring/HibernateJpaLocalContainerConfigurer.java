package com.souritra.configuration.spring;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.souritra.configuration.ConfigurationConstants;

public class HibernateJpaLocalContainerConfigurer {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	    DataSource dataSource,
	    JpaVendorAdapter jpaVendorAdapter) {
	LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = 
		new LocalContainerEntityManagerFactoryBean();
	localContainerEntityManagerFactoryBean.setDataSource(dataSource);
	localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
	localContainerEntityManagerFactoryBean.setPackagesToScan(ConfigurationConstants.DOMAIN_BASE_PACKAGE);
	localContainerEntityManagerFactoryBean.setJpaProperties(getHibernateProperties());
	return localContainerEntityManagerFactoryBean;
    }
    
 // used by sessionFactory
    private Properties getHibernateProperties() {
	Properties properties = new Properties();
	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
	properties.setProperty("hibernate.format_sql", "true");
	properties.setProperty("hibernate.use_sql_comments", "true");
	properties.setProperty("hibernate.hbm2ddl.auto", "update");
	
	return properties;
    }
}
