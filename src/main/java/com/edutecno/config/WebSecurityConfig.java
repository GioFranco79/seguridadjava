package com.edutecno.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration 
public class WebSecurityConfig {//clase para configurar el acceso web mediante filtrado de las peticiones
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//filtros de seguridad para comprar con el request http y definir rutas o acceso
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http
		.authorizeRequests()
		.antMatchers("/admin/**").hasAuthority("ADMIN") //definiendo rutas para los diferentes roles existentes
		.antMatchers("/user/**").hasAuthority("USER")
		.antMatchers("/login")
		.permitAll()
		.antMatchers(HttpMethod.POST)
		.permitAll()
		.antMatchers(HttpMethod.GET)
		.permitAll()
		.anyRequest()//algun request diferente sera autenticado, el usuario debe estar logueado
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")//establerciendo la pagina de login		 
		.failureUrl("/login?error=true")//pagina si sucede un error en el login
		.usernameParameter("email")//name en el input de ingreso
		.passwordParameter("password")
		.successHandler(authenticationSuccessHandler)
		.and()
		.exceptionHandling()
		.accessDeniedPage("/recurso-prohibido");
		
		http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .invalidSessionUrl("/login");
			
		return http.build();
	}
	
	@Bean 
    @Order(0)
    SecurityFilterChain resources(HttpSecurity http) throws Exception {
        http
            .requestMatchers((matchers) -> matchers.antMatchers("/images/**", "/js/**", "/webjars/**","/css/**"))
            .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
            .requestCache().disable()
            .securityContext().disable()
            .sessionManagement().disable();
        return http.build();
    }
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
