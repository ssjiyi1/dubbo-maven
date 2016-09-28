package cn.zw.dubbo.redis;

import redis.clients.jedis.JedisShardInfo;

/**
 * @description 切换数据库索引
 * @auther 'Amos'
 * @created 2016/9/27  17:37
 */
public class SwitchDBRedisInfo extends JedisShardInfo {


    public SwitchDBRedisInfo(String host, int port, int db) {
        super(host, port);
    }
}
