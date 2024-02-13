package com.Rupesh.hotalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotalServiceApplication.class, args);
    }

}
