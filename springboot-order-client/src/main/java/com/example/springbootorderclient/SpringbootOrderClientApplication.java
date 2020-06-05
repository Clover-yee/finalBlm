package com.example.springbootorderclient;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SpringbootOrderClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOrderClientApplication.class, args);
    }

}
