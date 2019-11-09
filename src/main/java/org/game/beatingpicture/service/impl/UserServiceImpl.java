package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.Rank;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.mapper.UserInfoMapper;
import org.game.beatingpicture.mapper.UserMapper;
import org.game.beatingpicture.service.UserInfoService;
import org.game.beatingpicture.service.UserService;
import org.game.beatingpicture.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void registUser(User user) {
        user.setCreateTime(new Date());
        userMapper.addUser(user);
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.findByUsername(username);
    }


    @Override
    public UserInfo getUserInfoByUserId(Integer userId) {
        UserInfo userInfo = userMapper.findUserInfoByUserId(userId);

        return userInfo;
    }
}
