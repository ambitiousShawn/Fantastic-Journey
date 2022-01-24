package com.cloudnote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.cloudnote.dao")
@ServletComponentScan
@EnableTransactionManagement
public class Clounote9Application {

    public static void main(String[] args) {
        SpringApplication.run(Clounote9Application.class, args);
    }
}
