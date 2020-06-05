package com.example.springbootuserprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.springbootuserprovider.mapper")
@EnableDubbo
public class SpringbootUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUserProviderApplication.class, args);
    }

}
