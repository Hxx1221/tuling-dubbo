package tuling.dubbo.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Tommy
 * Created by Tommy on 2018/11/18
 **/
public class SpringServerApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-provide2.xml");
        ((ClassPathXmlApplicationContext) context).start();
        System.in.read();
    }
}
