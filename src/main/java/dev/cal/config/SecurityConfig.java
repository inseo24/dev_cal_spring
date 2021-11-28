package dev.cal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.cors()
			.and()
			.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/", "/auth/**", "/event", "/board/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/auth/signin")
			.loginProcessingUrl("/auth/signin")
			.defaultSuccessUrl("/");
	}
} 
