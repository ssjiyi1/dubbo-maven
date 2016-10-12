package cn.zw.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @description
 * @auther 'Amos'
 * @created 2016/10/12  11:42
 */
public class TestZkClient extends  BaseZkClient{

    private static final Logger LOGGER = getLogger(TestZkClient.class);

    public static void main(String[] args) {
        ZkClient zkClient = getZkClient();
//        zkClient.subscribeChildChanges()
        String path = "/zk-data-zkclient";
//        String  info =zkClient.create(path,"你好", CreateMode.PERSISTENT);
//        zkClient.createPersistent(path+"/aa",true);
//        LOGGER.info("create ");
//        zkClient.getChildren()
//        zkClient.deleteRecursive(path);
//            zkClient.readData(path)

//        zkClient.writeData(path,"dsf",1);




    }




}
