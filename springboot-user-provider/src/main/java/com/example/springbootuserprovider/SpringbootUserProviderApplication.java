package com.example.springbootuserprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.example.srpingbootuserprovider.mapper")
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.example.srpingbootuserprovider.service.impl")
@PropertySource("classpath:/user-provider.yml")
public class SpringbootUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUserProviderApplication.class, args);
    }

}
