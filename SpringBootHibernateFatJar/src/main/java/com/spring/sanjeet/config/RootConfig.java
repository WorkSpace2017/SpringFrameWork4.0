package com.spring.sanjeet.config;

import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication(scanBasePackages= { "com.spring.sanjeet.model", "com.spring.sanjeet.services" })

public class RootConfig {
    
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource ds) {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(ds);

        Properties props = new Properties();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");
        props.put("hibernate.use_sql_comments", "true");
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

        lsfb.setHibernateProperties(props);
        lsfb.setMappingResources(new String[] { "Customer.hbm.xml" });

        return lsfb;
    }

    @Bean(autowire = Autowire.BY_TYPE)
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate();
    }
}
