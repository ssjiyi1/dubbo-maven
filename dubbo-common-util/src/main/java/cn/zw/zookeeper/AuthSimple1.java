package cn.zw.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @description
 * @auther 'Amos'
 * @created 2016/10/11  18:07
 */
public class AuthSimple1 extends BaseZookeeper {

    public final  static String PATH = "/zk-data-auth";

    public static final Logger LOGGER  = LoggerFactory.getLogger(AuthSimple1.class);

    public static void main(String[] args) {

        try {
            ZooKeeper zooKeeper = getZooKeeper();
            zooKeeper.addAuthInfo("digest","foo:true".getBytes());
//            String createInfoPath =zooKeeper.create(PATH+"/1","123".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
//            LOGGER.info("create contain auth info   path {} success --->{}",PATH,createInfoPath);



             ZooKeeper zooKeeper1 = getZooKeeper();
            zooKeeper1.delete(PATH,-1);
//             byte[] bytes = zooKeeper1.getData(PATH,null,null);
//            LOGGER.info("other zookeeper client get result -->{}",new String(bytes));




        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }


    }


}
