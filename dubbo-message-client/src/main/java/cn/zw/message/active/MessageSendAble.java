package cn.zw.message.active;

/**
 * @description 发送消息的接口
 * @auther 'Amos'
 * @created 2016/9/12  10:11
 */
public interface MessageSendAble extends  MessageAble {


    /**
     *  发送消息
     * @param msg
     */
    void send(Message msg);

}
