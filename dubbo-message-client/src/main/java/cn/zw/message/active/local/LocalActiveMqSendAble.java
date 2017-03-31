package cn.zw.message.active.local;

import cn.zw.message.active.MessageSendAble;

import javax.jms.Session;

/**
 * @description activemq原生的实现
 * @auther 'Amos'
 * @created 2016/9/12  11:10
 */
public abstract class LocalActiveMqSendAble implements MessageSendAble {




    Session session = null;
}
