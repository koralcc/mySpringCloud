package com.koral.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @Value("${server.port}")
    private String port;
    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string){
        return "Hello Nacos Discovery " + string + port ;
    }
}
