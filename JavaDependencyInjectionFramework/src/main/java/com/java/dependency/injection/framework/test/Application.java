package com.java.dependency.injection.framework.test;

import com.java.dependency.injection.framework.core.ApplicationContext;
import com.java.dependency.injection.framework.core.annotations.ComponentScan;
import com.java.dependency.injection.framework.core.annotations.Configuration;

@Configuration
@ComponentScan("com.java.dependency.injection.framework.test")
class Config {
}

public class Application {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ApplicationContext(Config.class);
            StudentService service = context.getInstance(StudentService.class);

            System.out.println(service.getInformation(1));
            System.out.println(service.getInformation(2));
            System.out.println(service.getInformation(3));
            System.out.println(service.getInformation(4));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
