package com.koreait.serverimpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.koreait.serverimpl.mapper")
public class ServerImplApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerImplApplication.class, args);
    }
}
