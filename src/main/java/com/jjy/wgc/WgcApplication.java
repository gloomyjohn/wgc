package com.jjy.wgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.jjy.wgc.mapper")
@EnableCaching
public class WgcApplication {

    public static void main(String[] args) {
        SpringApplication.run(WgcApplication.class, args);
    }

}
