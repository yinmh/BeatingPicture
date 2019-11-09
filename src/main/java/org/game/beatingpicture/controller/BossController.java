package org.game.beatingpicture.controller;

import org.game.beatingpicture.service.AreaService;
import org.game.beatingpicture.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boss")
public class BossController {
    @Autowired
    private BossService bossService;
    @RequestMapping("/getBossByAreaId")
    public ResponseEntity getBossByAreaId(Integer areaId){
        return ResponseEntity.ok(bossService.getBossByAreaId(areaId));
    }
}
