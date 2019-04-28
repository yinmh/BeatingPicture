package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.vo.UserInfoVo;

/**
 * 用户mapper
 * */
@Mapper
public interface UserMapper {
    /**
     * 添加用户信息
     * */
    void addUser(User user);

    /**
     * 根据用户名查询用户
     * */
    User findByUsername(String username);

    UserInfo findUserInfoByUserId(int userId);
}
