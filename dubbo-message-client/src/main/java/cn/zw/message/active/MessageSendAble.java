package cn.zw.message.active;

import cn.zw.duubo.message.common.Message;

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
    void sendTransactionMessage(Message msg);


    /**
     *  发送消息
     * @param msg
     */
    void sendClinetModel(Message msg,int  type);


}
