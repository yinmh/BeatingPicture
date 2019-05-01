package org.game.beatingpicture.controller;


import net.bytebuddy.asm.Advice;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.game.beatingpicture.entity.UploadPicture;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.service.UploadService;
import org.game.beatingpicture.service.UserInfoService;
import org.game.beatingpicture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @Autowired
    private UserService userService;

    @RequestMapping("/upload")
    public ResponseEntity uploadPicture(HttpServletRequest request, MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        try (InputStream in = file.getInputStream();
             FileOutputStream out = new FileOutputStream(originalFilename)) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            User user = (User) request.getSession().getAttribute("user");
            UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
            UploadPicture uploadPicture = new UploadPicture();
            String filename = file.getOriginalFilename();
            uploadPicture.setPictureName(filename);
            uploadPicture.setUploadTime(new Date());
            //这里的userId是userInfo的Id
            uploadPicture.setUserId(userInfo.getId());
            uploadService.addUploadPicture(uploadPicture);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        return ResponseEntity.ok(map);

    }

}
