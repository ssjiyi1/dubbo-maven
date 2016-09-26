import cn.zw.duubo.message.common.Message;
import cn.zw.message.active.local.LocalActiveMessageSend;

/**
 * @description 发送测试类
 * @auther 'Amos'
 * @created 2016/9/19  15:29
 */
public class SendTest {


    public static void main(String[] args) {


        LocalActiveMessageSend localActiveMessageSend = new LocalActiveMessageSend();
        Message message = new Message("aaabbbbcc");
        localActiveMessageSend.send(message);




    }

}
