package cn.zw.message.active;

import cn.zw.duubo.message.common.MessageType;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Destination;

/**
 * @description activemq消息类型的构建
 * @auther 'Amos'
 * @created 2016/9/12  11:43
 */
public class DestinationBuilder {


        public static Destination getDestination(MessageType messageType) {
            if (messageType.equals(MessageType.TOPPIC)) {
                return new ActiveMQTopic(messageType.getName());
            } else if (messageType.equals(MessageType.QUEUE)) {
                return new ActiveMQQueue(messageType.getName());
            } else {
                throw new RuntimeException("消息模型未识别，messageDomain=" + messageType);
            }
        }
    }
