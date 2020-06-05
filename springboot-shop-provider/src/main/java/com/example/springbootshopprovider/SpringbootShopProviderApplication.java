package com.example.springbootshopprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.springbootshopprovider.mapper")
@EnableDubbo
public class SpringbootShopProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShopProviderApplication.class, args);
    }

}
