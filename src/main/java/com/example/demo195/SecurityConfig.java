package com.example.demo195;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean

    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().
              username("user").
              password("user1")
              .roles("USER")
              .build();
        UserDetails mod = User.withDefaultPasswordEncoder().
                username("mod").
                password("mod1")
                .roles("MOD")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder().
                username("admin").
                password("admin1")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin, mod);

    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/mod").hasRole("MOD")
                .antMatchers("/h2/**").hasAnyRole("MOD", "USER", "ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .permitAll();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2/**");
    }
}
