package com.ke.lisijia.spring_boot_demo;

import com.ke.lisijia.spring_boot_demo.kafka.ZookeeperProSync;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

@Slf4j
public class ZookeeperTest {

    @Test
    public void testZookeeper() throws Exception {
        String path = "/Tohou";
        ZookeeperProSync.zooKeeper = new ZooKeeper("127.0.0.1:2181",
                                                    6000,
                                                    new ZookeeperProSync());
        ZookeeperProSync.connectedSemaphore.await();
        log.info("{}", new String(ZookeeperProSync.zooKeeper.getData(path, true, ZookeeperProSync.stat)));
      //  String data = new String(ZookeeperProSync.zooKeeper.getData(path, true, ZookeeperProSync.stat));
        Thread.sleep(Integer.MAX_VALUE);

    }
}
