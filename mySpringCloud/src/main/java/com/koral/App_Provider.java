package com.koral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
public class App_Provider {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(App_Provider.class);
        ConfigurableEnvironment environment = ctx.getEnvironment();
        while (true){
            //When configurations are refreshed dynamically, they will be updated in the Enviroment, therefore here we retrieve configurations from Environment every other second.
            String userName = environment.getProperty("user.name");
            String userAge = environment.getProperty("user.age");
            System.err.println("user name :" + userName + "; age: " + userAge);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}