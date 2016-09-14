package cn.zw.message.active;

/**
 * @description 消费消息
 * @auther 'Amos'
 * @created 2016/9/12  13:49
 */
public interface MessageConsumerAble extends MessageAble {

    void Listener(MessageType messageType);
}
