package tuling.dubbo.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import tuling.dubbo.server.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author Tommy
 * Created by Tommy on 2018/11/20
 **/
public class SimpleServer {

    public void openServer(int port) {
        // 构建应用
        ApplicationConfig config = new ApplicationConfig();
        config.setName("simple-app");

        // 通信协议
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo", port);
        protocolConfig.setThreads(200);

        ServiceConfig<UserService> serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(config);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://192.168.0.147:2181"));
        serviceConfig.setInterface(UserService.class);
        UserServiceImpl ref = new UserServiceImpl();
        serviceConfig.setRef(ref);
        //开始提供服务  开张做生意
        serviceConfig.export();
        System.out.println("服务已开启!端口:"+serviceConfig.getExportedUrls().get(0).getPort());
        ref.setPort(serviceConfig.getExportedUrls().get(0).getPort());
    }

    public static void main(String[] args) throws IOException {
        new SimpleServer().openServer(-1);
        System.in.read();
    }
}
