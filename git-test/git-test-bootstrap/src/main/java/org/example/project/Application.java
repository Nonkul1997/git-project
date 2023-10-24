package org.example.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 主程序类
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/24 18:43
 */
@SpringBootApplication
@MapperScan("org.example.project.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
