package com.souritra.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class EmbeddedDatabaseConfigurer {
    
    // DOUBT
    @Bean
    public DataSource embeddedDatabase() {
	return 
		new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.H2)
		.addScript("classpath:schema.sql")
		.addScript("classpath:test-data.sql")
		.build();
    }
}
