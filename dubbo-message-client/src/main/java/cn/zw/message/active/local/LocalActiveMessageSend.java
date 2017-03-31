package cn.zw.message.active.local;

import cn.zw.duubo.message.common.Message;
import cn.zw.message.active.DestinationBuilder;
import cn.zw.message.cfg.ActiveMqCfg;

import javax.jms.*;


/**
 * @description activemq自己的实现
 * @auther 'Amos'
 * @created 2016/9/12  11:11
 */
public class LocalActiveMessageSend extends LocalActiveMqSendAble {





    @Override
    public void sendTransactionMessage(Message msg) {
        try {
            if(null==session){
                session = ActiveMqCfg.getInstance().getSessionWithAutoACKTransactional();
            }
            Destination destination = DestinationBuilder.getDestination(msg.getMessageType());
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(destination, session.createTextMessage(msg.getData().toString()));
            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void sendClinetModel(Message msg, int type) {
        if(null==session){
            session = ActiveMqCfg.getInstance().getSessionWithClientACKTransactional(type);
        }
        try {
            Destination destination = DestinationBuilder.getDestination(msg.getMessageType());
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(destination, session.createTextMessage(msg.getData().toString()));
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


}
