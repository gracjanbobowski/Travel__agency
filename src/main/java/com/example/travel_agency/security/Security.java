package com.example.travel_agency.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class Security {

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
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/admin-login")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().hasRole("ADMIN")
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/configure-offer", "/add-tour").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/index").hasAnyRole("OWNER")
                        .anyRequest().authenticated()

                )
                .formLogin(withDefaults());
        return http.build();
    }
}


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(config -> config
//
//                        .requestMatchers(HttpMethod.GET, "/css/**").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/js/**").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/admin-login").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/login").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/index").hasAnyRole("OWNER", "PROPERTY_MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/configure-offer", "/add-tour").hasAnyRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/owner").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .logout(logout -> logout.logoutUrl("/logout"));
//
//        http.formLogin(Customizer.withDefaults());
//
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//}

//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        // ensure the passwords are encoded properly
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("password").roles("USER").build());
//        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
//        return manager;
//    }




