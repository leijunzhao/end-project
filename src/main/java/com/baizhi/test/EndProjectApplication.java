package com.baizhi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.baizhi.test.mapper")
public class EndProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndProjectApplication.class, args);
    }

}

