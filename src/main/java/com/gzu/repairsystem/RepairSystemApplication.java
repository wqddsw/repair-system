package com.gzu.repairsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.gzu.repairsystem.mapper")
public class RepairSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepairSystemApplication.class, args);
    }

}