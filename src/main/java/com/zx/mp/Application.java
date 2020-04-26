package com.zx.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/26 0026 16:40
 * @Version 1.0
 */

@SpringBootApplication
@MapperScan("com.zx.mp.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
