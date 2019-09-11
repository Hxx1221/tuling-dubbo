package tuling.dubbo.server.impl;

import tuling.dubbo.server.Bean.UserVo;
import tuling.dubbo.server.UserService;

import java.util.Date;

/**
 * @author Tommy
 * Created by Tommy on 2018/11/23
 **/
public class UserServiceImpl2 implements UserService {
    @Override
    public UserVo getUser(Integer id) {
        UserVo u = new UserVo();
        u.setBirthDay(new Date());
        u.setId(id);
        return u;
    }
}
