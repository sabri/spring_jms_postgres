package com.sabrouch.springjmspostgres;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringjmspostgresApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjmspostgresApplication.class, args);
    }
  @Bean
    CommandLineRunner commandLineRunner (){
        return args -> {
            System.out.println("I am working");
        };
  }
}
