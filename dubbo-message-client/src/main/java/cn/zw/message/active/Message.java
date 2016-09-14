package cn.zw.message.active;

/**
 * @description activemq的消息对象
 * @auther 'Amos'
 * @created 2016/9/12  11:39
 */
public class Message {


    private Object data;

    private MessageType messageType;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Message(Object data, String name) {
        this.data = data;
        this.messageType = MessageType.QUEUE;
        this.messageType.setName(name);
    }

    public Message(String  msg) {
        this.data = msg;
        this.messageType = MessageType.QUEUE;
        this.messageType.setName(MessageType.DEFAULT_NAME);
    }
}
