package com.souritra.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringDriverManagerDataSourceConfigurer {

    @Bean
    public DataSource driverManagerDataSource() {
	DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	driverManagerDataSource.setDriverClassName("org.h2.Driver");
	driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
	driverManagerDataSource.setUsername("sa");
	driverManagerDataSource.setPassword("");
	return driverManagerDataSource;
    }
}
