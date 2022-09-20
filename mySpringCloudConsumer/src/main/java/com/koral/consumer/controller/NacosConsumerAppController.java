package com.koral.consumer.controller;


import com.koral.api.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

@RestController
public class NacosConsumerAppController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private EchoService echoService;


    @GetMapping("/echo/app-name")
    public String echoAppName() throws InterruptedException {

        //return restTemplate.getForObject("http://localhost:8081/echo/microservice", String.class);

        // ribbon的调用方式(eureke和consule的注册中心，默认集成了ribbon不需要导入额外依赖) ：1. discovery client 2.loadBalanceClient 3.@loadBalance
        //1. DiscoveryClient， 可以获取到所有的服务实体，自己实现负载均衡
//        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-provider");
//        for (ServiceInstance instance : instances) {
//            System.out.println(instance.getHost());
//            System.out.println(instance.getPort());
//        }

        //2. loadBalanceClient
//        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
//        String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
//        System.out.println("request path:"+path);
//        return restTemplate.getForObject(path, String.class);

        //3. @loadBalanced
//        String uri = "http://nacos-provider/echo/" + appName;
//        System.out.println("uri:"+uri);
//        return restTemplate.getForObject(uri + appName, String.class);

        return echoService.echo("hello");


    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

    // 1.只使用redisTemplate问题：url地址写死了，不能用服务名称进行路由
    // 2.没有负载均衡，需要自己实现负载均衡算法
}
