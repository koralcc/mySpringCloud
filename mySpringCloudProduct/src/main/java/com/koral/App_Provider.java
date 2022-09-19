package com.koral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
            //多配置文件①
            String common0name = environment.getProperty("common.name");
            String common0age = environment.getProperty("common.age");
            //多配置文件②
            String common1name = environment.getProperty("common1.name");
            String common1age = environment.getProperty("common1.age");
            String common2name = environment.getProperty("common2.name");
            String common2age = environment.getProperty("common2.age");

            System.err.println("in "+currentEnv+" enviroment; "+"user name :" + userName + "; age: " + userAge
                    + "commonName0:"+common0name +"common0age:"+common0age
                    + "commonName1:"+common1name +"common1age:"+common1age
                    + "commonName2:"+common2name +"common2age:"+common2age);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}