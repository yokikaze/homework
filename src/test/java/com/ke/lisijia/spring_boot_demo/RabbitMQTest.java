package com.ke.lisijia.spring_boot_demo;

import com.ke.lisijia.spring_boot_demo.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    Sender sender;

    @Test
    public void hello() throws Exception{
        sender.send("this is RabbitMQ message");
    }
}
