package com.souritra.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfigurer {
    
    @Bean
    public LocalSessionFactoryBean hibernateLocalSessionFactoryBean(DataSource dataSource) {
	LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
	localSessionFactoryBean.setDataSource(dataSource);
	localSessionFactoryBean.setPackagesToScan(new String[] { "spittr.domain" });
	localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
	return localSessionFactoryBean;
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
    
    @Bean
    public BeanPostProcessor persistenceTranslation() {
	return new PersistenceExceptionTranslationPostProcessor();
    }
}
