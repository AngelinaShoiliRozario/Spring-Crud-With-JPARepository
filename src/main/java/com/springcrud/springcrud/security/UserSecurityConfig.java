package com.springcrud.springcrud.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {
    @Bean
    InMemoryUserDetailsManager userDetailsManager(){
        UserDetails jhon = User.builder().username("jhon").password("{noop}test123").roles("CLIENT").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("CLIENT","MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("CLIENT","MANAGER","ADMIN").build();
        return new InMemoryUserDetailsManager(jhon,mary,susan);
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
            .authorizeHttpRequests(configurer-> configurer
                .requestMatchers(HttpMethod.GET,"/api/students").hasRole("CLIENT")
                .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("CLIENT")
                .requestMatchers(HttpMethod.POST,"/api/students").hasAnyRole("MANAGER","ADMIN")
                .requestMatchers(HttpMethod.PUT,"/api/students/**").hasAnyRole("MANAGER","ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasRole("ADMIN"));
        //Use Http Basic Authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        // User CSRF disabled to resolve csrf attacks
        httpSecurity.csrf(csrf->csrf.disable());
    
        return httpSecurity.build();
    }
}
