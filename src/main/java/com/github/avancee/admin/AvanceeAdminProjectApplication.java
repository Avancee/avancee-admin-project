package com.github.avancee.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author byference
 * @since 2019-11-01
 */
@MapperScan("com.github.avancee.admin.modules.*.mapper")
@SpringBootApplication
public class AvanceeAdminProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvanceeAdminProjectApplication.class, args);
    }

}
