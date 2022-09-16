package com.koral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class App_Provider {
    public static void main(String[] args) {
        SpringApplication.run(App_Provider.class);
    }
}