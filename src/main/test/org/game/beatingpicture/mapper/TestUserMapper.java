package org.game.beatingpicture.mapper;

import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.game.beatingpicture.base.BaseJunit;
import java.util.Date;

public class TestUserMapper extends BaseJunit {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private static UserInfoMapper userInfoMapper;

    @Test
    public void test1() {

    }

    @Test
    public void test() {
//        User user = new User();
//        user.setUsername("test1");
//        user.setPassword("123");
//        user.setCreateTime(new Date());
//        user.setStatus(1);
//        userMapper.addUser(user);
    }

    public static void main(String[] args) {
        UserInfo info = userInfoMapper.findById(14);
        System.out.println(info);
    }


}
