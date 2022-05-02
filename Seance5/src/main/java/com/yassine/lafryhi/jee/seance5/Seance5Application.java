package com.yassine.lafryhi.jee.seance5;

import java.util.stream.Stream;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yassine.lafryhi.jee.seance5.entities.Role;
import com.yassine.lafryhi.jee.seance5.entities.User;
import com.yassine.lafryhi.jee.seance5.services.RoleService;
import com.yassine.lafryhi.jee.seance5.services.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Seance5Application {

    public static void main(String[] args) {
        SpringApplication.run(Seance5Application.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests().anyRequest().permitAll();
        }
    }

    @Bean
    CommandLineRunner start(UserService userService, RoleService roleService) {
        return args -> {

            Faker faker = new Faker();

            String firstUsername = faker.name().username();
            String secondUsername = faker.name().username();

            String firstPassword = faker.name().name();
            String secondPassword = faker.name().name();

            User firstUser = new User();
            firstUser.setUsername(firstUsername);
            firstUser.setPassword(firstPassword);
            userService.addNewUser(firstUser);

            User secondUser = new User();
            secondUser.setUsername(secondUsername);
            secondUser.setPassword(secondPassword);
            userService.addNewUser(secondUser);

            Stream.of("STUDENT", "USER", "ADMIN").forEach(role -> {
                Role theRole = new Role();
                theRole.setRoleName(role);
                theRole.setDescription("ROLE OF : " + role);
                roleService.addRole(theRole);
            });

            userService.assignRoleToUser(firstUsername, "STUDENT");
            userService.assignRoleToUser(firstUsername, "USER");

            userService.assignRoleToUser(secondUsername, "ADMIN");
            userService.assignRoleToUser(secondUsername, "USER");

            try {
                User user = userService.authenticate(firstUsername, firstPassword);
                System.out.println(user.getId());
                System.out.println(user.getUsername());
                user.getRoles().forEach(System.out::println);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
    }
}
