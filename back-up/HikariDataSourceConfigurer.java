package com.souritra.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariDataSourceConfigurer {
        
    /*
     * DataSource is going to be used by JPA
     * We pass dataSource as parameter to JPA configuration
     * 
     */
    @Bean
    public DataSource dataSource() {
       HikariConfig hikariConfig = new HikariConfig();
       // we can use DB vender driver class or DB vender DataSource
       hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
       hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/test");
       hikariConfig.setUsername("root");
       hikariConfig.setPassword("S0ur1tr@D@5");
       hikariConfig.setMaximumPoolSize(20);
       hikariConfig.setIdleTimeout(30000);
       
       hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
       hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
       hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

       return new HikariDataSource(hikariConfig);
   }
    
}
