package com.souritra.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicDataSourceConfigurer {
    
    /*
     * DataSource is going to be used by JPA
     * We pass dataSource as parameter to JPA configuration
     * 
     */
    @Bean
    public DataSource dataSource() {
	BasicDataSource basicDataSource = new BasicDataSource();
	basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	basicDataSource.setUrl("jdbc:mysql://localhost:3306/test");
	basicDataSource.setUsername("root");
	basicDataSource.setPassword("S0ur1tr@D@5");
	basicDataSource.setInitialSize(5);
	basicDataSource.setMaxTotal(10);
	return basicDataSource;
    }
}
