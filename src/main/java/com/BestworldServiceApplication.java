package com;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com", annotationClass = Mapper.class)
public class BestworldServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestworldServiceApplication.class, args);
    }

}
