package com.loubth.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
//@SpringBootApplication注解让当前类编程子module的主启动类
@SpringBootApplication
public class DeptProvider_8003 {
    public static void main(String[] args) {
        //第一个参数为启动类的类名，第二个参数为main函数的输入参数args
        SpringApplication.run(DeptProvider_8003.class, args);
    }
}


