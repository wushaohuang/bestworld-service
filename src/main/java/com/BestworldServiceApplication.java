package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com")
public class BestworldServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestworldServiceApplication.class, args);
        System.out.println("111111");
    }

}
