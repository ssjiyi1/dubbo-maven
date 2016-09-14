import cn.zw.message.active.*;
import cn.zw.message.active.local.LocalActiveMessageSend;

/**
 * @description 测试类
 * @auther 'Amos'
 * @created 2016/9/12  12:00
 */
public class SendTest {


    public static void main(String[] args) {

        send();
    }

    private static void send() {
        Message message = new Message("hello world");
        MessageSendAble messageAble = new LocalActiveMessageSend();
        messageAble.send(message);
    }


}
