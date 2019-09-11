package tuling.dubbo.test;

import tuling.dubbo.server.UserService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Tommy
 * Created by Tommy on 2018/11/23
 **/
public class SpiTest {
    public static void main(String[] args) {
        Iterator<UserService> ser = ServiceLoader.load(UserService.class).iterator();
        UserService s = ser.next();
        System.out.println(s.getUser(111));
        // JDBC  mysq Driver
        try {
            Class.forName("com.mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
