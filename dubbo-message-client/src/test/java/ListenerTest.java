import cn.zw.duubo.message.common.MessageType;
import cn.zw.message.active.MessageConsumerAble;
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
        messageType.setName("trans?customer.prefetchSize=2");
        MessageConsumerAble messageConsumerAble = new LocalActiveMqListener();
        messageConsumerAble.Listener(messageType);

    }

}
