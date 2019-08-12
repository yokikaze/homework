package com.ke.lisijia.spring_boot_demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class ZookeeperProSync implements Watcher {

    public static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    public static ZooKeeper zooKeeper = null;
    public static Stat stat = new Stat();

    public void process(WatchedEvent event) {
        if(Event.KeeperState.SyncConnected == event.getState()) {
            if(Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if (event.getType() == Event.EventType.NodeDataChanged) {
                try {
                    log.info("{}：{}", "配置已更改，新值为", zooKeeper.getData(event.getPath(), true, stat));
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
