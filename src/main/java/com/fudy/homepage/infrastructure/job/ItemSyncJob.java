package com.fudy.homepage.infrastructure.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemSyncJob {
    @XxlJob("itemSyncJobHandler")
    public void execute() throws Exception {
        log.warn("start execute");
        //TODO
        System.out.println("start execute");
    }
}
