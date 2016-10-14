package cn.zw.message.active.local;

import cn.zw.duubo.message.common.MessageType;
import cn.zw.message.active.DestinationBuilder;
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
            Session session = ActiveMqCfg.getInstance().getSessionWithOutClientACKTransactional();
            Destination destination = DestinationBuilder.getDestination(messageType);
            MessageConsumer messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(message -> {
                if (message instanceof TextMessage) {
                    try {
                        TextMessage message1 = (TextMessage) message;

                        System.out.println(message1.getText() + " JMSCorrelationID:" +
                                message1.getJMSCorrelationID() + " getJMSMessageID:" + message1.getJMSMessageID() + " this:" + this);
                        System.out.println("-----消息确认11----");

                        if (message1.getText().contains("99")) {
                            System.out.println("pre ack");
                            message1.acknowledge();
                            /**
                             * 1) message.acknowledge()，
                             * 2)ActiveMQMessageConsumer.acknowledege()，
                             * 3) ActiveMQSession.acknowledge()；
                             * 其1)和3)是等效的，将当前session中所有consumer中尚未ACK的消息都一起确认，
                             * 2)只会对当前consumer中那些尚未确认的消息进行确认。开发者可以在合适的时机必须调用一次上述方法。
                             *ActiveMQMessageConsumer.acknowledege()
                             */
                        }

                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(message);
                }
            });

            session.createConsumer(destination).setMessageListener(message -> {
                if (message instanceof TextMessage) {
                    try {
                        TextMessage message1 = (TextMessage) message;
                        System.out.println(message1.getText() + " JMSCorrelationID:" +
                                message1.getJMSCorrelationID() + " getJMSMessageID:" +
                                message1.getJMSMessageID() + " this: " + this);
                        System.out.println("-----消息确认22----");
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
