package com.souritra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.jndi.JndiObjectFactoryBean;

public class JndiObjectFactoryBeanDataSourceConfigurer {
    @Bean
    public JndiObjectFactoryBean jndiObjectFactoryBeanDataSource() {
	JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
	jndiObjectFactoryBean.setJndiName("jdbc/ApplicationDataSource");
	jndiObjectFactoryBean.setResourceRef(true);
	jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
	return jndiObjectFactoryBean;
    }
}
