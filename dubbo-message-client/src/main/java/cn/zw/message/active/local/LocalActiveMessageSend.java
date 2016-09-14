package cn.zw.message.active.local;

import cn.zw.message.active.DestinationBuilder;
import cn.zw.message.active.Message;
import cn.zw.message.cfg.ActiveMqCfg;

import javax.jms.*;

/**
 * @description activemq自己的实现
 * @auther 'Amos'
 * @created 2016/9/12  11:11
 */
public class LocalActiveMessageSend extends LocalActiveMqSendAble {


    @Override
    public void send(Message msg) {

        try {
            Session session = ActiveMqCfg.getInstance().getSessionWithTranscational();
            Destination destination = DestinationBuilder.getDestination(msg.getMessageType());
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(destination, session.createTextMessage(msg.getData().toString()));
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
