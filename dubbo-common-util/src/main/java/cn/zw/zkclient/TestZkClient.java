package cn.zw.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

/**
 * @description
 * @auther 'Amos'
 * @created 2016/10/12  11:42
 */
public class TestZkClient extends  BaseZkClient{

    


    public static void main(String[] args) {

        ZkClient zkClient = getZkClient();
        String  info =zkClient.create("zk-data-zkclient","你好", CreateMode.PERSISTENT);

    }




}
