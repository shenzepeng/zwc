package com.example.zwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@MapperScan("com.example.zwc.mapper")
@SpringBootApplication
public class ZwcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZwcApplication.class, args);
    }

}
