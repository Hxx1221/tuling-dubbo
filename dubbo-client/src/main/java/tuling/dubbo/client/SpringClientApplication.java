package tuling.dubbo.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tuling.dubbo.server.Bean.UserVo;
import tuling.dubbo.server.UserService;

import java.io.IOException;

/**
 * @author Tommy
 * Created by Tommy on 2018/11/18
 **/
public class SpringClientApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-consumer.xml");
        UserService userService = context.getBean(UserService.class);
        while (!read().equals("exit")) {
            UserVo u = userService.getUser(1111);
            System.out.println(u);
        }
    }

    private static String read() throws IOException {
        byte[] b = new byte[1024];
        int size = System.in.read(b);
        return new String(b, 0, size).trim();
    }

}

