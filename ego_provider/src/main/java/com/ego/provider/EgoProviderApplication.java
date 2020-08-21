package com.ego.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = {"com.ego.mapper"})
public class EgoProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EgoProviderApplication.class, args);
    }
}
