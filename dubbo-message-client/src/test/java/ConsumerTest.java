import cn.zw.duubo.message.common.MessageType;
import cn.zw.message.active.local.LocalActiveMqListener;

/**
 * @description 消费者测试
 * @auther 'Amos'
 * @created 2016/9/19  15:40
 */
public class ConsumerTest {


    public static void main(String[] args) {

        LocalActiveMqListener localActiveMqListener = new LocalActiveMqListener();
        MessageType defaultValue = MessageType.QUEUE;
        defaultValue.setName(MessageType.DEFAULT_NAME);
        localActiveMqListener.Listener(defaultValue);


    }

}
