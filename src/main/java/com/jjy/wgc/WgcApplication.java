package com.jjy.wgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jjy.wgc.mapper")
public class WgcApplication {

    public static void main(String[] args) {
        SpringApplication.run(WgcApplication.class, args);
    }

}
