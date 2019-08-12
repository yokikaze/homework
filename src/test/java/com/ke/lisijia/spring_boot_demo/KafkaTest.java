package com.ke.lisijia.spring_boot_demo;

import com.ke.lisijia.spring_boot_demo.kafka.SinkMessageListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KafkaTest {

    @Test
    public void testSinkMessageListener() throws Exception {
        SinkMessageListener listener = new SinkMessageListener();
        listener.run("losiji");
    }
}
