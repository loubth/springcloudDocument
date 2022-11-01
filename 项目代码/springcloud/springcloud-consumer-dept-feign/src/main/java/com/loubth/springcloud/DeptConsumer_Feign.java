package com.loubth.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
/*
 * 这个注解可以扫描到springcloud-api子模块下的DeptClientService.java，但是为什么可以跨模块扫描？
 * 因为api是公共模块，在pom中导入了已经，每个子模块都有引入这个公共模块，就没有跨模块编程
 * */
@EnableFeignClients(basePackages = {"com.loubth.springcloud"})
public class DeptConsumer_Feign {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign.class, args);
    }
}

