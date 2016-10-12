package cn.zw.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @description zookeeper客户端
 * @auther 'Amos'
 * @created 2016/10/10  10:52
 */
public class ZookeeperCreateUtils extends BaseZookeeper {


    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperCreateUtils.class);


    public static void main(String[] args) {
//        asyn();
        syn();
    }


    public static void asyn() {
        try {

            ZooKeeper zooKeeper = getZooKeeper();

            /**
             *       /**
             *  * @param rc   The return code or the result of the call.
             * @param path The path that we passed to asynchronous calls.
             * @param ctx  Whatever context object that we passed to
             *             asynchronous calls.
             * @param name The name of the Znode that was created.
             *             On success, <i>name</i> and <i>path</i> are usually
             *             equal, unless a sequential node has been created.
             */
            zooKeeper.create("/zk-data", "123".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                    (rc, path1, ctx, name) ->
                            LOGGER.info("created result rc {}, path1 {} , ctx {} , name {}", rc, path1, ctx, name), "last");


            zooKeeper.create("/zk-data", "123".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, (rc, path1, ctx, name) ->
                            LOGGER.info("created result rc {}, path1 {} , ctx {} , name {}", rc, path1, ctx, name), "last");


            TimeUnit.SECONDS.sleep(10000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void syn() {
        try {
            ZooKeeper zooKeeper = getZooKeeper();

            String path = zooKeeper.create("/zk-data", "123".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            LOGGER.info("make zookeeper path {}", path);


            path = zooKeeper.create("/zk-data/1", "123".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            LOGGER.info("make zookeeper path {}", path);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

}
