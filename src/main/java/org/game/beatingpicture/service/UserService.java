package org.game.beatingpicture.service;

import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.vo.UserInfoVo;


public interface UserService {
    /**
     * 注册用户的方法
     */
    void registUser(User user);

    User getUserByUserName(String username);

    UserInfo getUserInfoByUserId(int userId);
}
