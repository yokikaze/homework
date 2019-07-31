package com.ke.lisijia.spring_boot_demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class StartRunner implements CommandLineRunner {

    @Override
    public void run(String... args)throws Exception{
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>项目已成功启动<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
