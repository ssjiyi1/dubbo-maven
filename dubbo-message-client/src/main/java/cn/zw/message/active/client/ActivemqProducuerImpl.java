package cn.zw.message.active.client;

import cn.zw.message.active.DestinationBuilder;
import cn.zw.message.active.Message;
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
        Destination destination = DestinationBuilder.getDestination(message.getMessageType());
        jmsTemplate.send(destination, session -> session.createTextMessage(message.getData().toString()));

    }
}
