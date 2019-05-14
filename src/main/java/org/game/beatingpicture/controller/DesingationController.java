package org.game.beatingpicture.controller;

import org.ehcache.core.internal.util.CollectionUtil;
import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.mapper.UserInfoMapper;
import org.game.beatingpicture.service.DesingationService;
import org.game.beatingpicture.service.UserInfoService;
import org.game.beatingpicture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/desingation")
public class DesingationController {
    @Autowired
    private DesingationService desingationService;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("/getDesingation")
    public ResponseEntity getDesingation(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        Desingation desingation = userInfoMapper.getDesingationById(userInfo.getDesignationId());
        int desingationId = desingation.getId();
        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("list", desingationService.getDesingation(desingationId));
        return ResponseEntity.ok(data);
    }

}
