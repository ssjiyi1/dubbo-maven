package cn.zw.zookeeper;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @description
 * @auther 'Amos'
 * @created 2016/10/11  10:59
 */
public class BaseZookeeper {


    public final static CountDownLatch ZOOKEEPER_CONNECTED = new CountDownLatch(1);

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseZookeeper.class);

    public static ZooKeeper getZooKeeper() throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("server1:2181,192.168.1.49:2181", 2000,
                watchedEvent -> {
                    LOGGER.info(watchedEvent.toString());
                    if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                        ZOOKEEPER_CONNECTED.countDown();
                    }
                });
        ZOOKEEPER_CONNECTED.await();
        LOGGER.info("zookeeper connected ...");
        LOGGER.info("zookeeper sessionid :{}", zooKeeper.getSessionId());
        return zooKeeper;
    }



    public static ZooKeeper getZooKeeper(Watcher watcher) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("server1:2181,192.168.1.49:2181", 2000,watcher);
        ZOOKEEPER_CONNECTED.await();
        LOGGER.info("zookeeper connected ...");
        LOGGER.info("zookeeper sessionid :{}", zooKeeper.getSessionId());
        return zooKeeper;
    }

}
