package com.naresh.parkingspace.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.naresh.parkingspace")
@PropertySource("classpath:parkingspace.properties")
public class ParkingApplication {

  public static void main(String[] args) {
    SpringApplication.run(ParkingApplication.class, args);
  }

}