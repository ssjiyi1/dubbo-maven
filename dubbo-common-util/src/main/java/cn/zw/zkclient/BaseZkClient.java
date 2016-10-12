package cn.zw.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * @description
 * @auther 'Amos'
 * @created 2016/10/12  11:45
 */
public class BaseZkClient  {


    public static ZkClient getZkClient(){

        ZkClient zkClient =  new ZkClient("server1:2181,192.168.1.49:2181",5000);

        return zkClient;

    }

}
