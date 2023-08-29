package com.example.travel_agency.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Security {


//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails gbobo = User.builder()
//                .username("gbobo")
//                .password("{noop}test123")
//                .roles("USER")
//                .build();
//
//        UserDetails sda = User.builder()
//                .username("sda")
//                .password("{noop}test123")
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(gbobo, sda);
//    }
//}

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, true from users where username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, authority from authorities where username = ?");
        return jdbcUserDetailsManager;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( config ->
                        config
                                .requestMatchers(HttpMethod.GET, "/css/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/js/**").permitAll()
                                .requestMatchers(HttpMethod.GET, "/").permitAll()
                                .requestMatchers(HttpMethod.GET, "/admin-login").permitAll()
                                .requestMatchers(HttpMethod.GET, "/login").permitAll()
                                .requestMatchers(HttpMethod.GET, "/index").hasAnyRole("OWNER", "PROPERTY_MANAGER", "ADMIN")
                                .requestMatchers(HttpMethod.GET, "/configure-offer", "/add-tour").hasAnyRole("ADMIN")
                                //      .requestMatchers(HttpMethod.GET, "/home2").hasRole("OWNER")
                                .requestMatchers(HttpMethod.GET, "/owner").permitAll()
                                .anyRequest().authenticated()
//
//                        .requestMatchers(HttpMethod.GET, "/api/owners").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST, "/api/owner").hasRole("USER")
//                        .requestMatchers(HttpMethod.POST, "/api/createVet").hasRole("VET")
//                        .requestMatchers(HttpMethod.POST, "/api/createSpeciality").hasRole("ADMIN")
        )
                .logout( logout -> logout.logoutUrl("/logout"));

        http.formLogin(Customizer.withDefaults());
/*                http.formLogin(form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/authenticateUser") //admin-login
                    .permitAll());
                http.httpBasic(Customizer.withDefaults());*/

        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}


