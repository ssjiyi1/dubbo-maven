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
    public void send(Message msg,int type) {

        try {   //todo
            Session session = null;
            if(type==AUTO_ACK){  // 显然不合理。创建消息就要重新创建factory和connection和session
                session = ActiveMqCfg.getInstance().getSessionWithAutoACKTransactional();
            }else if(type==CLIENT_ACK){
                session = ActiveMqCfg.getInstance().getSessionWithClientACKTransactional();
            }
            Destination destination = DestinationBuilder.getDestination(msg.getMessageType());
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(destination, session.createTextMessage(msg.getData().toString()));
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
