package cn.zw.dubbo.consumer;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @description 消息的消费者
 * @auther 'Amos'
 * @created 2016/9/26  14:51
 */
@Component("AMQMessagelistener")
public class AMQMessagelistener implements SessionAwareMessageListener {


    @Override
    public void onMessage(Message message, Session session) throws JMSException {

        ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
        System.out.println(msg + "=================>" +msg.getText());
        System.out.println(1/0);


    }
}
