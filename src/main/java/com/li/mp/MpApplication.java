package com.li.mp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@MapperScan("com.li.mp.Mapper")
@EnableDiscoveryClient
public class MpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MpApplication.class, args);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
