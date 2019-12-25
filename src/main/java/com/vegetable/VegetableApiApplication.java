package com.vegetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.vegetable.mapper") //扫描 mapeer 包下的接口
public class VegetableApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VegetableApiApplication.class, args);
    }

}
