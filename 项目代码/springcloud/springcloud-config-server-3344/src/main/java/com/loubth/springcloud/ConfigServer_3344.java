package com.loubth.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//开启springcloud-config的server的服务
@EnableConfigServer
public class ConfigServer_3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_3344.class, args);
    }
}