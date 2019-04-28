package org.game.beatingpicture.schedule;

import org.game.beatingpicture.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling //开启定时任务
public class TimerTask {
    @Autowired
    private SignService signService;

    @Scheduled(fixedRate = 1000*60*60)//只支持单线程，每隔 1小时 执行一次
    public void updateSigned() {
        signService.updateSigned(1);
    }
}
