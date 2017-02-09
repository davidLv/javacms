package org.javacms.core.security.config;

import org.javacms.core.security.handler.CustomLoginSuccessHandler;
import org.javacms.core.security.handler.CustomLogoutSuccessHandler;
import org.javacms.core.security.userdetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CustomLoginSuccessHandler customLoginSuccessHandler;
	
	@Autowired
	private CustomLogoutSuccessHandler customLogoutSuccessHandler;
	
	private AuthenticationManager authenticationManager;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new Md5PasswordEncoder());
		this.authenticationManager = auth.build();
		auth.eraseCredentials(false);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//config to using the md5 encoder for password encoder to the authentication manager
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new Md5PasswordEncoder());
		//this.authenticationManager = auth.build();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return this.authenticationManager;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/res/**", "/admin", "/thirdparty/**", "/auth/login").permitAll()
		.antMatchers("/admin/**").hasAuthority("admin:index")
		//.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		//.formLogin().loginPage("/admin/login").successHandler(customLoginSuccessHandler).permitAll()
		//the customLoginSuccessHandler could not be involved if the loginProcessingUrl is not be provided
		.formLogin().loginPage("/admin").loginProcessingUrl("/auth/login").defaultSuccessUrl("/admin/index", false).permitAll().successHandler(customLoginSuccessHandler)
		.and()
		.logout().logoutUrl("/admin/logout").logoutSuccessHandler(customLogoutSuccessHandler).logoutSuccessUrl("/admin").invalidateHttpSession(true)
		.and()
		.csrf().disable()
		//void the Load denied by X-Frame-Options:does not permit framing. and frame does not display SAMEORIGIN
		.headers().frameOptions().sameOrigin();
		//.and()
		//.addFilter(customUsernamePasswordAuthenticationFilter);
		//.addFilterBefore(customUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
