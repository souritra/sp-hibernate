package com.souritra.configuration.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class HibernateJpaVendorAdapterConfigurer {
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
	HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();	
	hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
	hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL57InnoDBDialect");
	hibernateJpaVendorAdapter.setShowSql(true);
	hibernateJpaVendorAdapter.setGenerateDdl(false);
	
	return hibernateJpaVendorAdapter;
    }
}
