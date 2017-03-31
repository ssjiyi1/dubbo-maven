import cn.zw.duubo.message.common.Message;
import cn.zw.duubo.message.common.MessageType;
import cn.zw.message.active.MessageAble;
import cn.zw.message.active.local.LocalActiveMessageSend;

import javax.jms.Session;

/**
 * @description 发送测试类
 * @auther 'Amos'
 * @created 2016/9/19  15:29
 */
public class SendTest {


    public static void main(String[] args) {


        LocalActiveMessageSend localActiveMessageSend = new LocalActiveMessageSend();
        String msg = "文本消息-->";
        for (int i = 0; i < 1; i++) {
            String sendMessage = msg + i;
            Message message = new Message(sendMessage);
            MessageType messageType = MessageType.QUEUE;
            messageType.setName("trans");
            message.setMessageType(messageType);
            /**
             *    // 创建Session，参数解释：
             // 第一个参数是否使用事务:当消息发送者向消息提供者（即消息代理）发送消息时，消息发送者等待消息代理的确认，没有回应则抛出异常，消息发送程序负责处理这个错误。
             // 第二个参数消息的确认模式：
             // AUTO_ACKNOWLEDGE ： 指定消息提供者在每次收到消息时自动发送确认。消息只向目标发送一次，但传输过程中可能因为错误而丢失消息。
             // CLIENT_ACKNOWLEDGE ： 由消息接收者确认收到消息，
             // 通过调用消息的acknowledge()方法（会通知消息提供者收到了消息）
             // DUPS_OK_ACKNOWLEDGE ： 指定消息提供者在消息接收者没有确认发送时重新发送消息（这种确认
             *
             */
            localActiveMessageSend.sendClinetModel(message, Session.CLIENT_ACKNOWLEDGE);
            System.out.println("send success " + sendMessage);
        }





    }

}
