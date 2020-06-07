package com.example.springbootorderprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.springbootorderprovider.mapper")
@EnableDubbo
@ImportResource(locations = {"classpath:tcc-transaction.xml", "classpath:tcc-transaction-dubbo.xml"})
public class SpringbootOrderProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOrderProviderApplication.class, args);
    }

}
