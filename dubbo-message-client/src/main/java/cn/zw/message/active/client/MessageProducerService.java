package cn.zw.message.active.client;

import cn.zw.message.active.Message;

/**
 * @description 消息生成者接口
 * @auther 'Amos'
 * @created 2016/9/13  11:47
 */
public interface MessageProducerService {


    void  send(Message message);
}
