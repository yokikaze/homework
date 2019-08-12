package com.ke.lisijia.spring_boot_demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableCaching
@EnableEurekaServer
public class SpringBootDemoApplication {

    public static void main(String[] args) {
       SpringApplication app = new SpringApplication();
       app.setBannerMode(Banner.Mode.CONSOLE);
       app.run(SpringBootDemoApplication.class, args);
    }

}
