package org.game.beatingpicture.controller;

import org.game.beatingpicture.entity.Picture;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.service.PictureService;
import org.game.beatingpicture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    /*
     * 获取拥有的卡片信息（除了上阵的）
     * */
    @RequestMapping("/getAllPictureByUserInfoId")
    public ResponseEntity getAllPictureByUserInfoId(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        List<Picture> pictures = pictureService.getAllPictureByUserInfoId(userInfo.getId());
        int count = pictureService.findCount(userInfo.getId());
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",count);
        map.put("list",pictures);
        return ResponseEntity.ok(map);
    }

    /*
     * 获取上阵的卡片信息
     * */
    @RequestMapping("/getAllPictureByStatus")
    public ResponseEntity getAllPictureByStatus(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        List<Picture> pictures = pictureService.getAllPictureByStatus(userInfo.getId());
        return ResponseEntity.ok(pictures);
    }

    /*
     * 修改卡片上阵状态
     * */
    @PostMapping("/updatePictureStatus")
    public ResponseEntity updatePictureStatus(int flag,int id) {
        pictureService.updatePictureStatus(id,flag);
        return ResponseEntity.ok(0);
    }
}
