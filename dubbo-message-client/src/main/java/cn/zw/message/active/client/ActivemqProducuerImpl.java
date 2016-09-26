package cn.zw.message.active.client;

import cn.zw.duubo.message.common.Message;
import cn.zw.message.active.DestinationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @description active的消息生产者
 * @auther 'Amos'
 * @created 2016/9/13  11:49
 */
@Component
public class ActivemqProducuerImpl implements MessageProducerService {


    @Autowired
    private JmsTemplate jmsTemplate;


    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void send(Message message) {
//        Destination destination = DestinationBuilder.getDestination(message.getMessageType());
//        jmsTemplate.send(destination, session -> session.createTextMessage(message.getData().toString()));
        jmsTemplate.send(session -> session.createTextMessage(message.getData().toString()));
    }
}
