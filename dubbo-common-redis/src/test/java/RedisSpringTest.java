/**
 * 基于Dubbo的分布式系统架构视频教程，吴水成，wu-sc@foxmail.com，学习交流QQ群：367211134
 **/

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 *
 * @描述: Redis测试 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-3-23,上午1:30:40 .
 * @版本号: V1.0 .
 */
public class RedisSpringTest {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
            context.start();

            ShardedJedisPool pool = (ShardedJedisPool) context.getBean("shardedJedisPool");
            ShardedJedis redis = pool.getResource();
            String key = "k1";
            String value = "hello";
            redis.set(key,value);
            context.stop();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
