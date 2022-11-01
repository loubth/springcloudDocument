package com.loubth.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//和zuul有关的有@EnableZuulServer和@EnableZuulProxy，一般用@EnableZuulProxy，因为虽然当前微服务本质上是服务，但是功能上是代理
@EnableZuulProxy
public class ZuulApplication_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class, args);
    }
}
