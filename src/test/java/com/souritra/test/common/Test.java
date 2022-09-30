package com.souritra.test.common;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.souritra.configuration.ConfigurationConstants;

public class Test {

    public static void main(String args[]) {
	
	ApplicationContext applicationContext = 
		new AnnotationConfigApplicationContext(ConfigurationConstants.CONFIGURATION_BASE_PACKAGE);
	
	DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
	System.out.println(dataSource.toString());
    }
}
