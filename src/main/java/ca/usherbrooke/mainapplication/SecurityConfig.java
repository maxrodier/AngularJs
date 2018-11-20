package ca.usherbrooke.mainapplication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .httpBasic()
        	.and()
        .authorizeRequests()
        	.antMatchers(
        			"/", 
        			"/views/index.html", 
        			"/login", 
        			"/views/login.html",
        			"/resources/js/index.js",
        			"/resources/js/login.js",
        			"/resources/css/index.css",
        			"/resources/css/login.css",
        			"/resources/css/application.css",
        			"/webjars/**",
        			"/console/**").permitAll()
        	.anyRequest().authenticated()
        	.and()
        .formLogin()
        	.loginPage("/login")
        	.successHandler(new AuthenticationSuccessHandler() {
				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					response.setStatus(200);
				}
			})
        	.failureHandler(new AuthenticationFailureHandler() {
				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					response.setStatus(401);
				}
			})
        	.and()
        .csrf().disable()
        //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        .headers().frameOptions().disable();
    }
	
	
}
