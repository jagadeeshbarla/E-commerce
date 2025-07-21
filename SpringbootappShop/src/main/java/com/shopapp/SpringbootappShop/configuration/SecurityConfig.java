package com.shopapp.SpringbootappShop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.shopapp.SpringbootappShop.service.CustomUserDetailsService;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 @Autowired
	 private CustomAccessDeniedHandler accessDeniedHandler;
	 
	 @Autowired
	 private CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/home/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/customer/**").hasRole("CUSTOMER")
                .requestMatchers("/manager/**").hasRole("MANAGER")
                .anyRequest().authenticated()
            )
            .exceptionHandling(exceptions -> exceptions
                    .accessDeniedHandler(accessDeniedHandler)
             )
            .formLogin(withDefaults())
            .logout(logout -> logout
            	    .logoutUrl("/logout")
            	    .logoutSuccessUrl("/home/homepage")
            	    .invalidateHttpSession(true)
            	    .deleteCookies("JSESSIONID")
            ).userDetailsService(customUserDetailsService);
        
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//    	UserDetails admin1 = User.withDefaultPasswordEncoder()
//    			.username("test1")
//    			.password("4321")
//    			.roles("ADMIN")
//    			.build();
//    	
//    	UserDetails user1 = User.withDefaultPasswordEncoder()
//    			.username("test2")
//    			.password("1234")
//    			.roles("CUSTOMER")
//    			.build();
//    	
//    	UserDetails manager1 = User.withDefaultPasswordEncoder()
//    			.username("test3")
//    			.password("abcd")
//    			.roles("MANAGER")
//    			.build();
//    	
//		return new InMemoryUserDetailsManager(admin1 , user1 , manager1);
//    	
//    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/WEB-INF/**");
    }
}
