package com.yassine.lafryhi.jee.seance7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();
        String encodedPWD = passwordEncoder.encode("12345");
        System.out.println(encodedPWD);
        auth.inMemoryAuthentication().withUser("user").password(encodedPWD).roles("USER");
        auth.inMemoryAuthentication().withUser("yassine").password(passwordEncoder.encode("12345")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("12345")).roles("USER", "ADMIN");

        /*auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal, password as credentials,active from users where username = ?")
                .authoritiesByUsernameQuery("select username as principal, role as users_roles from roles where username=?")
                .rolePrefix("ROLE_").passwordEncoder(passwordEncoder);*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/delete/**", "/edit/**", "/add-patient/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/patients-list/**").hasRole("USER");
        http.authorizeRequests().anyRequest().authenticated();
        //http.exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
