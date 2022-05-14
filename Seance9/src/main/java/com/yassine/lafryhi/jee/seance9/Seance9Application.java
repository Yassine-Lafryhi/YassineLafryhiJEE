package com.yassine.lafryhi.jee.seance9;

import com.yassine.lafryhi.jee.seance9.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Seance9Application {

    public static void main(String[] args) {
        SpringApplication.run(Seance9Application.class, args);
    }

    @Bean
    CommandLineRunner saveUsers(SecurityService securityService) {
        return args -> {
            securityService.saveNewUser("yassine", "12345", "12345");
            securityService.saveNewUser("admin", "12345", "12345");
            securityService.saveNewUser("omar", "12345", "12345");
            securityService.saveNewUser("hafsa", "12345", "12345");
            securityService.saveNewUser("haitham", "12345", "12345");
            securityService.saveNewUser("user", "12345", "12345");

            securityService.saveNewRole("USER", "user");
            securityService.saveNewRole("ADMIN", "admin");

            securityService.addRoleToUser("omar", "ADMIN");
            securityService.addRoleToUser("yassine", "ADMIN");
            securityService.addRoleToUser("admin", "ADMIN");
            securityService.addRoleToUser("hafsa", "USER");
            securityService.addRoleToUser("haitham", "USER");
            securityService.addRoleToUser("user", "USER");
        };
    }


}
