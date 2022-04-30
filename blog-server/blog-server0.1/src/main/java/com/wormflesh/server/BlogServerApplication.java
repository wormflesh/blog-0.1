package com.wormflesh.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 启动程序
 * @Author: wormflesh
 * @Date: Created in 12:27 2022/4/28
 */
@SpringBootApplication
@MapperScan("com.wormflesh.server.mapper")
public class BlogServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogServerApplication.class);
    }
}
