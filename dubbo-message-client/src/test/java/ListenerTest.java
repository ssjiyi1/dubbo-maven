import cn.zw.message.active.*;
import cn.zw.message.active.local.LocalActiveMqListener;

/**
 * @description 测试类
 * @auther 'Amos'
 * @created 2016/9/12  12:00
 */
public class ListenerTest {


    public static void main(String[] args) {
        listener();
    }


    private static void listener() {
        MessageType messageType = MessageType.QUEUE;
        messageType.setName(MessageType.DEFAULT_NAME);
        MessageConsumerAble messageConsumerAble = new LocalActiveMqListener();
        messageConsumerAble.Listener(messageType);

    }

}
