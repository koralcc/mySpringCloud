package com.koral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableDiscoveryClient
public class App_Provider {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App_Provider.class);
        ConfigurableEnvironment environment = ctx.getEnvironment();
        String name = environment.getProperty("user.name");
        String age = environment.getProperty("user.age");
        System.out.println("name" +name+"age:"+age);
    }
}