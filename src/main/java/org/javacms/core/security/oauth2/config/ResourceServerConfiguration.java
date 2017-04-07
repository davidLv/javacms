package org.javacms.core.security.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	/*private static final String RESOURCE_ID = "rest_api";

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.anonymous().disable()
			.requestMatchers().antMatchers("/user/**")
			.and()
			.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN")
			.and()
			.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}*/
	
	private static final String RESOURCE_ID = "my_rest_api";
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }
 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
        anonymous().disable()
        .requestMatchers().antMatchers("/user/**")
        .and().authorizeRequests()
                .antMatchers("/user/**").hasAuthority("rest:access")
        //.antMatchers("/user/**").access("hasRole('ADMIN')")
        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}