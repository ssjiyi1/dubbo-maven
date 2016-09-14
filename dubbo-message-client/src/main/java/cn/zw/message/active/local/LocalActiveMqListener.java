package cn.zw.message.active.local;

import cn.zw.message.active.DestinationBuilder;
import cn.zw.message.active.MessageType;
import cn.zw.message.cfg.ActiveMqCfg;

import javax.jms.*;

/**
 * @description activemq监听方式实现获取消息
 * @auther 'Amos'
 * @created 2016/9/12  13:52
 */
public class LocalActiveMqListener extends LocalActiveMqListenerAble {


    @Override
    public void Listener(MessageType messageType) {
        try {
            Session session = ActiveMqCfg.getInstance().getSessionWithOutTranscational();
            Destination destination = DestinationBuilder.getDestination(messageType);
            MessageConsumer messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(message -> {
                if (message instanceof TextMessage) {
                    try {
                        System.out.println(((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(message);
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
