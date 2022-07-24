package com.sportyshoes.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.sportyshoes.model.UserRoles;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// Protecting the urls with a role-based access.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/user").hasRole("USER") // User
				.antMatchers("/admin").hasRole("ADMIN"); // Admin
        		//by default ROLE_ will be prefixed to match like ROLE_ADMIN
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new CustomAuthenticationProvider());
	}
}