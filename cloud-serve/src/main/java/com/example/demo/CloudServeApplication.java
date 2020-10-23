package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangpengcheng
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServeApplication.class, args);
    }

}
