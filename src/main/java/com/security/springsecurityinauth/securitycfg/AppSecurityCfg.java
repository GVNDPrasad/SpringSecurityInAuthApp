package com.security.springsecurityinauth.securitycfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityCfg extends WebSecurityConfigurerAdapter{
	
	private static final Logger log = LoggerFactory.getLogger(AppSecurityCfg.class);

	//Authentication based on User-name and password
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		log.info("Entered AppSecurityCfg :: configure(AuthenticationManagerBuilder auth)-"+auth);
		
		//Create User-name and Password with Role
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}admin") //Authentication
		.authorities("ADMIN");//Authorization
		
		auth.inMemoryAuthentication()
		.withUser("employee").password("{noop}employee")
		.authorities("EMPLOYEE");
		
		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}user")
		.authorities("USER");
		
		auth.inMemoryAuthentication()
		.withUser("guest").password("{noop}guest")
		.authorities("GUEST");
		
		//super.configure(auth);
	}
	
	//Autherization based on role
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("Entered AppSecurityCfg :: configure(HttpSecurity http)-"+http);
		
		//Doing Authorization based on request url and role
		http.authorizeRequests()
		 // .antMatchers("Request URL") for single url and permitAll() for all users & hasAuthority for single user
		//.antMatchers("/home/home").permitAll() //Allow all internal and external users
		//.antMatchers("/home/admin").hasAuthority("ADMIN") //Allow only admin users
		//.antMatchers("/home/employee").hasAuthority("EMPLOYEE") //Allow only employees
		//.antMatchers("/home/user").hasAuthority("USER") //Allow only users
		//.antMatchers("/home/customer").hasAuthority("GUEST") //Allow only users
		//.antMatchers("/home/dashboard").hasAuthority("ADMIN") //Allow only admin 
		//.antMatchers("/home/dashboard").hasAuthority("EMPLOYEE")  //Allow only employees
		//.anyRequest() for except other Request URL's with Authentication
		
		
		.antMatchers("/home").permitAll() //Allow all internal and external users
		.antMatchers("/admin").hasAuthority("ADMIN") //Allow only admin users
		.antMatchers("/employee").hasAuthority("EMPLOYEE") //Allow only employees
		.antMatchers("/user").hasAuthority("USER") //Allow only users
		.antMatchers("/customer").hasAuthority("GUEST") //Allow only users
		.antMatchers("/dashboard").hasAuthority("ADMIN") //Allow only admin 
		.antMatchers("/dashboard").hasAuthority("EMPLOYEE")  //Allow only emp
		
		
		
		
		
		
		.anyRequest().authenticated() //allow only logged users for except above url requests
		
		//After Login
		.and()
		.formLogin().defaultSuccessUrl("/home/welcome", true)
	
		//After Logout
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		//At the time access denied based on authorization
		.and()
		.exceptionHandling().accessDeniedPage("/home/denied");
		
		//super.configure(http);
	}

}
