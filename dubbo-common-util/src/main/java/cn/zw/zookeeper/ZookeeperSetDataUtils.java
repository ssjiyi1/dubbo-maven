package cn.zw.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @description zookeeper客户端
 * @auther 'Amos'
 * @created 2016/10/10  10:52
 */
public class ZookeeperSetDataUtils extends BaseZookeeper{


    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperSetDataUtils.class);

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
            zooKeeper = getZooKeeper();

            LOGGER.info("**************************第一次主动获取数据，同时获取到版本信息*****************************************");
            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                    ,stat.getCzxid(),stat.getMzxid(),stat.getVersion());
            byte[] buffer = zooKeeper.getData(createPath,false,stat);
            LOGGER.info(" First get  normal result ---->  {}",new String(buffer));
            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                    ,stat.getCzxid(),stat.getMzxid(),stat.getVersion());


            LOGGER.info("**********第一次主动改变数据，同时获取到版本信息*********************************************************");
            // -1  直接在最新版本改变，没有原子性（CAS）
            Stat setStat = zooKeeper.setData(createPath,"1".getBytes(),-1);
            byte[] buffer2 = zooKeeper.getData(createPath,false,stat);
            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                    ,stat.getCzxid(),stat.getMzxid(),stat.getVersion());
            LOGGER.info(" Second get  normal result ---->  {}",new String(buffer2));
            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                    ,stat.getCzxid(),stat.getMzxid(),stat.getVersion());


            LOGGER.info("************在一次改变数据，然后把上次的版本信息传入在次修改（版本不对。CAS失败。既修改失败）*******************************************************");
            /**************change stat version**********************/
            zooKeeper.setData(createPath,"1".getBytes(),-1);
            /***************change stat version*********************/
            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                    ,setStat.getCzxid(),setStat.getMzxid(),setStat.getVersion());
            zooKeeper.setData(createPath,"1".getBytes(),setStat.getVersion());
            byte[] buffer3 = zooKeeper.getData(createPath,false,stat);
            LOGGER.info(" Second get  normal result ---->  {}",new String(buffer3));
            LOGGER.info("stat getCzxid :{}, getMzxid:{},getVersion :{} "
                    ,stat.getCzxid(),stat.getMzxid(),stat.getVersion());
            LOGGER.info("*******************************************************************");





//            zooKeeper.setData(createPath,"1".getBytes(),-1);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }


}
