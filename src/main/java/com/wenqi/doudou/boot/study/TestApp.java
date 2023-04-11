package com.wenqi.doudou.boot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableService
public class TestApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestApp.class, args);
        context.getBean(TestService.class);


    }
}
