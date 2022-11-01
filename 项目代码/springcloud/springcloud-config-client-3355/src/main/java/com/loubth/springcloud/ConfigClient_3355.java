package com.loubth.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//springcloud-config-client不需要在启动类上用@EableXXX
public class ConfigClient_3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_3355.class, args);
    }
}
