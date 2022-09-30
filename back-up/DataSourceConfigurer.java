package com.souritra.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class DataSourceConfigurer {
    
    @Bean
    public LocalSessionFactoryBean hibernateLocalSessionFactoryBean(DataSource dataSource) {
	LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
	localSessionFactoryBean.setDataSource(dataSource);
	localSessionFactoryBean.setPackagesToScan(new String[] { "com.souritra.domain" });
	//localSessionFactoryBean.setAnnotatedClasses(new Class<?>[] { EntityClass1.class, EntityClass2.class });
	localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
	return localSessionFactoryBean;
    }
    
    // used by sessionFactory
    private Properties getHibernateProperties() {
	Properties properties = new Properties();
	properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
	return properties;
    }
    
    @Bean
    public BeanPostProcessor persistenceTranslation() {
	return new PersistenceExceptionTranslationPostProcessor();
    }
    
    @Bean
    public LocalEntityManagerFactoryBean localEntityManagerFactoryBean() {
	LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean();
	localEntityManagerFactoryBean.setPersistenceUnitName("spitterPU");
	return localEntityManagerFactoryBean;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
	    DataSource dataSource,
	    JpaVendorAdapter jpaVendorAdapter) {
	LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = 
		new LocalContainerEntityManagerFactoryBean();
	localContainerEntityManagerFactoryBean.setDataSource(dataSource);
	localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
	localContainerEntityManagerFactoryBean.setPackagesToScan("com.habuma.spittr.domain");
	return localContainerEntityManagerFactoryBean;
    }
    
    /*
     * 
     * EclipseLinkJpaVendorAdapter,
	HibernateJpaVendorAdapter,
	OpenJpaVendorAdapter
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
	HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
	hibernateJpaVendorAdapter.setShowSql(true);
	hibernateJpaVendorAdapter.setGenerateDdl(false);
	//adapter.setDatabasePlatform(databasePlatform);
	return hibernateJpaVendorAdapter;
    }
}
