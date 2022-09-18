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
            //Get the current deployment environment
            String currentEnv =environment.getProperty("current.env");
            //读取ext配置文件
            String common0name = environment.getProperty("common.name");
            String common0age = environment.getProperty("common.age");
            System.err.println("in "+currentEnv+" enviroment; "+"user name :" + userName + "; age: " + userAge + "commonName:"+common0name +"common0age:"+common0age);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}