package java.org.game.beatingpicture.mapper;

import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.mapper.UserMapper;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.org.game.beatingpicture.base.BaseJunit;
import java.util.Date;

public class TestUserMapper extends BaseJunit {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("test1");
        user.setPassword("123");
        user.setCreateTime(new Date());
        user.setStatus(1);
        userMapper.addUser(user);
    }

    public static void main(String[] args) {

    }


}
