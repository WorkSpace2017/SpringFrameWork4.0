package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;


@SpringBootApplication(scanBasePackages="com.spring.daos")
@PropertySource(value={"classpath:connection.properties"})
public class SpringJdbcConfig {
	static{
		System.out.println("***SpringJdbcConfig***");
	}
	/*@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("manager");
		bds.setInitialSize(10);
		bds.setMaxActive(15);
		return bds;
	}*/

	/*@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		System.out.println("***jdbcTemplate***" + ds.toString());
		return new JdbcTemplate(ds);
	}*/
	
	/*@Bean(name = "empdao" )
	public EmployeeDao empDao(){
		return new EmployeeDaoImpl();
	}*/

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		System.out.println("***HikariDataSource***");
		HikariDataSource ds =new HikariDataSource();
		try{
			ds.setDriverClassName(env.getProperty("jdbc.driverClass"));
			ds.setJdbcUrl(env.getProperty("jdbc.url"));
			ds.setUsername(env.getProperty("jdbc.username"));
			ds.setPassword(env.getProperty("jdbc.password"));
			ds.setMaximumPoolSize(20);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ds;
	}	
}
