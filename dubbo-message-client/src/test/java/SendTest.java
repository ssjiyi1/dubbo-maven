import cn.zw.duubo.message.common.Message;
import cn.zw.duubo.message.common.MessageType;
import cn.zw.message.active.MessageAble;
import cn.zw.message.active.local.LocalActiveMessageSend;

/**
 * @description 发送测试类
 * @auther 'Amos'
 * @created 2016/9/19  15:29
 */
public class SendTest {


    public static void main(String[] args) {


        LocalActiveMessageSend localActiveMessageSend = new LocalActiveMessageSend();
        String msg = "文本消息-->";
        for (int i = 0; i < 2001; i++) {
            String sendMessage = msg + i;
            Message message = new Message(sendMessage);
            MessageType messageType = MessageType.QUEUE;
            messageType.setName("trans");
            message.setMessageType(messageType);
            localActiveMessageSend.send(message, MessageAble.AUTO_ACK);
            System.out.println("send success " + sendMessage);
        }





    }

}
