package com.project.dashboard.config;

import org.apache.el.parser.AstFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.dashboard.service.UserService;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class Securityconfig {

	@Autowired
	UserService userService;
	
	 @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userService);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	 
	
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	 @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }
	 
	 @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.cors().and().csrf().disable()
	        .authorizeHttpRequests()
	        .requestMatchers(
	        		"/api/user/register",
	        		"/js/**",
	                "/css/**",
	                "/img/**").permitAll()
	        .anyRequest().authenticated()
	        .and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.permitAll()
			.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.permitAll();
	    
	    http.authenticationProvider(authenticationProvider());

	    
	    return http.build();
	  }
}
