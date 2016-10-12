package cn.zw.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description zookeeper客户端
 * @auther 'Amos'
 * @created 2016/10/10  10:52
 */
public class ZookeeperGetDataUtils extends BaseZookeeper{


    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperGetDataUtils.class);

    private static   ZooKeeper zooKeeper;
    /**
     czxid. 节点创建时的zxid.
     mzxid. 节点最新一次更新发生时的zxid(更新一次就会原子递增1).
     ctime. 节点创建时的时间戳.
     mtime. 节点最新一次更新发生时的时间戳.
     dataVersion. 节点数据的更新次数.
     cversion. 其子节点的更新次数.
     aclVersion. 节点ACL(授权信息)的更新次数.
     */
    private static Stat  stat = new Stat();


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
                    } else if (watchedEvent.getType() == Watcher.Event.EventType.NodeDataChanged) {
                        String path = watchedEvent.getPath();
                        try {
                            // watcher ->: 节点变化就会发通知到监听对象
                            // false 一次监听获取后,将不会继续监听
                            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                                    ,stat.getCzxid(),stat.getMzxid(),stat.getVersion());
                            LOGGER.info("retry get data :{}", new String(zooKeeper.getData(path,true,stat)));
                            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                                    ,stat.getCzxid(),stat.getMzxid(),stat.getVersion());
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

            LOGGER.info("normal get data :{}", new String(zooKeeper.getData(path,true,stat)));

            zooKeeper.setData(createPath,"567".getBytes(),-1);
            zooKeeper.setData(createPath,"110".getBytes(),-1);


//            path = zooKeeper.create(createPath , "456".getBytes(),
//                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            LOGGER.info("create persistent path {} successful ----{}",createPath,path);
//
//
//            path = zooKeeper.create(createPath , "789".getBytes(),
//                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            LOGGER.info("create persistent path {} successful ----{}",createPath,path);
//
//            path = zooKeeper.create(createPath , "101".getBytes(),
//                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            LOGGER.info("create persistent path {} successful ----{}",createPath,path);


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
