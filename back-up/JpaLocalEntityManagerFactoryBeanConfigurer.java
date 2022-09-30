package com.souritra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

public class JpaLocalEntityManagerFactoryBeanConfigurer {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean();
	localEntityManagerFactoryBean.setPersistenceUnitName("spitterPU");
	return localEntityManagerFactoryBean;
    }
}
