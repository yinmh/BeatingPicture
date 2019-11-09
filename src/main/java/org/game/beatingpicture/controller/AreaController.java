package org.game.beatingpicture.controller;

import org.game.beatingpicture.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping("/findAll")
    public ResponseEntity getAllArea(){
        return ResponseEntity.ok(areaService.findAll());
    }

    @PostMapping("/updateStatus")
    public ResponseEntity updateStatus(Integer status,Integer areaId){
        areaService.updateStatus(status,areaId);
        return ResponseEntity.ok(0);
    }
}
