package cn.zw.zookeeper;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description zookeeper客户端
 * @auther 'Amos'
 * @created 2016/10/10  10:52
 */
public class ZookeeperGetChildrenUtils extends BaseZookeeper{


    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperGetChildrenUtils.class);

    private static   ZooKeeper zooKeeper;


    public static void main(String[] args) {
        syn();
    }


    private static void syn() {
        try {
            String createPath = "/zk-data";
            zooKeeper = getZooKeeper(watchedEvent -> {
                LOGGER.info(watchedEvent.toString());
                if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                    if (Watcher.Event.EventType.None == watchedEvent.getType() &&
                             null == watchedEvent.getPath() ) { // first connection
                        ZOOKEEPER_CONNECTED.countDown();
                    } else if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                        String path = watchedEvent.getPath();
                        try {
                            // watcher ->: 节点变化就会发通知到监听对象
                            // false 一次监听获取后,将不会继续监听
                            LOGGER.info("retry get data :{}", zooKeeper.getChildren(path, false).toString());
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }







            });
            String path = zooKeeper.create(createPath, "123".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            LOGGER.info("create ephemeral path {} successful ----{}",createPath,path);

            path = zooKeeper.create(createPath + "/c1", "456".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            LOGGER.info("create persistent path {} successful ----{}",createPath,path);

            List<String> data = zooKeeper.getChildren(createPath,Boolean.TRUE);

            LOGGER.info("the result is {} of zookeeper ",data.toString());

            path = zooKeeper.create(createPath + "/c2", "789".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            LOGGER.info("create persistent path {} successful ----{}",createPath,path);

            path = zooKeeper.create(createPath + "/c3", "101".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            LOGGER.info("create persistent path {} successful ----{}",createPath,path);



            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }


}
