package cn.zw.message.cfg;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @description activemq的初始构建类
 * @auther 'Amos'
 * @created 2016/9/12  11:13
 */
public class ActiveMqCfg {



    private ConnectionFactory connectionFactory ; // 连接工厂，用于连接activemq

    private Connection connection ; // 连接


    private static ActiveMqCfg activeMqCfg = new ActiveMqCfg();

    public static ActiveMqCfg getInstance() {
        return activeMqCfg;
    }

    private ActiveMqCfg(){
        initFactory();
        initConnection();
    }

    private    void  initFactory(){
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "failover://tcp://server1:61616");
    }

    /**
     *  获取连接
     * @return
     */
    private  void initConnection(){
        try {
            connection =  connectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  获取session
     */
    public  Session  getSessionWithTranscational(){
        // 创建Session，参数解释：
        // 第一个参数是否使用事务:当消息发送者向消息提供者（即消息代理）发送消息时，消息发送者等待消息代理的确认，没有回应则抛出异常，消息发送程序负责处理这个错误。
        // 第二个参数消息的确认模式：
        // AUTO_ACKNOWLEDGE ： 指定消息提供者在每次收到消息时自动发送确认。消息只向目标发送一次，但传输过程中可能因为错误而丢失消息。
        // CLIENT_ACKNOWLEDGE ： 由消息接收者确认收到消息，
        // 通过调用消息的acknowledge()方法（会通知消息提供者收到了消息）
        // DUPS_OK_ACKNOWLEDGE ： 指定消息提供者在消息接收者没有确认发送时重新发送消息（这种确认
        try {
            return  connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public  Session  getSessionWithOutTranscational(){
        try {
            return  connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }





}
