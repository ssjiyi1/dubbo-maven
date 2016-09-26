import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description 开启服务器
 * @auther 'Amos'
 * @created 2016/9/26  15:02
 */
public class StartMain {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("jms.consumer.xml");
        applicationContext.start();



    }


}
