package com.karaca.customertrackingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CustomerTrackingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTrackingSystemApplication.class, args);
        System.out.println("ok");
    }

}
