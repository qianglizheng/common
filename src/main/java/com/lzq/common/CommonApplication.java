package com.lzq.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzq.common.mapper")
public class CommonApplication {

    public static void main(String[] args) {
        System.out.println("test");
        SpringApplication.run(CommonApplication.class, args);
    }
}
