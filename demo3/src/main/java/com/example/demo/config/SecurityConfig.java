package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.service.AuthenticationService;

@Configuration
@ComponentScan("com.concretepage")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource("classpath:jdbc.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Autowired
	private AuthenticationService authenticationService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/info/**").hasAnyRole("ADMIN", "USER").and().formLogin();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		authenticationManagerBuilder.userDetailsService(authenticationService).passwordEncoder(encoder);
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}

}
